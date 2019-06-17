package com.vn.tma.ntd.VM.model;

import com.vn.tma.ntd.VM.constant.ERoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
@EqualsAndHashCode
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ERoleName name;

    @OneToMany(
            mappedBy = "roleModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<MenuRoleModel> menuRoles;

    @Override
    public String toString() {
        return "RoleModel{id:" + this.id + ", name" + this.name + "}";
    }
}
