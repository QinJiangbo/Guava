package com.qinjiangbo;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qinjiangbo.pojo.Weather;
import org.junit.Test;

import java.util.List;

/**
 * Date: 9/9/16
 * Author: qinjiangbo@github.io
 */
public class PreConditionsTest {

    @Test
    public void testPreConditionCheckState() {
        Weather weather = Weather.SHINNY;
        Preconditions.checkState(weather.equals(Weather.SHINNY), "Weather is not the best for a sunbath!");
    }

    @Test
    public void testPreConditionCheckNotNull() {
        List<String> members = Lists.newArrayList();
        Preconditions.checkNotNull(members, "members can not be null!");
        Preconditions.checkArgument(members.size() == 0, "members can not be null!");
    }
}
