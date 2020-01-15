package com.learn.common.controller;

import com.learn.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共控制类
 * @param <E>公共类对应实体类
 * @param <S>公共类服务类
 */
public class CommonController<E,S extends CommonService> {

    @Autowired
    private  S service;

    public S getService() {
        return service;
    }

    public void setService(S service) {
        this.service = service;
    }

    @RequestMapping("insert")
    public void insert(E entity){
        service.insert(entity);
    }

    @RequestMapping("deleteByEntity")
    public void deleteByEntity(E entity){
        service.deleteByEntity(entity);
    }

    @RequestMapping("deleteById")
    public void deleteById(Object id){
        service.deleteById(id);
    }

    @RequestMapping("updateByEntity")
    public void updateByEntity(E entity){
        service.updateByEntity(entity);
    }

    @RequestMapping("updateByEntitySelective")
    public void updateByEntitySelective(E entity){
        service.updateByEntitySelective(entity);
    }

    @RequestMapping("selectById")
    public void select(Object id){
        service.selectById(id);
    }


}
