package com.vn.tma.ntd.VM.dto.request;

import com.vn.tma.ntd.VM.constant.EActionDelete;
import com.vn.tma.ntd.VM.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AccountDelete
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDelete {

    private UserDTO item;

    private EActionDelete optionAction;
}
