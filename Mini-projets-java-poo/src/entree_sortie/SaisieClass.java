package entree_sortie;

import java.util.Scanner;

public class SaisieClass {
	static Scanner sc = new Scanner(System.in);
	/**
	 * Retourne un string saisie par l'utilisateur depuis la console
	 * 
	 * @return String
	 */
	public static String saisieStringConsole(String message) {
		System.out.println(message);
		String src = sc.nextLine();
		return src;
	}
}
