package jp.ac.emoji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.emoji.entity.QuizLevel;

public interface QuizLevelRepository extends JpaRepository<QuizLevel, Integer> {

}