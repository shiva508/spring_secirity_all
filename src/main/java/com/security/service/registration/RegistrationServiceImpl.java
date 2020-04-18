package com.security.service.registration;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.security.forms.RegistrationForm;
import com.security.model.CachePerson;
import com.security.model.Registration;
import com.security.repository.registration.RegistrationJpa;
import ma.glasnost.orika.MapperFacade;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	@Autowired
	private RegistrationJpa registrationJpa;

	@Transactional
	public RegistrationForm saveUser(RegistrationForm registrationForm) {
		Registration registration=formDomineMapperfaced.map(registrationForm, Registration.class);
		Registration registrationSaved=registrationJpa.saveUser(registration);
		RegistrationForm registrationFormSaved =formDomineMapperfaced.map(registrationSaved, RegistrationForm.class);
		return registrationFormSaved;
	}

	@Transactional
	public List<RegistrationForm> usersList() {
		List<Registration> registrations=null;
		registrations=registrationJpa.usersList();
		List<RegistrationForm> registrationForms=new ArrayList<RegistrationForm>();
		for(Registration registration:registrations) {
			RegistrationForm registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
			registrationForms.add(registrationForm);
		}
		return registrationForms;
	}

	@Transactional
	public RegistrationForm updateUser(RegistrationForm registrationForm) {
		Registration registration=registrationJpa.getUserByUserId(registrationForm.getUserId());
		formDomineMapperfaced.map(registrationForm, registration);
		//registrationDao.updateUser(registration);
		return registrationForm;
	}

	@Transactional
	public Integer deleteUser(Integer userid) {
		
		return registrationJpa.deleteUser(userid);
	}

	@Transactional
	public RegistrationForm getUserByEmailAndPassword(String username, String password) {
		RegistrationForm registrationForm=null;
		Registration registration=registrationJpa.getUserByEmailAndPassword(username, password);
		registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		return registrationForm;
	}
	@Transactional
	public RegistrationForm getUserByUserId(Integer userId) {
		RegistrationForm registrationForm=null;
		Registration registration=registrationJpa.getUserByUserId(userId);
		registrationForm=formDomineMapperfaced.map(registration, RegistrationForm.class);
		return registrationForm;
	}
	@Transactional
	public List<CachePerson> getAllCachePersons() {
		return registrationJpa.getAllCachePersons();
	}

	@Override
	public Long isUserExist(String username) {
		return registrationJpa.isUserExist(username);
	}

}
