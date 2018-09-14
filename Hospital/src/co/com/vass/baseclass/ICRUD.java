package co.com.vass.baseclass;

import java.io.Serializable;
import java.util.List;

public interface ICRUD<Entity,PK extends Serializable> {
	
	void save(Entity t);
	void update(Entity t);
	Entity read(PK id);
	void delete(Entity t);
	
//	public boolean create(Person person);
//	public List<Person> read();
//	public boolean update(Person person);
//	public boolean delete(Person person);
}
