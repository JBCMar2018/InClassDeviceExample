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

/*    @Autowired
    ArrayList<Device> deviceList;

    @Bean
    public ArrayList<Device> getList()
    {
        return new ArrayList<Device>();
    }*/

    @Autowired
    DeviceRepository deviceList;

//    long id;


    @GetMapping("/")
    public @ResponseBody  String index(Model model) {
//        id++;
        Device aDevice = new Device();
        //Display HTML form, to add details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter device brand");
        aDevice.setBrand(sc.nextLine());

        System.out.println("Enter device model");
        aDevice.setModel(sc.nextLine());
        deviceList.save(aDevice);
        return "The device has been saved";
    }
    @GetMapping("/show")
    public @ResponseBody String show(Model model)
    {
        model.addAttribute("devices",deviceList.findAll());
        return "Devices in the list:"+deviceList.toString();
    }

    @GetMapping("/list")
    public String showForm(Model model)
    {
        model.addAttribute("devices",deviceList.findAll());
        return "list";
    }

    @RequestMapping("/add")
    public String addDevice(HttpServletRequest request)
    {
        //http://localhost:8080/add?brand=Samsung&model=Galaxy 9
        Device aDevice = new Device();

        aDevice.setModel(request.getParameter("model")==null?"no model":request.getParameter("model"));
        //This is equivalent to
        /*
                if(request.getParameter("model")==null)
            aDevice.setModel("no model");
        else
            aDevice.setModel(request.getParameter("model"));
        * */
        aDevice.setBrand(request.getParameter("brand")==null?"no brand":request.getParameter("brand"));


        deviceList.save(aDevice);
        return "redirect:/list";
    }

    

}
