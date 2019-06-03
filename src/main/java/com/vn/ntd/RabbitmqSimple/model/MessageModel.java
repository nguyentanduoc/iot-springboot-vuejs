package com.vn.ntd.RabbitmqSimple.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class MessageModel
 *
 * @author ntduoc
 * @since 6/3/2019
 */
@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;
}
