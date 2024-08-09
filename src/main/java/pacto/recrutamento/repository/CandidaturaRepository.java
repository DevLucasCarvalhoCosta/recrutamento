package pacto.recrutamento.repository;

import pacto.recrutamento.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
    // Novo método para encontrar candidaturas por ID da vaga
    List<Candidatura> findByVagaId(Long vagaId);
}
