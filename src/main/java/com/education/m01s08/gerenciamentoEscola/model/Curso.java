package com.education.m01s08.gerenciamentoEscola.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Curso {

    private static Integer proximoId = 1;
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    @Getter private static List<Curso> listaDeCursos = new ArrayList<>();

    public static Curso inserir(Curso curso){
        curso.id = proximoId++;
        listaDeCursos.add(curso);
        return curso;
    }

    public static Curso buscarPorId(Integer id) throws Exception{
        for (Curso curso : listaDeCursos){
           if( curso.getId().equals(id)) {
               return curso;
           }
        }

        throw new Exception("Curso não encontrado");
    }

}
