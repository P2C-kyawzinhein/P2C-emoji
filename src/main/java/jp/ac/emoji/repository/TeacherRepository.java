package jp.ac.emoji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.emoji.entity.Teacher;

public interface  TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByTeacherMailAndTeacherPass(String teacherMail, String teacherPass);
	// teacher_id と teacher_pass で検索するメソッド
    

	//Teacher findByTeacherIdAndTeacherPass(String id, String password);
}
