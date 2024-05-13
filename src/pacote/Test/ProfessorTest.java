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
    void  deveRetornarEstadoProfessor(){
        estado.setNomeEstado("Minas Gerais");
        cidade.setEstado(estado);
        professor.setCidade(cidade);
        Assertions.assertEquals("Minas Gerais", professor.retornarEstado());
    }
    @Test
    void  deveRetornarProfessorEstadoNaoEncontrado(){
        cidade.setNomeCidade("Paiva");
        professor.setCidade(cidade);
        Assertions.assertEquals("Estado não encontrado", professor.retornarEstado());
    }
    @Test
    void  deveRetornarProfessorCidadeEstadoNaoEncontrado(){
        Assertions.assertEquals("Cidade e Estado não encontrado", professor.retornarEstado());
    }
    @Test
    void  deveRetornarProfessorCidade(){
        cidade.setNomeCidade("Paiva");
        professor.setCidade(cidade);
        Assertions.assertEquals("Paiva", professor.retornarCidade());
    }
    @Test
    void  deveRetornarProfessorCidadeNaoEncontrada(){
        Assertions.assertEquals("Cidade não encontrada", professor.retornarCidade());
    }


    // G
    @Test
    void  deveRetornarProfessorTipoEnsino(){
        tipoEnsino.setTipo("médio");
        curso.setTipoEnsino(tipoEnsino);
        professor.setCurso(curso);
        Assertions.assertEquals("médio", professor.retornaTipoEnsino());
    }
    @Test
    void  deveRetornarProfessorCursoNaoCadastraso(){
        Assertions.assertEquals("Curso não cadastrado", professor.retornaTipoEnsino());
    }
    @Test
    void  deveRetornarProfessorTipoEnsinoNaoCadastrada(){
        professor.setCurso(curso);
        Assertions.assertEquals("Curso encontro, mais sem Tipo de Ensino cadastrado", professor.retornaTipoEnsino());
    }
    @Test
    void  deveRetornarProfessorNomeTipoEnsinoNaoCadastrado(){
        curso.setTipoEnsino(tipoEnsino);
        professor.setCurso(curso);
        Assertions.assertEquals("Curso encontro, mais sem o nome do Tipo de Ensino", professor.retornaTipoEnsino());
    }






    //I
    @Test
    void deveRetornarCursoNaoCadastrado(){
        try {
            professor.getCurso();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso não cadastrado", e.getMessage());
        }
    }

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