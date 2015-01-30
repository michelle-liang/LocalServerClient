package com.itu.localserver.client;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.itu.bean.SmartMeterData;
import com.itu.bean.Student;
import com.itu.util.HibernateUtil;
import com.itu.util.Log4jUtil;

public class HibernateTest extends TestCase {

	// static final Logger logger = Logger.getLogger(Log4jTest.class);
	static Logger logger = Log4jUtil.getLogger(HibernateTest.class);

	@Override
	protected void setUp() throws Exception {
	}

	@Override
	protected void tearDown() throws Exception {
	}

	public void testHibernate() {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Hibernate:
		// session.beginTransaction();
		// Stock stock = new Stock();
		//
		// stock.setStockCode("4177");
		// stock.setStockName("PETER2");
		//
		// session.save(stock);
		//
		// session.getTransaction().commit();
		logger.debug("session open correctly");
		session.close();
		logger.debug("session close correctly");
	}

	public void testSelectStock() {

		Session s = null;

		try {
			s = HibernateUtil.getSessionFactory().openSession();
			// from后面是对象，不是表名
			String hql = "from SmartMeterData as st where st.smIndex=:id";// 使用命名参数，推荐使用，易读。
			Query query = s.createQuery(hql);
			query.setInteger("id", 18);
			List<SmartMeterData> list = query.list();
			for (SmartMeterData ss : list) {
				logger.info(String.format("rmsV1 name:%s", ss.getRmsV1()));
			}
		} catch (Exception e) {
			logger.debug("exception:" + e);
			fail(e.getMessage());
		} finally {

			if (s != null)
				s.close();
		}
	}

//	public void testQueryStudent() {
//
//		Session s = null;
//
//		try {
//			s = HibernateUtil.getSessionFactory().openSession();
//			Query q = s.createSQLQuery("select * from student").addEntity(Student.class);
//			List<Student> list = q.list();
//			logger.debug("size of students:" + list.size());
//			for (Student stu : list) {
//				logger.info("stu name:"+stu.getName());
//			}
//
//		}catch(Exception e){
//			// logger.debug(e);
//			fail(e.getMessage());
//		}
//		
//		finally {
//			if (s != null)
//				s.close();
//		}
//
//	}
}
