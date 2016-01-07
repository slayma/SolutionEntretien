package fr.sg.code;

import java.util.ArrayList;
import java.util.List;

public class PlateauImpl {
	private static int limitX;
	private static int limitY;
	private static String plateau;
//constructeur dela classe
	public PlateauImpl(String plateau) {
		if (plateau == null) {
			System.out.println("le plateau est indéfinit");
		} else if ((plateau.split(" ").length - 1) != 1) {
			System.out
					.println("Le plateau doit doit etre ecrit sous la forme: '5 5' ");
		}

		else {
		PlateauImpl.setPlateau(plateau);
		}
	}

	public static String getPlateau() {
		return plateau;
	}
//getter and setter plateau(coordonées du plateu)  et des limites du plateau
	public static void setPlateau(String plateau) {
		if (plateau == null) {
			System.out.println("le plateau est indéfinit");
		} else if ((plateau.split(" ").length - 1) != 1) {
			System.out
					.println("Le plateau doit doit etre ecrit sous la forme: '5 5' ");
		}
		else{
		PlateauImpl.plateau = plateau;
		String[] charou = getPlateau().split(" ");
		List<String> convert = new ArrayList<String>();
		for (String retval : charou) {
			convert.add(retval);
		}
		try {
			setLimitX(Integer.parseInt(convert.get(0)));
			setLimitY(Integer.parseInt(convert.get(1)));
		} catch (NumberFormatException e) {
			System.out
					.println("la localisation doit etre sous la forme de '5 5' : 'entier entier' ");
		}
		}
	if (getLimitX() < 0)
		setLimitX(0);
	if (getLimitY() < 0)
		setLimitY(0);

	}

	public static int getLimitX() {
		return limitX;
	}

	public static void setLimitX(int limitX) {
		if (limitX == 0) {
			System.out.println("limite maximale % x non existant");
		} else {
			PlateauImpl.limitX = limitX;
		}

	}

	public static int getLimitY() {
		return limitY;
	}

	public static void setLimitY(int limitY) {
		if (limitY == 0) {
			System.out.println("limite maximale % y non existant");
		} else {
			PlateauImpl.limitY = limitY;
		}
	}
}