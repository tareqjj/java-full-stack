package com.springdatatwo.dojooverflow.controllers;

import com.springdatatwo.dojooverflow.models.Answer;
import com.springdatatwo.dojooverflow.models.Question;
import com.springdatatwo.dojooverflow.models.Tag;
import com.springdatatwo.dojooverflow.services.DojoOverflowServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class dojoOverflowController {
    private final DojoOverflowServices dojoOverflowServices;

    public dojoOverflowController(DojoOverflowServices dojoOverflowServices) {
        this.dojoOverflowServices = dojoOverflowServices;
    }

    @RequestMapping("/questions")
    public String displayIndex(Model model) {
        model.addAttribute("questions", dojoOverflowServices.allQuestions());
        return "/dojoOverflow/dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String displayAddQuestionForm(@ModelAttribute ("questions") Question question, @ModelAttribute ("tags") Tag tag) {
        return "/dojoOverflow/addQuestion.jsp";
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute("questions") Question question, BindingResult resultQuestion,
                              @Valid @ModelAttribute("tags") Tag tag, BindingResult resultTag) {
        if (resultQuestion.hasErrors() || resultTag.hasErrors())
            return "/dojoOverflow/addQuestion.jsp";
        dojoOverflowServices.createQuestion(question);
        dojoOverflowServices.createTag(tag, question);
        return "redirect:/questions/" + question.getId();
    }

    @RequestMapping("/questions/{id}")
    public String questionPage(@PathVariable ("id") Long id, @ModelAttribute ("answers") Answer answer, Model model) {
        Question question = dojoOverflowServices.findQuestion(id);
        model.addAttribute("question", question);
        model.addAttribute("answerList", dojoOverflowServices.displayAnswersOfQuestion(question));
        model.addAttribute("tags", dojoOverflowServices.tagsOfQuestions(question));
        return "/dojoOverflow/questionPage.jsp";
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String addAnswer(@PathVariable ("id") Long id, @Valid @ModelAttribute ("answers") Answer answer, BindingResult result) {
        if (result.hasErrors())
            return "/dojoOverflow/questionPage.jsp";
        Question question = dojoOverflowServices.findQuestion(id);
        Answer newAnswer = this.dojoOverflowServices.createAnswer(answer, question);
        return "redirect:/questions/" + newAnswer.getQuestion().getId();
    }
}