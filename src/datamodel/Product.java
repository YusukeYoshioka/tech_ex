package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "p_name")
	private String productName;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "inventory")
	private Integer inventory;
	
	public Product()
	{
	}
	
	public Product(Integer id, String productName, String manufacturer, Integer inventory)
	{
		this.id = id;
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.inventory = inventory;
	}
	
	public Product(String productName, String manufacturer, Integer inventory)
	{
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.inventory = inventory;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}
	
	public Integer getInventory()
	{
		return inventory;
	}
	
	public void setInventroy(Integer inventory)
	{
		this.inventory = inventory;
	}
	
	@Override
	public String toString()
	{
		return "Employee: " + this.id + ", " + this.productName + ", " + this.manufacturer + ", " + this.inventory;
	   }
}
