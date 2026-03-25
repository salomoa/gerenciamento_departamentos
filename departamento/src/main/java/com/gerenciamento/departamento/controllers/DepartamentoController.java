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
    public ResponseEntity<List<DepartamentoModel>> buscarTodosOsDepartamentos(){
        List<DepartamentoModel> requisicao = departamentoService.buscarTodosDepartamentos();
        return ResponseEntity.ok().body(requisicao);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamentos(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel requisicao = departamentoService.criarDepartamentos(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(departamentoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamentos(@PathVariable Long id){
        departamentoService.deletarDepartamentos(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarDepartamentoPeloId(@PathVariable Long id){
        return departamentoService.buscarDepartamentoId(id);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizarDepartamentos(@PathVariable Long id, @RequestBody DepartamentoModel departamentoModel){
        return departamentoService.atualizarDepartamentos(id, departamentoModel);
    }
}