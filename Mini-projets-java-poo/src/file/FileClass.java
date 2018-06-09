package file;

import java.io.File;
import java.util.Scanner;

public class FileClass {
	/**
	 * Affiche le contenu d’un répertoire en affichant si les éléments de ce
	 * répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un
	 * fichier elle affiche la capacité physique du fichier.
	 * 
	 * @param rep
	 *            emplacement répértoire
	 */
	public void afficheContenu(String rep) {

		File f = new File(rep);
		if (f.exists()) {
			String[] contenu = f.list();
			for (int i = 0; i < contenu.length; i++) {
				File f2 = new File(rep, contenu[i]);
				if (f2.isDirectory())
					System.out.println("REP : " + contenu[i]);
				else
					System.out.println("Fichier :" + contenu[i] + "Size:" + contenu[i].length());
			}
		} else {
			System.out.println(rep + " n'existe pas");
		}
	}

	/**
	 * Affiche le contenu d’un répertoire saisie en affichant si les éléments de ce
	 * répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un
	 * fichier elle affiche la capacité physique du fichier.
	 * 
	 * @param rep
	 *            emplacement répértoire
	 */
	public void afficheContenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir l'emplacement du répértoire:");
		String src = sc.nextLine();
		sc.close();
		afficheContenu(src);
	}

}
