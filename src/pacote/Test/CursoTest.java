package pacote.Test;

import pacote.Professor;
import pacote.Escolaridade;
import pacote.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {

    Professor professor;
    Escolaridade escolaridade;
    Curso curso;

    @BeforeEach
    void setUp() {
            curso = new Curso();
            professor = new Professor();
            escolaridade = new Escolaridade();
        }
    //B
    @Test
    void deveRetornarEscolaridadeProfessor(){

        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        curso.setCoodernador(professor);

        try {
            Assertions.assertEquals("Mestrado", curso.getCoodernador().getEscolaridade().getNomeEscolaridade());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Mestrado");
        }
    }

    @Test
    void deveRetornarEscolaridadeSemNome(){

        professor.setEscolaridade(escolaridade);
        curso.setCoodernador(professor);

        try {
            curso.getCoodernador().getEscolaridade().getNomeEscolaridade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não tem nome cadastrado", e.getMessage());
        }


    }

    @Test
    void deveRetornarEscolaridadeNula(){
        curso.setCoodernador(professor);
        try {
            curso.getCoodernador().getEscolaridade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não cadastrada", e.getMessage());
        }
    }

    @Test
    void deveRetornarCursoSemCoodernador(){
        try {
            curso.getCoodernador();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Coodernado não cadastrado", e.getMessage());
        }
    }


}
