package com.seduc2.vicecity.Repository;

import com.seduc2.vicecity.Entity.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}