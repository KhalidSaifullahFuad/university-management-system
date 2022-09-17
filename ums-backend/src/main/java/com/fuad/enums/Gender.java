package com.fuad.enums;

import java.util.Arrays;

public enum Gender {
    MALE,
    FEMALE,
    OTHERS;

    public static Gender get(String gender){
        return Arrays.stream(Gender.values()).filter(g -> g.name().equalsIgnoreCase(gender)).findAny().orElse(null);
    }
}
