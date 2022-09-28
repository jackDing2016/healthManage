package com.jack.healthManage.service;

import com.jack.healthManage.entity.TmMasturbation;
import com.jack.healthManage.mapper.TmMasturbationMapper;
import com.jack.healthManage.service.impl.TmMasturbationServiceImpl;
import com.jack.healthManage.vo.MasturbationVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TmMasturbationServiceImplyTest {

    @InjectMocks
    TmMasturbationServiceImpl masturbationService;

    @Mock
    TmMasturbationMapper masturbationMapper;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void calculateHowAverageLongOnceTest() {
        List<TmMasturbation> dummyMasturbationList = new ArrayList<>();
        TmMasturbation masturbation = new TmMasturbation( LocalDateTime.now().minusDays( 6 ) );
        dummyMasturbationList.add( masturbation );
        Assertions.assertEquals( 6.0, masturbationService.calculateHowAverageLongOnce(dummyMasturbationList) );
    }

    @Test
    public void calculateHowLongFromLastOnceToNowTest() {
        MasturbationVO masturbationVO = new MasturbationVO();
        masturbationVO.setHappenTime( LocalDateTime.now().minusDays( 1 ) );
        Mockito.when( masturbationMapper.getLastMasturbationVO() ).thenReturn( masturbationVO );
        Assertions.assertEquals( 1, masturbationService.calculateHowLongFromLastOnceToNow() );
    }

    @Test
    public void calculateMaxPeriodWithNoMasturbationTest() {
        List<TmMasturbation> dummyMasturbationList = new ArrayList<>();
        TmMasturbation masturbation = new TmMasturbation( LocalDateTime.now().minusDays( 6 ) );
        dummyMasturbationList.add( masturbation );
        Assertions.assertEquals( 6, masturbationService.calculateMaxPeriodWithNoMasturbation(dummyMasturbationList) );
    }

}
