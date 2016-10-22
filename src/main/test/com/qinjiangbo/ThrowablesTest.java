package com.qinjiangbo;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Date: 9/12/16
 * Author: qinjiangbo@github.io
 */
public class ThrowablesTest {

    @Test
    public void testExtractInnerMostException() {
        try {
            try {
                try {
                    throw new RuntimeException("Inner Most exception");
                } catch (Exception e) {
                    throw new SQLException("Middle tier exception", e);
                }
            } catch (Exception e) {
                throw new IllegalStateException("Last exception", e);
            }
        } catch (Exception e) {
            System.out.println(Throwables.getRootCause(e).getMessage());
        }
    }

    @Test
    public void testThrowablesPropagate() {
        try {
            throw new Exception();
        } catch (Throwable t) {
            String messages = Throwables.getStackTraceAsString(t);
            System.out.println("messages: " + messages);
            Throwables.propagate(t); // RuntimeException
        }
    }

    @Test
    public void call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, NullPointerException.class);
            System.out.println("Hello World!");
        }
    }
}
