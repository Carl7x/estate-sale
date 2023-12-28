package com.kyle.exception;

/**
 * 账号不存在异常
 */
public class AccountNotFoundException1 extends BaseException {

    public AccountNotFoundException1() {
    }

    public AccountNotFoundException1(String msg) {
        super(msg);
    }

}