package com.una.controller;

import com.una.entity.Genero;
import com.una.repository.GeneroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/genero")
public class GeneroController {

    private GeneroRepository generoRepository;

    private GeneroController(GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("generos", generoRepository.findAll());
        return "genero/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("genero", new Genero());
        return "genero/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Genero genero, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "genero/formulario";
        }
        generoRepository.save(genero);
        return "redirect:/genero";
    }

    @GetMapping("/editar")
    public String editar(Model model, @RequestParam Integer id){
        model.addAttribute("genero", generoRepository.findOne(id));
        model.addAttribute("generos", generoRepository.findAll());
        return "genero/formulario";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id){
        generoRepository.delete(id);
        return "redirect:/genero";
    }
}
