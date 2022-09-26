package com.jack.healthManage.service;

import com.jack.healthManage.entity.TmMasturbation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.healthManage.vo.MasturabationMonthlyVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jack
 * @since 2022-09-26
 */
public interface ITmMasturbationService extends IService<TmMasturbation> {

    void add(LocalDateTime happenTime);

    void add();

    void initialData();

    List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByPeriod(LocalDate start, LocalDate end);

    List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByMonth( int year, int month );

    List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByCurrentMonth();

}
