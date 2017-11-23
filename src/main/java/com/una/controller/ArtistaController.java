package com.una.controller;


import com.una.entity.Artista;
import com.una.repository.ArtistaRepository;
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
@RequestMapping("/artista")
public class ArtistaController {

    private ArtistaRepository artistaRepository;
    private GeneroRepository generoRepository;

    private ArtistaController(ArtistaRepository artistaRepository, GeneroRepository generoRepository){
        this.artistaRepository = artistaRepository;
        this.generoRepository = generoRepository;
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("artistas", artistaRepository.findAll());
        return "artista/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("artista", new Artista());
        model.addAttribute("generos", generoRepository.findAll());
        return "artista/formulario";
    }
    @PostMapping("/salvar")
    public String salvar(@Valid Artista artista, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("generos", generoRepository.findAll());
            return "artista/formulario";
        }
        artistaRepository.save(artista);
        return "redirect:/artista";
    }

    @GetMapping("/editar")
    public String editar(Model model, @RequestParam Integer id){
        model.addAttribute("artista", artistaRepository.findOne(id));
        model.addAttribute("generos", generoRepository.findAll());
        return "artista/formulario";
    }

    @GetMapping("/excluir")
    public String excluir(Model model, @RequestParam Integer id){
        artistaRepository.delete(id);
        return "redirect:/artista";
    }


}
