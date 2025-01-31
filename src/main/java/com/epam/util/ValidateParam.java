package com.epam.util;

import java.util.Arrays;

public class ValidateParam {

    private ValidateParam() {}

    public static boolean isNotValid(String ids) {
        try{
            Arrays.stream(ids.split(","))
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e){
            return false;
        }

        return ids.length() >= 200;
    }
}
