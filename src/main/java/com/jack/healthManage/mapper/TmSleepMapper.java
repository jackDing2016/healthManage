package com.jack.healthManage.mapper;

import com.jack.healthManage.entity.TmSleep;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.healthManage.vo.SleepVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2022-10-12
 */
public interface TmSleepMapper extends BaseMapper<TmSleep> {

    List<SleepVO> listAll();

}
