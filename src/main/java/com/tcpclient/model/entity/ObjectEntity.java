package com.tcpclient.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "objects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String object_name;
    private String object_description;
    private Long device_id;
}