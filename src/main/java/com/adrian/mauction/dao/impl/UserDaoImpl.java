package com.adrian.mauction.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.adrian.mauction.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Resource(name = "sqlSession")
	private SqlSessionTemplate session;
	
}
