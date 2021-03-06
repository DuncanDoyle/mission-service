package com.redhat.cajun.navy.mission.message;

import com.redhat.cajun.navy.mission.ErrorCodes;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.KafkaProducerRecord;
import io.vertx.kafka.client.producer.RecordMetadata;

import java.util.HashMap;
import java.util.Map;

public class MissionProducerVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(MissionProducerVerticle.class.getName());
    private Map<String, String> config = new HashMap<>();
    KafkaProducer<String,String> producer = null;
    public static final String PUB_QUEUE = "pub.queue";

    public String missionUpdateCommandTopic = null;
    public String responderUpdateTopic = null;


    @Override
    public void start() throws Exception {

        config.put("bootstrap.servers", config().getString("kafka.connect", "localhost:9092"));
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        missionUpdateCommandTopic = config().getString("kafka.pub");
        responderUpdateTopic = config().getString("kafka.pub.responder.update");
        producer = KafkaProducer.create(vertx,config);
        vertx.eventBus().consumer(PUB_QUEUE, this::onMessage);
    }

    public void onMessage(Message<JsonObject> message) {

        if (!message.headers().contains("action")) {
            message.fail(ErrorCodes.NO_ACTION_SPECIFIED.ordinal(), "No action header specified");
            return;
        }


        String action = message.headers().get("action");
        String key = message.headers().get("key");
        switch (action) {
            case "PUBLISH_UPDATE":
                sendMessage(missionUpdateCommandTopic, key, String.valueOf(message.body()));
                message.reply("Message sent "+missionUpdateCommandTopic);
                break;
            case "RESPONDER_UPDATE":
                sendMessage(responderUpdateTopic, key, String.valueOf(message.body()));
                message.reply("Message Sent "+responderUpdateTopic);
                break;

            default:
                message.fail(ErrorCodes.BAD_ACTION.ordinal(), "Bad action: " + action);

        }
    }


    public void sendMessage(String topic, String key, String body){

        KafkaProducerRecord<String, String> record =
                KafkaProducerRecord.create(topic, key, body);

        producer.write(record, done -> {
            if (done.succeeded()) {

                RecordMetadata recordMetadata = done.result();
                logger.info("Message " + record.value() + " written on topic=" + recordMetadata.getTopic() +
                        ", partition=" + recordMetadata.getPartition() +
                        ", offset=" + recordMetadata.getOffset());

            }
        });

    }


}
