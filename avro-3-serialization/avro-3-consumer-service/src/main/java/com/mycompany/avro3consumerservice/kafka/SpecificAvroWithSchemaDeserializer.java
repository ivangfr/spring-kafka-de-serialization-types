package com.mycompany.avro3consumerservice.kafka;

import io.confluent.kafka.serializers.AbstractKafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.Schema;
import org.apache.kafka.common.serialization.Deserializer;

import java.lang.reflect.Field;
import java.util.Map;

public class SpecificAvroWithSchemaDeserializer extends AbstractKafkaAvroDeserializer implements Deserializer<Object> {

    public static final String AVRO_KEY_RECORD_TYPE = "avro.key.record.type";
    public static final String AVRO_VALUE_RECORD_TYPE = "avro.value.record.type";

    private Schema readerSchema;

    public SpecificAvroWithSchemaDeserializer() {
    }

    @Override
    public void configure(Map<String, ?> props, boolean isKey) {
        this.configure(new KafkaAvroDeserializerConfig(props));
        readerSchema = getSchema(getRecordClass(props, isKey));
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return super.deserialize(bytes, readerSchema);
    }

    @Override
    public void close() {
    }

    private Class<?> getRecordClass(Map<String, ?> configs, boolean isKey) {
        String configsKey = isKey ? AVRO_KEY_RECORD_TYPE : AVRO_VALUE_RECORD_TYPE;
        Object configsValue = configs.get(configsKey);

        if (configsValue instanceof Class) {
            return (Class) configsValue;
        } else if (configsValue instanceof String) {
            String recordClassName = (String) configsValue;
            try {
                return Class.forName(recordClassName);
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(String.format("Unable to find the class '%s'", recordClassName));
            }
        } else {
            throw new IllegalArgumentException(
                    String.format("A class or a string must be informed into ConsumerConfig properties: '%s' and/or '%s'",
                            AVRO_KEY_RECORD_TYPE, AVRO_VALUE_RECORD_TYPE));
        }
    }

    private Schema getSchema(Class<?> targetType) {
        try {
            Field field = targetType.getDeclaredField("SCHEMA$");
            return (Schema) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException(
                    String.format("Unable to get Avro Schema from the class '%s'", targetType.getName()), e);
        }
    }

}
