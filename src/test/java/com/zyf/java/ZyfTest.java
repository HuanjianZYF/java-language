package com.zyf.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author zyf
 * @CreateAt 2018/4/4 下午2:58
 */
public class ZyfTest {

    public  Date getStartTimesThisWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    @Test
    public void testDay() {
        System.out.println(getStartTimesThisWeek());
    }
}
