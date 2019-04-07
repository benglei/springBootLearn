/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.springboot.full.edition.fulledition.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * 
 * @author wujing
 */
public class RoncooUser implements Serializable {
	private static final long serialVersionUID = -6558279573469790016L;

	private int id;
	private String name;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "RoncooUser [id=" + id + ", name=" + name + ", createTime=" + createTime + "]";
	}

}
