package br.com.edusync.desafio.controllers;

import br.com.edusync.desafio.models.FuncionarioModel;
import br.com.edusync.desafio.services.FuncionarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping (value = "/listar")
    public ResponseEntity listarFuncionario(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping (value = "/add")
   public ResponseEntity adicionarEmpresa(@RequestBody FuncionarioModel funcionario){
        service.adicionar(funcionario);
        return new ResponseEntity(funcionario, HttpStatus.CREATED);
   }
   @PutMapping(value = "/alterar/{cpf}")
   public ResponseEntity alterarFuncionario(@PathVariable String cpf, @RequestBody FuncionarioModel funcionario){
        service.atualizar(cpf, funcionario);
        return new ResponseEntity(funcionario, HttpStatus.OK);
   }
   @DeleteMapping (value = "/deletar/{cpf}")
   public ResponseEntity deletarEmpresa(@PathVariable String cpf){
        service.Remove(cpf);
        return new ResponseEntity(HttpStatus.OK);
   }
}
