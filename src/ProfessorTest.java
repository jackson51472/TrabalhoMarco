import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    Professor professor;
    Escolaridade escolaridade;

    @BeforeEach
    void setUp() {
        professor = new Professor();
        escolaridade = new Escolaridade();
    }
    @Test
    void deveRetornarEscolaridadeProfessor(){
        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        assertEquals("Mestrado", professor.pegarEscolaridade());
    }

}