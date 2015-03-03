package beans;

public class Adresse implements Comparable<Adresse> {
	private int id;
	private String nom, prenom, tel, rue, codePostal, ville, pays;

	public Adresse() {
	}
	
	public Adresse(int id) {
		this.id = id;
	}
	
	public Adresse(int id, String nom, String prenom, String tel, String rue,
			String codePostal, String ville, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int compareTo(Adresse a) {
		int compare = nom.compareTo(a.nom);
		if(compare == 0)
			compare = prenom.compareTo(a.prenom);
		return compare;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Adresse)
			return id == ((Adresse) obj).id;
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
