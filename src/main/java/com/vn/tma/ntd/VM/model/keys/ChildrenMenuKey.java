package com.vn.tma.ntd.VM.model.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

/**
 * The Class ChildrenMenu
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ChildrenMenuKey implements Serializable {

    @Column(name = "children_id")
    private Long children;

    @Column(name = "parent_id")
    private Long parent;

}
