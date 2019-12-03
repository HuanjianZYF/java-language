package com.zyf.java;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

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


    @Test
    public void testLength() {
        String s = "$$331023100009~浙江大学附属第一医院~00~331023~201900000069~251242993~21556|0|0|FH0055.01|3||利鲁唑片|1556|2019-04-19 16:00:00|2019-04-19 16:00:00|32662|利鲁唑片|50毫克*56片/盒|无|片||||0|1|20.7143|1.0000|20.71||||0||||||32|庄元丰^1557|0|0|FH0055.01|3||八宝丹|1557|2019-04-19 16:00:00|2019-04-19 16:00:00|24379|八宝丹|0.3克*12粒/盒|无|粒||||0|1|10.1892|7.0000|71.32||||0||||||32|庄元丰^$$";
        System.out.println(s.length());
    }

    @Test
    public void testNumeric() {
        System.out.println(Character.isDigit('-'));
    }

    @Test
    public void testBigDecimal() {
        BigDecimal big = new BigDecimal("0.00");
        System.out.println(big.toPlainString());
    }

    @Test
    public void testFormatter() {
        String s = "201900002777_1|162779|194575|6.0|0.0|0.0|22|1|0|0.0|6.0||$201900002777_1|162780|194576|22.0|0.0|22.0|28|1|2|0.0|22.0|## 没有符合条件的康复备案信息，本条康复项目自费处理|$201900002777_1|162781|194577|14.0|0.0|0.0|33|1|0|0.0|14.0||$201900002777_1|162782|194578|80.0|0.0|0.0|29|1|0|0.0|80.0||$201900002777_1|162783|194579|9.0|0.0|0.0|29|1|0|0.0|9.0||$201900002777_1|162784|194580|0.55|0.0|0.0|32|1|0|0.0|15.0||$201900002777_1|162785|194581|2.4|0.0|0.0|29|1|0|0.0|2.4||$201900002777_1|162794|194590|1.46|0.0|0.0|32|1|0|0.0|200.0||$201900002777_1|162795|194591|11.0|0.0|0.0|32|1|0|0.0|200.0||$201900002777_1|162796|194592|8.5|0.0|0.0|29|1|0|0.0|8.5||$201900002777_1|163097|195089|4.76|0.0|0.0|11|1|0|0.0|0.0|##药品的频次字段为空或没有按照正确的二级代码上传，请确认。|$201900002777_1|167136|200695|60.0|0.0|0.0|22|1|0|0.0|60.0||$201900002777_1|167136|200696|10.0|0.0|0.0|22|1|0|0.0|10.0||$201900002777_1|167136|200697|5.0|0.0|5.0|50|3|0|1.0|0.0||$201900002777_1|167136|200698|20.0|0.0|0.0|22|1|0|0.0|20.0||$201900002777_1|167136|200699|20.0|0.0|0.0|22|1|0|0.0|20.0||$201900002777_1|167178|200826|150.0|0.0|0.0|22|1|0|0.0|150.0||$201900002777_1|168801|202675|60.0|0.0|0.0|22|1|0|0.0|60.0||$201900002777_1|168802|202676|10.0|0.0|0.0|22|1|0|0.0|10.0||$201900002777_1|168803|202677|5.0|0.0|5.0|50|3|0|1.0|0.0||$201900002777_1|168804|202678|20.0|0.0|0.0|22|1|0|0.0|20";
        String[] strs = s.split("\\$", -1);
        System.out.println(strs);
    }

    @Test
    public void testContains() {
        String s = "1111";
        System.out.println(s.contains(""));
    }

    @Test
    public void testSplit() {
        String[] strs = "$$0~~~~$$".split("~", -1);
        System.out.println(strs);
    }

    @Test
    public void testString() {
        Object o = new Object();
        Integer a = (Integer) o;
        System.out.println(o);
    }

    @Test
    public void testTrim() {
        System.out.println(trimByteSize("城站血液病M ", 20));
    }
    private static String trimByteSize(String str, int len) {
        int count = 0;
        int newCount = 0;
        StringBuilder result = new StringBuilder();
        while (true) {
            for (char ch : str.toCharArray()) {
                if (isChinese(ch)) {
                    newCount = count + 2;
                } else {
                    newCount = count + 1;
                }
                if (newCount > len) {
                    return result.toString();
                } else {
                    count = newCount;
                    result.append(ch);
                }
            }
            return result.toString();
        }
    }

    /**
     * 判断一个字符是不是中文
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    @Test
    public void testBigDecimal2() {
        BigDecimal bigN = new BigDecimal("0.1429");
        BigDecimal bigP = new BigDecimal("34.2600");
        BigDecimal total1 = new BigDecimal("4.8943").setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal total2 = bigN.multiply(bigP).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal diff = total1.subtract(total2).abs();

        while (diff.compareTo(new BigDecimal("0.01")) >= 0) {
            bigN = new BigDecimal("0.0001").add(bigN);
            bigP = total1.divide(bigN, 4, BigDecimal.ROUND_HALF_UP);
            total2 = bigN.multiply(bigP).setScale(2, BigDecimal.ROUND_HALF_UP);
            diff = total1.subtract(total2).abs();
        }
        System.out.println(bigN.setScale(4).toPlainString() + "\n" + bigP.setScale(4).toPlainString()
        + "\n" + total2.setScale(4, BigDecimal.ROUND_HALF_UP).toPlainString());
    }

    @Test
    public void testDir() {
        File file = new File("D:\\xshell\\python34");
        System.out.println(file.getParent() + "    " + file.getName() + "  " + file.exists());
    }

    @Test
    public void testFile() {
        File file = new File("D:\\ideaprj\\medicare-platform-client\\lib\\HZSiInterface.class");
        System.out.println(file.exists());
    }

    @Test
    public void testHashMapKeyNull() {
        Map<Object, Object> map = new HashMap();
        map.put(null, null);
        map.put(null, null);
        map.put("123", null);
        map.put(null, 1);
        System.out.println(map);
    }

    @Test
    public void testStringEquals() {
        String s1 = "<?xml version='1.0' encoding='UTF-8'?><MSG><HEAD><VER>1.0</VER><YLJGDM>330118</YLJGDM><YLJGXZQH>331023</YLJGXZQH><AGENTIP>10.1.35.60</AGENTIP><AGENTMAC>D8-CB-8A-26-99-B8</AGENTMAC><SBKH>H00841110-331023D156000005000135EDFF2D918C</SBKH ><SBKSBH>331023D156000005000135EDFF2D918C</SBKSBH><SFZH>331023198811137018</SFZH ><CBRXZQH>331023</CBRXZQH><JZWYBH></JZWYBH><XXLXM>3200</XXLXM><JYSJ>20191031/180438</JYSJ></HEAD><BODY><YSBM>18975</YSBM><PackHospital xmlns='http://schemas.datacontract.org/2004/07/BMI.Engine.Common.Hospital' xmlns:i='http://www.w3.org/2001/XMLSchema-instance'><HospitalClaim ><BENEFIT_GROUP_ID>11</BENEFIT_GROUP_ID><BENEFIT_TYPE>-9999</BENEFIT_TYPE><BMI_CONVERED_AMOUNT>1263.72</BMI_CONVERED_AMOUNT><CKC892>2019-10-31</CKC892><DIAGNOSIS_IN></DIAGNOSIS_IN><DIAGNOSIS_OUT>I25.103</DIAGNOSIS_OUT><DIAGNOSIS_TOTHER></DIAGNOSIS_TOTHER><GENDER>1</GENDER><HOSPITAL_ID>330118</HOSPITAL_ID><HOSPITAL_LEVEL>3</HOSPITAL_LEVEL><HS_AREA_CODE></HS_AREA_CODE><HS_DIAGNOSIS_IN_NAME></HS_DIAGNOSIS_IN_NAME><HS_DIAGNOSIS_OUT_NAME>冠状动脉粥样硬化性心脏病</HS_DIAGNOSIS_OUT_NAME><HS_IN_NUMBER>11041653</HS_IN_NUMBER><HS_NUMBER>H00841110</HS_NUMBER><HS_PATIENT_NAME>戴赐明</HS_PATIENT_NAME><HS_STATUS>0</HS_STATUS><HospitalType>1</HospitalType><ID>JZ1004831732</ID><IN_DATE>2019-10-31</IN_DATE><IsLactation>0</IsLactation><IsPregnant>0</IsPregnant><MEDICAL_TYPE>11</MEDICAL_TYPE><OUT_DATE>2019-10-31</OUT_DATE><PATIENT_BIRTH>1988-11-13</PATIENT_BIRTH><PatientBenefitGroupCode>-1</PatientBenefitGroupCode><Patient_IDStr>705830238</Patient_IDStr><SETTLE_DATE>2019-10-31</SETTLE_DATE><TOTAL_COST>1302.80</TOTAL_COST><UNUSUAL_FLAG>0</UNUSUAL_FLAG><Z_AACT007>0</Z_AACT007><Z_AACT008>0</Z_AACT008><Z_BAC021>0</Z_BAC021> </HospitalClaim><HospitalClaimDetailSet><ClaimDetailHospital><AKF003>0</AKF003><AKF005>18975</AKF005><ApprovalNumber></ApprovalNumber><BKA609>1</BKA609><BKC227>0</BKC227><COSTS>1302.8000</COSTS><DEPTNAME>方便门诊</DEPTNAME><ELIGIBLE_AMOUNT>1263.72</ELIGIBLE_AMOUNT><FREQUENCY_INTERVAL>12</FREQUENCY_INTERVAL><ID>JZ1004831732|1|CF1</ID><ITEM_DATE>2019-10-31</ITEM_DATE><ITEM_ID>x030102002100001</ITEM_ID><ITEM_NAME>塞来昔布胶囊 200毫克*6粒</ITEM_NAME><ITEM_TYPE>1</ITEM_TYPE><NUMBERS>40.0000</NUMBERS><PRICE>32.5700</PRICE><PhysicianLevel>1</PhysicianLevel><Specification>200毫克*6粒</Specification><USAGE>4</USAGE><USAGE_DAYS>30</USAGE_DAYS><USAGE_UNIT>盒</USAGE_UNIT><ZZZ_Flag>0</ZZZ_Flag><Z_PhysicianAP></Z_PhysicianAP></ClaimDetailHospital></HospitalClaimDetailSet></PackHospital></BODY></MSG>";
        String s2 = "<?xml version='1.0' encoding='UTF-8'?><MSG><HEAD><VER>1.0</VER><YLJGDM>330118</YLJGDM><YLJGXZQH>331023</YLJGXZQH><AGENTIP>10.1.35.60</AGENTIP><AGENTMAC>D8-CB-8A-26-99-B8</AGENTMAC><SBKH>H00841110-331023D156000005000135EDFF2D918C</SBKH ><SBKSBH>331023D156000005000135EDFF2D918C</SBKSBH><SFZH>331023198811137018</SFZH ><CBRXZQH>331023</CBRXZQH><JZWYBH></JZWYBH><XXLXM>3200</XXLXM><JYSJ>20191031/180438</JYSJ></HEAD><BODY><YSBM>18975</YSBM><PackHospital xmlns='http://schemas.datacontract.org/2004/07/BMI.Engine.Common.Hospital' xmlns:i='http://www.w3.org/2001/XMLSchema-instance'><HospitalClaim ><BENEFIT_GROUP_ID>11</BENEFIT_GROUP_ID><BENEFIT_TYPE>-9999</BENEFIT_TYPE><BMI_CONVERED_AMOUNT>1263.72</BMI_CONVERED_AMOUNT><CKC892>2019-10-31</CKC892><DIAGNOSIS_IN></DIAGNOSIS_IN><DIAGNOSIS_OUT>I25.103</DIAGNOSIS_OUT><DIAGNOSIS_TOTHER></DIAGNOSIS_TOTHER><GENDER>1</GENDER><HOSPITAL_ID>330118</HOSPITAL_ID><HOSPITAL_LEVEL>3</HOSPITAL_LEVEL><HS_AREA_CODE></HS_AREA_CODE><HS_DIAGNOSIS_IN_NAME></HS_DIAGNOSIS_IN_NAME><HS_DIAGNOSIS_OUT_NAME>冠状动脉粥样硬化性心脏病</HS_DIAGNOSIS_OUT_NAME><HS_IN_NUMBER>11041653</HS_IN_NUMBER><HS_NUMBER>H00841110</HS_NUMBER><HS_PATIENT_NAME>戴赐明</HS_PATIENT_NAME><HS_STATUS>0</HS_STATUS><HospitalType>1</HospitalType><ID>JZ1004831732</ID><IN_DATE>2019-10-31</IN_DATE><IsLactation>0</IsLactation><IsPregnant>0</IsPregnant><MEDICAL_TYPE>11</MEDICAL_TYPE><OUT_DATE>2019-10-31</OUT_DATE><PATIENT_BIRTH>1988-11-13</PATIENT_BIRTH><PatientBenefitGroupCode>-1</PatientBenefitGroupCode><Patient_IDStr>705830238</Patient_IDStr><SETTLE_DATE>2019-10-31</SETTLE_DATE><TOTAL_COST>1302.80</TOTAL_COST><UNUSUAL_FLAG>0</UNUSUAL_FLAG><Z_AACT007>0</Z_AACT007><Z_AACT008>0</Z_AACT008><Z_BAC021>0</Z_BAC021> </HospitalClaim><HospitalClaimDetailSet><ClaimDetailHospital><AKF003>0</AKF003><AKF005>18975</AKF005><ApprovalNumber></ApprovalNumber><BKA609>1</BKA609><BKC227>0</BKC227><COSTS>1302.8000</COSTS><DEPTNAME>方便门诊</DEPTNAME><ELIGIBLE_AMOUNT>1263.72</ELIGIBLE_AMOUNT><FREQUENCY_INTERVAL>12</FREQUENCY_INTERVAL><ID>JZ1004831732|1|CF1</ID><ITEM_DATE>2019-10-31</ITEM_DATE><ITEM_ID>x030102002100001</ITEM_ID><ITEM_NAME>塞来昔布胶囊 200毫克*6粒</ITEM_NAME><ITEM_TYPE>1</ITEM_TYPE><NUMBERS>40.0000</NUMBERS><PRICE>32.5700</PRICE><PhysicianLevel>1</PhysicianLevel><Specification>200毫克*6粒</Specification><USAGE>4</USAGE><USAGE_DAYS>30</USAGE_DAYS><USAGE_UNIT>盒</USAGE_UNIT><ZZZ_Flag>0</ZZZ_Flag><Z_PhysicianAP></Z_PhysicianAP></ClaimDetailHospital></HospitalClaimDetailSet></PackHospital></BODY></MSG>";
        System.out.println(s1.equals(s2));
    }

    @Test
    public void testPutNpt() {
        JSONObject jsonObject = JSONObject.parseObject("{}");
        jsonObject.put("a", "b").toString();

    }

    @Test
    public void testBigDecimalKeep() {
        BigDecimal num = new BigDecimal("18.8889");
        System.out.println(num.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
    }

    @Test
    public void testCompare() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        System.out.println(list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList()));
    }

    @Test
    public void testCalculateChinese() {
        System.out.println(calculateChinese("$$"));
    }

    private int calculateChinese(String s) {
        int valueLength = 0;
        String chinese = "[^\\x00-\\xff]";
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                valueLength += 1;
            }
        }
        return valueLength;
    }

}
