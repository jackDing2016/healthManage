package com.jack.healthManage.service;

import com.jack.healthManage.entity.TmSleep;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.healthManage.vo.SleepStatisticsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jack
 * @since 2022-10-12
 */
public interface ITmSleepService extends IService<TmSleep> {

    double getHowAverageLongAllTime();

    int getMaxRecordWithContinuousHighQuality( List<TmSleep> sleepList );

    int getMaxRecordWithContinuousHighQualityAllTime();

    int getHowLongFromLastHighQualityToNow();

    int getStayUpAnnualLimit();

    int getStayUpAnnualUsed();

    SleepStatisticsVO getSleepStatisticsVO();


}
