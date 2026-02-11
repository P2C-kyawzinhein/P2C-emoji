package jp.ac.emoji.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.ac.emoji.entity.Answer;
import jp.ac.emoji.entity.Question;
import jp.ac.emoji.repository.AnswerRepository;
import jp.ac.emoji.repository.QuestionRepository;
import jp.ac.emoji.repository.QuizLevelRepository;

@Controller
public class QuizController {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuizLevelRepository quizLevelRepository;

	// TEACHER — QUIZ REGISTER
	@GetMapping("/teacher/quiz/register")
	public String showQuizRegisterPage(org.springframework.ui.Model model) {

		model.addAttribute("question", new Question());

		// ★ここが抜けていた！レベルを画面へ渡す
		model.addAttribute("levels", quizLevelRepository.findAll());

		model.addAttribute("answers", answerRepository.findAll());
		return "teacher/quiz_register";
	}

	@PostMapping("/teacher/quiz/register")
	public String registerQuiz(Question question, Integer answerId) {

		Answer answer = answerRepository.findById(answerId).orElse(null);
		question.setAnswer(answer);

		Question saved = questionRepository.save(question);

		return "redirect:/teacher/quiz/register";
	}

	// student
	@GetMapping("/student/quiz")
	public String quizPage() {
		return "student/quiz";
	}
//
//	@GetMapping("/student/api/questions")
//	@ResponseBody
//	public List<Question> quizApi() {
//		List<Question> list = questionRepository.findAll();
//		Collections.shuffle(list);
//		return list;
//	}
	@GetMapping("/student/api/questions")
	@ResponseBody
	public List<Question> quizApi(@RequestParam(required = false) String level) {

	    List<Question> list;

	    if (level == null) {
	        list = questionRepository.findAll();  // 全部
	    } else {
	        list = questionRepository.findByQuizlevel_LevelName(level); // レベル別
	    }

	    Collections.shuffle(list);
	    return list;
	}


}
