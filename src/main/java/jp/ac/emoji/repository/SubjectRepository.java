package jp.ac.emoji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.emoji.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
   
}
