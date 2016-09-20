package com.qinjiangbo.service;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class OurTestEvent {

    private final int message;

    public OurTestEvent(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
