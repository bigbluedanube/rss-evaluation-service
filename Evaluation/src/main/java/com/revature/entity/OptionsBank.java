package com.revature.entity;

import javax.persistence.*;

@Entity
@Table(name="OPTIONS_BANK")
public class OptionsBank {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="OPTIONS_BANK_SEQ")
    @Column(name="OPTION_ID")
    private long optionId;

    @Column(name="OPTION", nullable = false)
    private String option;

    //We create one transient field for questionId.
    //It will take input from front-end and do the rest of the process which help to maintain relationship with QUIZZES table.
    @JoinColumn(name = "QUESTION_ID", nullable = false)
    private Long questionId;

//    @ManyToOne
//    @JoinColumn(name = "QUESTION_ID", nullable = false)
//    private QuestionsBank question;

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

//    public QuestionsBank getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(QuestionsBank question) {
//        this.question = question;
//    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

//    @Override
//    public String toString() {
//        return "OptionsBank{" +
//                "optionId=" + optionId +
//                ", option='" + option + '\'' +
//                ", questionId=" + questionId +
//                ", question=" + question +
//                '}';
//    }


    @Override
    public String toString() {
        return "OptionsBank{" +
                "optionId=" + optionId +
                ", option='" + option + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
