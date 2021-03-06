package com.springboot.full.edition.fulledition.service;

import com.alibaba.fastjson.JSON;
import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.haveMapperXML.RoncooUserDao;
import com.springboot.full.edition.fulledition.noMapperXML.RoncooUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @ClassNameRoncooUserService
 * @Description
 * @Author
 * @Date2019/4/6 18:03
 * @Version V1.0
 **/
//缓存配置
@CacheConfig(cacheNames = "roncooCacheXML")
@Service
public class UseRoncooUserXMLService {
    private static final Logger log = LoggerFactory.getLogger(UseRoncooUserXMLService.class);
    @Autowired
    private RoncooUserDao roncooUserDao;//这个不用管理是idea的问题
    /*
     * 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
     * 是，它每次都会触发真实方法的调用。 适用于更新和插入
     * */
    @CachePut
    public int insert(RoncooUser roncooUser) throws Exception{
        log.info("=====UseRoncooUserXMLService.insert===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserDao.insert(roncooUser);
        //log.info("=====UseRoncooUserXMLService.insert===返回===result:"+ result);
        return result;
    }
    @CachePut
    public int update(RoncooUser roncooUser) throws Exception{
        log.info("=====UseRoncooUserXMLService.updateByPrimaryKey===传入的参数===roncooUser:"+ JSON.toJSONString(roncooUser));
        int result = roncooUserDao.updateByPrimaryKey(roncooUser);
        //log.info("=====UseRoncooUserXMLService.updateByPrimaryKey===返回===result:"+ result);
        return result;
    }

    /*
     * 应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
     *用方法获取数据，然后把数据添加到缓存中。 适用于查找
     * */
    @Cacheable
    public RoncooUser selectByPrimaryKey(Integer id) throws Exception{
        log.info("=====UseRoncooUserXMLService.selectByPrimaryKey===传入的参数===id:"+ id);
        RoncooUser roncooUser = roncooUserDao.selectByPrimaryKey(id);
        //log.info("=====UseRoncooUserXMLService.selectByPrimaryKey===返回====roncooUser:"+ JSON.toJSONString(roncooUser));
        return roncooUser;
    }

    /*
     * 主要针对方法配置，能够根据一定的条件对缓存进行清空。 适用于删除
     * */
    @CacheEvict
    public int delete(Integer id) throws Exception{
        int result=roncooUserDao.deleteByPrimaryKey(id);
        log.info("=====RoncooUserService.delete===返回===result:"+ result);
        return result;
    }
}
