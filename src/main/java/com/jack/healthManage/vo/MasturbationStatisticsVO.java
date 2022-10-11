package com.jack.healthManage.vo;

import lombok.Data;

@Data
public class MasturbationStatisticsVO implements java.io.Serializable {

    private double howAverageLongOneAllTime;

    private int maxPeriodWithNoMasturbation;

    private int howLongFromLastOnceToNow;

}
