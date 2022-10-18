package com.jack.healthManage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jack.healthManage.constant.SleepQualityEnum;
import com.jack.healthManage.entity.TmSleep;
import com.jack.healthManage.mapper.TmSleepMapper;
import com.jack.healthManage.service.impl.TmSleepServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TmSleepServiceImplyTest {

    @InjectMocks
    TmSleepServiceImpl sleepService;

    @Mock
    TmSleepMapper sleepMapper;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void getHowAverageLongAllTimeTest() {

        List<TmSleep> dummySleepList = new ArrayList<>();
        TmSleep sleep1 = new TmSleep();
        sleep1.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep1.setStartTime( LocalDateTime.of( 2022, 10, 1, 1,0,0 ) );
        sleep1.setEndTime( LocalDateTime.of( 2022, 10, 1, 10,0,0 ) );
        dummySleepList.add( sleep1 );

        TmSleep sleep2 = new TmSleep();
        sleep2.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep2.setStartTime( LocalDateTime.of( 2022, 10, 2, 1,0,0 ) );
        sleep2.setEndTime( LocalDateTime.of( 2022, 10, 2, 10,0,0 ) );
        dummySleepList.add( sleep2 );

        TmSleep sleep3 = new TmSleep();
        sleep3.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep3.setStartTime( LocalDateTime.of( 2022, 10, 3, 1,0,0 ) );
        sleep3.setEndTime( LocalDateTime.of( 2022, 10, 3, 10,0,0 ) );
        dummySleepList.add( sleep3 );

        Mockito.when( sleepService.list() ).thenReturn( dummySleepList );

        Assertions.assertEquals( 9.0, sleepService.getHowAverageLongAllTime() );
    }

    @Test
    public void getHowLongFromLastHighQualityToNowTest() {
        List<TmSleep> dummySleepList = new ArrayList<>();
        TmSleep sleep1 = new TmSleep();
        sleep1.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep1.setStartTime( LocalDateTime.of( 2022, 10, 1, 1,0,0 ) );
        sleep1.setEndTime( LocalDateTime.of( 2022, 10, 1, 10,0,0 ) );
        dummySleepList.add( sleep1 );

        TmSleep sleep2 = new TmSleep();
        sleep2.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep2.setStartTime( LocalDateTime.of( 2022, 10, 2, 1,0,0 ) );
        sleep2.setEndTime( LocalDateTime.of( 2022, 10, 2, 10,0,0 ) );
        dummySleepList.add( sleep2 );

        TmSleep sleep3 = new TmSleep();
        sleep3.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep3.setStartTime( LocalDateTime.of( 2022, 10, 3, 1,0,0 ) );
        sleep3.setEndTime( LocalDateTime.of( 2022, 10, 3, 10,0,0 ) );
        dummySleepList.add( sleep3 );

//        Mockito.when( sleepService.list( new LambdaQueryWrapper<TmSleep>()
//                .eq( TmSleep::getSleepQuality, 1))).thenReturn( dummySleepList );

        Mockito.doReturn( dummySleepList ).when( sleepMapper).selectList( Mockito.any())
        ;

        Assertions.assertEquals( 15, sleepService.getHowLongFromLastHighQualityToNow() );
    }

    @Test
    public void getMaxRecordWithContinuousHighQualityTest() {
        List<TmSleep> dummySleepList = new ArrayList<>();
        TmSleep sleep1 = new TmSleep();
        sleep1.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep1.setStartTime( LocalDateTime.of( 2022, 10, 1, 0,0,0 ) );
        dummySleepList.add( sleep1 );

        TmSleep sleep2 = new TmSleep();
        sleep2.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep2.setStartTime( LocalDateTime.of( 2022, 10, 2, 0,0,0 ) );
        dummySleepList.add( sleep2 );

        TmSleep sleep3 = new TmSleep();
        sleep3.setSleepQuality(SleepQualityEnum.GOOD.getCode());
        sleep3.setStartTime( LocalDateTime.of( 2022, 10, 3, 0,0,0 ) );
        dummySleepList.add( sleep3 );

        Assertions.assertEquals( 3, sleepService.getMaxRecordWithContinuousHighQuality( dummySleepList ) );
    }

}
