package co.com.vass.baseclass;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.com.vass.vo.User;

public class ConectionDAO {
	private Session session;

	public ConectionDAO() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		session = factory.openSession();
	}

	public Session getSession() {
		return session;
	}

}
