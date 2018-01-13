package com.gitlab.adilcan.erp.commercial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    public String getOrderList(Model model){
        model.addAttribute("orders", orderRepository.findAll());
        return "order/orderList";
    }

    @GetMapping("/new")
    public String getNewOrder(Model model){
        model.addAttribute("order", new Order());
        return "orders/createOrder";
    }

    @PostMapping("/new")
    public String postNewOrder(@ModelAttribute Order order){
        orderRepository.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}")
    public String showOrderList(@PathVariable Long id, Model model){
        model.addAttribute("order", orderRepository.findById(id).get());
        return "orders/showOrder";
    }

    @GetMapping("/{id}/update")
    public String getUpdateOrder(@PathVariable Long id, Model model){
        model.addAttribute("order", orderRepository.findById(id).get());
        return "orders/updateOrder";
    }

    @PostMapping("/{id}/update")
    public String postUpdateOrder(@ModelAttribute Order order){
        orderRepository.save(order);
        return "redirect:/orders";
    }
}
