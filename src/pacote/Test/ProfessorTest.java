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
        escolaridade.setNome("Mestrado");
        professor.setEscolaridade(escolaridade);
        try{
        Assertions.assertEquals("Mestrado", professor.getNomeEscolaridade());
        } catch(NullPointerException e){
            Assertions.assertEquals("Deveria ter retorndado Mestrado", e.getMessage());
        }
    }
    @Test
    void deveRetornarEscolaridadeSemNome(){

        professor.setEscolaridade(escolaridade);

        try {
            professor.getNomeEscolaridade();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não tem nome cadastrado", e.getMessage());
        }


    }
    @Test
    void deveRetornarEscolaridadeNula(){

        try {
            professor.getNomeEscolaridade();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escolaridade não cadastrada", e.getMessage());
        }

    }


    //E
    @Test
    void  deveRetornarNomeCidade() {
        cidade.setNome("Paiva");
        professor.setCidade(cidade);
        try {

            Assertions.assertEquals("Paiva", professor.getCidadeEscola());

        } catch (NullPointerException e) {

            Assertions.fail("Deveria ter lançado Paiva");

        }
    }
    @Test
    void  deveRetornarNomeCidadeNaoCadastrada(){
        professor.setCidade(cidade);
        Assertions.assertEquals("Cidade sem nome",professor.getCidadeEscola());
    }
    @Test
    void  deveRetornarCidadeNaoCadastrada(){

        try {
            professor.getCidadeEscola();
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

        Assertions.assertEquals("médio", professor.getNomeTipoEnsino());

    }
    @Test
    void  deveRetornarNomeTipoEnsinoNaoCadastrado(){
        curso.setTipoEnsino(tipoEnsino);
        professor.setCurso(curso);

        Assertions.assertEquals("Nome do Tipo não cadastrado", professor.getNomeTipoEnsino());
    }
    @Test
    void  deveRetornarTipoEnsinoNaoCadastrada(){
        professor.setCurso(curso);

        Assertions.assertEquals("Tipo ensino não cadastrado", professor.getNomeTipoEnsino());

    }
    @Test
    void deveRetornarCursoNaoCadastrado1(){
        Assertions.assertEquals("Curso não cadastrado", professor.getNomeTipoEnsino());
    }

    // I
    @Test
    void  deveRetornarCursoNaoCadastrado2(){
        try {
            professor.getNomeDiretor();
            Assertions.fail("Tinha que ter lançado NullPointerException");
        }catch (NullPointerException e){
            Assertions.assertEquals("Professor sem curso",e.getMessage());
        }
    }
    @Test
    void deveRetornarEscolaNaoCadastrado(){
        professor.setCurso(curso);
        try {
            professor.getNomeDiretor();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso sem escola cadastrada", e.getMessage());
        }

    }
    @Test
    void deveRetornarEscolaSemDiretor(){
        curso.setEscola(escola);
        professor.setCurso(curso);
        try {
            professor.getNomeDiretor();
            Assertions.fail("Deveria ter lançado NullPointerException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Escola sem diretor", e.getMessage());
        }

    }
    @Test
    void deveRetornarDiretorSemNome(){
        escola.setDiretor(professor);
        curso.setEscola(escola);
        professor.setCurso(curso);

        Assertions.assertEquals("Nome não cadastrado", professor.getNomeDiretor());
    }
    @Test
    void deveRetornarDiretorNome(){
        professor.setNome("Marco Antonio");
        curso.setEscola(escola);
        professor.setCurso(curso);
        escola.setDiretor(professor);

        Assertions.assertEquals("Marco Antonio", professor.getNomeDiretor());
    }



    //J
    @Test
    void  deveRetornarCursoNaoCadastrado3(){
        try {
            professor.getNomeCoordenadorCurso();
            Assertions.fail("Tinha que ter lançado NullPointerException");
        }catch (NullPointerException e){
            Assertions.assertEquals("Professor sem curso",e.getMessage());
        }
    }
    @Test
    void deveRetornarCoodernadoNaoCadastrado(){
        professor.setCurso(curso);

        try {

            professor.getNomeCoordenadorCurso();
            Assertions.fail("Deveria ter lançado IllegalArgumentException");
        } catch (NullPointerException e) {
            Assertions.assertEquals("Curso sem coodernador", e.getMessage());
        }

    }
    @Test
    void deveRetornarCoordenadorSemNome() {
        professor.setCurso(curso);
        curso.setCoodernador(professor);
        Assertions.assertEquals("Nome não cadastrado", professor.getNomeCoordenadorCurso());
    }
    @Test
    void deveRetornarCoordenadorNome(){
        professor.setNome("Marco Antonio");
        curso.setCoodernador(professor);
        professor.setCurso(curso);

        Assertions.assertEquals("Marco Antonio", professor.getNomeCoordenadorCurso());
    }
}