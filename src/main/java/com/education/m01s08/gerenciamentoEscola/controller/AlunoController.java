package com.education.m01s08.gerenciamentoEscola.controller;

import com.education.m01s08.gerenciamentoEscola.model.Aluno;
import com.education.m01s08.gerenciamentoEscola.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception{
        return alunoService.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> get(){
        return alunoService.buscarTodos();
    }

    @GetMapping("{id}")
    public Aluno getId(@PathVariable Integer id) throws Exception{
        return alunoService.buscarPorId(id);
    }


}
