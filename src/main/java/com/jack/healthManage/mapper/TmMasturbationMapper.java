package com.jack.healthManage.mapper;

import com.jack.healthManage.entity.TmMasturbation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jack.healthManage.vo.MasturbationVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2022-09-26
 */
public interface TmMasturbationMapper extends BaseMapper<TmMasturbation> {

    MasturbationVO getLastMasturbationVO();

    List<MasturbationVO> listAll();




}
