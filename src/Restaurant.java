import java.io.IOException;

/**
 * @(#) Restaurant.java
 */
public class Restaurant{
	
	public int reputation = 15;
	
	public float budget = 10000;
	
	public String name;
	
	public String address;
	
	public String city;
	
	private java.util.List<Table> tables;
	
	private Barman barman;
	
	private java.util.List<Waiter> waiters;
	
	private Chef chef;
	
	private java.util.List foodItems;
	
	
	public Restaurant( ) throws IOException {
		System.out.print("Enter restaurant name:");
		name = GameController.in.readLine();
		
		System.out.print("Enter restaurant address:");
		address = GameController.in.readLine();
		
		System.out.print("Enter city:");
		city = GameController.in.readLine();
	}
	
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

	public float getBudget( ) {
		return Math.round(budget*100)/100;
	}
	
}
