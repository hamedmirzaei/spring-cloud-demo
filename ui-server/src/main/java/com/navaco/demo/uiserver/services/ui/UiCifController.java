package com.navaco.demo.uiserver.services.ui;

import com.navaco.demo.uiserver.services.api.CifServices;
import com.navaco.demo.uiserver.services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UiCifController {

    @Autowired
    private CifServices cifServices;

    @RequestMapping(value = "/rest/cif-all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getRestCIFInformation(){
        return this.cifServices.getUserInformation();
    }

    @RequestMapping(value = "/rest/cit-ni", method = RequestMethod.GET)
    @ResponseBody
    public User getRestCIFInformationByNationalIdentity(@RequestParam(name = "ni", required = true) String ni){
        return this.cifServices.getUserInformationByNI(ni);
    }

    @RequestMapping(value = "/cif-all", method = RequestMethod.GET)
    public String showCIFTable(Model model){
        List<User> users = this.cifServices.getUserInformation();
        model.addAttribute("users", users);
        return "cifinfo";
    }

}
