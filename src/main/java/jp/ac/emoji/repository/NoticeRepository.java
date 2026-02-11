package jp.ac.emoji.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.emoji.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
	

}
