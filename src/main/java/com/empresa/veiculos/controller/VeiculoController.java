package com.empresa.veiculos.controller;

import com.empresa.veiculos.model.Veiculo;
import com.empresa.veiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    // 1. LISTAR TODOS os veículos (GET /veiculos)
    @GetMapping
    public List<Veiculo> listarTodos() {
        return service.listarTodos();
    }

    // 2. BUSCAR POR ID (GET /veiculos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CADASTRAR novo veículo (POST /veiculos)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return service.salvar(veiculo);
    }

    // 4. ATUALIZAR veículo existente (PUT /veiculos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return service.buscarPorId(id)
                .map(veiculoExistente -> {
                    veiculo.setId(veiculoExistente.getId());
                    return ResponseEntity.ok(service.salvar(veiculo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETAR veículo (DELETE /veiculos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}