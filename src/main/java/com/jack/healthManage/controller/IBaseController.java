package com.jack.healthManage.controller;

import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

public interface IBaseController<T> {


    void add(T t);

    void update(T t);

    void delete( Serializable id );

    T get( Serializable id );
}
