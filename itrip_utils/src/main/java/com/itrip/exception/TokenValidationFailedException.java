package com.itrip.exception;

public class TokenValidationFailedException extends Exception {
    /**
     * token 失效或不存在异常
     * @param exc
     */
    public TokenValidationFailedException(String exc) {
        super(exc);
    }


}
