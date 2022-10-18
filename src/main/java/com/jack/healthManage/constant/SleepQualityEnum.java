package com.jack.healthManage.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SleepQualityEnum {


    GOOD(
            1, "good"
    ),
    MEDIUM(
            2, "medium"
    ),
    BAD(
            3, "bad"
    );

    private final int code;

    private final String name;

}
