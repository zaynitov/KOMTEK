package app.controller;


import app.model.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import app.service.BloodService;
import app.service.PatientService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller

public class BloodController {
    @Autowired
    BloodService bloodService;
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/getAllBloodsForPatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getAllBloodsForPatient(@PathVariable("id") int id, Model model) {
        if (patientService.getPatient(id).getBlood() == null) {
            patientService.getPatient(id).setBlood(new HashSet<Blood>());
        }
        Set<Blood> listOfBloods =
                patientService.getPatient(id).getBlood();
        model.addAttribute("blood", new Blood());
        model.addAttribute("listOfBloods", listOfBloods);
        return "bloodDetails";
    }

    @RequestMapping(value = "/addBloodForPatient/{id}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public String addBlood(@PathVariable("id") int id,
                           @ModelAttribute("blood") Blood blood) {
        if (blood == null || blood.getId() == null || bloodService.getBlood(blood.getId()) == null) {

            blood.setPatient(patientService.getPatient(id));
            bloodService.addBlood(blood);
        } else {
            blood.setPatient(bloodService.getBlood(blood.getId()).getPatient());
            bloodService.updateBlood(blood);
        }
        return "redirect:/getAllBloodsForPatient/{id}";
    }

    @RequestMapping(value = "/getAllBloodsForPatient/{snils}/updateBlood/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateBlood(@PathVariable("snils") int snils, @PathVariable("id") int id, Model model) {
        model.addAttribute("blood", this.bloodService.getBlood(id));
        Set<Blood> blood = bloodService.getBlood(id).getPatient().getBlood();
        model.addAttribute("listOfBloods", blood);
        return "bloodDetails";
    }

    @RequestMapping(value = "/getAllBloodsForPatient/{snils}/deleteBlood/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteBlood(@PathVariable("snils") int snils, @PathVariable("id") int id) {
        bloodService.deleteBlood(id);
        return "redirect:/getAllBloodsForPatient/{snils}";
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "measuredate", new CustomDateEditor(dateFormat, true));
    }
}
