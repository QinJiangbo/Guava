package com.qinjiangbo;

import com.google.common.eventbus.EventBus;
import com.qinjiangbo.service.EventListener;
import com.qinjiangbo.service.OurTestEvent;
import org.junit.Test;

/**
 * Date: 9/20/16
 * Author: qinjiangbo@github.io
 */
public class EventBusTest {

    @Test
    public void testReceiveEvent() {
        EventBus eventBus = new EventBus("test");
        EventListener eventListener = new EventListener();
        eventBus.register(eventListener);
        eventBus.post(new OurTestEvent(200));
        System.out.println(eventListener.getLastMessage());
    }
}
