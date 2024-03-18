package com.education.m01s08.gerenciamentoEscola.service;


import com.education.m01s08.gerenciamentoEscola.model.Aluno;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    public Aluno salvar(Aluno aluno) throws Exception{

        if(validar(aluno)) {
            return Aluno.inserir(aluno);
        }
        return null;
    }

    public List<Aluno> buscarTodos(){
        return Aluno.getListaDeAlunos();
    }

    public Aluno buscarPorId(Integer id) throws Exception {
        return Aluno.buscarPorId(id);
    }


    public static boolean validar(Aluno aluno) throws Exception{
        if(aluno.getNome() == null || aluno.getNome().isBlank()){
            throw new Exception("Nome do aluno é obrigatório");
        }

        return true;
    }
}
