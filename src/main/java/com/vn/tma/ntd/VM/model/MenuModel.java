package com.vn.tma.ntd.VM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * The Class MenuModel
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@Entity
@Table(name = "menu_entity")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String icon;

    @Column
    private String href;

    @Column
    private String header;

    @Column(name = "sort_num")
    private Long sortNum;

    @Column(name="is_divider")
    private Boolean isDriver;

    @OneToMany(mappedBy = "childrenMenu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ChildrenMenuModel> children;

    @OneToMany(mappedBy = "menuModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuRoleModel> menuRoles;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    private GroupMenuModel groupMenuModel;
}
