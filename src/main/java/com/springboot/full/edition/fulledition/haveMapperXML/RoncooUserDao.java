package com.springboot.full.edition.fulledition.haveMapperXML;

import com.springboot.full.edition.fulledition.bean.RoncooUser;
import com.springboot.full.edition.fulledition.bean.RoncooUserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoncooUserDao {
	int countByExample(RoncooUserExample example);

	int deleteByExample(RoncooUserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(RoncooUser record);

	int insertSelective(RoncooUser record);

	List<RoncooUser> selectByExample(RoncooUserExample example);

	RoncooUser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);

	int updateByExample(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);

	int updateByPrimaryKeySelective(RoncooUser record);

	int updateByPrimaryKey(RoncooUser record);
}
