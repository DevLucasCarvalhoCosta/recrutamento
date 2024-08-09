package pacto.recrutamento.service;

import pacto.recrutamento.model.Vaga;
import pacto.recrutamento.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga salvarVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }

    public Vaga buscarVagaPorId(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

    public void deletarVaga(Long id) {
        vagaRepository.deleteById(id);
    }
}
