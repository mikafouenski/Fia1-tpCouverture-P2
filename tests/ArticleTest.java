package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import magasin.Article;

public class ArticleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@Test(expected=AssertionError.class)
	public void testArticle1() {
		Article a = new Article("", 1, 1);
	}
	
	@Test
	public void testArticle2() {
		Article a = new Article("a", 1, 1);
	}
	
	@Test
	public void testArticle3() {
		Article a = new Article("a", 1, 0);
	}

	@Test
	public void testGetNom() {
		String str = "test";
		Article a = new Article(str, 1, 2);
		assertTrue(str.equals(a.getNom()));
	}

	@Test
	public void testGetPrix() {
		double prx = 2.8;
		Article a = new Article("a", prx, 3);
		assertEquals(prx, a.getPrix(), 0);
	}

	@Test
	public void testGetNumero() {
		int num = 4;
		Article a = new Article("a", 2, num);
		assertEquals(num, a.getNumero(), 0);
	}

	@Test
	public void testIsEqual1() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test", 1, 2);
		assertTrue(a1.isEqual(a2));
	}
	
	@Test
	public void testIsEqual2() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test", 1, 1);
		assertFalse(a1.isEqual(a2));
	}
	
	@Test
	public void testIsEqual3() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test", 2, 2);
		assertFalse(a1.isEqual(a2));
	}
	
	@Test
	public void testIsEqual4() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test1", 1, 2);
		assertFalse(a1.isEqual(a2));
	}

	@Test
	public void testSmallerThan1() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test", 2, 2);
		assertTrue(a1.smallerThan(a2));
	}
	
	@Test
	public void testSmallerThan2() {
		Article a1 = new Article("test", 2, 1);
		Article a2 = new Article("test", 1, 2);
		assertFalse(a1.smallerThan(a2));
	}
	
	@Test
	public void testSmallerThan3() {
		Article a1 = new Article("test", 2, 2);
		Article a2 = new Article("test", 2, 1);
		assertFalse(a1.smallerThan(a2));
	}
	
	@Test
	public void testSmallerThan4() {
		Article a1 = new Article("test", 1, 2);
		Article a2 = new Article("test", 2, 2);
		assertTrue(a1.smallerThan(a2));
	}


}
