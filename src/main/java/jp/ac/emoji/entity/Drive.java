package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drives")
public class Drive {
@Id
private Integer driveId;

@Column
private String driveUrl;

@Column
private Integer driveDifd;

public Integer getDriveId() {
	return driveId;
}

public void setDriveId(Integer driveId) {
	this.driveId = driveId;
}

public String getDriveUrl() {
	return driveUrl;
}

public void setDriveUrl(String driveUrl) {
	this.driveUrl = driveUrl;
}

public Integer getDriveDifd() {
	return driveDifd;
}

public void setDriveDifd(Integer driveDifd) {
	this.driveDifd = driveDifd;
}

}
