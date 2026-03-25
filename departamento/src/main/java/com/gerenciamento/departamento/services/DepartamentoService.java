package com.gerenciamento.departamento.services;

import com.gerenciamento.departamento.models.DepartamentoModel;
import com.gerenciamento.departamento.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> buscarTodosDepartamentos() { return departamentoRepository.findAll(); }

    public DepartamentoModel criarDepartamentos(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public Optional<DepartamentoModel> buscarDepartamentoId(Long id) { return departamentoRepository.findById(id); }

    public DepartamentoModel atualizarDepartamentos(Long id, DepartamentoModel departamentoModel){
        DepartamentoModel model = departamentoRepository.findById(id).get();
        model.setNome(departamentoModel.getNome());
        model.setLocalizacao(departamentoModel.getLocalizacao());
        return departamentoRepository.save(model);
    }

    public void deletarDepartamentos(Long id){ departamentoRepository.deleteById(id); }

}
