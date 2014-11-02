import java.io.IOException;

public class Player
{
	public String name;
	private Restaurant restaurant;
	
	public Player( ) throws IOException {
		System.out.print("\nEnter your name:");
		name = GameController.in.readLine();
		
		restaurant = new Restaurant();
	}
	
	public int getDishCountForClient( Dish dish, Client client )
	{
		return 0;
	}
	
	public int getBeverageCountForClient( Beverage beverage, Client client )
	{
		return 0;
	}
	
	public double getAvgDishCaloriesForClient( Client client )
	{
		return 0;
	}
	
	public double getAvgBeverageVolumeForClient( Client client )
	{
		return 0;
	}
	
	public double getTotalMoneySpentByClient( Client client )
	{
		return 0;
	}

	public Restaurant getRestaurant( ) {
		return restaurant;
	}

	public String getName( ) {
		return name;
	}
	
}
