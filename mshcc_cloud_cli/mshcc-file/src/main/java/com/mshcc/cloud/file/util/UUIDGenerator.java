package com.mshcc.cloud.file.util;

import java.util.UUID;

/**
 * @author mshcc
 * @Date 2021/1/13 14:04
 * @Description TODO
 */
public class UUIDGenerator {
    public static String uuidGenerator(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        return uuid.toString();
    }
    public static String uuidGenerator(String target){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        return uuid.toString().replace("-","")+"."+target;
    }
}
