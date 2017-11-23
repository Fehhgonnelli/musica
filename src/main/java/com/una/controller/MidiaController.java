package com.una.controller;

import com.una.entity.Midia;
import com.una.repository.MidiaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/midia")
public class MidiaController{

    private MidiaRepository midiaRepository;

    public MidiaController( MidiaRepository midiaRepository){
        this.midiaRepository = midiaRepository;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("midias", midiaRepository.findAll());
        return "midia/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model){

        model.addAttribute("midia", new Midia());
        return "midia/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Midia midia, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "midia/formulario";
        }
        midiaRepository.save(midia);
        return "redirect:/midia";
    }

    @GetMapping("/editar")
    public String editar(Model model, @RequestParam Integer id){
        model.addAttribute("midia", midiaRepository.findOne(id));
        model.addAttribute("midias", midiaRepository.findAll());
        return "midia/formulario";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id){
        midiaRepository.delete(id);
        return "redirect:/midia";
    }

}
