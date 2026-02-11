package jp.ac.emoji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.emoji.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentMailAndStudentPass(String studentMail, String studentPass);
    
}

