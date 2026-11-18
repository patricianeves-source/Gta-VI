package com.seduc2.vicecity.Repository;

import com.seduc2.vicecity.Entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
}