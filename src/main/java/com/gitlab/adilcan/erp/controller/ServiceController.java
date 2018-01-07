package com.gitlab.adilcan.erp.controller;

import com.gitlab.adilcan.erp.domain.Service;
import com.gitlab.adilcan.erp.repository.ServiceRepository;
import com.gitlab.adilcan.erp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String getServiceList(Model model){
        model.addAttribute("services", serviceRepository.findAll());
        return "services/serviceList";
    }

    @GetMapping("/new")
    public String getNewService(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("tags", tagRepository.findAll());
        return "services/newService";
    }

    @PostMapping("/new")
    public String postNewTag(@ModelAttribute Service service){
        serviceRepository.save(service);
        return "redirect:/services";
    }

    @GetMapping("/{id}")
    public String getShowTag(@PathVariable Long id, Model model){
        model.addAttribute("service",serviceRepository.findById(id).get());
        return "services/showService";
    }

    @GetMapping("/{id}/update")
    public String getUpdateTag(@PathVariable Long id, Model model){
        model.addAttribute("service", serviceRepository.findById(id).get());
        return "service/updateService";
    }

    @PostMapping("/{id}/update")
    public String postUpdateTag(@ModelAttribute Service service){
        serviceRepository.save(service);
        return "redirect:/services";
    }
}
