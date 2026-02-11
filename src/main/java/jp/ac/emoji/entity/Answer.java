package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANSWERS")
public class Answer {

    @Id
    @Column(name = "ANSWER_ID")
    private Integer answerId;

    @Column(name = "ANSWER_NUMBER")
    private String answerNumber;

    public Integer getAnswerId() { return answerId; }
    public void setAnswerId(Integer answerId) { this.answerId = answerId; }

    public String getAnswerNumber() { return answerNumber; }
    public void setAnswerNumber(String answerNumber) { this.answerNumber = answerNumber; }
}


