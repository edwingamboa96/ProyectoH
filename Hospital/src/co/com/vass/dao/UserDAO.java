package co.com.vass.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.com.vass.vo.User;

public class UserDAO {

	public boolean consultUserDatabase(User user) {
		boolean isUser=false;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		Session session =  factory.openSession();
            User object = null;
		try {
			
			session.beginTransaction();
		//SELECT *from user where name="Edwin" and password= "34";
		//	Query theStudents = session.createQuery("from User a where a.password="+"'"+ user.getPassword()+"'");	
			//SELECT *from user where name="Edwin "
			Query theStudents = session.createQuery(" from User where password="+"'"+ user.getPassword()+"'and name="+"'"+ user.getName()+"'");		
				object = (User) theStudents.uniqueResult();
			   if(object==null) {
				   isUser=false;
			   }
			   else {
				   isUser=true; 
			   }
			
			
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		return isUser;
	}

//	public UserVO consultUserDatabase(String documento) {
//		// UserVO vo = new UserVO();
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserVO.class)
//				.buildSessionFactory();
//
//		Session session;
//		session = factory.openSession();
//		Transaction t = session.beginTransaction();
//
//		// Query query = session.createSQLQuery("SELECT * FROM users where document
//		// ="+documento);
//
//		UserVO vo = (UserVO) session.get(UserVO.class, 1);
////        List results = query.list();
////        String client="";
////        Iterator itr = results.iterator();
////        while(itr.hasNext()){
////           Object[] obj = (Object[]) itr.next();        
////          client = String.valueOf(obj[1]); 
////        
////        }
//
//		session.getTransaction().commit();
//
//		session.close();
//
//		System.out.println("elementos" + vo.getDocumento());
//
//		return vo;
//	}

}
