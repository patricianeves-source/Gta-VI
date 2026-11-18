
package com.seduc2.vicecity.Controller;

import com.seduc2.vicecity.Entity.Veiculo;
import com.seduc2.vicecity.Services.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo veiculo = service.buscarPorId(id);

        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(service.salvar(veiculo));
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody Veiculo v) {
        service.alterar(id, v);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
