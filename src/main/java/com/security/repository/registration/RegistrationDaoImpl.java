package com.security.repository.registration;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.security.model.CachePerson;
import com.security.model.Registration;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	private EntityManager entityManager;

	public Registration saveUser(Registration registration) {
		return entityManager.merge(registration);
	}
	@Override
	public List<Registration> usersList() {
		Query query = entityManager.createQuery("FROM Registration", Registration.class);
		return query.getResultList();
	}
	@Override
	public void updateUser(Registration registration) {
		entityManager.merge(registration);
	}
	@Override
	public Integer deleteUser(Integer userid) {
		Registration registration = entityManager.find(Registration.class, userid);
		int deleteid=0;
		if (registration != null) {
			deleteid=registration.getUserId();
			entityManager.remove(registration);
		}
		return deleteid;
	}
	@Override
	public Registration getUserByEmailAndPassword(String userName, String password) {

		TypedQuery<Registration> query = (TypedQuery<Registration>) entityManager.createQuery("SELECT R FROM Registration R where R.userName=:userName AND R.password=password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return  query.getSingleResult();
	}
	@Override
	public Registration getUserByEmail(String userName) {
		Query query =  entityManager.createQuery("SELECT R FROM Registration R where R.userName=:userName ");
		query.setParameter("userName", userName);
		Optional<Registration> registration=query.getResultList().stream().findFirst();
		return  registration.get();
	}
	@Override
	public Registration getUserByUserId(Integer userId) {
		Registration registration=entityManager.find(Registration.class, userId);
		return registration;
	}
	@Override
	public List<CachePerson> getAllCachePersons() {
	Query query=entityManager.createNamedQuery("GET_ALL_PERSONS",CachePerson.class);
		return query.getResultList();
	}
	@Override
	public Long isUserExist(String userName) {
		Query query=entityManager.createQuery("select count(*) from Registration r where r.userName=:userName");
		query.setParameter("userName", userName);
		return (Long) query.getSingleResult();
	}
}
