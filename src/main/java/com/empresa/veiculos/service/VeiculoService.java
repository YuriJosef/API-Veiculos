package com.empresa.veiculos.service;

import com.empresa.veiculos.model.Veiculo;
import com.empresa.veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}