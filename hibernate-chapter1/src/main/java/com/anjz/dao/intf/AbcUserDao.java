package com.anjz.dao.intf;

import java.util.List;

import com.anjz.model.AbcUser;


/**
 * 
 * @author shuai.ding
 * @date 2016年11月18日下午4:54:25
 */
public interface AbcUserDao {
	
	/**
	 * 通过主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AbcUser findById(String id) throws Exception;
	
	
	public List<AbcUser> findByUser(AbcUser user);
	
	/**
	 * 插入-返回主键
	 * @param user
	 * @return
	 */
	public String insert(AbcUser user);
	
	public void update(AbcUser user);
}
