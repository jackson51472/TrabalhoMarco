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
        estado.setNome("Minas Gerais");
        cidade.setEstado(estado);
        aluno.setCidade(cidade);

        try {
            Assertions.assertEquals("Minas Gerais", aluno.getNomeEstado());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Minas Gerais");
        }

    }
    @Test
    void  deveRetornarEstadoSemNome() {
        cidade.setEstado(estado);
        aluno.setCidade(cidade);
        try {
            aluno.getNomeEstado();
            Assertions.fail("Deveria ter lançado Minas Gerais");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome do Estado não cadastrado", e.getMessage());
        }
    }
    @Test
    void  deveRetornarEstadoNaoCadastrado(){
        aluno.setCidade(cidade);
        try {
            aluno.getNomeEstado();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Estado nulo",e.getMessage());
        }

    }
    @Test
    void  deveRetornarCidadeNaoCadastrada(){

        try {
            aluno.getNomeEstado();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Cidade não cadastrada",e.getMessage());
        }

    }

    //F
    @Test
    void deveRetornarSemEscola(){
        aluno.setCurso(curso);
        Assertions.assertEquals("Sem escola cadastrada", aluno.getCidadeEscola());
    }
    @Test
    void deveRetornarEscolaSemCidade(){
        curso.setEscola(escola);
        aluno.setCurso(curso);
        Assertions.assertEquals("Escola sem cidade", aluno.getCidadeEscola());

    }
    @Test
    void deveRetornarCidadeSemNome(){
        escola.setCidade(cidade);
        curso.setEscola(escola);
        aluno.setCurso(curso);
        Assertions.assertEquals("Cidade sem nome", aluno.getCidadeEscola());

    }
    @Test
    void deveRetornarNomeCidade() {
        cidade.setNome("Paiva");
        escola.setCidade(cidade);
        curso.setEscola(escola);
        aluno.setCurso(curso);
        Assertions.assertEquals("Paiva", aluno.getCidadeEscola());
    }

    // H
    @Test
    void deveRetornaNomeCoodernadorCurso(){

        professor.setNome("Marco Antonio");
        curso.setCoodernador(professor);
        aluno.setCurso(curso);

        try {
            Assertions.assertEquals("Marco Antonio", aluno.getNomeCoordenado());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Marco Antonio");
        }
    }
    @Test
    void deveRetornarCoodernadorSemNome(){
        curso.setCoodernador(professor);
        aluno.setCurso(curso);

        Assertions.assertEquals("Nome não cadastrado", aluno.getNomeCoordenado());
    }
    @Test
    void deveRetornarCoordenadorNaoEncontrado(){
        aluno.setCurso(curso);

        try {
            aluno.getNomeCoordenado();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso sem coodernador", e.getMessage());
        }
    }
    @Test
    void deveRetornarCursoNaoEncontrada(){

        try {
            aluno.getNomeCoordenado();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Aluno sem curso", e.getMessage());
        }
    }

}