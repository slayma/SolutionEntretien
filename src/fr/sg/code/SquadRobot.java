package fr.sg.code;

import java.util.ArrayList;
import java.util.List;

public class SquadRobot {
	private int j = 0;
	List<Robot> SquadRob;

	// constructeur du squad
	public SquadRobot() {
		SquadRob = new ArrayList<Robot>();
	}

	// méthode qui ajouter les robot au sqaud
	public List<Robot> addRobot(Robot rob) {

		SquadRob.add(rob);

		return SquadRob;
	}

	// méthode qui liste les robot selon leurs positions finaux
	public void ListSquad() {

		for (int i = 0; i < SquadRob.size(); i++) {
			j++;
			System.out.println("Robot n°" + j + " "
					+ SquadRob.get(i).finaLocation());
		}
	}

}
