package com.example.sbb.question;

import com.example.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter //관례로는 Entity에는 Setter 어노테이션을 쓰지 않다
@Entity //엔티티로 인식하기 위해
public class Question { //Question Entity
    @Id //기본키로지정한다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터를 저장할 때 해당 속성에 값을 자동으로 1씩 증가하여 저장한다
    private Integer id;

    @Column(length = 200) //열을 뜻한다
    private String subject;

    @Column(columnDefinition = "TEXT") //열 데이터의 유형 정의
    private String content;

    private LocalDateTime createDate; //엔티티에서는 createDate로 이름 지었지만, 테이블에서는 create_date로 설정된다(카멜 방식)

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    //mappedBy는 참조 엔티티의 속성명을 정한다. 즉 Answer 엔티티의 question 속성을 mappedBy에 전달한다.
    //cascade = CascadeType.REMOVE 는 질문을 삭제하면 그 질문에 대한 답변도 모두 삭제되도록 한다
    private List<Answer> answerList; //질문 역시 답변과 1:다 의 관계를 가지므로 Answer 객체를 요소로 하는 List로 반환한다.
    //question.getAnswerList()를 통해서 이제 질문에서도 답변을 참조 할 수 있다.
}
