package com.itu.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
//import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.mysql.jdbc.Connection;

@Path("/dto")
public class DTO {

	// connect to database directly.
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		String dbUrl = "jdbc:mysql://localhost:3306/itu";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * from student";
		String username = "root";
		String password = "gqq";
		try {

			Class.forName(dbClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			String s = "";
			while (resultSet.next()) {
				String sName = resultSet.getString("name");
				s += sName;
				System.out.println("student name : " + sName);
			}

			connection.close();
			return s;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// fail(e.getMessage());
		} catch (SQLException e) {
			// fail(e.getMessage());
			e.printStackTrace();
		}
		return "Connection right";
	}

	// connect to database directly.
	@GET
	@Path("/tom")
	public String testTomcatConn() {
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			javax.sql.DataSource ds = (javax.sql.DataSource)envCtx.lookup("jdbc/itu");
			// Allocate and use a connection from the pool
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from student");
			String s = "";
			while (resultSet.next()) {
				String sName = resultSet.getString("name");
				s += sName;
				System.out.println("student name : " + sName);
			}

			connection.close();
			return s;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

		
	}

//	/**
//	 * get person by id through hibernate
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public static Person.Builder getPersonById(int id) {
//		Session s = null;
//		try {
//
////			Builder personBuilder = Person.newBuilder();
////			s = HibernateUtil.getSessionFactory().openSession();
////			// from后面是对象，不是表名
////			String hql = "from Student as st where st.studentId=:id";// 使用命名参数，推荐使用，易读。
////			Query query = s.createQuery(hql);
////			query.setInteger("id", id);
////			List<Student> list = query.list();
////			if (null != list && list.size() > 0) {
////				Student stu = list.get(0);
////				personBuilder.setId(id).setName(stu.getName()).setEmail(stu.getEmail());
////			}
////			// personBuilder.
//			return personBuilder;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			if (s != null)
//				s.close();
//		}
//	}

}
