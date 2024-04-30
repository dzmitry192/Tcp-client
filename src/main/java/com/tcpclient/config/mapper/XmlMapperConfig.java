package com.tcpclient.config.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMapperConfig {

    private static XmlMapper xmlMapper;

    public static XmlMapper getXmlMapper() {
        if (xmlMapper == null) {
            xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
            xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        }
        return xmlMapper;
    }
}
