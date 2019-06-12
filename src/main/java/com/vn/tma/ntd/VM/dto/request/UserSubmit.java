package com.vn.tma.ntd.VM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserSubmit
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubmit {

    private String username;

    private String password;
}
