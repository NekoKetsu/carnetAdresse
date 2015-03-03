package services;

import java.util.ArrayList;
import java.util.Collections;

import beans.Adresse;

public class AdresseServiceLocal implements AdresseService {
	static ArrayList<Adresse> adresses = null;
	static int cpt = 0;
	
	public AdresseServiceLocal() {
		if(adresses == null)
			init();
	}
	
	public  void init(){
		adresses = new ArrayList<Adresse>();
		cpt = 1;
		adresses.add(new Adresse(cpt++, "Dupont", "Jean", "0123456789", "1 rue de l'exemple", "44120", "Vertou", "France"));
		adresses.add(new Adresse(cpt++, "Durans", "Patrick", "0123456789", "2 rue de l'exemple", "44120", "Vertou", "France"));
		adresses.add(new Adresse(cpt++, "Dupont", "Henry", "0123456789", "3 rue de l'exemple", "44120", "Vertou", "France"));
	}
	
	public ArrayList<Adresse> getAdresses() {
		Collections.sort(adresses);
		return adresses;
	}
	
	public Adresse getAdresse(int id) throws Exception{
		int indexInList = adresses.indexOf(new Adresse(id));
		if(indexInList == -1)
			throw new Exception("L'adresse d'id : " + id + " introuvable");
		return adresses.get(indexInList);
	}
	
	public void createAdresse(String nom, String prenom, String tel, String rue, String codePostal, String ville, String pays){
		adresses.add(new Adresse(++cpt, nom, prenom, tel, rue, codePostal, ville, pays));
	}
	
	public void deleteAdresse(int id) throws Exception{
		int indexInList = adresses.indexOf(new Adresse(id));
		if(indexInList == -1)
			throw new Exception("L'adresse d'id : " + id + " introuvable");
		adresses.remove(indexInList);
	}
	
	public void updateAdresse(int id, String nom, String prenom, String tel, String rue, String codePostal, String ville, String pays) throws Exception{
		Adresse a = new Adresse(id, nom, prenom, tel, rue, codePostal, ville, pays);
		int indexInList = adresses.indexOf(a);
		if(indexInList == -1)
			throw new Exception("L'adresse d'id : " + id + " introuvable");
		adresses.set(indexInList, a);
	}
}
