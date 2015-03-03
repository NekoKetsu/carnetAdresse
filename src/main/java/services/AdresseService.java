package services;

import java.util.ArrayList;
import java.util.LinkedList;

import beans.Adresse;

public interface AdresseService {
	
	public ArrayList<Adresse> getAdresses();
	
	public Adresse getAdresse(int id) throws Exception;
	
	public void createAdresse(String nom, String prenom, String tel, String rue, String codePostal, String ville, String pays);
	
	public void updateAdresse(int id, String nom, String prenom, String tel, String rue, String codePostal, String ville, String pays) throws Exception;
}
