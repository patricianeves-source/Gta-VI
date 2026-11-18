
package com.seduc2.vicecity.Controller;

import com.seduc2.vicecity.Entity.Personagem;
import com.seduc2.vicecity.Services.PersonagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
@CrossOrigin(origins = "*")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Personagem> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id) {
        Personagem personagem = service.buscarPorId(id);

        return ResponseEntity.ok(personagem);
    }

    @PostMapping
    public ResponseEntity<Personagem> cadastrar(@RequestBody Personagem personagem) {
        Personagem novoPersonagem = service.salvar(personagem);
        return ResponseEntity.ok(novoPersonagem);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody Personagem p) {
        service.alterar(id, p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
