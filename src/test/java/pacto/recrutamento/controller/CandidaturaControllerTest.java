package pacto.recrutamento.controller;

import pacto.recrutamento.model.Candidatura;
import pacto.recrutamento.service.CandidaturaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CandidaturaControllerTest {

    @Mock
    private CandidaturaService candidaturaService;

    @InjectMocks
    private CandidaturaController candidaturaController;

    public CandidaturaControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarCandidatura_Success() {
        Candidatura candidatura = new Candidatura();
        when(candidaturaService.salvarCandidatura(any(Candidatura.class))).thenReturn(candidatura);

        Candidatura result = candidaturaController.criarCandidatura(candidatura);

        assertEquals(candidatura, result);
    }

    @Test
    public void testListarCandidaturas_Success() {
        List<Candidatura> candidaturas = List.of(new Candidatura());
        when(candidaturaService.listarCandidaturas()).thenReturn(candidaturas);

        List<Candidatura> result = candidaturaController.listarCandidaturas();

        assertEquals(candidaturas, result);
    }
}
