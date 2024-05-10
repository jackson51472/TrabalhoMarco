package pacote.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pacote.*;

class AlunoTest {
    Estado estado;
    Cidade cidade;
    Aluno aluno;
    Curso curso;

    @BeforeEach
    void setUp() {
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
    @Test
    void  deveRetornarAlunoCursoNaoEncontrado(){
        Assertions.assertEquals("Curso não foi encontrado", aluno.getCurso());
    }
    // H
    @Test
    void deveRetornarAlunoCursoNaoEncontrada(){
        Assertions.assertEquals("Curso não foi encontrado", aluno.retornaCoordenadorCurso());
    }
    @Test
    void deveRetornarAlunoCoordenadorCursoNaoEncontrado(){
        aluno.setCurso(curso);
        Assertions.assertEquals("Curso sem coordenador", aluno.retornaCoordenadorCurso());
    }

}