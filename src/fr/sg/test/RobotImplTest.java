package fr.sg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.sg.code.PlateauImpl;
import fr.sg.code.RobotImpl;

public class RobotImplTest {
//test pour le constructeur
	@Test
	public void testRobot() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertEquals(1, rob.getActualX());
		RobotImpl rob1= new RobotImpl("-1 -2 N", "LMLMLMLMM");
		assertNotEquals(-1, rob1.getActualX());
		assertNotEquals(-2, rob1.getActualY());
	}
	//test pour le constructeur au cas ou le sortie est nulle et déclenche une exception
	@Test(expected = NullPointerException.class)
	public final void testRobotNullException() {
		RobotImpl rob = new RobotImpl(null, "MMRMMRMRRM");
		assertNotNull(rob.getLocation(), "Location value should not be null");
		RobotImpl rob1 = new RobotImpl("3 3 E", null);
		assertNotNull(rob1.getInstruction(),
				"Instrucion value should not be null");
		RobotImpl rob2 = new RobotImpl(null, null);
		assertNotNull(rob2.getLocation(),
				"Location and instruction values should not be null");
		RobotImpl rob3 = new RobotImpl("K K 5", "LMLMLMLMM");
		assertNotNull( rob3.getLocation(),"la localisation est fausse ");
		
		RobotImpl rob4 = new RobotImpl("33E", "MMRMMRMRRM");
		assertNotNull(rob4.getLocation(), "cette localisation ne contient pas d'espace");

		RobotImpl rob5 = new RobotImpl("3 3 E 6 8", "MMRMMRMRRM");
		assertNotNull(rob5.getLocation(),"cette localisation contient beaucoup d'argument");
	}
	// test pour la méthode rotate
	@Test
	public void testRotate() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		rob.rotate(rob.getInstruction().charAt(0) + "");
		assertEquals("W", rob.getOrientation());
		RobotImpl rob2 = new RobotImpl("3 3 E", "RMMRLMMMR");
		rob2.rotate(rob2.getInstruction().charAt(0) + "");
		assertEquals("S", rob2.getOrientation());

	}
	// test pour la méthode move
	@Test
	public void testMove() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		rob.move();
		assertEquals(3, rob.getActualY());
		assertEquals(1, rob.getActualX());
	}
	// test pour la méthode finalLocation
	@Test
	public void testFinaLocation() {
		PlateauImpl plat =new PlateauImpl("5 5");
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		String res = "1 3 N";
		assertTrue("True", rob.finaLocation().equals(res));

		RobotImpl rob2 = new RobotImpl("3 3 E", "MMRMMRMRRM");
		String res2 = "5 1 E";
		assertTrue("True", rob2.finaLocation().equals(res2));

		RobotImpl rob3 = new RobotImpl("3 3 E", "AZERTYUI");
		assertFalse("cette fonction ne contient pas L", rob3.finaLocation()
				.equals(res2));

		RobotImpl rob4 = new RobotImpl("3 3 E", "MMRMMRMRRMMM");
		String res4 = "5 1 E";
		assertFalse("le robot a dépasser le plateau", rob4.finaLocation()
				.equals(res4));

	}
	// test pour la méthode ValidInstruction
	@Test
	public void ValidInstruction() {
		RobotImpl rob2 = new RobotImpl("1 2 N", null);
		assertNotNull("Location value should not be null",rob2.ValidInstruction());
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertTrue("True", rob.ValidInstruction().equals(true));
		RobotImpl rob3 = new RobotImpl("1 2 N", "ABCDEFG");
		assertTrue("True", rob3.ValidInstruction().equals(false));
		RobotImpl rob4 = new RobotImpl("1 2 N", "LMABCDEFG");
		assertTrue("True", rob4.ValidInstruction().equals(false));
	}
	
	// test pour les getters et setters
	@Test
	public void testSetActualX() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertEquals(1, rob.getActualX());
	}
	@Test(expected=NullPointerException.class)
	public void testActualX_NullException() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		rob.setActualX(-1);
		assertNotNull("La valeur est fausse", rob.getActualX());
	}
	@Test
	public void testGetActualX() {
		PlateauImpl.setPlateau("5 5");
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertEquals(1, rob.getActualX());
		assertTrue("le robot est dans le plateau",
				rob.getActualX() < PlateauImpl.getLimitX());
	}
	@Test
	public void testGetActualY() {
		
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertEquals(2, rob.getActualY());
		assertTrue("le platot est dans le plateau",
				rob.getActualY() < PlateauImpl.getLimitY());
	}

	@Test
	public void testSetActualY() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertEquals(2, rob.getActualY());
	}
	@Test(expected=NullPointerException.class)
	public void testActualY_NullException() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		rob.setActualY(-1);
		assertNotNull("La valeur est fausse", rob.getActualY());
	}
	@Test
	public void testGetOrientation() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertTrue("True", rob.getOrientation().equals("N"));

	}

	@Test
	public void testSetOrientation() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertTrue("True", rob.getOrientation().equals("N"));
	}

	@Test(expected = NullPointerException.class)
	public final void testOrientationNullException() {
		RobotImpl rob2 = new RobotImpl(null, "MMRMMRMRRM");
		assertNotNull(rob2.getOrientation(),
				"Orientation value should not be null");
		RobotImpl rob3= new RobotImpl("1 1 5", "MMRMMRMRRM");
		assertNotNull(rob3.getOrientation(),"ce n'est pas une lettre");
		rob3.setOrientation(null);
		assertNotNull(rob3.getOrientation(),"ce n'est pas une lettre");
	}
	

	@Test
	public void testGetLocation() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertTrue("True", rob.getLocation().equals("1 2 N"));

		
	}

	@Test
	public void testSetLocation() {
		RobotImpl rob = new RobotImpl("1 2 N", "MMRMMRMRRM");
		assertTrue( "Location value should not be null", rob.getLocation().equals("1 2 N"));
		

	}
	@Test(expected= NullPointerException.class)
	public void testSetLocationNullException() {
		RobotImpl rob2 = new RobotImpl(null, "MMRMMRMRRM");
		rob2.setLocation(null);
		assertNotNull(rob2.getLocation(), "Location value should not be null");
	}

	@Test
	public void testGetInstruction() {
		RobotImpl rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		assertTrue("True", rob.getInstruction().equals("LMLMLMLMM"));
	}

	@Test
	public void testSetInstruction() {
		RobotImpl rob2 = new RobotImpl("1 2 N", null);
		assertNotNull(rob2.getLocation(), "Location value should not be null");
		RobotImpl rob3 = new RobotImpl("1 2 N",  "ABCDEFG");
		assertNotNull("Location value should not be null",rob3.getInstruction());
		RobotImpl rob4= new RobotImpl("1 2 N",  "LMLMLMLMM");
		assertTrue("vraii ",rob4.getInstruction().equals("LMLMLMLMM"));
		RobotImpl rob5= new RobotImpl("1 2 N",  "LM M");
		assertFalse("vraii ",rob5.getInstruction().equals("LMLMLMLMM"));
		
	}

	@Test(expected=NullPointerException.class)
	public void testSetInstructionNullException() {
		RobotImpl rob= new RobotImpl("1 2 N",  "LMLMLMLMM");
		rob.setInstruction(null);
		assertNotNull("Location value should not be null",rob.getInstruction());
	}

}