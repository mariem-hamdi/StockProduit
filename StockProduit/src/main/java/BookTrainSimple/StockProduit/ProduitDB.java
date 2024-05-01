package BookTrainSimple.StockProduit;


	import java.util.ArrayList;
	import java.util.List;

	import java.sql.*;
	public class ProduitDB {
		Connection con =null;

		public ProduitDB ()
		{
			String url ="jdbc:mysql://localhost:3306/produits";
			String username="root";
			String password="hamdi424+424";
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con=DriverManager.getConnection(url,username,password);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public List<Produit> getProduits()
		{
			List<Produit> produits =new ArrayList<Produit>();
			String sql = "select * from prod";
			try {
				Statement st =con.createStatement();
				ResultSet rs =st.executeQuery(sql);
				while(rs.next()) {
					Produit p =new Produit();
					p.setId(rs.getInt(1));
					p.setNom(rs.getString(2));
					p.setPrix(rs.getString(3));
					p.setQuantité(rs.getString(4));
					
					produits.add(p);
					
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return produits;
		}
		

		public Produit getProduits(int id) {
			
			String sql = "select* from prod where id="+id;
			Produit p =new Produit();
			try {
				Statement st =con.createStatement();
				ResultSet rs =st.executeQuery(sql);
				if(rs.next()) {
					
					p.setId(rs.getInt(1));
					p.setNom(rs.getString(2));
					p.setPrix(rs.getString(3));
					p.setQuantité(rs.getString(4));
					
				}	
				
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
			return p;
			
		}
	    
		public void create(Produit p1) {
			String sql ="insert into prod values(?,?,?,?)";
			try {
				PreparedStatement st =con.prepareStatement(sql);
				
	            st.setInt(1, p1.getId());
	            st.setString(2, p1.getNom());
	            st.setString(3, p1.getPrix());
	            st.setString(4, p1.getQuantité());
	            
	            
	            
				
				st.executeUpdate();
				}
		
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		public void update(Produit p1) {
			String sql ="update prod set nom=?,prix=?,quantité=? where id=?";
			try {
				PreparedStatement st =con.prepareStatement(sql);
				
	            
	            st.setString(1, p1.getNom());
	            st.setString(2, p1.getPrix());
	            st.setString(3, p1.getQuantité());
	           
	            st.setInt(4, p1.getId());
				st.executeUpdate();
				}
		
			catch(Exception e) {
				System.out.println(e);
			}
			
		}

		public void delete(int id) {
			String sql ="delete from prod where id=?";
			try {
				PreparedStatement st =con.prepareStatement(sql);
				
	            st.setInt(1, id);
				st.executeUpdate();
				}
		
			catch(Exception e) {
				System.out.println(e);
			}
			
			
		}


}
