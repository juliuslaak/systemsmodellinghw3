import java.util.Collection;

public class Person
{
	public String name;
	
	public String surname;
	
	public String telephoneNumber;
	
	public String taxCode;
	
	
	private Integer calCount;
	
	
	private Integer volCount;
	
	
	private Integer nrOfDishes;
	
	
	private Integer nrOfBev;
	
	public Person (String name, String surname, String telephoneNumber, String taxCode) {
		this.name = name;
		this.surname = surname;
		this.telephoneNumber = telephoneNumber;
		this.taxCode = taxCode;
		this.calCount = 0;
		this.volCount = 0;
		this.nrOfDishes = 0;
		this.nrOfBev = 0;
	}
	
	public Collection pickRandomClientsForRestaurant( )
	{
		return null;
	}
	
	

	public void setCalCount( Integer calCount )
	{
		this.calCount=calCount;
	}
	
	
	public Integer getCalCount( )
	{
		return calCount;
	}
	
	
	public void setNrOfBev( Integer nrOfBev )
	{
		this.nrOfBev=nrOfBev;
	}
	
	
	public Integer getNrOfBev( )
	{
		return nrOfBev;
	}
	
	
	public void setNrOfDishes( Integer nrOfDishes )
	{
		this.nrOfDishes=nrOfDishes;
	}
	
	
	public Integer getNrOfDishes( )
	{
		return nrOfDishes;
	}
	
	
	public void setVolCount( Integer volCount )
	{
		this.volCount=volCount;
	}
	
	
	public Integer getVolCount( )
	{
		return volCount;
	}
	
	
}
