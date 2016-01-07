package fr.sg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.sg.code.PlateauImpl;
import fr.sg.code.Robot;
import fr.sg.code.RobotImpl;
import fr.sg.code.SquadRobot;

//test duconstruteur de le groupe
public class SquadRobotTest {

	@Test
	public void testSquadRobot() {
		SquadRobot squad = new SquadRobot();
		assertNotNull(squad);
	}

	// test d'ajoutde robot dans le groupe
	@Test
	public void testAddRobot() {
		PlateauImpl plat = new PlateauImpl("5 5");
		Robot rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		SquadRobot sq = new SquadRobot();
		sq.addRobot( rob);
		Robot rob1 = new RobotImpl(null, null);
		sq.addRobot(rob1);
		assertNotNull(sq);
		assertFalse("cette pération est verifiée", sq.equals(rob));

	}


	// test d'affichage des robot du squad
	@Test
	public void testListSquad() {
		PlateauImpl plat = new PlateauImpl("5 5");
		SquadRobot sq1 = new SquadRobot();
		Robot rob = new RobotImpl("1 2 N", "LMLMLMLMM");
		Robot rob1 = new RobotImpl(null, null);
		sq1.addRobot(rob);
		sq1.addRobot(rob1);
		sq1.ListSquad();
		assertNotNull(sq1);
		assertFalse("Cette methodeest vérifiée", sq1.equals(null));
	}

}
