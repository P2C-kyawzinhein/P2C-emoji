package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEACHERS") 
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq_gen")
    @SequenceGenerator(name = "teacher_seq_gen", sequenceName = "TEACHER_SEQ", allocationSize = 1)
    @Column(name = "TEACHER_ID")
    private Integer teacherId;

    @Column(name = "TEACHER_MAIL", nullable = false, length = 50)
    private String teacherMail;

    @Column(name = "TEACHER_NAME", nullable = false, length = 50)
    private String teacherName;

    @Column(name = "TEACHER_PASS", nullable = false, length = 50)
    private String teacherPass;

    @Column(name = "TEACHER_NUMBER", length = 8)
    private String teacherNumber;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherMail() {
		return teacherMail;
	}

	public void setTeacherMail(String teacherMail) {
		this.teacherMail = teacherMail;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPass() {
		return teacherPass;
	}

	public void setTeacherPass(String teacherPass) {
		this.teacherPass = teacherPass;
	}

	public String getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	} 
	
	
	

	
}
