package org.fluttercode.datafactory.impl;

import org.fluttercode.datafactory.PhoneDataValues;

/**
 * Created by A on 2017/3/13.
 */
public class DefaultPhoneDataValues implements PhoneDataValues {

    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public String[] getTelFirst() {
        return telFirst;
    }

    public String getTelSecond() {
        return String.valueOf(getNum(1,888)+10000).substring(1);
    }

    public String getTelThird() {
        return String.valueOf(getNum(1,9100)+10000).substring(1);
    }

    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

}
