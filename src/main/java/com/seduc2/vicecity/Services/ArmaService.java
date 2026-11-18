
package com.seduc2.vicecity.Services;

import com.seduc2.vicecity.Entity.Arma;
import com.seduc2.vicecity.Repository.ArmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmaService {

    private final ArmaRepository repository;

    public ArmaService(ArmaRepository repository) {
        this.repository = repository;
    }

    public List<Arma> listarTodos() {
        return repository.findAll();
    }

    public Arma buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Arma salvar(Arma arma) {
        return repository.save(arma);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void alterar(Long id, Arma a) {
        Arma arma = repository.getReferenceById(id);

        arma.setNome(a.getNome());
        arma.setCategoria(a.getCategoria());
        arma.setDescricao(a.getDescricao());
        arma.setFabricante(a.getFabricante());
        arma.setImagem(a.getImagem());
    }
}
