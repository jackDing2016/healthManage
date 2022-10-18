package com.jack.healthManage.vo;

import lombok.Data;

@Data
public class SleepStatisticsVO implements java.io.Serializable {

    private double howAverageLongAllTime;

    private int maxRecordWithContinuousHighQuality;

    private int howLongFromLastHighQualityToNow;

    private int stayUpAnnualLimit;

    private int stayUpAnnualUsed;

}
