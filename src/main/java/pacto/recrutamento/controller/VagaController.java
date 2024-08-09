package pacto.recrutamento.controller;

import pacto.recrutamento.model.Vaga;
import pacto.recrutamento.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public Vaga criarVaga(@RequestBody Vaga vaga) {
        return vagaService.salvarVaga(vaga);
    }

    @GetMapping
    public List<Vaga> listarVagas() {
        return vagaService.listarVagas();
    }

    @GetMapping("/{id}")
    public Vaga buscarVagaPorId(@PathVariable Long id) {
        return vagaService.buscarVagaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVaga(@PathVariable Long id) {
        vagaService.deletarVaga(id);
    }
}
