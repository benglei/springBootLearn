package com.springboot.full.edition.fulledition.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.service.UseRoncooUserXMLService;
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
@RequestMapping(value = "/roncooUserXML")
public class UseRoncooUserXXMLController {
    private static final Logger log = LoggerFactory.getLogger(UseRoncooUserXXMLController.class);
    @Autowired
    private UseRoncooUserXMLService useRoncooUserXMLService;

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET )
    public RoncooUser selectByPrimaryKey(@RequestParam(value = "id")int id){
        System.out.println("======UseRoncooUserXXMLController.selectByPrimaryKey=====传入的参数==id:"+id);
        log.info("======UseRoncooUserXXMLController.selectByPrimaryKey=====传入的参数==id:"+id);
        RoncooUser roncooUser = null;
        try {
            roncooUser=useRoncooUserXMLService.selectByPrimaryKey(id);
            log.info("======UseRoncooUserXXMLController.selectByPrimaryKey=====返回==roncooUser:"+ JSON.toJSONString(roncooUser));
        } catch (Exception e) {
            log.error("======UseRoncooUserXXMLController.selectByPrimaryKey=====异常==e:",e);
        }
        return roncooUser;
    }

    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET )
    public RoncooUser selectById(@PathVariable(value = "id") int id){
        System.out.println("======UseRoncooUserXXMLController.selectById=====传入的参数==id:"+id);
        log.info("======UseRoncooUserXXMLController.selectById=====传入的参数==id:"+id);
        RoncooUser roncooUser = null;
        try {
            roncooUser=useRoncooUserXMLService.selectByPrimaryKey(id);
            log.info("======UseRoncooUserXXMLController.selectById=====返回==roncooUser:"+ JSON.toJSONString(roncooUser));
        } catch (Exception e) {
            log.error("======UseRoncooUserXXMLController.selectById=====异常==e:",e);
            return null;
        }
        return roncooUser;
    }

}
