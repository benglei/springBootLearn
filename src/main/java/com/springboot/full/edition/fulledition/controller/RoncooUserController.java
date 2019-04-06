package com.springboot.full.edition.fulledition.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.service.RoncooUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNameRoncooUserController
 * @Description
 * @Author
 * @Date2019/4/6 18:22
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "/roncooUser")
public class RoncooUserController {
    private static final Logger log = LoggerFactory.getLogger(RoncooUserController.class);
    @Autowired
    private RoncooUserService roncooUserService;

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET )
    public RoncooUser selectByPrimaryKey(@RequestParam(value = "id")int id){
        System.out.println("======RoncooUserController.selectByPrimaryKey=====传入的参数==id:"+id);
        log.info("======RoncooUserController.selectByPrimaryKey=====传入的参数==id:"+id);
        RoncooUser roncooUser = null;
        try {
            roncooUser=roncooUserService.selectByPrimaryKey(id);
            log.info("======RoncooUserController.selectByPrimaryKey=====返回==roncooUser:"+ JSON.toJSONString(roncooUser));
        } catch (Exception e) {
            log.error("======RoncooUserController.selectByPrimaryKey=====异常==e:",e);
        }
        return roncooUser;
    }

    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET )
    public RoncooUser selectByid(@PathVariable(value = "id") int id){
        System.out.println("======RoncooUserController.selectByPrimaryKey=====传入的参数==id:"+id);
        log.info("======RoncooUserController.selectByPrimaryKey=====传入的参数==id:"+id);
        RoncooUser roncooUser = null;
        try {
            roncooUser=roncooUserService.selectByPrimaryKey(id);
            log.info("======RoncooUserController.selectByPrimaryKey=====返回==roncooUser:"+ JSON.toJSONString(roncooUser));
        } catch (Exception e) {
            log.error("======RoncooUserController.selectByPrimaryKey=====异常==e:",e);
            return null;
        }
        return roncooUser;
    }


}
