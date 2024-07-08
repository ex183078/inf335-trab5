package br.unicamp.ic.inf335.beans;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class AnuncioBeanTest {

    private ProdutoBean produto;
    private ArrayList<URL> fotosUrl;
    private Double desconto;
    AnuncioBean anuncioBeanUnderTest;
    private URL url = null;
    private URI uri = null;
    ProdutoBean produtoToTest;

    @Before
    public void SetUp(){
        produto = new ProdutoBean("prodA",
                "nomA",
                "descA",
                3.0,
                "estdA");
        fotosUrl = new ArrayList<>();

        produtoToTest = new ProdutoBean("prodB",
                "nomB",
                "descB",
                1.0,
                "estdB");

        try {
            uri = new URI("http://example.com");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Convert the URI to a URL
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        anuncioBeanUnderTest = new AnuncioBean(produto, fotosUrl, desconto);
    }

    @Test
    public void testGetProduto(){
        assertEquals(produto, anuncioBeanUnderTest.getProduto());
    }

    @Test
    public void testSetProduto(){
        anuncioBeanUnderTest.setProduto(produtoToTest);

        assertEquals(produtoToTest, anuncioBeanUnderTest.getProduto());
    }

    @Test
    public void testGetFotosUrl(){
        assertEquals(fotosUrl, anuncioBeanUnderTest.getFotosUrl());
    }

    @Test
    public void testSetFotosUrl(){
        ArrayList<URL> fotosToTest = new ArrayList<>();
        fotosToTest.add(url);

        anuncioBeanUnderTest.setFotosUrl(fotosToTest);

        assertEquals(fotosToTest, anuncioBeanUnderTest.getFotosUrl());
    }

    @Test
    public void testGetDesconto(){
        assertEquals(desconto, anuncioBeanUnderTest.getDesconto());
    }

    @Test
    public void testSetDesconto(){
        anuncioBeanUnderTest.setDesconto(0.1);
        assertEquals(0.1, anuncioBeanUnderTest.getDesconto());
    }

    @Test
    public void testGetSerialversionuid(){
        assertEquals(1L, AnuncioBean.getSerialversionuid());
    }

    @Test
    public void testGetValor(){
        anuncioBeanUnderTest.setDesconto(0.0);

        Double valor = anuncioBeanUnderTest.getValor();

        assertEquals(3.0, anuncioBeanUnderTest.getValor());
    }
}
