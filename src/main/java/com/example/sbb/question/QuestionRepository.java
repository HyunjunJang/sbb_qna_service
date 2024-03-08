package com.example.sbb.question;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}//QuestionRepository 가 JpaRepostiory를 상속한다 extends
//JpaRepostiory는 JPA가 제공하는 인터페이스 중 하나로 CRUD 작업을 처리하는 메서드를 내장
//<Question, Integer> 는 Question 엔티티로 리포지터리를 생성한다. 기본키가 Integer(id) 이므로 지정한다
