package br.com.edusync.desafio.controllers;

import br.com.edusync.desafio.models.SalarioModel;
import br.com.edusync.desafio.services.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/salario")
public class SalarioController {
    @Autowired
    private SalarioService service;

    @GetMapping (value = "/listar")
    public ResponseEntity listarSalario(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping (value = "/add")
    public ResponseEntity adicionarSalario(@RequestBody SalarioModel salario){
       service.adicionar(salario);
        return new ResponseEntity(salario, HttpStatus.CREATED);
    }
    @PutMapping (value = "/alterar/{codigo}")
    public ResponseEntity alterarSalario(@PathVariable Integer codigo, @RequestBody SalarioModel salario){
        service.atualizar(codigo, salario);
        return new ResponseEntity(salario, HttpStatus.OK);
    }
    @DeleteMapping (value = "/deletar")
    public ResponseEntity deletarSalario(Integer codigo){
        service.Remove(codigo);
        return new ResponseEntity(HttpStatus.OK);
    }

}
