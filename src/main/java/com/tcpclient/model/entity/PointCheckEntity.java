package com.tcpclient.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "point_checks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointCheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime check_time;
    private String gps;
    private String point_name;
    private Integer order_index;
    private Long patrol_id;
}
