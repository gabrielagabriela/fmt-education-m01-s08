package com.education.m01s08.gerenciamentoEscola.controller;

import com.education.m01s08.gerenciamentoEscola.model.Curso;
import com.education.m01s08.gerenciamentoEscola.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    @GetMapping
    public List<Curso> get(){
        return cursoService.buscarTodos();
    }

    @GetMapping("{id}")
    public Curso getId(@PathVariable Integer id) throws Exception{
        return cursoService.buscarPorId(id);
    }
}
