package br.com.edusync.desafio.services;

import br.com.edusync.desafio.models.EmpresaModel;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmpresaService {
    public List<EmpresaModel> empresas = new ArrayList<>();

    public List<EmpresaModel> listar() {

        return empresas;
    }
    public void adicionar(EmpresaModel empresaSalva){
        empresas.add(empresaSalva);
    }
    public EmpresaModel buscarPorCnpj(String cnpj){
        return empresas.stream().filter(e -> cnpj.equals(e.getCnpj())).findFirst().orElseThrow();
    }
    public void atualizar( String cnpj, EmpresaModel empresa){
        EmpresaModel pesquisarEmpresa = buscarPorCnpj(cnpj);

    }
    public void Remove(String cnpj){
        EmpresaModel pesquisarCnpj = buscarPorCnpj(cnpj);
        if (pesquisarCnpj != null){
            empresas.remove(cnpj);
        }
        empresas.remove(pesquisarCnpj);
    }
}
