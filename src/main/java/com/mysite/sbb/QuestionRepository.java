package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);

    //@Modifying // 만약 아래 쿼리가 UPDATE, DELETE, INSERT라면 붙여야함
    //아래 Query 어노테이션에서 실행되는 것이 SELECT가 아닐 때 붙여야 한다.
    //@nativeQuery = true 여야 MySQL 쿼리문법 사용 가능
    @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1", nativeQuery = true)
    void clearAutoIncrement(int i);
}
