package com.una.controller;

import com.una.entity.Gravadora;
import com.una.repository.GravadoraRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/gravadora")
public class GravadoraController {

    private GravadoraRepository gravadoraRepository;

    public GravadoraController( GravadoraRepository gravadoraRepository){
        this.gravadoraRepository = gravadoraRepository;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("gravadoras", gravadoraRepository.findAll());
        return "gravadora/listar";

    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("gravadora", new Gravadora());
        return "gravadora/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Gravadora gravadora, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "gravadora/formulario";
        }
        gravadoraRepository.save(gravadora);
        return "redirect:/gravadora";
    }

    @GetMapping("/editar")
    public String editar(Model model, @RequestParam Integer id){
        model.addAttribute("gravadora", gravadoraRepository.findOne(id));
        model.addAttribute("gravadoras", gravadoraRepository.findAll());
        return "gravadora/formulario";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id){
        gravadoraRepository.delete(id);
        return "redirect:/gravadora";
    }

}
