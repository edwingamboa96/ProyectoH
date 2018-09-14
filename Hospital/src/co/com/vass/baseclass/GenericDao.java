package co.com.vass.baseclass;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mysql.cj.exceptions.UnableToConnectException;
import co.com.vass.vo.User;

public class GenericDao<Entity, K extends Serializable> implements ICRUD<Entity, K> {

	private Session session;
	public Class domainClass = getDomainClass();

	protected Class getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private Session conectionDAO() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public void save(Entity t) {
		try {
			conectionDAO().save(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new UnableToConnectException(e);
		}

	}

	@Override
	public void update(Entity t) {
		try {
			conectionDAO().update(t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new UnableToConnectException(e);
		}

	}

	@Override
	public Entity read(K id) {
		Entity returnValue = (Entity) conectionDAO().load(domainClass, id);
		session.getTransaction().commit();
		return returnValue;
	}

	@Override
	public void delete(Entity t) {
		conectionDAO().delete(t);
		session.getTransaction().commit();

	}

}
