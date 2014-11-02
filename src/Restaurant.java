import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Restaurant{
	
	public int reputationPoints = 15;
	public double budget = 10000.0;
	public String name;
	public String address;
	public String city;
	
	private Barman barman;
	private Chef chef;
	private java.util.List<Waiter> waiters;
	
	private Table table;
	
	
	public int reputation;
	
	
	private java.util.List<MenuItem> menu;
	
	
	private java.util.List<Table> tables;
	
	public Restaurant( ) throws IOException {
		System.out.print("Enter restaurant name:");
		name = GameController.in.readLine();
		
		System.out.print("Enter restaurant address:");
		address = GameController.in.readLine();
		
		System.out.print("Enter city:");
		city = GameController.in.readLine();
		
		//tax code chosen arbitrarily because I have no idea what it is
		chef = new Chef("Micheal", "Scott", 123);
		barman = new Barman("Dwight", "Schrute");
		
		waiters = new ArrayList<Waiter>();
		waiters.add(new Waiter("Pam", "Beesly"));
		waiters.add(new Waiter("Jim", "Halpert"));
		waiters.add(new Waiter("Kelly", "Kapoor"));
		
		initMenu();
	}
	
	public void payMonthlyCosts( ){
		
	}
	
	private void initMenu( ){
		menu = new ArrayList<MenuItem>();
		
		//Dishes
		menu.add(new Dish("French fries", 500))
		//Beverages
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
	
	public boolean checkIfBudgetEnough( double cost ){
		if(cost > budget){
			return false;
		}else{
			return true;
		}
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
	
	public Barman getBarman( ) {
		return barman;
	}

	public List<Waiter> getWaiters( ) {
		return waiters;
	}

	public Chef getChef( ) {
		return chef;
	}
	
	public void setBudget( double budget ) {
		this.budget = budget;
	}

	public boolean checkIfBudgetEnough( )
	{
		return false;
	}
	
}
