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
        log.info("======RoncooUserController.selectByid=====传入的参数==id:"+id);
        RoncooUser roncooUser = null;
        try {
            roncooUser=roncooUserService.selectByPrimaryKey(id);
            log.info("======RoncooUserController.selectByid=====返回==roncooUser:"+ JSON.toJSONString(roncooUser));
        } catch (Exception e) {
            log.error("======RoncooUserController.selectByid=====异常==e:",e);
            return null;
        }
        return roncooUser;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String insert(RoncooUser roncooUser){
        log.info("======RoncooUserController.insert=====传入的参数==roncooUser:"+JSON.toJSONString(roncooUser));
        try {
            int result=roncooUserService.insert(roncooUser);
            log.info("======RoncooUserController.insert=====返回=result:"+result);
        } catch (Exception e) {
            log.error("======RoncooUserController.insert=====异常==e:",e);
            return "===insert异常==";
        }
        return "===insert成功==";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(RoncooUser roncooUser){
        log.info("======RoncooUserController.update=====传入的参数==roncooUser:"+JSON.toJSONString(roncooUser));
        try {
            int result=roncooUserService.update(roncooUser);
            log.info("======RoncooUserController.update=====返回=result:"+result);
        } catch (Exception e) {
            log.error("======RoncooUserController.update=====异常==e:",e);
            return "===update异常==";
        }
        return "===update成功==";
    }

}
