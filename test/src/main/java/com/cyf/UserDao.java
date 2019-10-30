package com.cyf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao {
	
	
	public Map queryUserById(int id) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 2.��ȡ�����ļ�������
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

		// 3.ʹ��sqlSessionFactory���󣬴���SqlSession����
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 4.ʹ��sqlSession���󣬵��÷���ִ��
				Object user = sqlSession.selectOne("queryUserById", id);
				System.out.println(user);
				// 5.�ͷ���Դ
				sqlSession.close();

		
		return (Map) user;
		
	}

}
