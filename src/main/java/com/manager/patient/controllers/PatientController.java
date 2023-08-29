package com.manager.patient.controllers;

import com.manager.patient.dto.PatientDto;
import com.manager.patient.services.IPatientservices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private IPatientservices patientservices;

    @GetMapping("/users")
    public String showList(Model model ,
                           @RequestParam(name = "page",defaultValue = "1")int numPage,
                           @RequestParam(name = "size",defaultValue = "3")int nomPage,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword) {
      Page<PatientDto> listpatient = patientservices.findPaginated(numPage,nomPage,keyword);
        model.addAttribute("listpatient", listpatient);
        model.addAttribute("currentPage",numPage );
        model.addAttribute("totalPages", new  int[listpatient.getTotalPages()] );
        model.addAttribute("keyword",keyword);



        return "users";
    }

    @GetMapping("users/new")
    public String showform(Model model) {
        model.addAttribute("patientdto", new PatientDto());
        model.addAttribute("pageTitle", "Add New Patient");
        return "user_form";
    }

    @PostMapping("/patient/save")
    public String savePatient(PatientDto patientDto, RedirectAttributes ra) {
        ra.addFlashAttribute("message", "the user has been saved successfuly");
        patientservices.save(patientDto);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        PatientDto patientdto = patientservices.get(id);
        model.addAttribute("patientdto", patientdto);
        model.addAttribute("pageTitle", "Edit PatientDto(ID:" + id + ")");
        return "user_form";

    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        patientservices.delete(id);
        return "redirect:/users";
    }
}
