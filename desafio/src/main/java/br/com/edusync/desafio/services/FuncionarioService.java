package br.com.edusync.desafio.services;

import br.com.edusync.desafio.models.EmpresaModel;
import br.com.edusync.desafio.models.FuncionarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FuncionarioService {

    public List<FuncionarioModel> funcionarios = new ArrayList<>();

    public List<FuncionarioModel> listar(){

        return funcionarios;
    }
    public void adicionar(FuncionarioModel funcionarioSalvo){
        funcionarios.add(funcionarioSalvo);
    }
    public FuncionarioModel buscarPOrCpf(String cpf){
        return funcionarios.stream().filter(f -> cpf.equals(f.getCpf())).findFirst().orElseThrow();
    }
    public void atualizar(String cpf, FuncionarioModel funcionario){
        FuncionarioModel pesquisarFuncionario = buscarPOrCpf(cpf);
    }
    public void Remove( String cpf){
        FuncionarioModel pesquisarCpf = buscarPOrCpf(cpf);
        if (pesquisarCpf != null){
            funcionarios.remove(cpf);
        }
        funcionarios.remove(pesquisarCpf);
    }
}
