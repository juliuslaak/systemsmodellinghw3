import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Restaurant{
	
	public Integer reputation = 15;

	public double budget = 10000.0;
	private double ingredientsCostWeekly = 0;

	public String name;
	public String address;
	public String city;
	
	private Barman barman;
	private Chef chef;
	private ArrayList<Waiter> waiters;
	private static ArrayList<Dish> dishMenu;
	private static ArrayList<Beverage> beverageMenu;
	
	ArrayList<Table> tables;
	
	public Restaurant( ) throws IOException {
		System.out.print("Restaurant NAME: ");
		name = GameController.in.readLine();
		
		System.out.print("Restaurant ADDRESS: ");
		address = GameController.in.readLine();
		
		System.out.print("City: ");
		city = GameController.in.readLine();
		
		System.out.println("\n");
		
		//tax code chosen arbitrarily because I have no idea what it is
		chef = new Chef("Micheal", "Scott", 123);
		barman = new Barman("Dwight", "Schrute");
		
		waiters = new ArrayList<Waiter>();
		waiters.add(new Waiter("Pam", "Beesly"));
		waiters.add(new Waiter("Jim", "Halpert"));
		waiters.add(new Waiter("Kelly", "Kapoor"));

		tables = new ArrayList<Table>();
		for (int i = 1; i<10; i++) {
			tables.add(new Table(i));
		}

		initMenu();
		
	}
	
	public void payMonthlyCosts( ){
		budget -= 4000;
	}
	
	private void initMenu( ){
		dishMenu = new ArrayList<Dish>();
		beverageMenu = new ArrayList<Beverage>();
		
		//Dishes
		dishMenu.add(new Dish("French fries", 500));
		dishMenu.add(new Dish("Chicken", 700));
		dishMenu.add(new Dish("Spaghetti", 400));
		dishMenu.add(new Dish("Hamburger", 500));
		dishMenu.add(new Dish("Roasted beef", 800));
	

		//Beverages
		beverageMenu.add(new Beverage("Water", 500));
		beverageMenu.add(new Beverage("Coffee", 300));
		beverageMenu.add(new Beverage("Coca-Cola", 500));
		beverageMenu.add(new Beverage("Orange juice", 700));
		beverageMenu.add(new Beverage("Tea", 300));
	}
	
	public boolean checkIfBudgetEnough( double cost ){
		if(cost > budget){
			return false;
		}else{
			return true;
		}
	}
	
	public void paySuppliers( )
	{
		budget = budget - ingredientsCostWeekly;
		ingredientsCostWeekly = 0;
	}

	public float getBudget( ) {
		return Math.round(budget*100)/100;
	}
	
	public Barman getBarman( ) {
		return barman;
	}

	public ArrayList<Waiter> getWaiters( ) {
		return waiters;
	}

	public Chef getChef( ) {
		return chef;
	}
	
	public void setBudget( double budget ) {
		this.budget = budget;
	}

	public boolean budgetNegative( ) {
		if (budget < 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void payWeeklySalaries( double salary ){
		budget -= salary;
	}
	
	public static ArrayList<Beverage> getBeverages( ) {
		return beverageMenu;
	}
	
	public static ArrayList<Dish> getDishes( ) {
		return dishMenu;
	}

	public double getIngredientsCostWeekly( ) {
		return ingredientsCostWeekly;
	}

	public void setIngredientsCostWeekly( double ingredientsCostWeekly ) {
		this.ingredientsCostWeekly = ingredientsCostWeekly;
	}
		
}
