package com.qinjiangbo.service;

import com.google.common.eventbus.Subscribe;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class EventListener {

    public int lastMessage = 0;

    @Subscribe
    public void listen(OurTestEvent event) {
        lastMessage = event.getMessage();
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
