package com.newasia.hrm.controller;

import com.newasia.hrm.model.Address;
import com.newasia.hrm.service.service_implementation.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address_form")
    public String showAddressForm(Model model){
        Address address = new Address();
        model.addAttribute("address",address);
        return "address_form";
    }

    @PostMapping("/store_address")
    public String saveAddress(Model model, @ModelAttribute Address address){
        addressService.saveAddress(address);
        model.addAttribute("address",address);
        return "index";
    }
}
