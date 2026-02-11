package jp.ac.emoji.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {

	//student 

	@GetMapping("/student/timetable")
	public String timetable(Model model) {
		model.addAttribute("active", "timetable");
		return "student/timetable";
	}

	@GetMapping("/student/schedule")
	public String schedule(Model model) {
		model.addAttribute("active", "schedule");
		return "student/schedule";
	}

	@GetMapping("/student/reports")
	public String reports(Model model) {
		model.addAttribute("active", "reports");
		return "student/report";
	}

	@GetMapping("/student/schedule/")
	public String showPdf(Model model) {
		model.addAttribute("pdfPath", "/extraDatas/YearSchedule.pdf");
		return "student/schedule_pdf"; // schedule_pdf.html に遷移
	}

	/**
	 * 　Teacherの年間スケジュール表示
	 * アリュンツェツェグ テムージンジャラガル
	 */
	@GetMapping("/teacher/timetable")
	public String TeacherTimetable(Model model) {
		model.addAttribute("active", "timetable");
		return "teacher/timetable";
	}

	@GetMapping("/teacher/reports")
	public String Teacherreports(Model model) {
		model.addAttribute("active", "reports");
		return "teacher/report-detail";
	}

	//	@GetMapping("/student/schedule/")
	//	public String yearTable() {
	//	    return "redirect:static/extraDatas/YearSchdule.pdf";
	//	}
//	@GetMapping("/teacher/schedule")
//	public String teacherYearTable() {
//		return "redirect:/extraDatas/TeacherYearSchdule.pdf";
//	}
		@GetMapping("/teacher/schedule")
		public String showTrPdf(Model model) {
			model.addAttribute("pdfPath", "/extraDatas/TeacherYearSchedule.pdf");
			return "teacher/schedule"; // schedule_pdf.html に遷移
		}

}