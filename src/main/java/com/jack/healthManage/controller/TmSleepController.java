package com.jack.healthManage.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jack.healthManage.entity.TmSleep;
import com.jack.healthManage.service.ITmSleepService;
import com.jack.healthManage.service.impl.TmSleepServiceImpl;
import com.jack.healthManage.vo.SleepStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jack
 * @since 2022-10-12
 */
@RestController
@RequestMapping("/tmSleep")
public class TmSleepController extends BaseController<TmSleep, ITmSleepService> {

    @GetMapping( "/getSleepStatisticsVO" )
    @ResponseBody
    SleepStatisticsVO getSleepStatisticsVO() {
        return is.getSleepStatisticsVO();
    }

//    @Autowired
//    private IService<TmSleep> service;

//    @GetMapping( "/test" )
//    @ResponseBody
//    List<TmSleep> test() {
//        return service.list();
//    }

    @GetMapping( "/test" )
    @ResponseBody String test( @RequestParam String name ) {
        return name;
    }

}
