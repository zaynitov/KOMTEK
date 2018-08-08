package app.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import app.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import app.service.PatientService;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/getAllPatients", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getAllPatient(Model model) {
        List<Patient> listOfPatients = patientService.getAllPatients();
        model.addAttribute("patient", new Patient());
        model.addAttribute("listOfPatients", listOfPatients);
        return "customerDetails";
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birth", new CustomDateEditor(dateFormat, true));
    }


    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public String goToHomePage() {
        return "redirect:/getAllPatients";
    }

    @RequestMapping(value = "/getPatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatient(id);
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.GET, headers = "Accept=application/json")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
            patientService.addPatient(patient);
        return "redirect:/getAllPatients";
    }

    @RequestMapping(value = "/updatePatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updatePatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", this.patientService.getPatient(id));
        model.addAttribute("listOfPatients", this.patientService.getAllPatients());
        patientService.deletePatient(id);
        return "customerDetails";

    }

    @RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return "redirect:/getAllPatients";
    }
}
