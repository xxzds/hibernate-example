package com.anjz.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anjz.dao.impl.AbcUserDaoImpl;
import com.anjz.dao.intf.AbcUserDao;
import com.anjz.model.AbcUser;
import com.anjz.util.UuidUtil;
import com.sun.jmx.snmp.UserAcl;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月18日下午5:00:42
 */
public class AbcUserTest {
	
	private Logger logger = LoggerFactory.getLogger(AbcUserTest.class);
	
	private AbcUserDao abcUserDao;

	@Before
	public void Before(){
		abcUserDao=new AbcUserDaoImpl();
	}
	
	@Test
	public void findByIdTest(){
		try {
			AbcUser user = abcUserDao.findById("1");
			logger.info("返回结果："+user.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void findByUser(){
		AbcUser user = new AbcUser();
		user.setUsername("a");
		abcUserDao.findByUser(user);
	}
	
	@Test
	public void insertUserTest(){
		AbcUser user=new AbcUser();	
		user.setId(UuidUtil.generateUuid32());
		user.setUsername("哈哈");
		user.setPassword("123456");
		String id = abcUserDao.insert(user);
		logger.info("插入返回的主键："+id);
	}
	
	@Test
	public void updateTest(){
		AbcUser user=new AbcUser();	
//		user.setId("74b267f980744de39fc829ca8d53fe318");
		user.setUsername("哈哈1");
		user.setPassword("123456");
		abcUserDao.update(user);
	}
}
