package com.jack.healthManage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jack
 * @since 2022-10-12
 */
@TableName("tm_sleep")
@Data
//@ApiModel(value = "TmSleep对象", description = "")
public class TmSleep implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer createBy;

    private Integer updateBy;

    private Integer sleepQuality;


    @Override
    public String toString() {
        return "TmSleep{" +
            "id=" + id +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", createBy=" + createBy +
            ", updateBy=" + updateBy +
        "}";
    }
}
