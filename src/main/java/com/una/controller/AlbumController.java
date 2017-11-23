package com.una.controller;


import com.una.entity.Album;

import com.una.repository.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.data.domain.Pageable;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Properties;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/album")
public class AlbumController {

    private AlbumRepository albumRepository;
    private GeneroRepository generoRepository;
    private GravadoraRepository gravadoraRepository;
    private MidiaRepository midiaRepository;
    private ArtistaRepository artistaRepository;

    public AlbumController(AlbumRepository albumRepository, GeneroRepository generoRepository,
                           GravadoraRepository gravadoraRepository, MidiaRepository midiaRepository,
                           ArtistaRepository artistaRepository) {
        this.albumRepository = albumRepository;
        this.generoRepository = generoRepository;
        this.gravadoraRepository = gravadoraRepository;
        this.midiaRepository = midiaRepository;
        this.artistaRepository = artistaRepository;
    }

    @GetMapping
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("albuns", albumRepository.findAll(pageable));
        return "album/listar";
    }

  @GetMapping("/editar")
    public String editar(Model model, @RequestParam Integer id){
        model.addAttribute("album", albumRepository.findOne(id));
        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("gravadoras", gravadoraRepository.findAll());
        model.addAttribute("midias", midiaRepository.findAll());
        model.addAttribute("artistas", artistaRepository.findAll());
        return "album/formulario";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("album", new Album());
        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("gravadoras", gravadoraRepository.findAll());
        model.addAttribute("midias", midiaRepository.findAll());
        model.addAttribute("artistas", artistaRepository.findAll());
        return "album/formulario";
    }


    @PostMapping("/salvar")
    public String salvar(@Valid Album album, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("generos", generoRepository.findAll());
            model.addAttribute("gravadoras", gravadoraRepository.findAll());
            model.addAttribute("midias", midiaRepository.findAll());
            model.addAttribute("artistas", artistaRepository.findAll());
            return "album/formulario";
        }
        albumRepository.save(album);
        return "redirect:/album";
    }

    @GetMapping("/delete")
    public String excluir(Model model, @RequestParam Integer id){
        albumRepository.delete(id);
        return "redirect:/album";
    }
    @RequestMapping(value = "/relatorio", method = RequestMethod.GET)
    public String relatorio(Model model, @RequestParam(defaultValue = "pdf") String format, HttpServletResponse response) {
        model.addAttribute("datasource", albumRepository.findAll());
        model.addAttribute("format", format);
        return "reports/albuns";
    }
    
    @GetMapping("/buscar")
    public String buscar(Model model, @RequestParam String nome,@PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("album", new Album());
        model.addAttribute("albuns",	albumRepository.findByNomeLike("%" + nome + "%",pageable));
        return "album/listar";
    }


}

