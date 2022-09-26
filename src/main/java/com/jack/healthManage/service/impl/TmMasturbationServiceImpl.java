package com.jack.healthManage.service.impl;

import com.jack.healthManage.entity.TmMasturbation;
import com.jack.healthManage.mapper.TmMasturbationMapper;
import com.jack.healthManage.service.ITmMasturbationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.healthManage.vo.MasturabationMonthlyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
                            ThreadLocalRandom.current().nextInt(30 + 1));
            add( randomDayOfMonth.atStartOfDay() );
        }

    }

    @Override
    public List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByPeriod(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByMonth(int year, int month) {
        return null;
    }

    @Override
    public List<MasturabationMonthlyVO> queryMasturabationMonthlyVOListByCurrentMonth() {
        return null;
    }
}
