
package com.seduc2.vicecity.Services;

import com.seduc2.vicecity.Entity.Personagem;
import com.seduc2.vicecity.Repository.PersonagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository repository;

    public PersonagemService(PersonagemRepository repository) {
        this.repository = repository;
    }

    public List<Personagem> listarTodos() {
        return repository.findAll();
    }

    public Personagem buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Personagem salvar(Personagem personagem) {
        return repository.save(personagem);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void alterar(Long id, Personagem p) {
        Personagem personagem = repository.getReferenceById(id);

        personagem.setNome(p.getNome());
        personagem.setApelido(p.getApelido());
        personagem.setTipo(p.getTipo());
        personagem.setImagem(p.getImagem());
        personagem.setDescricao(p.getDescricao());
    }
}
