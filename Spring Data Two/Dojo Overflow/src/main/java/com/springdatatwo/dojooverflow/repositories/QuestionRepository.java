package com.springdatatwo.dojooverflow.repositories;

import com.springdatatwo.dojooverflow.models.Answer;
import com.springdatatwo.dojooverflow.models.Question;
import com.springdatatwo.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findAll();

}
