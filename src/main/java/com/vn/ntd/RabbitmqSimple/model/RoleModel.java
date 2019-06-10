package com.vn.ntd.RabbitmqSimple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class RoleModel
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "role_entity")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleName name;
}
