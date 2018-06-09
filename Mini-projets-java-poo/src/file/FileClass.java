package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import constants.ConstantMsgClass;
import entree_sortie.AffichageClass;
import entree_sortie.SaisieClass;

public class FileClass {
	
	private static final int ITERATION_LIMITE = 9999999;

	/**
	 * Affiche le contenu d’un répertoire en affichant si les éléments de ce
	 * répertoire sont des fichier ou des répertoires. Dans le cas ou il s’agit d’un
	 * fichier elle affiche la capacité physique du fichier.
	 * 
	 * @param rep
	 *            emplacement répértoire
	 */
	public static void afficheContenu(String rep) {
		File f = new File(rep);
		if (f.exists()) {
			String[] contenu = f.list();
			for (int i = 0; i < contenu.length; i++) {
				File f2 = new File(rep, contenu[i]);
				if (f2.isDirectory())
					AffichageClass.afficheConsole("REP : " + contenu[i]);
				else
					AffichageClass.afficheConsole("Fichier :" + contenu[i] + "Size:" + contenu[i].length());
			}
		} else {
			AffichageClass.afficheConsole(rep + " n'existe pas");
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
	public static void afficheContenu() {
		String src = SaisieClass.saisieStringConsole(ConstantMsgClass.FILECLASS_SAISIE_MSG_SAISIE_REPERTOIRE);
		afficheContenu(src);
	}

	/**
	 * Permet d’afficher le contenu d’un répertoire y compris le contenu de ses sous
	 * répertoires
	 */
	public static void afficheContenuComprisSousReprtoires() {
		String src = SaisieClass.saisieStringConsole(ConstantMsgClass.FILECLASS_SAISIE_MSG_SAISIE_REPERTOIRE);
		afficheContenuComprisSousReprtoires("", src);
	}

	/**
	 * Permet d’afficher le contenu d’un répertoire y compris le contenu de ses sous
	 * répertoires
	 * 
	 * @param rep
	 *            emplacement répértoire
	 */
	public static void afficheContenuComprisSousReprtoires(String rep) {
		afficheContenuComprisSousReprtoires("", rep);
	}

	/**
	 * Permet d’afficher le contenu d’un répertoire y compris le contenu de ses sous
	 * répertoires
	 * 
	 * @param rep
	 *            emplacement répértoire
	 * @param espace
	 */
	private static void afficheContenuComprisSousReprtoires(String espace, String rep) {

		File f = new File(rep);
		if (f.exists()) {
			String[] contenu = f.list();
			if (contenu == null) {
				exitVoidMethode();
			}
			List<String> listDirectory = new ArrayList<String>();
			for (int i = 0; i < contenu.length; i++) {
				File f2 = new File(rep, contenu[i]);
				if (f2.isDirectory()) {
					listDirectory.add(contenu[i]);
				} else
					AffichageClass.afficheConsole(espace + "Fichier : " + contenu[i] + "Size : " + contenu[i].length());
			}
			for (String elem : listDirectory) {
				AffichageClass.afficheConsole(espace + "REP : " + elem);
				afficheContenuComprisSousReprtoires(espace + "\t", rep + "/" + elem);
			}
		} else {
			AffichageClass.afficheConsole(rep + " n'existe pas");
		}

	}

	/**
	 * Copier le contenu du fichier path1 dans le fichier path2 (si le fichier path2
	 * est inexistant il va être créer si il existe son contenu va être écraser )
	 * 
	 * @param path1
	 * @param path2
	 * @throws IOException
	 */
	public static void copierFichierTextDansUnAutre(String path1, String path2) throws IOException {
		File f1 = new File(path1);
		if (!f1.exists() && !f1.isDirectory()) {
			if (!f1.exists())
				AffichageClass.afficheConsole("File don't exist " + path1);
			else
				AffichageClass.afficheConsole("Is not file");
			exitVoidMethode();
		}
		FileReader fr = new FileReader(f1);
		File f2 = new File(path2);
		if (!f2.exists()) {
			AffichageClass.afficheConsole("File or directory don't exist " + path2);
			exitVoidMethode();
		}
		FileWriter fw = new FileWriter(f2);
		int c;
		while ((c = fr.read()) != -1) {
			fw.write(c);
		}
		fr.close();
		fw.close();
		AffichageClass.afficheConsole(
				"Contenu du fichier : " + f1.getName() + " est bien copier dans le fichier : " + f2.getName());
	}

	/**
	 * Sortir d'une méthode qui retourne void
	 */
	private static void exitVoidMethode() {
		return;
	}

	/**
	 * Copier le contenu du fichier path1 dans le fichier path2 avec cryptage (si le fichier path2
	 * est inexistant il va être créer si il existe son contenu va être écraser )
	 * 
	 * @param path1
	 * @param path2
	 * @throws IOException
	 */
	public static void copierFichierTextDansUnAutreAvecCryptage(String path1, String path2) throws IOException {
		File f1 = new File(path1);
		if (!f1.exists() && !f1.isDirectory()) {
			if (!f1.exists())
				AffichageClass.afficheConsole("File don't exist " + path1);
			else
				AffichageClass.afficheConsole("Is not file");
			exitVoidMethode();
		}
		FileReader fr = new FileReader(f1);
		File f2 = new File(path2);
		if (!f2.exists()) {
			AffichageClass.afficheConsole("File or directory don't exist " + path2);
			exitVoidMethode();
		}
		FileWriter fw = new FileWriter(f2);
		int c;
		while ((c = fr.read()) != -1) {
			fw.write(cryptage(c));
		}
		fr.close();
		fw.close();
		AffichageClass.afficheConsole(
				"Contenu du fichier : " + f1.getName() + " est bien copier dans le fichier : " + f2.getName());
	}
	
	public static void decrypterFichier(String path) throws IOException {
		File f1 = new File(path);
		if (!f1.exists() && !f1.isDirectory()) {
			if (!f1.exists())
				AffichageClass.afficheConsole("File don't exist " + path);
			else
				AffichageClass.afficheConsole("Is not file");
			exitVoidMethode();
		}
		FileReader fr = new FileReader(f1);
		int numFile=4;
		
		File f2 = new File(f1.getParentFile()+"/File"+numFile+".txt");
		while (f2.exists() && numFile < ITERATION_LIMITE) {
			numFile++;
			f2 = new File(f1.getParentFile()+"/File"+numFile+".txt");
		}
		if (numFile == ITERATION_LIMITE) {
			AffichageClass.afficheConsole("Impossible de décrypter le fichier (la création d'un fichier intermédiaire a échoué)");
			exitVoidMethode();
		}
		FileWriter fw = new FileWriter(f2);
		int c;
		while ((c = fr.read()) != -1) {
			fw.write(decryptage(c));
		}
		fr.close();
		fw.close();
		copierFichierTextDansUnAutre(f2.getPath(), f1.getPath());
		f2.delete();
		AffichageClass.afficheConsole(
				"Contenu du fichier : " + f1.getName() + " est bien décrypter.");

	}
	
	/**
	 * Exemple de fonction de cryptage
	 * @param c
	 * @return
	 */
	private static int cryptage(int c) {
		return ((c*c)*2+1);
	}
	
	/**
	 * Exemple de fonction de décryptage
	 * @param c
	 * @return
	 */
	private static int decryptage(int c) {
		return (int) Math.sqrt((c-1)/2);
	}
	

}
