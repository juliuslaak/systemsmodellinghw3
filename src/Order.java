import java.util.Random;

public class Order
{
	private Beverage beverage;
	
	private Dish dish;
	
	public Order() {
		Random randomGenerator1 = new Random();
		Random randomGenerator2 = new Random();
		int indexOfTable1 = randomGenerator1.nextInt(Restaurant.getBeverages().size());
		int indexOfTable2 = randomGenerator2.nextInt(Restaurant.getDishes().size());
        Beverage bev = Restaurant.getBeverages().get(indexOfTable1);
        Dish dis = Restaurant.getDishes().get(indexOfTable2);
        this.beverage = bev;
        this.dish = dis;
	}
	
	private void addToBudget() {
		double budget;
		double dishPrice = dish.getPrice();
		double bevPrice = beverage.getPrice();
		budget = dishPrice + bevPrice + GameController.player.getRestaurant().getBudget();
		
	}

	public Dish chooseRandomDish( )
	{
		return null;
	}
	
	
	public Beverage chooseRandomBev( )
	{
		return null;
	}
	
	
}
