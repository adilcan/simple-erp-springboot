package com.gitlab.adilcan.erp.commercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String getContractList(Model model){
        model.addAttribute("contracts", contractRepository.findAll());
        return "contracts/contractList";
    }

    @GetMapping("/new")
    public String getNewContract(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("thirdParties", thirdPartyRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("contracts", contractRepository.findAll());
        return "contracts/createContract";
    }

    @PostMapping("/new")
    public String postNewContract(@ModelAttribute @Valid Contract contract, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "contracts/createContract";
        }
        contractRepository.save(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/{id}")
    public String showContractList(@PathVariable Long id, Model model){
        model.addAttribute("contract", contractRepository.findById(id).get());
        return "contracts/showContract";
    }

    @GetMapping("/{id}/update")
    public String getUpdateContract(@PathVariable Long id, Model model){
        model.addAttribute("contract", contractRepository.findById(id).get());
        return "supplier/updateContract";
    }

    @PostMapping("/{id}/update")
    public String postUpdateContract(@ModelAttribute Contract contract){
        contractRepository.save(contract);
        return "redirect:/contracts";
    }
}
