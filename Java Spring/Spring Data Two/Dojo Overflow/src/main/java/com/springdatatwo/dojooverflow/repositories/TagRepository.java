package com.springdatatwo.dojooverflow.repositories;

import com.springdatatwo.dojooverflow.models.Question;
import com.springdatatwo.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    List<Tag> findByQuestionsContaining(Question question);
    Tag findBySubject(String subject);
}
