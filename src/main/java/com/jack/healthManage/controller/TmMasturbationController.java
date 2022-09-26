package com.jack.healthManage.controller;

import com.jack.healthManage.service.ITmMasturbationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

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

}
