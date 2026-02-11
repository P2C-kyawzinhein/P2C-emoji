package jp.ac.emoji.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subId;

	private String subTitle;

	@Column(length = 2000)
	private String subDescription;

	private String subFileName;
	private String subFileUrl;

	private LocalDate subUploadedAt;

	public Subject() {
	}

	public Subject(String subTitle, String subDescription, String subFileName, String subFileUrl) {
		this.subTitle = subTitle;
		this.subDescription = subDescription;
		this.subFileName = subFileName;
		this.subFileUrl = subFileUrl;
		this.subUploadedAt = LocalDate.now();
	}

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSubDescription() {
		return subDescription;
	}

	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}

	public String getSubFileName() {
		return subFileName;
	}

	public void setSubFileName(String subFileName) {
		this.subFileName = subFileName;
	}

	public String getSubFileUrl() {
		return subFileUrl;
	}

	public void setSubFileUrl(String subFileUrl) {
		this.subFileUrl = subFileUrl;
	}

	public LocalDate getSubUploadedAt() {
		return subUploadedAt;
	}

	public void setSubUploadedAt(LocalDate subUploadedAt) {
		this.subUploadedAt = subUploadedAt;
	}

}
