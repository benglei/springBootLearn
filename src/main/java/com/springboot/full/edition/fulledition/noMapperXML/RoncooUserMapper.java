package com.springboot.full.edition.fulledition.noMapperXML;

import com.springboot.full.edition.fulledition.bean.RoncooUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoncooUserMapper {
	@Insert(value = "insert into roncoo_user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
	public int insert(RoncooUser record);

	@Select(value = "select id, name, create_time from roncoo_user where id = #{id}")
	@Results(value = { @Result(column = "create_time", property = "createTime") })
	public RoncooUser selectByPrimaryKey(Integer id);
	@Update(value="update roncoo_user set name=#{name},create_time=#{createTime}")
	public int update(RoncooUser record);
	@Select("select * from roncoo_user where name like concat('%',#{name},'%')")
	public List<RoncooUser> likeName(String name);
}
