package com.vn.tma.ntd.VM.model;

import com.vn.tma.ntd.VM.constant.ERoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class RoleModel
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_entity")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ERoleName name;

    @Override
    public String toString() {
        return "RoleModel{id:" + this.id + ", name" + this.name + "}";
    }
}
