import java.util.Random;

public class Order
{
	private Beverage beverage;
	
	private Dish dish;
	
	public Order() {
        this.beverage = chooseRandomBev();
        this.dish = chooseRandomDish();
        addToBudget();
	}
	
	private void addToBudget() {
		double budget;
		double dishPrice = dish.getPrice();
		double bevPrice = beverage.getPrice();
		budget = dishPrice + bevPrice + GameController.player.getRestaurant().getBudget();
		GameController.player.getRestaurant().setBudget(budget);
	}

	public Dish chooseRandomDish( )
	{
		Random randomGenerator2 = new Random();
		int indexOfTable2 = randomGenerator2.nextInt(Restaurant.getDishes().size());
        Dish dis = Restaurant.getDishes().get(indexOfTable2);
        return dis;
	}
	
	
	public Beverage chooseRandomBev( )
	{
		Random randomGenerator1 = new Random();
		int indexOfTable1 = randomGenerator1.nextInt(Restaurant.getBeverages().size());
        Beverage bev = Restaurant.getBeverages().get(indexOfTable1);
        return bev;
	}
	
	
}
