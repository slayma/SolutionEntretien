package fr.sg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.sg.code.PlateauImpl;

public class PlateauImplTest {
//test du constructeur du plateau
	@Test
	public void testPlateauImpl() {
		PlateauImpl plat=new PlateauImpl("5 5");
		assertTrue(PlateauImpl.getPlateau().equals("5 5"));
	}
	// test des cas null
	@Test(expected = NullPointerException.class)
	public final void testPlateau_NullException() {
		PlateauImpl plat=new PlateauImpl(null);
		assertNotNull(PlateauImpl.getPlateau(),"plateau non définit");
		PlateauImpl plat1=new PlateauImpl("K K");
		assertNotNull("le plateau ne contient pas de chiffre", PlateauImpl.getPlateau());
		
		PlateauImpl plat2=new PlateauImpl("-1 -1");
		assertNotNull("les chiffres de ce plateau sont négatives",PlateauImpl.getPlateau());

		PlateauImpl plat3=new PlateauImpl("55");
		assertNotNull("les chiffres de ce plateau sont négatives",PlateauImpl.getPlateau());
	}
	
//test getter and setter
	@Test
	public void testSetLimitX() {
		PlateauImpl.setPlateau("5 5");
		assertEquals(5, PlateauImpl.getLimitX());
		PlateauImpl.setLimitX(3);
		assertEquals(3, PlateauImpl.getLimitX());
	}
	@Test(expected= NullPointerException.class)
	public void testLimitX_NullException() {
		PlateauImpl.setLimitX(-1);
		assertNotNull("le platot est dans le plateau",PlateauImpl.getLimitX());
	}

	@Test
	public void testGetLimitY() {
		PlateauImpl.setPlateau("5 5");
		assertEquals(5,PlateauImpl.getLimitY());
		PlateauImpl.setLimitY(3);
		assertEquals(3, PlateauImpl.getLimitY());
	}

	@Test
	public void testSetLimitY() {
		PlateauImpl.setPlateau("5 5");
		assertEquals(5,PlateauImpl.getLimitY());
		
	}
	@Test(expected= NullPointerException.class)
	public void testLimitY_NullException() {
		PlateauImpl.setLimitY(-1);
		assertNotNull("le platot est dans le plateau",PlateauImpl.getLimitY());
		
	}

	@Test
	public void testGetPlateau() {
		PlateauImpl.setPlateau("5 5");
		assertTrue(PlateauImpl.getPlateau().equals("5 5"));
	}
	@Test 
	public  void testSetPlateau()
	{
		PlateauImpl.setPlateau("5 5");
		assertTrue(PlateauImpl.getPlateau().equals("5 5"));
	}
	@Test(expected = NullPointerException.class)
	public final void testSetPlateau_NullException() {
		PlateauImpl.setPlateau(null);
		assertNotNull(PlateauImpl.getPlateau(),"plateau non définit");
		PlateauImpl.setPlateau("K K");
		assertNotNull("le plateau ne contient pas de chiffre", PlateauImpl.getPlateau());
		
		PlateauImpl.setPlateau("-1 -1");
		assertNotNull("les chiffres de ce plateau sont négatives",PlateauImpl.getPlateau());

		PlateauImpl.setPlateau("55");
		assertNotNull("les chiffres de ce plateau sont négatives",PlateauImpl.getPlateau());
	}

}
