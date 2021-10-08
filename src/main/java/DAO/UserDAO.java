package DAO;
import JPAConfig.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Model.User;

public class UserDAO extends AbstractDAO<User>{

	public UserDAO() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
	
}
