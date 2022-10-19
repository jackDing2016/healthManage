package com.jack.healthManage.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public class BaseController<T, IS extends IService<T>> implements IBaseController<T> {

    @Autowired
    protected IS is;

    @PostMapping("/add")
    @Override
    public void add(@RequestBody T t) {
        is.save(t);
    }

    @PostMapping("/update")
    @Override
    public void update(T t) {
        is.saveOrUpdate(t);
    }

    @DeleteMapping( "/" )
    @Override
    public void delete(Serializable id) {
        is.removeById(id);
    }

    @GetMapping( "/get" )
    @Override
    public @ResponseBody T get( @RequestParam Serializable id) {
        return is.getById( id );
    }

    @GetMapping( "/testInSuper" )
    @ResponseBody String testInSuper( @RequestParam String name ) {
        return name;
    }

}
