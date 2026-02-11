package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
@SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
private Integer studentId;
@Column(name = "student_mail")
private String studentMail;

@Column
private String studentPass;

@Column
private String studentName;
@Column(name = "student_number")
private String studentNumber;

public String getStudentNumber() {
	return studentNumber;
}

public void setStudentNumber(String studentNumber) {
	this.studentNumber = studentNumber;
}

public String getStudentMail() {
	return studentMail;
}

public void setStudentMail(String studentMail) {
	this.studentMail = studentMail;
}



public Integer getStudentId() {
	return studentId;
}

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}

public String getStudentPass() {
	return studentPass;
}

public void setStudentPass(String studentPass) {
	this.studentPass = studentPass;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}



}
