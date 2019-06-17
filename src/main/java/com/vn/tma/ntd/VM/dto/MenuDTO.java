package com.vn.tma.ntd.VM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * The Class MenuDto
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MenuDTO {

    private Long id;

    private String name;

    private String title;

    private String icon;

    private String href;

    private String header;

    private Boolean isDriver;

    private GroupMenuDTO groupMenuModel;

    private Long sortNum;
}
