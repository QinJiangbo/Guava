package com.qinjiangbo;

import com.google.common.eventbus.EventBus;
import com.qinjiangbo.service.EventListener;
import com.qinjiangbo.service.MultipleListener;
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

    @Test
    public void testReceiveMultipleEvents() {
        EventBus eventBus = new EventBus("test");
        MultipleListener multipleListener = new MultipleListener();
        eventBus.register(multipleListener);
        eventBus.post(new Integer(100));
        eventBus.post(new Long(200L));
        System.out.println(multipleListener.getLastInteger());
        System.out.println(multipleListener.getLastLong());
    }
}
