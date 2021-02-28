package com.springdatatwo.dojooverflow.services;

import com.springdatatwo.dojooverflow.models.Answer;
import com.springdatatwo.dojooverflow.models.Question;
import com.springdatatwo.dojooverflow.models.Tag;
import com.springdatatwo.dojooverflow.repositories.AnswerRepository;
import com.springdatatwo.dojooverflow.repositories.QuestionRepository;
import com.springdatatwo.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DojoOverflowServices {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    public DojoOverflowServices(AnswerRepository answerRepository, QuestionRepository questionRepository, TagRepository tagRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
    }

    public Question createQuestion(Question q) {
        return questionRepository.save(q);
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }

    public Question findQuestion(Long id){
        Optional<Question> questionToFind = questionRepository.findById(id);
        if (questionToFind.isPresent())
            return questionToFind.get();
        else
            return null;
    }

    public Answer createAnswer(Answer a, Question q) {
        Answer newAnswer = new Answer(a.getAnswer(),q);
        return answerRepository.save(newAnswer);
    }

    public List<Answer> displayAnswersOfQuestion(Question q) {
        return answerRepository.findAnswersByQuestionEquals(q);
    }

    public void createTag(Tag t, Question q) {
        ArrayList<String> allTags = new ArrayList<>();
        for (Tag tag: tagRepository.findAll()) {
            allTags.add(tag.getSubject());
        }
        String[] tagsList = t.getSubject().split("\\s*,\\s*");
        for (String tag: tagsList) {
            if (!allTags.contains(tag)) {
                List<Question> questionList = new ArrayList<Question>();
                questionList.add(q);
                Tag newTag = new Tag(tag.toLowerCase(), questionList);
                tagRepository.save(newTag);
            } else {
                Tag tagToUpdate = tagRepository.findBySubject(tag);
                tagToUpdate.getQuestions().add(q);
                tagRepository.save(tagToUpdate);
            }
        }
    }

    public List<Tag> tagsOfQuestions(Question q) {
        return tagRepository.findByQuestionsContaining(q);
    }
}
