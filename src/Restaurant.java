import java.util.List;
import java.io.IOException;

public class Restaurant{
	
	public int reputation;
	
	public double budget = 10000.0;
	
	public String name;
	
	public String address;
	
	public String city;
	
	private java.util.List<Table> tables;
	
	private Barman barman;
	
	private java.util.List<Waiter> waiters;
	
	private Chef chef;
	
	private List foodItems;
	
	
	public Restaurant( ) throws IOException {
		System.out.print("Enter restaurant name:");
		name = GameController.in.readLine();
		
		System.out.print("Enter restaurant address:");
		address = GameController.in.readLine();
		
		System.out.print("Enter city:");
		city = GameController.in.readLine();
	}
	
	
	private MenuItem menuItem;
	
	
	private Table table;
	
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
	

	public int calculateReputation( )
	{
		return 0;
	}
	
	
}
