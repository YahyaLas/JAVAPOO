package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import constants.ConstantMsgClass;
import saisie.SaisieClass;

public class FileClass {

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
			if (contenu == null) 
				return;
			List<String> listDirectory = new ArrayList<String>();
			for (int i = 0; i < contenu.length; i++) {
				File f2 = new File(rep, contenu[i]);
				if (f2.isDirectory()) {
					listDirectory.add(contenu[i]);
				} else
					System.out.println(espace + "Fichier : " + contenu[i] + "Size : " + contenu[i].length());
			}
			for (String elem : listDirectory) {
				System.out.println(espace + "REP : " + elem);
				afficheContenuComprisSousReprtoires(espace + "\t", rep + "/" + elem);
			}
		} else {
			System.out.println(rep + " n'existe pas");
		}

	}

}
