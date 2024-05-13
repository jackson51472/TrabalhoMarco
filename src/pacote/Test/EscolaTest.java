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

        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        escola.setDiretor(professor);

        try {
            Assertions.assertEquals("Mestrado", escola.getDiretor().getEscolaridade().getNomeEscolaridade());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Mestrado");
        }
    }
    @Test
    void deveRetornarEscolaridadeSemNome(){

        professor.setEscolaridade(escolaridade);
        escola.setDiretor(professor);

        try {
            escola.getDiretor().getEscolaridade().getNomeEscolaridade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não tem nome cadastrado", e.getMessage());
        }


    }
    @Test
    void deveRetornarEscolaridadeNula(){
        escola.setDiretor(professor);
        try {
            escola.getDiretor().getEscolaridade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não cadastrada", e.getMessage());
        }
    }
    @Test
    void deveRetornarSemDiretor(){
        try {
            escola.getDiretor();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Diretor não cadastrado", e.getMessage());
        }
    }


    // I
    @Test
    void deveRetornarNomeDiretor(){

        professor.setNome("Marco Antonio");
        escola.setDiretor(professor);

        try {
            Assertions.assertEquals("Marco Antonio", escola.getDiretor().getNome());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Marco Antonio");
        }
    }
    @Test
    void deveRetornarDiiretorSemNome(){
        escola.setDiretor(professor);

        try {
            escola.getDiretor().getNome();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome não cadastrado", e.getMessage());
        }


    }
    @Test
    void deveRetornarDiretorNulo(){
        try {
            escola.getDiretor();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Diretor não cadastrado", e.getMessage());
        }
    }




}