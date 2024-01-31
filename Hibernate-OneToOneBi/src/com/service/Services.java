package com.service;

public interface Services {

	public void addPersonWithAdhaarCard();

	public void addAdhaarCardWithPerson();

	public void getPersonWithAdhaarCard();

	public void getAdhaarCardWithPerson();

	public void updatePersonUsingPid();

	public void updateAdhaarCardUsingAid();

	public void updatePersonUsingAid();

	public void updateAdhaarCardUsingPid();

	public void deletePersonWithAdhaarCard();

	public void deleteAdhaarCardWithPerson();

	public void deletePersonOnly();

	public void deleteAdhaarCardOnly();

}
