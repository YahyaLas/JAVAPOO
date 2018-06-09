package fileProjet;

import file.FileClass;

public class FileProjet {

	public static void main(String[] args) {
		/*
		 * Afficher le contenu d’un répertoire saisie en affichant si les éléments de ce
		 * répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un
		 * fichier elle affiche la capacité physique du fichier.
		 */
		System.out.println("\r\n**Afficher le contenu d’un répertoire saisie en affichant si les éléments de ce"
				+ " répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un"
				+ "fichier elle affiche la capacité physique du fichier.");
		FileClass.afficheContenu("C:/");
		FileClass.afficheContenu();

		/*
		 * afficher le contenu d’un répertoire y compris le contenu de ses sous
		 * répertoires
		 */
		System.out.println(
				"\r\n**Afficher le contenu d’un répertoire y compris le contenu de ses sous répertoires\r\n**");
		FileClass.afficheContenuComprisSousReprtoires("C:/Users/");
		FileClass.afficheContenuComprisSousReprtoires();
	}

}
