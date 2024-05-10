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

    @Test
    void deveRetornarEscolaridadeProfessor(){

        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        curso.setCoodernador(professor);
        Assertions.assertEquals("Mestrado", curso.getCoodernador().pegarEscolaridade());
    }
    @Test
    void deveRetornarEscolaridadeNula(){
        curso.setCoodernador(professor);
        Assertions.assertEquals("Escolaridade nula", curso.getCoodernador().pegarEscolaridade());
    }



    }
