package com.vn.tma.ntd.VM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class TypeSensorModel
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Data
@Entity
@Table(name = "type_sensor_entity")
@AllArgsConstructor
@NoArgsConstructor
public class TypeSensorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String detail;
}
