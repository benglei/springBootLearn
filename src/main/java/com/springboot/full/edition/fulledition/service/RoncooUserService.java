package com.springboot.full.edition.fulledition.service;

import com.alibaba.fastjson.JSON;
import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.noMapperXML.RoncooUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @ClassNameRoncooUserService
 * @Description
 * @Author
 * @Date2019/4/6 18:03
 * @Version V1.0
 **/
@Service
public class RoncooUserService {
    private static final Logger log = LoggerFactory.getLogger(RoncooUserService.class);
    @Autowired
    private RoncooUserMapper roncooUserMapper;

    public int insert(RoncooUser roncooUser) throws Exception{
        //log.info("=====RoncooUserService.insert===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserMapper.insert(roncooUser);
        //log.info("=====RoncooUserService.insert===返回===result:"+ result);
        return result;
    }

    public int update(RoncooUser roncooUser) throws Exception{
        //log.info("=====RoncooUserService.update===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserMapper.update(roncooUser);
        //log.info("=====RoncooUserService.update===返回===result:"+ result);
        return result;
    }

    public RoncooUser selectByPrimaryKey(Integer id) throws Exception{
        //log.info("=====RoncooUserService.selectByPrimaryKey===传入的参数===id:"+ id);
        RoncooUser roncooUser = roncooUserMapper.selectByPrimaryKey(id);
        //log.info("=====RoncooUserService.selectByPrimaryKey===返回====roncooUser:"+ JSON.toJSONString(roncooUser));
        return roncooUser;
    }
}
