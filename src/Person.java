
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
	
	private double moneySpent;
	
	private boolean currentlyClient;
	
	public Person( String name, String surname, String telephoneNumber, String taxCode ) {

		this.name = name;
		this.surname = surname;
		this.telephoneNumber = telephoneNumber;
		this.taxCode = taxCode;
		this.calCount = 0;
		this.volCount = 0;
		this.nrOfDishes = 0;
		this.nrOfBev = 0;
		this.moneySpent = 0;
		this.currentlyClient = false;
	}
	
	public void displayPersonStats( ) {
		System.out.println(name + " " + surname + "\t" + nrOfDishes + "\t" + 
	calCount + "\t\t" + nrOfBev + "\t\t" + volCount + "\t" + moneySpent );
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
	
	public boolean getcurrentlyClient( ) {
		return currentlyClient;
	}
	
	public void setcurrentlyClient( boolean IsClient ) {
		this.currentlyClient = IsClient;
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
	

	public double getMoneySpent( ) {
		return moneySpent;
	}

	public void setMoneySpent( double moneySpent ) {
		this.moneySpent = moneySpent;
	}
	
	
}
