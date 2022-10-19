package com.jack.healthManage.controller;

import com.jack.healthManage.entity.TmMasturbation;
import com.jack.healthManage.service.ITmMasturbationService;
import com.jack.healthManage.vo.MasturbationMonthlyVO;
import com.jack.healthManage.vo.MasturbationStatisticsVO;
import com.jack.healthManage.vo.MasturbationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jack
 * @since 2022-09-26
 */
@RestController
@RequestMapping("/tmMasturbation")
public class TmMasturbationController extends BaseController<TmMasturbation, ITmMasturbationService> {

    @PostMapping( "/addByHappenTime" )
    @ResponseBody String addByHappenTime(@RequestParam LocalDateTime happenTime) {
        is.add(happenTime);
        return "success";
    }

    @PostMapping( "/initialData" )
    @ResponseBody String initialData() {
        is.initialData();
        return "success";
    }

    @GetMapping("/queryMasturbationMonthlyVOListByPeriod")
    @ResponseBody
    List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByPeriod(
            @RequestParam @DateTimeFormat( iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat( iso = DateTimeFormat.ISO.DATE) LocalDate end ) {
        return is.queryMasturbationMonthlyVOListByPeriod( start, end );
    }

    @GetMapping("/calculateHowAverageLongOneAllTime")
    @ResponseBody Double calculateHowAverageLongOneAllTime(){
        return is.calculateHowAverageLongOneAllTime();
    }

    @GetMapping("/calculateHowLongFromLastOnceToNow")
    @ResponseBody Long calculateHowLongFromLastOnceToNow(){
        return is.calculateHowLongFromLastOnceToNow();
    }

    @GetMapping("/calculateMaxPeriodWithNoMasturbationAllTime")
    @ResponseBody Integer calculateMaxPeriodWithNoMasturbationAllTime(){
        return is.calculateMaxPeriodWithNoMasturbationAllTime();
    }

    @GetMapping( "/listAll" )
    @ResponseBody List<MasturbationVO> listAll() {
        return is.listAll();
    }

    @GetMapping("/getPageList")
    @ResponseBody List<MasturbationVO> getPageList( @RequestParam Integer pageNumber, @RequestParam Integer pageSize ) {
        return is.getPageList( pageSize, pageNumber );
    }

    @GetMapping( "/justTest" )
    @ResponseBody String justTest() {
        return "hi guy";
    }

    @GetMapping( "/justTestTwo" )
    @ResponseBody MasturbationVO justTestTwo() {
        return listAll().get( 0 );
    }

    @GetMapping( "/getMasturbationStatisticsVO" )
    @ResponseBody
    MasturbationStatisticsVO getMasturbationStatisticsVO() {
        return is.getMasturbationStatisticsVO();
    }

    @GetMapping( "/getAnnualLimit" )
    @ResponseBody Integer getAnnualLimit() {
        return is.getAnnualLimit();
    }

    @GetMapping( "/getAnnualUsed" )
    @ResponseBody Long getAnnualUsed() {
        return is.getAnnualUsed();
    }

}
