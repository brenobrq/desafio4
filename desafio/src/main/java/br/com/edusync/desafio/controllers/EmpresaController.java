package br.com.edusync.desafio.controllers;

import br.com.edusync.desafio.models.EmpresaModel;
import br.com.edusync.desafio.services.EmpresaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService service;
    @GetMapping (value = "/listar")
    public ResponseEntity listarPagamento(){
        return new ResponseEntity(service.listar(),HttpStatus.OK);
    }
    @PostMapping (value = "/add")
    public ResponseEntity adicionarEmpresa(@RequestBody EmpresaModel empresa){
        service.adicionar(empresa);
        return new ResponseEntity(empresa, HttpStatus.CREATED);
    }
    @PutMapping (value = "/alterar/{cnpj}")
    public ResponseEntity alterarEmpresa(@PathVariable String cnpj, @RequestBody EmpresaModel empresa){
        service.atualizar(cnpj, empresa);
        return new ResponseEntity(empresa, HttpStatus.OK);

    }
    @DeleteMapping (value = "/deletar/{cnpj}")
    public ResponseEntity deletarEmpresa(@PathVariable String cnpj){
        service.Remove(cnpj);
        return new ResponseEntity(HttpStatus.OK);
    }
}
