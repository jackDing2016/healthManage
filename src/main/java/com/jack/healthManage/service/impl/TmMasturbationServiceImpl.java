package com.jack.healthManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.jack.healthManage.entity.TmMasturbation;
import com.jack.healthManage.mapper.TmMasturbationMapper;
import com.jack.healthManage.service.ITmMasturbationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.healthManage.vo.MasturbationMonthlyVO;
import com.jack.healthManage.vo.MasturbationStatisticsVO;
import com.jack.healthManage.vo.MasturbationVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jack
 * @since 2022-09-26
 */
@Service
public class TmMasturbationServiceImpl extends ServiceImpl<TmMasturbationMapper, TmMasturbation> implements ITmMasturbationService {

    @Transactional
    @Override
    public void add(LocalDateTime happenTime) {
        TmMasturbation masturbation = new TmMasturbation();
        masturbation.setHappenTime(happenTime);
        save(masturbation);
    }

    @Transactional
    @Override
    public void add() {
        add(LocalDateTime.now());
    }


    @Transactional
    @Override
    public void initialData() {
        initMonthData( 2022, 1, 6 );
        initMonthData( 2022, 2, 7 );
        initMonthData( 2022, 3, 7 );
        initMonthData( 2022, 4, 4 );
        initMonthData( 2022, 5, 5 );
        initMonthData( 2022, 6, 4 );
        initMonthData( 2022, 7, 4 );
        initMonthData( 2022, 8, 3 );
        initMonthData( 2022, 9, 6 );
    }

    private void initMonthData(int year, int month, int quantity) {

        for ( int i = 0; i < quantity; i++ ) {
            LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
            LocalDate randomDayOfMonth =
                    firstDayOfMonth.plusDays(
                            ThreadLocalRandom.current().nextInt(27 + 1));
            add( randomDayOfMonth.atStartOfDay() );
        }

    }

    @Override
    public List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByPeriod(LocalDate start, LocalDate end) {

        List<TmMasturbation> list =
                list(
                        new LambdaQueryWrapper<TmMasturbation>()
                                .ge( TmMasturbation::getHappenTime, start.atStartOfDay() )
                                .le( TmMasturbation::getHappenTime, end.atTime(23, 59, 59) )
                );

        if ( !CollectionUtils.isEmpty( list )) {
            Map<String, Long> map =
            list.stream().collect( Collectors.groupingBy(  x -> x.getHappenTime().getYear() + "-" + x.getHappenTime().getMonthValue(), Collectors.counting() ) );
            List<MasturbationMonthlyVO> resultList = new ArrayList<>();
            for ( Map.Entry<String, Long> map1 : map.entrySet() ) {
                MasturbationMonthlyVO masturbationMonthlyVO = new MasturbationMonthlyVO();
                String[] yearMonthStrArr = map1.getKey().split( "-" );
                masturbationMonthlyVO.setYear( Integer.parseInt( yearMonthStrArr[0] ) );
                masturbationMonthlyVO.setMonth( Integer.parseInt( yearMonthStrArr[1] ) );
                masturbationMonthlyVO.setQuantity( map1.getValue().intValue() );
                resultList.add(masturbationMonthlyVO);
            }
            return resultList;
        }

        return null;
    }

    @Override
    public List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByMonth(int year, int month) {
        return null;
    }

    @Override
    public List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByCurrentMonth() {
        return null;
    }

    @Override
    public Double calculateHowAverageLongOnce(List<TmMasturbation> masturbationList) {
        if ( CollectionUtils.isEmpty(masturbationList) ) return null;
        masturbationList.sort(Comparator.comparing( TmMasturbation::getHappenTime ));
        LocalDateTime start = masturbationList.get(0).getHappenTime();
        LocalDateTime end = LocalDateTime.now();
        long days = Duration.between( start, end ).toDays();
        return days * 1.0 / masturbationList.size() ;
    }

    @Override
    public Double calculateHowAverageLongOneAllTime() {
        List<TmMasturbation> masturbationList = list();
        return calculateHowAverageLongOnce(masturbationList );
    }

    @Override
    public Long calculateHowLongFromLastOnceToNow() {
        MasturbationVO lastMasturbationVO = baseMapper.getLastMasturbationVO();
        return Duration.between( lastMasturbationVO.getHappenTime(), LocalDateTime.now() ).toDays();
    }

    @Override
    public Integer calculateMaxPeriodWithNoMasturbation(List<TmMasturbation> masturbationList) {
        if ( CollectionUtils.isEmpty(masturbationList) ) return null;
        masturbationList.sort(Comparator.comparing( TmMasturbation::getHappenTime ));
        int res = 0;
        for (int i = 0; i < masturbationList.size() - 1; i++ ) {
            res = Math.max( res, (int)Duration.between( masturbationList.get( i ).getHappenTime(), masturbationList.get( i + 1 ).getHappenTime() ).toDays() );
        }
        res = Math.max( res, (int) Duration.between( masturbationList.get( masturbationList.size() - 1 ).getHappenTime(), LocalDateTime.now() ).toDays() );
        return res;
    }

    @Override
    public Integer calculateMaxPeriodWithNoMasturbationAllTime() {
        return calculateMaxPeriodWithNoMasturbation( list() );
    }

    @Override
    public List<MasturbationVO> listAll() {
        return baseMapper.listAll();
    }

    @Override
    public List<MasturbationVO> getPageList(int pageSize, int pageNumber) {
        PageHelper.startPage(pageNumber, pageSize);
        return baseMapper.listAll();
    }

    @Override
    public MasturbationStatisticsVO getMasturbationStatisticsVO() {
        MasturbationStatisticsVO masturbationStatisticsVO = new MasturbationStatisticsVO();
        masturbationStatisticsVO.setMaxPeriodWithNoMasturbation( calculateMaxPeriodWithNoMasturbationAllTime() );
        masturbationStatisticsVO.setHowLongFromLastOnceToNow( calculateHowLongFromLastOnceToNow().intValue() );
        masturbationStatisticsVO.setHowAverageLongOneAllTime( calculateHowAverageLongOneAllTime() );
        return masturbationStatisticsVO;
    }
}
