package com.project.markdown.controller;

import com.project.markdown.service.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class CommonController {
    private final CommonUtil commonUtil;

    @GetMapping("/view/{filename}")
    public String MarkdownController(@PathVariable String filename, Model model) throws IOException {
        model.addAttribute("contents", commonUtil.markdown(filename));

        return "viewer";
    }
}
