package com.revature.repo;

import com.revature.entity.OptionsBank;
import com.revature.entity.QuestionsBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OptionsBankRepository extends JpaRepository<OptionsBank, Long>, CrudRepository<OptionsBank, Long> {
    public List<OptionsBank> findOptionsByQuestion(QuestionsBank qb);

//    //Method to find optionId by questionID
//    @Query("Select OptionsBank.optionId from OptionsBank where OptionsBank.question = ?1")
//    public List<Long> findOptionIdByQuestionId(Long questionId);
//
//    @Query("Select OptionsBank from OptionsBank where OptionsBank.optionId = ?1")
//    public OptionsBank findOptionsBankById(Long optionId);

    @Query(value = "Select * from Options_Bank o where o.question_id = ?1",
    nativeQuery = true)
    public Set<OptionsBank> findOptionsBankByQuestionId(long id);
}