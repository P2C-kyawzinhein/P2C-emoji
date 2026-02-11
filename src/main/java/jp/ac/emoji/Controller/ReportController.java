package jp.ac.emoji.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {


	/**
	 * 
	 * 小山　凛空
	 */
	

	//student
	@GetMapping("student/notice/visa")

	public String visa(Model model) {
		model.addAttribute("active", "visa");
		return "notice/visa";
	}

	@GetMapping("student/notice/part-time")
	public String part(Model model) {
		model.addAttribute("active", "reports");
		return "student/report";
	}

	@GetMapping("student/notice/jlpt")
	public String jlpt(Model model) {
		model.addAttribute("active", "schedule");
		return "student/schedule";
	}

	@GetMapping("atudent/notice/address")
	public String address(Model model) {
		model.addAttribute("active", "notices");
		return "student/notices";
	}

	

	
	//teacher
	@GetMapping("teacher/notice/visa")
	public String Teachervisa(Model model) {
		model.addAttribute("active", "visa");
		return "notice/visa";
	}

	@GetMapping("teacher/notice/part-time")
	public String Teacherpart(Model model) {
//		model.addAttribute("active", "reports");
		return "teacher/report";
	}

	@GetMapping("teacher/notice/jlpt")
	public String Teacherjlpt(Model model) {
		model.addAttribute("active", "schedule");
		return "teacher/schedule";
	}

	@GetMapping("teacher/notice/address")
	public String Teacheraddress(Model model) {
		model.addAttribute("active", "notices");
		return "teacher/notices";
	}
}
