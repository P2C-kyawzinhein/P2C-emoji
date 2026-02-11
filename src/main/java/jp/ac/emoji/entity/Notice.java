package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "notices")
public class Notice {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_seq_gen")
@SequenceGenerator(name = "notice_seq_gen", sequenceName = "notice_seq", allocationSize = 1)
private Integer sessionNoti;
@Column
private String sessionTitle;
@Column
private String sessionSub;

public String getSessionTitle() {
	return sessionTitle;
}

public void setSessionTitle(String sessionTitle) {
	this.sessionTitle = sessionTitle;
}

public Integer getSessionNoti() {
	return sessionNoti;
}

public void setSessionNoti(Integer sessionNoti) {
	this.sessionNoti = sessionNoti;
}

public String getSessionSub() {
	return sessionSub;
}

public void setSessionSub(String sessionSub) {
	this.sessionSub = sessionSub;
} 

}
