package br.unicamp.ic.inf335.beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProdutoBeanTest {

    private String codigo;
    private String nome;
    private String descricao;
    private Double valor;
    private String estado;
    private ProdutoBean produtoBean;
    private ProdutoBean produtoToTest;

    @Before
    public void SetUp(){
        codigo = "cod1";
        nome = "nome1";
        descricao = "desc1";
        valor = 1.0;
        estado = "est1";

        produtoBean = new ProdutoBean(codigo, nome, descricao, valor, estado);
    }

    @Test
    public void testGetCodigo(){
        assertEquals(codigo, produtoBean.getCodigo());
    }

    @Test
    public void testSetCodigo(){
        produtoBean.setCodigo("cod2");

        assertEquals("cod2", produtoBean.getCodigo());
    }

    @Test
    public void testGetNome(){
        assertEquals(nome, produtoBean.getNome());
    }

    @Test
    public void testSetNome(){
     produtoBean.setNome("nome2");

     assertEquals("nome2", produtoBean.getNome());
    }

    @Test
    public void testGetDescricao(){
        assertEquals(descricao, produtoBean.getDescricao());
    }

    @Test
    public void testSetDescricao(){
        produtoBean.setDescricao("desc2");

        assertEquals("desc2", produtoBean.getDescricao());
    }

    @Test
    public void testGetValor(){
        assertEquals(valor, produtoBean.getValor());
    }

    @Test
    public void testSetValor(){
        produtoBean.setValor(2.0);
        Double valor = 2.0;
        assertEquals(valor, produtoBean.getValor());
    }

    @Test
    public void testGetEstado(){
        assertEquals(estado, produtoBean.getEstado());
    }

    @Test
    public void testSetEstado(){
        produtoBean.setEstado("est2");
        assertEquals("est2", produtoBean.getEstado());
    }

    @Test
    public void testGetSerialversionuid(){
        assertEquals(1L, ProdutoBean.getSerialversionuid());
    }

    @Test
    public void testCompareToWhenCurValorIsHigher(){

        produtoToTest = new ProdutoBean(
                codigo,
                nome,
                descricao,
                0.5,
                "estado3");

        assertEquals(1, produtoBean.compareTo(produtoToTest));
    }

    @Test
    public void testCompareToWhenCurValorIsLower(){

        produtoToTest = new ProdutoBean(
                codigo,
                nome,
                descricao,
                2.0,
                "estado3");

        assertEquals(-1, produtoBean.compareTo(produtoToTest));
    }

    @Test
    public void testCompareToWhenCurValorIsEqual(){

        produtoToTest = new ProdutoBean(
                codigo,
                nome,
                descricao,
                1.0,
                "estado3");

        assertEquals(0,  produtoBean.compareTo(produtoToTest));
    }
}
