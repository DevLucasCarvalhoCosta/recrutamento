package pacto.recrutamento.service;

import pacto.recrutamento.model.Candidatura;
import pacto.recrutamento.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    public Candidatura salvarCandidatura(Candidatura candidatura) {
        return candidaturaRepository.save(candidatura);
    }

    public List<Candidatura> listarCandidaturas() {
        return candidaturaRepository.findAll();
    }

    public Candidatura buscarCandidaturaPorId(Long id) {
        return candidaturaRepository.findById(id).orElse(null);
    }

    public void deletarCandidatura(Long id) {
        candidaturaRepository.deleteById(id);
    }

    public List<Candidatura> buscarCandidaturasPorVaga(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

}
