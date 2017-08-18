package com.yexj.yougo.common.util;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 金额工具类
 */
public class AmountUtil {

    /**
     * 校验金额格式并返回默认值
     * @param amount
     * @return
     */
    public static boolean validateFormat(String amount,boolean required){
        if (StringUtils.isBlank(amount)){
            if (required){
                return false;
            }
            return true;
        }
        if(!IsDecimal(amount)){
            return false;
        }
        return new BigDecimal(amount).compareTo(BigDecimal.ZERO) >= 0;
    }

    public static boolean validateFormatNumber(String amount,boolean required){
        if (StringUtils.isBlank(amount)){
            if (required){
                return false;
            }
        }
        if(!IsDecimal(amount)){
            return false;
        }
        return true;
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean IsNumber(String str) {
        String regex = "^[0-9]*$";
        return match(regex, str);
    }
    public static boolean IsDecimal(String str) {
        String regex = "^(-)?[0-9]+(.[0-9]{1,2})?$";
        return match(regex, str);
    }

    public static String formatAmount(BigDecimal amount){
        DecimalFormat df=new DecimalFormat(",###,##0.00"); //保留一位小数
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(amount);
    }

    public static BigDecimal amtToYuan(String amt, BigDecimal multi){
        BigDecimal amount = new BigDecimal(amt);
        BigDecimal divided = amount.divide(multi).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        return divided;
    }


    public static void main(String[]args){
        formatAmount(new BigDecimal("23333.6666"));
    }

}


