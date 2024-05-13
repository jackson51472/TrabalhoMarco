package pacote.Test;

import pacote.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    Estado estado;
    Cidade cidade;
    Professor professor;
    Escolaridade escolaridade;
    TipoEnsino tipoEnsino;
    Curso curso;
    Escola escola;

    @BeforeEach
    void setUp() {
        escola = new Escola();
        tipoEnsino = new TipoEnsino();
        curso = new Curso();
        cidade = new Cidade();
        estado = new Estado();
        professor = new Professor();
        escolaridade = new Escolaridade();
    }
    // A
    @Test
    void deveRetornarEscolaridadeProfessor(){
        escolaridade.setNomeEscolaridade("Mestrado");
        professor.setEscolaridade(escolaridade);
        Assertions.assertEquals("Mestrado", professor.pegarEscolaridade());
    }
    @Test
    void deveRetornarEscolaridadeSemNome(){

        professor.setEscolaridade(escolaridade);


        try {
            professor.getEscolaridade().getNomeEscolaridade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não tem nome cadastrado", e.getMessage());
        }


    }
    @Test
    void deveRetornarEscolaridadeNula(){

        try {
            professor.getEscolaridade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não cadastrada", e.getMessage());
        }

    }


    //E
    @Test
    void  deveRetornarNomeCidade() {
        cidade.setNomeCidade("Paiva");
        professor.setCidade(cidade);
        try {

            Assertions.assertEquals("Paiva", professor.getCidade().getNomeCidade());

        } catch (NullPointerException e) {

            Assertions.fail("Deveria ter lançado Paiva");

        }
    }
    @Test
    void  deveRetornarNomeCidadeNaoCadastrada(){
        professor.setCidade(cidade);
        try {
            professor.getCidade().getNomeCidade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome da Cidade esta vazia",e.getMessage());
        }
    }
    @Test
    void  deveRetornarCidadeNaoCadastrada(){

        try {
            professor.getCidade().getNomeCidade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Cidade não cadastrada",e.getMessage());
        }

    }



    // G
    @Test
    void  deveRetornarTipoEnsino(){
        tipoEnsino.setTipo("médio");
        curso.setTipoEnsino(tipoEnsino);
        professor.setCurso(curso);
        try {
            professor.getCurso().getTipoEnsino().getTipo();
            Assertions.assertEquals("médio", professor.getCurso().getTipoEnsino().getTipo());
        } catch (NullPointerException e) {
            Assertions.fail("Deveria ter lançado Nome do Tipo Ensino");
        }
    }
    @Test
    void  deveRetornarTipoEnsinoNaoCadastrado(){
        curso.setTipoEnsino(tipoEnsino);
        professor.setCurso(curso);

        try {
            professor.getCurso().getTipoEnsino().getTipo();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome do Tipo não cadastrado", e.getMessage());
        }
    }
    @Test
    void  deveRetornarProfessorTipoEnsinoNaoCadastrada(){
        professor.setCurso(curso);

        try {
            professor.getCurso().getTipoEnsino().getTipo();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Tipo Ensino não cadastrado", e.getMessage());
        }

    }



    // G,I,J
    @Test
    void deveRetornarCursoNaoCadastrado(){
        try {
            professor.getCurso();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso não cadastrado", e.getMessage());
        }
    }

    // I
    @Test
    void deveRetornarEscolaNaoCadastrado(){
        professor.setCurso(curso);
        try {
            professor.getCurso().getEscola();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escola não cadastrada", e.getMessage());
        }

    }
    @Test
    void deveRetornarEscolaSemDiretor(){
        curso.setEscola(escola);
        professor.setCurso(curso);
        try {
            professor.getCurso().getEscola().getDiretor();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Diretor não cadastrado", e.getMessage());
        }

    }
    @Test
    void deveRetornarDiretorSemNome(){
        escola.setDiretor(professor);
        curso.setEscola(escola);
        professor.setCurso(curso);
        try {

            professor.getCurso().getEscola().getDiretor().getNome();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome não cadastrado", e.getMessage());
        }

    }
    @Test
    void deveRetornarDiretorNome(){
        professor.setNome("Marco Antonio");
        curso.setEscola(escola);
        professor.setCurso(curso);
        escola.setDiretor(professor);

        try {
            Assertions.assertEquals("Marco Antonio", professor.getCurso().getEscola().getDiretor().getNome());

        } catch (IllegalArgumentException e) {
            Assertions.fail("Deveria ter lançado Marco Antonio");
        }
    }



    //J
    @Test
    void deveRetornarCoodernadoNaoCadastrado(){
        professor.setCurso(curso);

        try {

            professor.getCurso().getCoodernador();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Coodernado não cadastrado", e.getMessage());
        }

    }
    @Test
    void deveRetornarCoordenadorSemNome() {
        professor.setCurso(curso);
        curso.setCoodernador(professor);
        try {

            professor.getCurso().getCoodernador().getNome();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Nome não cadastrado", e.getMessage());
        }
    }
    @Test
    void deveRetornarCoordenadorNome(){
        professor.setNome("Marco Antonio");
        curso.setCoodernador(professor);
        professor.setCurso(curso);


        try {

            Assertions.assertEquals("Marco Antonio", professor.getCurso().getCoodernador().getNome());

        } catch (NullPointerException e) {

            Assertions.fail("Deveria ter lançado Marco Antonio");

        }
    }
}