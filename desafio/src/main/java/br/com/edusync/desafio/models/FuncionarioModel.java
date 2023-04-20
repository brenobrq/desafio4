package br.com.edusync.desafio.models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FuncionarioModel {

    private String nome;
    private String cpf;

    private LocalDate idade;

    private EmpresaModel empresa;

    private SalarioModel salario;
}
