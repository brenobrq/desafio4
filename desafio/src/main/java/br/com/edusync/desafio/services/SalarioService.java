package br.com.edusync.desafio.services;

import br.com.edusync.desafio.models.FuncionarioModel;
import br.com.edusync.desafio.models.SalarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalarioService {
    public List<SalarioModel> salarios = new ArrayList<>();

    public List<SalarioModel> listar() {
        return salarios;
    }

    public void adicionar(SalarioModel salarioSalvo) {
        salarios.add(salarioSalvo);
    }

    public SalarioModel buscarPorcodigo(Integer codigo) {
        return salarios.stream().filter(c -> codigo.equals(c.getCodigo())).findFirst().orElseThrow();
    }

    public void atualizar(Integer codigo, SalarioModel salario) {
        SalarioModel pesquisarSalario = buscarPorcodigo(codigo);
    }
    public void Remove(Integer codigo){
        SalarioModel pesquisarSalario = buscarPorcodigo(codigo);
        if (pesquisarSalario != null){
            salarios.remove(codigo);
        }
        salarios.remove(pesquisarSalario);
    }
}