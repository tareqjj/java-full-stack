package com.springdatatwo.dojooverflow.repositories;

import com.springdatatwo.dojooverflow.models.Answer;
import com.springdatatwo.dojooverflow.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAnswersByQuestionEquals(Question question);
}
