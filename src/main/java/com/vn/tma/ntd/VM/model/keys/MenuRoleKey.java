package com.vn.tma.ntd.VM.model.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The Class FkMenuRoleModel
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRoleKey implements Serializable {

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "role_id")
    private Long roleId;
}
