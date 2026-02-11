package jp.ac.emoji.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.ac.emoji.entity.Student;
import jp.ac.emoji.entity.Teacher;
import jp.ac.emoji.form.LoginForm;
import jp.ac.emoji.repository.StudentRepository;
import jp.ac.emoji.repository.TeacherRepository;
import jp.ac.emoji.service.AttendanceService;
@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AttendanceService attendanceService;

 // ================= LOGIN =================

    @GetMapping("/login")
    public String showLogin(Model model, HttpSession session) {
        session.invalidate();  // セッション削除
        model.addAttribute("loginForm", new LoginForm());
        return "auth/login";  
    }

    @PostMapping("/login")
    public String handleLogin(@Valid @ModelAttribute("loginForm") LoginForm form,  BindingResult result,Model model,HttpSession session) {

        //  バリデーションチェック
        if (result.hasErrors()) {
            return "auth/login";  
        }

        //  学生チェック
        Student student = studentRepository.findByStudentMailAndStudentPass(
                form.getUserMail(), form.getPassword());

        if (student != null) {
            session.setAttribute("loginStudent", student);
            return "redirect:/student/home";
        }

        //  先生チェック
        Teacher teacher = teacherRepository.findByTeacherMailAndTeacherPass(
                form.getUserMail(), form.getPassword());

        if (teacher != null) {
            session.setAttribute("loginTeacher", teacher);
            return "redirect:/teacher/home";
        }

        //  どちらも合わない場合
        model.addAttribute("error", "メールアドレスまたはパスワードが正しくありません。");
        return "auth/login";
    }


    //forgetパスワード
    
    @GetMapping("/forgot")
    public String showForgotPage() {
        return "auth/forgot-password"; // forgot.htmlを表示
    }

    // 共通ログアウト
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


    // ---------------------学生画面 ------------------------------
    @GetMapping("/student/home")
    public String studentHome(Model model, HttpSession session) {

        Student student = (Student) session.getAttribute("loginStudent");
        if (student == null) return "redirect:/login";

        String attendanceRate = "0";
        try {
            attendanceRate =
                attendanceService.getAttendanceRate(student.getStudentNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("active", "home");
        model.addAttribute("studentName", student.getStudentName());
        model.addAttribute("studentNumber", student.getStudentNumber());
        model.addAttribute("attendanceRate", attendanceRate);
        
        return "student/home";
    }
    @GetMapping("/student/profile")
    public String studentProfile(Model model, HttpSession session) {

        Student student = (Student) session.getAttribute("loginStudent");
        if (student == null) return "redirect:/login";

        // 🔥 出席率 
        String attendanceRate = "0";
        try {
            attendanceRate =
                attendanceService.getAttendanceRate(student.getStudentNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("active", "profile");
        model.addAttribute("studentName", student.getStudentName());
        model.addAttribute("studentNumber", student.getStudentNumber());
        model.addAttribute("studentMail", student.getStudentMail());
        model.addAttribute("studentPass", student.getStudentPass());
        model.addAttribute("attendanceRate", attendanceRate); 

        return "student/profile";
    }


    @GetMapping("/student/settings")
    public String studentSettings(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("loginStudent");
        if (student == null) return "redirect:/login";

        model.addAttribute("active", "settings");
        model.addAttribute("studentName", student.getStudentName());
        return "student/settings";
    }

    // ====================== 先生画面 ======================
    @GetMapping("/teacher/home")
    public String teacherHome(Model model, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
        if (teacher == null) return "redirect:/login";

        model.addAttribute("active", "home");
        model.addAttribute("teacherName", teacher.getTeacherName());
        model.addAttribute("teacherNumber", teacher.getTeacherNumber());
        return "teacher/home";
    }

    @GetMapping("/teacher/profile")
    public String teacherProfile(Model model, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
        if (teacher == null) return "redirect:/login";

        model.addAttribute("active", "profile");
        model.addAttribute("teacherName", teacher.getTeacherName());
        model.addAttribute("teacherNumber", teacher.getTeacherNumber());
        model.addAttribute("teacherMail", teacher.getTeacherMail());
        model.addAttribute("teacherPass", teacher.getTeacherPass());
        return "teacher/profile";
    }

    @GetMapping("/teacher/settings")
    public String teacherSettings(Model model, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
        if (teacher == null) return "redirect:/login";

        model.addAttribute("active", "settings");
        model.addAttribute("teacherName", teacher.getTeacherName());
        return "teacher/settings";
    }
    // ====================== 新規登録（学生登録） ======================

    		// 新規登録ページ表示
    		@GetMapping("/teacher/register")
    		public String showRegisterPage(Model model, HttpSession session) {
    		    // ログイン中の先生確認
    		    Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
    		    if (teacher == null) return "redirect:/login";

    		    model.addAttribute("student", new Student());
    		    model.addAttribute("active", "settings");
    		    return "teacher/register"; // templates/teacher/register.html に対応
    		}

    		// フォーム送信（登録処理）
    		@PostMapping("/teacher/register")
    		public String registerStudent(Student student, HttpSession session) {
    		    Teacher teacher = (Teacher) session.getAttribute("loginTeacher");
    		    if (teacher == null) return "redirect:/login";

    		    studentRepository.save(student);
    		    return "redirect:/teacher/home"; // 登録後、先生のホームへ戻る
    		}
    		
    		@GetMapping("/teacher/register/teacher")
    		public String showTeacherRegisterPage(Model model, HttpSession session) {
    		    Teacher loginTeacher = (Teacher) session.getAttribute("loginTeacher");
    		    if (loginTeacher == null) return "redirect:/login";

    		    model.addAttribute("teacher", new Teacher());
    		    return "teacher/register_teacher";
    		}

    		@PostMapping("/teacher/register/teacher")
    		public String registerTeacher(@ModelAttribute Teacher teacher, HttpSession session) {
    		    Teacher loginTeacher = (Teacher) session.getAttribute("loginTeacher");
    		    if (loginTeacher == null) return "redirect:/login";

    		    teacherRepository.save(teacher);
    		    return "redirect:/teacher/home";
    		}
}
    

