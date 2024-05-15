package com.tcpclient.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.tcpclient.model.entity.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @JacksonXmlProperty(localName = "BattVol", isAttribute = true)
    private String battVol;
    @JacksonXmlProperty(localName = "PowerStatus", isAttribute = true)
    private String powerStatus;
    @JacksonXmlProperty(localName = "MovementActivity", isAttribute = true)
    private String movementActivity;
    @JacksonXmlProperty(isAttribute = true)
    private String gps;

    public static EventEntity toEventEntity(Msg msg) {
        return EventEntity.builder()
                .dt(msg.getDt())
                .serialNumber(Long.valueOf(msg.getSerialNumber()))
                .evt(msg.getEvt())
                .serverTimestamp(LocalDateTime.parse(msg.getCsts(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .dts(LocalDateTime.parse(msg.getDts(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .gps(msg.getGps())
                .CSQ(msg.getCSQ())
                .connectionStatus(msg.getConnectionStatus())
                .battVol(msg.getBattVol())
                .powerStatus(msg.getPowerStatus())
                .movementActivity(Integer.valueOf(msg.getMovementActivity()))
                .src(msg.getSrc())
                .evtData(msg.toString().getBytes(StandardCharsets.UTF_8))
                .build();
    }
}