package pacto.recrutamento.controller;

import pacto.recrutamento.model.Vaga;
import pacto.recrutamento.service.VagaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VagaControllerTest {

    @Mock
    private VagaService vagaService;

    @InjectMocks
    private VagaController vagaController;

    public VagaControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarVaga_Success() {
        Vaga vaga = new Vaga();
        when(vagaService.salvarVaga(any(Vaga.class))).thenReturn(vaga);

        Vaga result = vagaController.criarVaga(vaga);

        assertEquals(vaga, result);
    }

    @Test
    public void testListarVagas_Success() {
        List<Vaga> vagas = List.of(new Vaga());
        when(vagaService.listarVagas()).thenReturn(vagas);

        List<Vaga> result = vagaController.listarVagas();

        assertEquals(vagas, result);
    }
}
