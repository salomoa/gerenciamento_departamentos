package com.gerenciamento.departamento.controllers;

import com.gerenciamento.departamento.models.DepartamentoModel;
import com.gerenciamento.departamento.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoas")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> requisicao = departamentoService.findAll();
        return ResponseEntity.ok().body(requisicao);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarPessoa(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel requisicao = departamentoService.criarPessoa(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(departamentoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarId(@PathVariable Long id){
        return departamentoService.buscarId(id);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizar(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel){
        return departamentoService.atualizar(id, departamentoModel);
    }
}