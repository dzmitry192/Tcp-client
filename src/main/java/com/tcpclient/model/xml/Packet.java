package com.tcpclient.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "packet")
public class Packet {
    @JacksonXmlProperty(isAttribute = true)
    private String sq;
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String count;
    @JacksonXmlProperty(isAttribute = true)
    private String rep;
    @JacksonXmlProperty(isAttribute = true)
    private String group;
    @JacksonXmlProperty
    private Msg msg;
}