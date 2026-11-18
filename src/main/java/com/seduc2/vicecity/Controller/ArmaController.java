
package com.seduc2.vicecity.Controller;

import com.seduc2.vicecity.Entity.Arma;
import com.seduc2.vicecity.Services.ArmaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armas")
@CrossOrigin(origins = "*")
public class ArmaController {

    private final ArmaService service;

    public ArmaController(ArmaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Arma> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arma> buscarPorId(@PathVariable Long id) {
        Arma arma = service.buscarPorId(id);

        if (arma == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(arma);
    }

    @PostMapping
    public ResponseEntity<Arma> cadastrar(@RequestBody Arma arma) {
        return ResponseEntity.ok(service.salvar(arma));
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody Arma a) {
        service.alterar(id, a);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
