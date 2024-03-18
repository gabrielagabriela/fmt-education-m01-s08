package com.education.m01s08.gerenciamentoEscola.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Aluno {

    public static Integer proximoId = 1;
    @Setter(AccessLevel.NONE)private Integer id;
    private String nome;
    private Date dataNascimento;
    @Getter private static List<Aluno> listaDeAlunos = new ArrayList<>();

    public static Aluno inserir(Aluno aluno){
        aluno.id = proximoId++;
        listaDeAlunos.add(aluno);
        return aluno;
    }

    public static Aluno buscarPorId(Integer id) throws Exception {
        for(Aluno aluno: listaDeAlunos){
            if(aluno.getId().equals(id)){
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }




}
