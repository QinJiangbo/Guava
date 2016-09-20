package com.qinjiangbo.service;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class EventListener {

    public int lastMessage = 0;

    public void listen(OurTestEvent event) {
        lastMessage = event.getMessage();
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
