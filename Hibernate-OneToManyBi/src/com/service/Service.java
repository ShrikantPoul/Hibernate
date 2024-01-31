package com.service;

public interface Service {

	public void addTeacherWithMultipleStudents();

	public void addStudentWithTeacher();

	public void getTeacherWithMultipleStudents();

	public void getStudentWithTeacher();

	public void updateTeacherUsingTid();

	public void updateStudentUsingTid();

	public void updateStudentUsingSid();

	public void updateTeacherUsingSid();

	public void deleteTeacherWithAllStudent();

	public void deleteAllStudentsOfParticularTeacher();

	public void deleteParticularStudentUsingTid();

	public void deleteTeacherUsingSid();

}
