package com.vn.tma.ntd.VM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class GroupMenu
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@Entity
@Table(name = "group_menu_entity")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GroupMenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
}
