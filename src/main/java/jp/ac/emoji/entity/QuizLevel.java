package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUIZ_LEVEL")
public class QuizLevel {
	@Id
    @Column(name = "LEVEL_ID")
    private Integer levelId;

    @Column(name = "LEVEL_NAME")
    private String levelName;

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
    

}
