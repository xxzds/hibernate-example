package com.anjz.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.anjz.dao.intf.AbcUserDao;
import com.anjz.model.AbcUser;
import com.anjz.util.HibernateUtil;

/**
 * 
 * @author shuai.ding
 * @date 2016年11月18日下午4:54:42
 */
public class AbcUserDaoImpl implements AbcUserDao{

	@Override
	public AbcUser findById(String id) throws Exception {		
		 //获取Session  
        Session session = HibernateUtil.openSession();  
        
        session.beginTransaction();
        AbcUser user = (AbcUser)session.get(AbcUser.class, id);
        session.getTransaction().commit();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AbcUser> findByUser(AbcUser user){
		//获取Session  
        Session session = HibernateUtil.openSession();  
        
        session.beginTransaction();
        
        Criteria c = session.createCriteria(AbcUser.class);
        if(user!=null){
        	if(StringUtils.isNotEmpty(user.getId())){
        		c.add(Restrictions.eq("id", user.getId()));
        	}
        	if(StringUtils.isNotEmpty(user.getUsername())){
        		c.add(Restrictions.eq("username", user.getUsername()));
        	}
        	if(StringUtils.isNotEmpty(user.getPassword())){
        		c.add(Restrictions.eq("password", user.getPassword()));
        	}
        }
        List<AbcUser> resultList = c.list();
        session.getTransaction().commit();
		return resultList;
	}

	@Override
	public String insert(AbcUser user) {
		//获取Session  
        Session session = HibernateUtil.openSession();  

        if(user!=null){
        	session.beginTransaction();
        	String id =(String)session.save(user);
        	session.getTransaction().commit();
        	return id;
        }            
        return null;
	}

	@Override
	public void update(AbcUser user) {
		//获取Session  
        Session session = HibernateUtil.openSession();  

        if(user!=null){
        	session.beginTransaction();
        	session.update(user);
        	session.getTransaction().commit();
        }    
	}
}
