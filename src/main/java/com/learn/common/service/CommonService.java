package com.learn.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import java.lang.reflect.ParameterizedType;

/**
 * 公共服务
 * @param <E>服务类实体类
 * @param <M>服务类映射类
 */
public class CommonService<E,M extends Mapper<E>> {
    @Autowired
    protected M mapper;

    protected Class<E> entityType;

    public CommonService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityType = (Class<E>) pt.getActualTypeArguments()[0];
    }

    public void insert(E entity) {
        mapper.insert(entity);
    }

    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void deleteByEntity(E entity) {
        mapper.delete(entity);
    }

    public void updateByEntity(E entity) {
        mapper.updateByPrimaryKey(entity);
    }

    public void updateByEntitySelective(E entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

    public E selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


}
