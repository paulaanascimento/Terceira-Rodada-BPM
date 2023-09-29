package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    public void deveAtribuirNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fernanda");
        assertEquals("Fernanda", pessoa.getNome());
    }

    @Test
    public void deveAtribuirID() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(10);
        assertEquals(10, pessoa.getId());
    }
}