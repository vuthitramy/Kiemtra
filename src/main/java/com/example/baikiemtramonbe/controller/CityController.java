package com.example.baikiemtramonbe.controller;



import com.example.baikiemtramonbe.model.City;
import com.example.baikiemtramonbe.service.CityService;
import com.example.baikiemtramonbe.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    private ICityService cityService = new CityService();
    @GetMapping("")
    public String city(Model model) {
        List<City> list =  cityService.findAll();
        System.out.println(list);
        model.addAttribute("city", list);
        return "/index";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("city", new City());
        return "/create";
    }

    @PostMapping("/save")
    public String save(City city) {
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(City city) {
        cityService.save(city);
        return "redirect:/city";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id , RedirectAttributes redirect) {
        City city = cityService.findById(id);
        cityService.remove(city.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/city";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        return "/view";
    }
}