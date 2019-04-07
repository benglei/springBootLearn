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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String insert(RoncooUser roncooUser){
        log.info("======UseRoncooUserXXMLController.insert=====传入的参数==roncooUser:"+JSON.toJSONString(roncooUser));
        try {
            int result=useRoncooUserXMLService.insert(roncooUser);
            log.info("======UseRoncooUserXXMLController.insert=====返回=result:"+result);
        } catch (Exception e) {
            log.error("======UseRoncooUserXXMLController.insert=====异常==e:",e);
            return "===insert异常==";
        }
        return "===insert成功==";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(RoncooUser roncooUser){
        log.info("======UseRoncooUserXXMLController.update=====传入的参数==roncooUser:"+JSON.toJSONString(roncooUser));
        try {
            int result=useRoncooUserXMLService.update(roncooUser);
            log.info("======UseRoncooUserXXMLController.update=====返回=result:"+result);
        } catch (Exception e) {
            log.error("======UseRoncooUserXXMLController.update=====异常==e:",e);
            return "===update异常==";
        }
        return "===update成功==";
    }

}
