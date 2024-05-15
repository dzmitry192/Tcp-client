package com.tcpclient.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_type")
    private String dt;

    @Column(name = "serial_number")
    private Long serialNumber;

    @Column(name = "evt")
    private String evt;

    @Column(name = "server_timestamp")
    private LocalDateTime serverTimestamp;

    @Column(name = "device_timestamp")
    private LocalDateTime dts;

    @Column(name = "gps")
    private String gps;

    @Column(name = "csq")
    private String CSQ;

    @Column(name = "connection_status")
    private String connectionStatus;

    @Column(name = "battery_volume")
    private String battVol;

    @Column(name = "power_status")
    private String powerStatus;

    @Column(name = "movement_activity")
    private Integer movementActivity;

    @Column(name = "src")
    private String src;

    @Lob
    @Column(name = "evt_data", columnDefinition = "MEDIUMBLOB")
    private byte[] evtData;

//    public String getFormattedDetected() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return detected.format(formatter);
//    }
//
//    public String getFormattedOccurrence() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return occurrence.format(formatter);
//    }
}
