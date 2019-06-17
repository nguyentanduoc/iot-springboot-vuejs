package com.vn.tma.ntd.VM.transfer;

import com.vn.tma.ntd.VM.dto.MenuDTO;
import com.vn.tma.ntd.VM.model.MenuRoleModel;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class MenuTransfer
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Component
public class MenuTransfer {

    Logger logger = LoggerFactory.getLogger( getClass() );

    @Autowired
    private ModelMapper modelMapper;

    public Set<MenuDTO> listModelToDto(Set<MenuRoleModel> menuModels) {
        return menuModels.stream().map( menu -> modelMapper.map( menu.getMenuModel(), MenuDTO.class ) ).collect( Collectors.toSet() );
    }
}
