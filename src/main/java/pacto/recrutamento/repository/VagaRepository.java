package pacto.recrutamento.repository;

import pacto.recrutamento.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
