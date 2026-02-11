package jp.ac.emoji.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_gen")
    @SequenceGenerator(name = "question_seq_gen", sequenceName = "question_seq", allocationSize = 1)
    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "QUESTION_TITLE")
    private String questionTitle;

    @Column(name = "QUESTION_SELECT_1")
    private String questionSelect1;

    @Column(name = "QUESTION_SELECT_2")
    private String questionSelect2;

    @Column(name = "QUESTION_SELECT_3")
    private String questionSelect3;

    @Column(name = "QUESTION_SELECT_4")
    private String questionSelect4;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID", referencedColumnName = "ANSWER_ID")
    private Answer answer;
    
    @ManyToOne
    @JoinColumn(name = "LEVEL_ID",referencedColumnName = "LEVEL_ID")
    private QuizLevel quizlevel;



	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionSelect1() {
		return questionSelect1;
	}

	public void setQuestionSelect1(String questionSelect1) {
		this.questionSelect1 = questionSelect1;
	}

	public String getQuestionSelect2() {
		return questionSelect2;
	}

	public void setQuestionSelect2(String questionSelect2) {
		this.questionSelect2 = questionSelect2;
	}

	public String getQuestionSelect3() {
		return questionSelect3;
	}

	public void setQuestionSelect3(String questionSelect3) {
		this.questionSelect3 = questionSelect3;
	}

	public String getQuestionSelect4() {
		return questionSelect4;
	}

	public void setQuestionSelect4(String questionSelect4) {
		this.questionSelect4 = questionSelect4;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public QuizLevel getQuizlevel() {
		return quizlevel;
	}

	public void setQuizlevel(QuizLevel quizlevel) {
		this.quizlevel = quizlevel;
	}
	
	

   
}
