package com.tcpclient.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
    @JacksonXmlProperty(isAttribute = true)
    private String dt;
    @JacksonXmlProperty(isAttribute = true)
    private String serialNumber;
    @JacksonXmlProperty(isAttribute = true)
    private String sn;
    @JacksonXmlProperty(isAttribute = true)
    private String csts;
    @JacksonXmlProperty(isAttribute = true)
    private String evt;
    @JacksonXmlProperty(isAttribute = true)
    private String src;
    @JacksonXmlProperty(isAttribute = true)
    private String dts;
    @JacksonXmlProperty(isAttribute = true)
    private String CSQ;
    @JacksonXmlProperty(localName = "ConnectionStatus", isAttribute = true)
    private String connectionStatus;
    @JacksonXmlProperty(localName = "BattVol",isAttribute = true)
    private String battVol;
    @JacksonXmlProperty(localName = "PowerStatus",isAttribute = true)
    private String powerStatus;
    @JacksonXmlProperty(localName = "MovementActivity",isAttribute = true)
    private String movementActivity;
    @JacksonXmlProperty(isAttribute = true)
    private String gps;
}