package com.revature.service;

import com.revature.entity.OptionsBank;
import com.revature.entity.QuestionsBank;
import com.revature.repo.OptionsBankRepository;
import com.revature.repo.QuestionsBankRepository;
import com.revature.repo.QuizRepository;
import com.revature.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OptionsBankService {

    OptionsBankRepository obr;
    QuestionsBankRepository qbr;
    QuizRepository qr;
    SubjectRepository sr;

    //We use constructor auto-wiring to auto-wired multiple repositories.
    @Autowired
    public OptionsBankService(OptionsBankRepository obRepository, QuestionsBankRepository qbRepository, QuizRepository qRepository, SubjectRepository sRepository) {
        this.obr=obRepository;
        this.qbr=qbRepository;
        this.qr = qRepository;
        this.sr = sRepository;
    }

    //Method to find all options
    public List<OptionsBank> findAllOptions(){
        return obr.findAll();
    }

    //Method to get option by option ID.
    public Set<OptionsBank> getOption(long questionId) {
        Set<OptionsBank> options = new HashSet<>();
//        long id = qb.getQuestionId();
        System.out.println(questionId);
        Set<OptionsBank> set = obr.findOptionsBankByQuestionId(questionId);
        for (OptionsBank x: set) {
            options.add(x);
        }
        return options;
    }

    //Methods to insert option.
    public OptionsBank InsertOption(OptionsBank ob) {
        ob.setQuestion(qbr.findById(ob.getQuestionId()).get());
        return obr.save(ob);
    }

    //Method to delete option by option ID.
    public List<String> deleteOption(long OptionId) {
        List<String> tmp = new ArrayList<>();
        this.qbr.deleteById(OptionId);
        tmp.add("deleted option with id " + OptionId);
        return tmp;
    }
}
