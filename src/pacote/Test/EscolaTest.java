package pacote.Test;

import pacote.Professor;
import pacote.Escolaridade;
import pacote.Escola;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EscolaTest {

    Professor professor;
    Escolaridade escolaridade;
    Escola escola;

    @BeforeEach
    void setUp() {
        escola = new Escola();
        professor = new Professor();
        escolaridade = new Escolaridade();
    }

    @Test
    void deveRetornarEscolaridadeDiretor(){

        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        escola.setDiretor(professor);
        Assertions.assertEquals("Mestrado", escola.getDiretor().pegarEscolaridade());
    }
    @Test
    void deveRetornarEscolaridadeNula(){
        escola.setDiretor(professor);
        Assertions.assertEquals("Escolaridade nula", escola.getDiretor().pegarEscolaridade());
    }



}