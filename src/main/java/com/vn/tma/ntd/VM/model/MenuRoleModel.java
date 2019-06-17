package com.vn.tma.ntd.VM.model;

import com.vn.tma.ntd.VM.model.keys.MenuRoleKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * The Class MenuRole
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fk_menu_role")
public class MenuRoleModel {

    @EmbeddedId
    private MenuRoleKey menuRoleKey;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("menu_id")
    @JoinColumn(name = "menu_id")
    private MenuModel menuModel;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("role_id")
    @JoinColumn(name = "role_id")
    private RoleModel roleModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuRoleModel)) return false;
        MenuRoleModel menuRole = (MenuRoleModel) o;
        return Objects.equals( getMenuRoleKey().getMenuId(), menuRole.getMenuRoleKey().getMenuId() ) &&
                Objects.equals( getMenuModel().getId(), menuRole.getMenuModel().getId() ) &&
                Objects.equals( getRoleModel().getId(), menuRole.getRoleModel().getId() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getMenuRoleKey().getMenuId(), getMenuModel().getId(), getRoleModel().getId() );
    }
}
