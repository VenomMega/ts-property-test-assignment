package kz.alibek.kafkareceiveservice.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import kz.alibek.kafkareceiveservice.model.dto.MessageDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class MessageDtoSerializer implements Serializer<MessageDto> {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public byte[] serialize(String topic, MessageDto data) {
        if (data == null) {
            return null;
        }
        try {
            return xmlMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing MessageDto to XML", e);
        }
    }
}
