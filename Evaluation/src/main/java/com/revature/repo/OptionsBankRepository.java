package com.revature.repo;

import com.revature.entity.OptionsBank;
import com.revature.entity.QuestionsBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface OptionsBankRepository extends JpaRepository<OptionsBank, Long>, CrudRepository<OptionsBank, Long> {
    public List<OptionsBank> findOptionsByQuestionId(QuestionsBank qb);

    @Query(value = "Select * from Options_Bank o where o.question_id = ?1",
    nativeQuery = true)
    public Set<OptionsBank> findOptionsBankByQuestionId(long id);

    @Modifying
    @Transactional
    @Query(value = "Delete from Options_Bank o where o.question_id = ?1",
    nativeQuery = true)
    public void deleteOptionsByQuestionId(long id);
}
