package com.mysite.sbb.question;




import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    //OneToMany 자바세상에서의 편의를 위해 필드 생성
    // 이 녀석은 실제 DB 테이블에 칼럼이 생성되지 않음
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    //OneToMany 에는 직접 객체 초기화
    private List<Answer> answerList = new ArrayList<>();

    public void addAnswer(Answer a){
        a.setQuestion(this);
        answerList.add(a);
    }
}
