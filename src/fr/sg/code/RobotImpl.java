package fr.sg.code;

import java.util.ArrayList;
import java.util.List;

public class RobotImpl implements Robot {
	private int actualX;
	private int actualY;
	private String orientation;
	private String location;
	private String instruction;
	

	// Constructeur: on y initialise la localisation et l'instruction à faire
	public RobotImpl(String location, String instruction) {
		super();
		if (location == null || instruction == null) {
			System.out
					.println("Veuillez insérer une loclisation et une instruction pour chaque Robot");
		} else if ((location.split(" ").length - 1) != 2) {
			System.out
					.println("La localisation doit contenir des espaces exemple '1 1 N' ");
		} else {
			setLocation(location);
			setInstruction(instruction.toUpperCase());
			String[] charou = getLocation().split(" ");
			List<String> convert = new ArrayList<String>();
			for (String retval : charou) {
				convert.add(retval);
			}
			try {
				setActualX(Integer.parseInt(convert.get(0)));
				setActualY(Integer.parseInt(convert.get(1)));
			} catch (NumberFormatException e) {
				System.out
						.println("la localisation doit etre sous la forme de '1 1 N' : entier, entier,caractère");
			}
			
			if (convert.get(2).toUpperCase().matches("[N,S,E,W]")) {
				setOrientation(convert.get(2).toUpperCase());
			} else {
				System.out
						.println("LA lettre que vous avez choisit dans la localisation doit etre soit 'N' ou 'W' ou 'E'ou 'S'");
			}

		}
	}

	// Cette méthode permet au Robot de tourner selon l'intruction
	public void rotate(String instruct) {
		if (instruct.equals("L")) {
			switch (getOrientation()) {
			case "N":
				setOrientation("W");
				break;
			case "E":
				setOrientation("N");
				break;
			case "S":
				setOrientation("E");
				break;
			case "W":
				setOrientation("S");
				break;
			}
		} else if (instruct.equals("R")) {
			switch (getOrientation()) {
			case "N":
				setOrientation("E");
				break;
			case "E":
				setOrientation("S");
				break;
			case "S":
				setOrientation("W");
				break;
			case "W":
				setOrientation("N");
				break;
			}
		}
	}

	// cette méthode permet au robot de se déplacer
	public void move() {
		int som;
		switch (getOrientation()) {
		case "N":
			som = getActualY() + 1;
			setActualY(som);
			break;
		case "E":
			som = getActualX() + 1;
			setActualX(som);
			break;
		case "S":
			som = getActualY() - 1;
			setActualY(som);
			break;
		case "W":
			som = getActualX() - 1;
			setActualX(som);
			break;
		}
	}

	// cette methode analyse l'instruction et prend la décision pour le robot:
	// se deplacer ou tourner
	public String finaLocation() {
		String result;
		String inst = "";
		Boolean bool = ValidInstruction();
		if (bool == true) {
			for (int i = 0; i < getInstruction().length(); i++) {
				inst = getInstruction().charAt(i) + "";

				switch (inst) {

				case "M":
					move();
					break;

				case "L":
					rotate(inst);
					break;

				case "R":
					rotate(inst);
					break;
				}

			}
		} else {
			System.out
					.println("l'instruction doit contenir seulement et au moin l'une des 3 lettres 'L'ou 'R' ou'M'");
		}

		if ((getActualX() <= PlateauImpl.getLimitX()) &&( getActualY() <= PlateauImpl.getLimitY()))
			result = (getActualX() + " " + getActualY() + " " + getOrientation());
		else {
			System.out.println("le robot a dépasser le plateau");
			result = "le robot a dépasser le plateau";
		}
		return result;
	}

	// cette méthode permet de valider l'instruction
	public Boolean ValidInstruction() {
		String inst = "";
		Boolean bool = false;
		if(getInstruction()==null)
		{
			System.out.println("L'instruction est vide veuillez la vérifier");
		}
		else
		{
		for (int i = 0; i < getInstruction().length(); i++) {
			inst = getInstruction().charAt(i) + "";
			if (inst.matches("[L,M,R]")) {
				bool = true;
			} else {
				bool = false;
				break;
			}
		}
		}
		return bool;
	}

	// ici les getters et setters des attributs
	public int getActualX() {
		return actualX;
	}

	public void setActualX(int actualX) {
		if(actualX<0)
		{
			System.out.println("la valeur est négative veuillez la changer");
		}
		else
		this.actualX = actualX;
	}

	public int getActualY() {
		return actualY;
	}

	public void setActualY(int actualY) {
		if(actualY<0)
		{
			System.out.println("la valeur est négative veuillez la changer");
		}
		else
		this.actualY = actualY;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		if (orientation==null) {
			System.out.println("l'orientation est vide");
		} else {
			this.orientation = orientation;
		}
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		if (location==null) {
			System.out.println("la localisation est vide");
		} else {
			this.location = location;
		}

	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		if (instruction==null) {
			System.out.println("l'instruction est vide");
		} else {
			this.instruction = instruction;
		}
	}

}
