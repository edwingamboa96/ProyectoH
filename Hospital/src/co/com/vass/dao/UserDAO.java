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

import co.com.vass.baseclass.ConectionDAO;
import co.com.vass.vo.Patient;
import co.com.vass.vo.User;

public class UserDAO extends ConectionDAO {
	public UserDAO() {
		super();
	}

	Session session = getSession();

	public boolean consultUserDatabase(User user) {
		session.beginTransaction();
		boolean isUser = false;
		User object = null;
		try {
			Query theStudents = session.createQuery(" from User where password=" + "'" + user.getPassword()
					+ "'and name=" + "'" + user.getName() + "'");
			object = (User) theStudents.uniqueResult();
			if (object == null) {
				isUser = false;
			} else {
				isUser = true;
			}

			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
		}
		return isUser;
	}

	public boolean create_Patien(User user) {
		session.save(user);
		session.getTransaction().commit();
		boolean isUser = false;
		return isUser;
	}



}
