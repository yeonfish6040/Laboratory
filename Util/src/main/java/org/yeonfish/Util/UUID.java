package org.yeonfish.Util;

public class UUID {
    public static String generate() {
        String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return uuid;
    }
}
