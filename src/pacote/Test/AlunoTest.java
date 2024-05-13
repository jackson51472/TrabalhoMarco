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
    Escola escola;

    @BeforeEach
    void setUp() {
        escola = new Escola();
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

        try {
            Assertions.assertEquals("Minas Gerais", aluno.getCidade().getEstado().getNomeEstado());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Minas Gerais");
        }

    }
    @Test
    void  deveRetornarEstadoSemNome() {
        cidade.setEstado(estado);
        aluno.setCidade(cidade);
        try {
            aluno.getCidade().getEstado().getNomeEstado();
            Assertions.fail("Deveria ter lançado Minas Gerais");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome do Estado não cadastrado", e.getMessage());
        }
    }
    @Test
    void  deveRetornarEstadoNaoCadastrado(){
        aluno.setCidade(cidade);
        try {
            aluno.getCidade().getEstado().getNomeEstado();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Estado não cadastrada",e.getMessage());
        }

    }
    @Test
    void  deveRetornarCidadeNaoCadastrada(){

        try {
            aluno.getCidade().getEstado().getNomeEstado();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Cidade não cadastrada",e.getMessage());
        }

    }

    //F
    @Test
    void deveRetornarEscolaNaoCadastrada(){
        aluno.setCurso(curso);
        try {
            aluno.getCurso().getEscola();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escola não cadastrada", e.getMessage());
        }

    }
    @Test
    void deveRetornarEscolaSemCidadeCadastrada(){
        curso.setEscola(escola);
        aluno.setCurso(curso);
        try {
            aluno.getCurso().getEscola().getCidade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Cidade não cadastrada", e.getMessage());
        }

    }
    @Test
    void deveRetornarCidadeSemNomeCadastrado(){
        escola.setCidade(cidade);
        curso.setEscola(escola);
        aluno.setCurso(curso);
        try {
            aluno.getCurso().getEscola().getCidade().getNomeCidade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome da Cidade esta vazia", e.getMessage());
        }

    }
    @Test
    void deveRetornarNomeCidade() {
        cidade.setNomeCidade("Paiva");
        escola.setCidade(cidade);
        curso.setEscola(escola);
        aluno.setCurso(curso);
        try {

            Assertions.assertEquals("Paiva", aluno.getCurso().getEscola().getCidade().getNomeCidade());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Paiva");
        }
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