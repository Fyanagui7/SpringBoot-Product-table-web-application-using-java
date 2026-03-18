package com.example.demo.Service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.Model.ModelProduto;
import com.example.demo.Repository.RepositoryProduto;

@Service
public class ServiceProduto {

    private final RepositoryProduto repository;

    public ServiceProduto(RepositoryProduto repository) {
        this.repository = repository;
    }

    public List<ModelProduto> listar() {
        return repository.findAll();
    }

    public ModelProduto procurarID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}