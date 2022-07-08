package com.pnc.registration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserOutsideCanadaException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String status;

    private String code;

    private String message;
}
