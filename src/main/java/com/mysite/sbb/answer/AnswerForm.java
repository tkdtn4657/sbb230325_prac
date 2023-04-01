package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}
