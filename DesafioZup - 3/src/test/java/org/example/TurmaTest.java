package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    private Turma turma;

    @BeforeEach
    public void iniciar(){
        turma = new Turma();
    }

    @Test
    public void deveAdicionarPessoaNormalmente() throws Exception {
        assertEquals(0, turma.getPessoas().size());

        Pessoa pessoa = new Pessoa(1, "Paula");
        turma.adicionarPessoa(pessoa);

        assertEquals(1, turma.getPessoas().size());
        assertEquals(1, turma.getPessoas().get(0).getId());
        assertEquals("Paula", turma.getPessoas().get(0).getNome());
    }

    @Test
    public void deveLancarExcecaoPessoaInvalidaPorCausaDoIDMenorQueZero() {
        Pessoa pessoa = new Pessoa(-1, "Paula");
        assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoa));
        assertEquals(0, turma.getPessoas().size());
    }

    @Test
    public void deveLancarExcecaoPessoaInvalidaPorCausaDoNomeVazio() {
        Pessoa pessoa = new Pessoa(2, "");
        assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoa));
        assertEquals(0, turma.getPessoas().size());
    }

    @Test
    public void deveLancarExcecaoPessoaExistente() throws Exception {
        Pessoa pessoa = new Pessoa(1, "Paula");
        turma.adicionarPessoa(pessoa);

        Pessoa pessoa2 = new Pessoa(1, "Paulo");
        assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoa2));
        assertEquals(1, turma.getPessoas().size());
    }

    @Test
    public void deveRemoverPessoasNormalmente() throws Exception {
        Pessoa pessoa = new Pessoa(1, "Namjoon");
        turma.adicionarPessoa(pessoa);

        Pessoa pessoa2 = new Pessoa(2, "Seokjin");
        turma.adicionarPessoa(pessoa2);

        assertEquals(2, turma.getPessoas().size());

        turma.removerTodasPessoas();

        assertEquals(0, turma.getPessoas().size());
    }
}