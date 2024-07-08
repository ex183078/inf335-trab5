package br.unicamp.ic.inf335.beans;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class AnuncianteBeanTest {

     private String nome;
    private String CPF;
    private ArrayList<AnuncioBean> anuncios;
    private AnuncianteBean anuncianteUnderTest;
    private AnuncioBean anuncioToTest;

    @Before
    public void SetUp(){
        nome = "Joao";
        CPF = "123456789";
        anuncios = new ArrayList<AnuncioBean>();
        anuncios.add(new AnuncioBean());
        anuncios.add(new AnuncioBean());

        anuncioToTest = new AnuncioBean();
        anuncioToTest.setDesconto(0.8);
        anuncianteUnderTest = new AnuncianteBean(nome,
                CPF,
                anuncios);
    }

    @Test
    public void testGetNome(){
        assertEquals(nome, anuncianteUnderTest.getNome());
    }

    @Test
    public void testSetNome(){
        anuncianteUnderTest.setNome("Guilherme");

        assertEquals("Guilherme",
                anuncianteUnderTest.getNome());
    }

    @Test
    public void testGetCPF(){
        assertEquals(CPF, anuncianteUnderTest.getCPF());
    }

    @Test
    public void testSetCPF(){
        anuncianteUnderTest.setCPF("987654321");

        assertEquals("987654321",
                anuncianteUnderTest.getCPF());
    }

    @Test
    public void testGetAnuncios(){
        assertEquals(anuncios,
                anuncianteUnderTest.getAnuncios());
    }

    @Test
    public void testSetAnuncios(){
        anuncios.add(anuncioToTest);
        anuncianteUnderTest.setAnuncios(anuncios);

        assertEquals(anuncios,
                anuncianteUnderTest.getAnuncios());
    }

    @Test
    public void testAddAnuncio(){
        anuncios.add(anuncioToTest);
        anuncianteUnderTest.addAnuncio(anuncioToTest);

        assertEquals(anuncios,
                anuncianteUnderTest.getAnuncios());
    }

    @Test
    public void testRemoveAnuncio(){
        anuncianteUnderTest.removeAnuncio(1);

        assertEquals(1,
                anuncianteUnderTest.getAnuncios().size());
    }

    @Test
    public void testValorMedioAnuncios(){
        ProdutoBean produtoBean = new ProdutoBean(
                "prodA",
                "nomA",
                "descA",
                3.0,
                "estdA");
        ArrayList<URL> fotos = new ArrayList<>();
        AnuncioBean anuncioBean = new AnuncioBean(
                produtoBean,
                fotos,
                0.0);

        anuncianteUnderTest.addAnuncio(anuncioBean);

        assertEquals(1.0,
                anuncianteUnderTest.valorMedioAnuncios());
    }
}
