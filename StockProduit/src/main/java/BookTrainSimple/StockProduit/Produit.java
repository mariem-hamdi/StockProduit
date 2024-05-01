package BookTrainSimple.StockProduit;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produit {
	private int id;
	private String nom;
	private String prix;
	private String quantité;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getQuantité() {
		return quantité;
	}
	public void setQuantité(String quantité) {
		this.quantité = quantité;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantité=" + quantité + "]";
	}
	
	

}