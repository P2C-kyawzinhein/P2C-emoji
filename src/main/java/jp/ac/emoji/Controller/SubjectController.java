package jp.ac.emoji.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.ac.emoji.entity.Subject;
import jp.ac.emoji.repository.SubjectRepository;

@Controller
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    /**
     * 教材一覧を表示
     * 菅野優輝
     */
    @GetMapping("/subjects")
    public String list(Model model) {
        List<Subject> subjectList = subjectRepository.findAll();
        model.addAttribute("subjects", subjectList);
        return "subject_list";
    }

    /**
     * 教材詳細を表示
     * 菅野優輝
     */
    @GetMapping("/subjects/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Subject subject = subjectRepository.findById(id).orElse(null);
        model.addAttribute("subject", subject);
        return "subject_detail";
    }
}
