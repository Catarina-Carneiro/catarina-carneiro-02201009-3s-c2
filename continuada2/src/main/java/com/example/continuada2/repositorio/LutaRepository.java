package com.example.continuada2.repositorio;


import com.example.continuada2.dominio.LutaLivre;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutaRepository extends JpaRepository<LutaLivre, Integer> {

    List<LutaLivre> findBynNomeandForcaGolpeandVivoFalse(String nome, Double forcaGolpe);
    List<LutaLivre> findBynVivoTrue();

}
