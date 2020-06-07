package com.xxs.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static SqlSessionFactory factory;
	static {//在静态代码块下，factory只会被创建一个
		String config="mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(config);
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession createSqlSession() {
		return factory.openSession();
	}
	
	public static void closeSqlSession(SqlSession session) {
	   if(null!=null) {
		  session.close();
	   }
	}

}
