package me.afua.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class MainController {

    @Autowired
    DeviceRepository deviceList;

    @GetMapping("/")
    public String showForm(Model model)
    {
        model.addAttribute("devices",deviceList.findAll());
        return "list";
    }

    @RequestMapping("/addform")
    public String addDevice(Model model)
    {
        model.addAttribute("theDevice",new Device());
        return "addform";
    }

    @RequestMapping("/addmethod")
    public String saveDevice(@ModelAttribute("theDevice") Device device)
    {

        deviceList.save(device);
        return "redirect:/";
    }
    

}
