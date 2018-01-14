package com.gitlab.adilcan.erp.service_product;

import com.gitlab.adilcan.erp.service_product.enumeration.PurchaseStatus;
import com.gitlab.adilcan.erp.service_product.enumeration.SaleStatus;
import com.gitlab.adilcan.erp.service_product.Service;
import com.gitlab.adilcan.erp.service_product.ServiceRepository;
import com.gitlab.adilcan.erp.service_product.TagRepository;
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

        model.addAttribute("notSaleAndNotPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.NOT_FOR_SALE, PurchaseStatus.NOT_FOR_PURCHASE));
        model.addAttribute("forSaleCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.FOR_SALE, PurchaseStatus.NOT_FOR_PURCHASE));
        model.addAttribute("forPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.NOT_FOR_SALE, PurchaseStatus.FOR_PURCHASE));
        model.addAttribute("forSaleAndForPurchaseCount", serviceRepository.countBySaleStatusAndPurchaseStatus(SaleStatus.FOR_SALE, PurchaseStatus.FOR_PURCHASE));
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
