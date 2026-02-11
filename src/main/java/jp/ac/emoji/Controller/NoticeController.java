package jp.ac.emoji.Controller;

import java.util.List; // ✅ зөв import

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.emoji.entity.Notice;
import jp.ac.emoji.form.NoticeForm;
import jp.ac.emoji.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;

    //ーーーーーー生徒
    @GetMapping("/student/notices")
    public String studentNotice(Model model) {
        model.addAttribute("active", "notices");
        model.addAttribute("noticesList", noticeRepository.findAll());
        return "student/notice";
    }

    // -----------先生
    @GetMapping("/teacher/notices")
    public String showNotices(Model model) {
        List<Notice> noticesList = noticeRepository.findAll();
        model.addAttribute("noticesList", noticesList);
        model.addAttribute("noticeForm", new NoticeForm()); 
        model.addAttribute("active", "notices");
        return "teacher/notice"; 
    }

    // --- お知らせ追加処理Insert---
    @PostMapping("/teacher/notice/add")
    public String addNotice(NoticeForm form) {
        Notice notice = new Notice();
        BeanUtils.copyProperties(form, notice);
        noticeRepository.save(notice);
        return "redirect:/teacher/notices";
    }

    // --- 削除処理（Delete）---
    @PostMapping("/teacher/notice/delete/{id}")
    public String deleteNotice(@PathVariable("id") Long id) {
        noticeRepository.deleteById(id);
        return "redirect:/teacher/notices";
    }
}
