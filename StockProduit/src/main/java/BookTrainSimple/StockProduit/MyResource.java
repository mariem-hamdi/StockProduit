
package BookTrainSimple.StockProduit;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/produits")
public class MyResource {
    
	ProduitDB produitbd =new ProduitDB();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Produit> getProduits()
	{
		return produitbd.getProduits();
	}
    
    
    @GET
	@Path("/produit/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Produit getProduit(@PathParam("id")int id) 
	{
		return produitbd.getProduits(id);
	}
	
	@POST
	@Path("/produit")
	@Produces(MediaType.APPLICATION_XML)
	public Produit createProduit(Produit p1) {
		System.out.println(p1);
		produitbd.create(p1);
		return p1;
	}
	
	@PUT
	@Path("/produit")
	@Produces(MediaType.APPLICATION_XML)
	public Produit updateProduit(Produit p1) {
		System.out.println(p1);
		if(produitbd.getProduits(p1.getId()).getId()==0) 
		{
			produitbd.create(p1);
			return p1;
		}
		else
		{
			produitbd.update(p1);
			return p1;
		}
	
	}
	
	@DELETE
	@Path("/{id}")
	public Produit killProduit(@QueryParam("id") int id) 
	{
		Produit p =produitbd.getProduits(id);
		if (p.getId()!=0) {
		produitbd.delete(id);
		}
		return p;
	}
}
