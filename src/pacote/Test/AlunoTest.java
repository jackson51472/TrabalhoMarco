package pacote.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pacote.*;

class AlunoTest {
    Professor professor;
    Estado estado;
    Cidade cidade;
    Aluno aluno;
    Curso curso;

    @BeforeEach
    void setUp() {
        professor = new Professor();
        curso = new Curso();
        cidade = new Cidade();
        estado = new Estado();
        aluno = new Aluno();
    }
    //D
    @Test
    void  deveRetornarEstadoAluno(){
        estado.setNomeEstado("Minas Gerais");
        cidade.setEstado(estado);
        aluno.setCidade(cidade);
        Assertions.assertEquals("Minas Gerais", aluno.retornarEstado());
    }
    @Test
    void  deveRetornarAlunoEstadoNaoEncontrado(){
        cidade.setNomeCidade("Paiva");
        aluno.setCidade(cidade);
        Assertions.assertEquals("Estado não encontrado", aluno.retornarEstado());
    }
    @Test
    void  deveRetornarAlunoCidadeEstadoNaoEncontrado(){
        Assertions.assertEquals("Cidade e Estado não encontrado", aluno.retornarEstado());
    }
    @Test
    void  deveRetornarAlunoCidade(){
        cidade.setNomeCidade("Paiva");
        aluno.setCidade(cidade);
        Assertions.assertEquals("Paiva", aluno.retornarCidade());
    }
    @Test
    void  deveRetornarAlunoCidadeNaoEncontrada(){
        Assertions.assertEquals("Cidade não encontrada", aluno.retornarCidade());
    }




    // H
    @Test
    void deveRetornaNomeCoodernadorCurso(){

        professor.setNome("Marco Antonio");
        curso.setCoodernador(professor);
        aluno.setCurso(curso);

        try {
            Assertions.assertEquals("Marco Antonio", aluno.getCurso().getCoodernador().getNome());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Marco Antonio");
        }
    }

    @Test
    void deveRetornarCoodernadorSemNome(){

        curso.setCoodernador(professor);
        aluno.setCurso(curso);

        try {
            aluno.getCurso().getCoodernador().getNome();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome não cadastrado", e.getMessage());
        }
    }


    @Test
    void deveRetornarCoordenadorNaoEncontrado(){
        aluno.setCurso(curso);

        try {

            aluno.getCurso().getCoodernador();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Coodernado não cadastrado", e.getMessage());
        }
    }
    @Test
    void deveRetornarCursoNaoEncontrada(){

        try {
            aluno.getCurso();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso não cadastrado", e.getMessage());
        }
    }

}