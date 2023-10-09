package kz.alibek.kafkasenderservice.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "message")
@Getter
@Setter
public class MessageDto {

    @JacksonXmlProperty(localName = "sender")
    private String sender;

    @JacksonXmlProperty(localName = "content")
    private String content;

}