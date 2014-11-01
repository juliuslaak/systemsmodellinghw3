/**
 * @(#) Restaurant.java
 */

public class Restaurant
{
	public String name;
	
	public int reputation;
	
	public float budget = 10000;
	
	public String address;
	
	public String city;
	
	private java.util.List<Table> tables;
	
	private Barman barman;
	
	private java.util.List<Waiter> waiters;
	
	private Chef chef;
	
	private java.util.List foodItems;
	
	public void payMonthlyCosts( )
	{
		
	}
	
	private void initDishes( )
	{
		
	}
	
	private void initBeverages( )
	{
		
	}
	
	public void initMenuItemsCorrespondingPrices( )
	{
		
	}
	
	public void rateService( )
	{
		
	}
	
	public int calculateReputation( )
	{
		return 0;
	}
	
	public float receivePaymentForOrder( )
	{
		return 0;
	}
	
	public void assignTablesToWaiters( )
	{
		
	}
	
	public boolean checkIfBudgetEnough( )
	{
		return false;
	}
	
	public LevelOfExperience checkExperience( )
	{
		return null;
	}
	
	public float paySuppliers( )
	{
		return 0;
	}
	
	
}
