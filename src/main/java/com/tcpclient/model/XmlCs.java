package com.tcpclient.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "xml_cs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XmlCs {
    @JacksonXmlProperty(localName = "packet")
    private Packet packet;
}