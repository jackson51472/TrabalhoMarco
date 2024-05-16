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


    // C
    @Test
    void deveRetornarEscolaridadeDiretor(){

        escolaridade.setNome("Mestrado");
        professor.setEscolaridade(escolaridade);
        escola.setDiretor(professor);

        try {
            Assertions.assertEquals("Mestrado", escola.getNomeEscolaridadeDiretor());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Mestrado");
        }
    }
    @Test
    void deveRetornarEscolaridadeSemNome(){

        professor.setEscolaridade(escolaridade);
        escola.setDiretor(professor);

        try {
            escola.getNomeEscolaridadeDiretor();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não tem nome cadastrado", e.getMessage());
        }


    }
    @Test
    void deveRetornarEscolaridadeNula(){
        escola.setDiretor(professor);
        try {
            escola.getNomeEscolaridadeDiretor();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não cadastrada", e.getMessage());
        }
    }
    @Test
    void deveRetornarSemDiretor(){
        try {
            escola.getNomeEscolaridadeDiretor();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Diretor não cadastrado", e.getMessage());
        }
    }
}