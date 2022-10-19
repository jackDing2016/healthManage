package com.jack.healthManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jack.healthManage.constant.SleepQualityEnum;
import com.jack.healthManage.entity.TmSleep;
import com.jack.healthManage.mapper.TmSleepMapper;
import com.jack.healthManage.service.ITmSleepService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.healthManage.vo.SleepStatisticsVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack
 * @since 2022-10-12
 */
@Service
public class TmSleepServiceImpl extends ServiceImpl<TmSleepMapper, TmSleep> implements ITmSleepService {

    @Override
    public double getHowAverageLongAllTime() {
        List<TmSleep> list = list();
        long sumSleep = 0;
        for ( TmSleep sleep : list ) {
            sumSleep += Duration.between(sleep.getStartTime(), sleep.getEndTime()).toMinutes();
        }
        return sumSleep / list.size() / 60;
    }

    @Override
    public int getMaxRecordWithContinuousHighQuality(List<TmSleep> sleepList) {
        if ( CollectionUtils.isEmpty(sleepList) ) return 0;
        sleepList.sort(Comparator.comparing( TmSleep::getStartTime ));
        int res = 0; int currentRes = 0;
        for (TmSleep sleep : sleepList) {
            if ( SleepQualityEnum.GOOD.getCode() != sleep.getSleepQuality()) currentRes = 0;
            else res = Math.max( res, ++currentRes  );
        }
        return res;
    }

    @Override
    public int getHowLongFromLastHighQualityToNow() {
        LambdaQueryWrapper<TmSleep> lambdaQueryWrapper =
                new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq( TmSleep::getSleepQuality, SleepQualityEnum.GOOD.getCode() );
        List<TmSleep> list = baseMapper.selectList( lambdaQueryWrapper);
        list.sort(Comparator.comparing( TmSleep::getStartTime ).reversed());
        return (int)Duration.between(list.get(0).getStartTime(), LocalDateTime.now()).toDays();
    }

    @Override
    public int getStayUpAnnualLimit() {
        return 52;
    }

    @Override
    public int getStayUpAnnualUsed() {
        return (int) list().stream().filter( x -> x.getStartTime().getHour() == 23 ||
                        (x.getStartTime().getHour() > 0 && x.getStartTime().getHour() < 8)
                ).count();
    }

    @Override
    public SleepStatisticsVO getSleepStatisticsVO() {
        SleepStatisticsVO sleepStatisticsVO = new SleepStatisticsVO();
        sleepStatisticsVO.setStayUpAnnualLimit( getStayUpAnnualLimit() );
        sleepStatisticsVO.setStayUpAnnualUsed( getStayUpAnnualUsed() );
        sleepStatisticsVO.setHowAverageLongAllTime( getHowAverageLongAllTime() );
        sleepStatisticsVO.setMaxRecordWithContinuousHighQuality( getMaxRecordWithContinuousHighQualityAllTime() );
        sleepStatisticsVO.setHowLongFromLastHighQualityToNow( getHowLongFromLastHighQualityToNow() );
        return sleepStatisticsVO;
    }

    @Override
    public int getMaxRecordWithContinuousHighQualityAllTime() {

        return getMaxRecordWithContinuousHighQuality(list());
    }
}
