
package com.seduc2.vicecity.Services;

import com.seduc2.vicecity.Entity.Missao;
import com.seduc2.vicecity.Repository.MissaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository repository;

    public MissaoService(MissaoRepository repository) {
        this.repository = repository;
    }

    public List<Missao> listarTodos() {
        return repository.findAll();
    }

    public Missao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Missao salvar(Missao missao) {
        return repository.save(missao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void alterar(Long id, Missao m) {
        Missao missao = repository.getReferenceById(id);

        missao.setNome(m.getNome());
        missao.setLocal(m.getLocal());
        missao.setDificuldade(m.getDificuldade());
        missao.setImagem(m.getImagem());
        missao.setDescricao(m.getDescricao());
    }
}
