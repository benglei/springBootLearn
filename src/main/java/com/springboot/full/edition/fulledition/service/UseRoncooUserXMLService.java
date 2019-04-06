package com.springboot.full.edition.fulledition.service;

import com.alibaba.fastjson.JSON;
import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.haveMapperXML.RoncooUserDao;
import com.springboot.full.edition.fulledition.noMapperXML.RoncooUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassNameRoncooUserService
 * @Description
 * @Author
 * @Date2019/4/6 18:03
 * @Version V1.0
 **/
@Service
public class UseRoncooUserXMLService {
    private static final Logger log = LoggerFactory.getLogger(UseRoncooUserXMLService.class);
    @Autowired
    private RoncooUserDao roncooUserDao;//这个不用管理是idea的问题

    public int insert(RoncooUser roncooUser) throws Exception{
        //log.info("=====UseRoncooUserXMLService.insert===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserDao.insert(roncooUser);
        //log.info("=====UseRoncooUserXMLService.insert===返回===result:"+ result);
        return result;
    }

    public int update(RoncooUser roncooUser) throws Exception{
        //log.info("=====UseRoncooUserXMLService.updateByPrimaryKey===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserDao.updateByPrimaryKey(roncooUser);
        //log.info("=====UseRoncooUserXMLService.updateByPrimaryKey===返回===result:"+ result);
        return result;
    }

    public RoncooUser selectByPrimaryKey(Integer id) throws Exception{
        // log.info("=====UseRoncooUserXMLService.selectByPrimaryKey===传入的参数===id:"+ id);
        RoncooUser roncooUser = roncooUserDao.selectByPrimaryKey(id);
        //log.info("=====UseRoncooUserXMLService.selectByPrimaryKey===返回====roncooUser:"+ JSON.toJSONString(roncooUser));
        return roncooUser;
    }
}
