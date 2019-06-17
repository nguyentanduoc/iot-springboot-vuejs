package com.vn.tma.ntd.VM.model;

import com.vn.tma.ntd.VM.model.keys.ChildrenMenuKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Class ChildrenMenuModel
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fk_children_menu")
@EqualsAndHashCode
public class ChildrenMenuModel {

    @EmbeddedId
    private ChildrenMenuKey childrenMenuKey;

    @MapsId("parent_id")
    @JoinColumn(name = "parent_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MenuModel parentMenu;

    @MapsId("children_id")
    @JoinColumn(name = "children_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MenuModel childrenMenu;
}
