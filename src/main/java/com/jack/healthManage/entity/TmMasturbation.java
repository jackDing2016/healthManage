package com.jack.healthManage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author jack
 * @since 2022-09-26
 */
@TableName("tm_masturbation")
@Data
@NoArgsConstructor
//@ApiModel(value = "TmMasturbation对象", description = "")
public class TmMasturbation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private LocalDateTime happenTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer createBy;

    private Integer updateBy;

    public TmMasturbation(LocalDateTime happenTime) {
        this.happenTime = happenTime;
    }

    @Override
    public String toString() {
        return "TmMasturbation{" +
            "id=" + id +
            ", happenTime=" + happenTime +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", createBy=" + createBy +
            ", updateBy=" + updateBy +
        "}";
    }
}
