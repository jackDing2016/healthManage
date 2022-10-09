package com.jack.healthManage.controller;

import com.jack.healthManage.service.ITmMasturbationService;
import com.jack.healthManage.vo.MasturbationMonthlyVO;
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
public class TmMasturbationController {

    @Autowired
    private ITmMasturbationService masturbationService;

    @PostMapping( "/add" )
    @ResponseBody String add() {
        masturbationService.add();
        return "success";
    }

    @PostMapping( "/addByHappenTime" )
    @ResponseBody String addByHappenTime(@RequestParam LocalDateTime happenTime) {
        masturbationService.add(happenTime);
        return "success";
    }

    @PostMapping( "/initialData" )
    @ResponseBody String initialData() {
        masturbationService.initialData();
        return "success";
    }

    @GetMapping("/queryMasturbationMonthlyVOListByPeriod")
    @ResponseBody
    List<MasturbationMonthlyVO> queryMasturbationMonthlyVOListByPeriod(
            @RequestParam @DateTimeFormat( iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat( iso = DateTimeFormat.ISO.DATE) LocalDate end ) {
        return masturbationService.queryMasturbationMonthlyVOListByPeriod( start, end );
    }

    @GetMapping("/calculateHowAverageLongOneAllTime")
    @ResponseBody Double calculateHowAverageLongOneAllTime(){
        return masturbationService.calculateHowAverageLongOneAllTime();
    }

    @GetMapping("/calculateHowLongFromLastOnceToNow")
    @ResponseBody Long calculateHowLongFromLastOnceToNow(){
        return masturbationService.calculateHowLongFromLastOnceToNow();
    }

    @GetMapping("/calculateMaxPeriodWithNoMasturbationAllTime")
    @ResponseBody Integer calculateMaxPeriodWithNoMasturbationAllTime(){
        return masturbationService.calculateMaxPeriodWithNoMasturbationAllTime();
    }

    @GetMapping( "/listAll" )
    @ResponseBody List<MasturbationVO> listAll() {
        return masturbationService.listAll();
    }

    @GetMapping("/getPageList")
    @ResponseBody List<MasturbationVO> getPageList( @RequestParam Integer pageNumber, @RequestParam Integer pageSize ) {
        return masturbationService.getPageList( pageSize, pageNumber );
    }

    @GetMapping( "/justTest" )
    @ResponseBody String justTest() {
        return "hi guy";
    }

    @GetMapping( "/justTestTwo" )
    @ResponseBody MasturbationVO justTestTwo() {
        return listAll().get( 0 );
    }

}
