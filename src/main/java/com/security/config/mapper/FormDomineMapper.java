package com.security.config.mapper;

import com.security.forms.RegistrationForm;
import com.security.model.Registration;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;

public class FormDomineMapper {
	private MapperFactory formToDomineMApperFactory = null;

	public FormDomineMapper(MapperFactory mapperFactory) {
		this.formToDomineMApperFactory = mapperFactory;
		ConverterFactory converterFactory = formToDomineMApperFactory.getConverterFactory();
		mapRegistration();
	}

	public void mapRegistration() {
		formToDomineMApperFactory.classMap(Registration.class, RegistrationForm.class).field("userId", "userId")
				.field("firstName", "firstName").field("lastName", "lastName").field("fatherName", "fatherName")
				.field("motherName", "motherName").field("adharNumber", "adharNumber")
				.field("phoneNumber", "phoneNumber").field("email", "email").field("password", "password")
				.field("gender", "gender");
	}
}
