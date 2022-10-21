package com.jack.healthManage.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SleepVO implements java.io.Serializable {

    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer sleepQuality;

    private String sleepQualityStr;

    private Double period;

}
