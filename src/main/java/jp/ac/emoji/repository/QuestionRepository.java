package jp.ac.emoji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.emoji.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>  {
	 List<Question> findAllByOrderByQuestionIdAsc();

	List<Question> findByQuizlevel_LevelName(String level);

}
