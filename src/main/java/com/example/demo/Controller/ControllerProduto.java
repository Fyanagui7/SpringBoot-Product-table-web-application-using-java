package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.ModelProduto;
import com.example.demo.Repository.RepositoryProduto;

@Controller
public class ControllerProduto {

    private final RepositoryProduto repository;

    public ControllerProduto(RepositoryProduto repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("produtos", repository.findAll());
        return "produtos";
    }

    @PostMapping("/produto/salvar")
    public String salvar(ModelProduto produto) {
        repository.save(produto);
        return "redirect:/";
    }

    @GetMapping("/produto/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}