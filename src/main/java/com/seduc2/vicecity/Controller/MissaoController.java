
package com.seduc2.vicecity.Controller;

import com.seduc2.vicecity.Entity.Missao;
import com.seduc2.vicecity.Services.MissaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
@CrossOrigin(origins = "*")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Missao> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Missao> buscarPorId(@PathVariable Long id) {
        Missao missao = service.buscarPorId(id);

        if (missao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(missao);
    }

    @PostMapping
    public ResponseEntity<Missao> cadastrar(@RequestBody Missao missao) {
        return ResponseEntity.ok(service.salvar(missao));
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody Missao m) {
        service.alterar(id, m);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
