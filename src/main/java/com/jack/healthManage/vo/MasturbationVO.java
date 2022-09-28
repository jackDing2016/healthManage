package com.jack.healthManage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasturbationVO implements java.io.Serializable {

    private LocalDateTime happenTime;

}
