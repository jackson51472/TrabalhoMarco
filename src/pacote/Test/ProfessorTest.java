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
    void deveRetornarEscolaridadeNula(){
        Assertions.assertEquals("Escolaridade nula", professor.pegarEscolaridade());
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
    void deveRetornarDiretorCursoNaoCadastrado(){
        Assertions.assertEquals("Curso não cadastrado", professor.retornaDiretor());
    }
    @Test
    void deveRetornarDiretorEscolaNaoCadastrado(){
        professor.setCurso(curso);
        Assertions.assertEquals("Sem escola cadastrada", professor.retornaDiretor());
    }
    @Test
    void deveRetornarDiretorEscolaSemDiretor(){
        curso.setEscola(escola);
        professor.setCurso(curso);
        Assertions.assertEquals("Escola do sem Diretor cadastrado", professor.retornaDiretor());

    }
    @Test
    void deveRetornarDiretorSemNome(){
        escola.setDiretor(professor);
        curso.setEscola(escola);
        professor.setCurso(curso);
        Assertions.assertEquals("Diretor sem Nome cadastrado", professor.retornaDiretor());
    }
    @Test
    void deveRetornarDiretorNome(){
        professor.setNome("Marco Antonio");
        escola.setDiretor(professor);
        curso.setEscola(escola);
        professor.setCurso(curso);
        Assertions.assertEquals("Marco Antonio", professor.retornaDiretor());
    }

    //J
    @Test
    void deveRetornarCoodernadonaoCadastrado(){
        Assertions.assertEquals("Curso não cadastrado", professor.retornaCoodernadoCurso());
    }
    @Test
    void deveRetornarCoodernadoNaoCadastrado(){
        professor.setCurso(curso);
        Assertions.assertEquals("Coodernado não cadastrado", professor.retornaCoodernadoCurso());
    }
    @Test
    void deveRetornarCoordenadorSemNome(){
        curso.setCoodernador(professor);
        professor.setCurso(curso);
        Assertions.assertEquals("Nome do Coodernado não foi cadastrado", professor.retornaCoodernadoCurso());
    }
    @Test
    void deveRetornarCoordenadorNome(){
        professor.setNome("Marco Antonio");
        curso.setCoodernador(professor);
        professor.setCurso(curso);
        Assertions.assertEquals("Marco Antonio", professor.retornaCoodernadoCurso());
    }
}