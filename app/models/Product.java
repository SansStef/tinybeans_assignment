package models;

import play.mvc.*;

import play.db.jpa.Model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product extends Model{

	@Column(name="image_file")
	public String imageFile;
	
	@Column(name="product_name")
	public String productName;
	
	@Column(name="product_description")
	public String productDescription;
	
	@Column(name="sku")
	public int sku;
	
	@Column(name="price")
	public double price;

	

}