package com.jack.healthManage.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SleepAddDTO implements java.io.Serializable {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer sleepQuality;

}
