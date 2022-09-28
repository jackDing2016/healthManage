package com.jack.healthManage.service;

import com.jack.healthManage.entity.TmMasturbation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.healthManage.vo.MasturbationMonthlyVO;

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

    List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByPeriod(LocalDate start, LocalDate end);

    List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByMonth(int year, int month );

    List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByCurrentMonth();

    Double calculateHowAverageLongOnce(List<TmMasturbation> masturbationList);

    Double calculateHowAverageLongOneAllTime();

    Long calculateHowLongFromLastOnceToNow();

    Integer calculateMaxPeriodWithNoMasturbation(List<TmMasturbation> masturbationList);

    Integer calculateMaxPeriodWithNoMasturbationAllTime();

}
