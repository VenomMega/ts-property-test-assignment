package kz.alibek.kafkasenderservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import kz.alibek.kafkasenderservice.model.dto.MessageDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDtoDeserializer implements Deserializer<MessageDto> {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public MessageDto deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return xmlMapper.readValue(data, MessageDto.class);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing MessageDto from XML", e);
        }
    }
}
