import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

// Testa os cálculos de matrículas ponderadas e repasses do Fundeb.
class CalculoFundebTest {
    @Test
    void deveRetornarZeroQuandoMunicipioNaoTemMatriculas() {
    Municipio municipio = new Municipio("Cidade teste", 1234567);
    CalculoFundeb calculo = new CalculoFundeb(1000.0);

    assertEquals(0.0, calculo.calcularRepasse(municipio), 0.001);
    }
    @Test
    void deveAdicionarMatricula() {
    // Preparar os dados
    Municipio municipio = new Municipio("Cidade teste", 1234567);
    Matricula matricula = new Matricula(
            new ModalidadeEnsino("Integral", 1.2), 25);

    // Executar o método que queremos testar
    municipio.adicionarMatricula(matricula);

    // Conferir o resultado
    assertEquals(1, municipio.getMatriculas().size());
    assertSame(matricula, municipio.getMatriculas().get(0));
}
    
}
