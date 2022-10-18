package com.jack.healthManage.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SleepVO implements java.io.Serializable {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double period;

}
