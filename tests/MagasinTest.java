package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import magasin.Article;
import magasin.Magasin;

public class MagasinTest {

	private static Magasin magasin;
	
	private static Article present1;
	private static Article present2;
	private static Article notpresent;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		magasin = new Magasin(30);
		for (int i = 1; i <= 30; i++) {
			Article a = new Article("test" + i, i, (i % 4) + 1);
			if (i == 13) present1 = a;
			if (i == 20) present2 = a;
			magasin.insererArticle(a);
		}
		notpresent = new Article("notpresent", 1000, 1000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMagasin() {
		Magasin m = new Magasin(0);
	}

	@Test
	public void testGetNbArticle() {
		Magasin m = new Magasin(0);
		assertEquals(0, m.getNbArticle());
	}

	@Test
	public void testGetNbMaxArticle() {
		Magasin m = new Magasin(0);
		assertEquals(0, m.getNbMaxArticle());
	}

	@Test
	public void testGetStock() {
		Magasin m = new Magasin(0);
		assertEquals(0, m.getStock().length);
	}

	@Test(expected=AssertionError.class)
	public void testSetStock1() {
		Magasin m = new Magasin(0);
		Article[] articles = new Article[2];
		m.setStock(articles);
	}
	
	@Test
	public void testSetStock2() {
		Magasin m = new Magasin(2);
		Article[] articles = new Article[2];
		m.setStock(articles);
	}
	
	@Test
	public void testSetStock3() {
		Magasin m = new Magasin(4);
		Article[] articles = new Article[2];
		m.setStock(articles);
	}

	@Test(timeout=1000)
	public void testChercherDicho11() {
		assertTrue(magasin.chercherDicho1(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho12() {
		assertFalse(magasin.chercherDicho1(notpresent));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho13() {
		Magasin magasin = new Magasin(1);
		magasin.insererArticle(present1);
		assertTrue(magasin.chercherDicho1(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho14() {
		Magasin magasin = new Magasin(1);
		magasin.insererArticle(present1);
		assertFalse(magasin.chercherDicho1(notpresent));
	}

	@Test(timeout=1000)
	public void testChercherDicho21() {
		assertTrue(magasin.chercherDicho2(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho22() {
		assertFalse(magasin.chercherDicho2(notpresent));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho23() {
		magasin.insererArticle(present1);
		assertTrue(magasin.chercherDicho2(present1));
	}

	@Test(timeout=1000)
	public void testChercherDicho31() {
		assertTrue(magasin.chercherDicho3(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho32() {
		assertFalse(magasin.chercherDicho3(notpresent));
	}

	@Test(timeout=1000)
	public void testChercherDicho41() {
		assertTrue(magasin.chercherDicho4(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho42() {
		assertFalse(magasin.chercherDicho4(notpresent));
	}

	@Test(timeout=1000)
	public void testChercherDicho51() {
		assertTrue(magasin.chercherDicho5(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho52() {
		assertFalse(magasin.chercherDicho5(notpresent));
	}
	
	@Test(timeout=1000)
	public void testChercherDicho53() {
		Magasin magasin = new Magasin(1);
		magasin.insererArticle(present1);
		assertFalse(magasin.chercherDicho5(notpresent));
	}
	
	@Test(timeout=1000)
	public void testChercherDichoEtu1() {
		assertTrue(magasin.chercherDichoEtu(present1));
	}
	
	@Test(timeout=1000)
	public void testChercherDichoEtu2() {
		assertTrue(magasin.chercherDichoEtu(present2));
	}
	
	@Test(timeout=1000)
	public void testChercherDichoEtu3() {
		assertFalse(magasin.chercherDichoEtu(notpresent));
	}

	@Test
	public void testAfficherStock() {
		magasin.afficherStock();
	}

	@Test
	public void testMain() {
		Magasin.main(null);
	}

}
