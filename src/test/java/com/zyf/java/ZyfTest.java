package com.zyf.java;

import org.junit.Test;

import java.security.MessageDigest;
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


    @Test
    public void testMd5() {
        String s = "zyf is the best";
        System.out.println(MD5Encode(s, "utf-8"));
    }

    private String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public  String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };



}
