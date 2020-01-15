package com.learn.common.service;

import com.learn.common.entity.Result;
import com.learn.common.dao.TestMapper;
import org.springframework.stereotype.Service;

@Service
public class TestService extends CommonService<Result, TestMapper> {
}
