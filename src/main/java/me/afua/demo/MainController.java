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
    ArrayList<Device> deviceList;
    long id;

    @Bean
    public ArrayList<Device> getList()
    {
        return new ArrayList<Device>();
    }

    @GetMapping("/")
    public @ResponseBody  String index(Model model) {
        id++;
        Device aDevice = new Device();
        //Display HTML form, to add details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter device brand");
        aDevice.setBrand(sc.nextLine());

        System.out.println("Enter device model");
        aDevice.setModel(sc.nextLine());
        deviceList.add(aDevice);
        return "The device has been saved";
    }
    @GetMapping("/show")
    public @ResponseBody String show(Model model)
    {
        model.addAttribute("devices",deviceList);
        return "Devices in the list:"+deviceList.toString();
    }

    @GetMapping("/list")
    public String showForm(Model model)
    {
        model.addAttribute("devices",deviceList);
        return "list";
    }

    @RequestMapping("/add")
    public String addDevice(HttpServletRequest request)
    {
        Device aDevice = new Device();
        aDevice.setModel(request.getParameter("model")==null?"no model":request.getParameter("model"));
        aDevice.setBrand(request.getParameter("brand")==null?"no brand":request.getParameter("brand"));
        deviceList.add(aDevice);
        return "redirect:/list";
    }

    

}
