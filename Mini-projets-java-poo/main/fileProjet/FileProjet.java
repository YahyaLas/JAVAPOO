package fileProjet;

import java.io.IOException;

import file.FileClass;

public class FileProjet {

	public static void main(String[] args) throws IOException {
		/*
		 * Afficher le contenu d’un répertoire saisie en affichant si les éléments de ce
		 * répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un
		 * fichier elle affiche la capacité physique du fichier.
		 */
		// System.out.println("\r\n**Afficher le contenu d’un répertoire saisie en
		// affichant si les éléments de ce"
		// + " répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit
		// d’un"
		// + "fichier elle affiche la capacité physique du fichier.");
		// FileClass.afficheContenu("C:/");
		// FileClass.afficheContenu();

		/*
		 * afficher le contenu d’un répertoire y compris le contenu de ses sous
		 * répertoires
		 */
		// System.out.println(
		// "\r\n**Afficher le contenu d’un répertoire y compris le contenu de ses sous
		// répertoires\r\n**");
		// FileClass.afficheContenuComprisSousReprtoires("C:/Users/");
		// FileClass.afficheContenuComprisSousReprtoires();

		/*
		 * Copier Contenu d'un Fichier text dans un autre
		 */
//		System.out.println("\r\n**Copier Contenu d'un fichier text dans un autre**\r\n");
//		FileClass.copierFichierTextDansUnAutre("ressources/File1.txt", "ressources/File2");
		
		/*
		 * Copier Contenu d'un Fichier text dans un autre avec cryptage personnalisé
		 */
//		System.out.println(
//				"\r\n**Copier Contenu d'un fichier text dans un autre avec cryptage**\r\n");
//		FileClass.copierFichierTextDansUnAutreAvecCryptage("ressources/File1.txt","ressources/File2.txt");
	
		/*
		 * décrypté un fichier qui est crypté par la fonction de cryptage du FileClass
		 */
		System.out.println(
				"\r\n**Décrypter un fichier qu'on a crypté avec notre cryptage**\r\n");
		FileClass.decrypterFichier("ressources/File2.txt");

	}

}
