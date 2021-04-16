package com.example.continuada2.controle;
import com.example.continuada2.dominio.LutaLivre;
import com.example.continuada2.repositorio.LutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutaController {

    @Autowired
    private LutaRepository repository;

    @PostMapping({ "nome","forcaGolpe" })
    public ResponseEntity postLutador(@RequestBody  @Valid LutaLivre novoLutador) {
        if (novoLutador.getNome().length() < 3 || novoLutador.getNome().length() > 13) {
            return ResponseEntity.status(400).body("O nome conter entre 3 e 13 letras");
        }
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getPizzas() {
        List<LutaLivre> lutadores = repository.findAll();
        return ResponseEntity.status(200).body(lutadores);
    }

    @GetMapping("/contagem-vivos ")
    public ResponseEntity getContagemVivos() {
        return ResponseEntity.status(200).body(repository.findBynVivoTrue());
    }

    @GetMapping("/contagem-vivos ")
    public ResponseEntity getMortos() {
        return ResponseEntity.status(200).body(repository.findBynNomeandForcaGolpeandVivoFalse(nome,forcaGolpe));
    }


}
