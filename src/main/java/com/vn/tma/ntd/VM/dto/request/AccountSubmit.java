package com.vn.tma.ntd.VM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AccountSubmit
 *
 * @author ntduoc
 * @since 6/18/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountSubmit {

    private String username;
    private String email;
    private Iterable<Long> roles;
}
