package com.gitlab.adilcan.erp.controller;

import com.gitlab.adilcan.erp.domain.Tag;
import com.gitlab.adilcan.erp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String getTagList(Model model){
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/tagList";
    }

    @GetMapping("/new")
    public String getNewTag(Model model){
        model.addAttribute("tag", new Tag());
        return "tags/newTag";
    }

    @PostMapping("/new")
    public String postNewTag(@ModelAttribute Tag tag){
        tagRepository.save(tag);
        return "redirect:/tags";
    }

    @GetMapping("/{id}")
    public String getShowTag(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagRepository.findById(id).get());
        return "tags/showTag";
    }

    @GetMapping("/{id}/update")
    public String getUpdateTag(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagRepository.findById(id).get());
        return "tags/updateTag";
    }

    @PostMapping("/{id}/update")
    public String postUpdateTag(@ModelAttribute Tag tag){
        tagRepository.save(tag);
        return "redirect:/tags";
    }
}
