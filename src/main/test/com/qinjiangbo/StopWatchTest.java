package com.qinjiangbo;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Date: 9/12/16
 * Author: qinjiangbo@github.io
 */
public class StopWatchTest {

    @Test
    public void testCalculateIterationsTime() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted(); //已经启动
        Thread.sleep(2000l);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));
    }

}
