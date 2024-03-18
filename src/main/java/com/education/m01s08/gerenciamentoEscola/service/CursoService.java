package com.education.m01s08.gerenciamentoEscola.service;

import com.education.m01s08.gerenciamentoEscola.model.Aluno;
import com.education.m01s08.gerenciamentoEscola.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private AlunoService alunoService;
    public Curso salvar(Curso curso) throws Exception{
        if (validar(curso)) {
            return Curso.inserir(curso);
        }

        return null;
    }

    public List<Curso> buscarTodos(){return Curso.getListaDeCursos();}

    public Curso buscarPorId(Integer id) throws Exception{
        return Curso.buscarPorId(id);
    }


    public Curso adicionaAluno(Integer idCurso, Integer idAluno) throws Exception{
        Curso curso = buscarPorId(idCurso);
        Aluno aluno = alunoService.buscarPorId(idAluno);
        Curso.adicionarAlunoAoCurso(curso, aluno);
        return curso;
    }


    public static boolean validar(Curso curso) throws Exception{
        if(curso.getNome() == null || curso.getNome().isBlank()){
            throw new Exception("Nome obrigatório!");
        }

        return true;
    }
}
