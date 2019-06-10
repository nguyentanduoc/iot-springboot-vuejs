package com.vn.ntd.RabbitmqSimple.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 * The Class CurrentUser
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
}
