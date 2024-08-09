package pacto.recrutamento.controller;

import pacto.recrutamento.model.Candidatura;
import pacto.recrutamento.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping
    public Candidatura criarCandidatura(@RequestBody Candidatura candidatura) {
        return candidaturaService.salvarCandidatura(candidatura);
    }

    @GetMapping
    public List<Candidatura> listarCandidaturas() {
        return candidaturaService.listarCandidaturas();
    }

    @GetMapping("/{id}")
    public Candidatura buscarCandidaturaPorId(@PathVariable Long id) {
        return candidaturaService.buscarCandidaturaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCandidatura(@PathVariable Long id) {
        candidaturaService.deletarCandidatura(id);
    }

    @GetMapping("vaga/{vagaId}")
    public List<Candidatura> buscarCandidaturasPorVaga(@PathVariable Long vagaId) {
        return candidaturaService.buscarCandidaturasPorVaga(vagaId);
    }
}
