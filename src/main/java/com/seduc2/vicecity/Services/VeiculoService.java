
package com.seduc2.vicecity.Services;

import com.seduc2.vicecity.Entity.Veiculo;
import com.seduc2.vicecity.Repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void alterar(Long id, Veiculo v) {
        Veiculo veiculo = repository.getReferenceById(id);

        veiculo.setNome(v.getNome());
        veiculo.setMarca(v.getMarca());
        veiculo.setTipo(v.getTipo());
        veiculo.setDescricao(v.getDescricao());
        veiculo.setImagem(v.getImagem());
    }
}
