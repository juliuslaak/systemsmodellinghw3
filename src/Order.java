import java.util.Random;

public class Order
{
	private Beverage beverage;
	private Dish dish;
	public String orderId;
	public Integer date;
	
	public Order( ) {
        this.beverage = chooseRandomBev();
        this.dish = chooseRandomDish();
        addToBudget();
        updateIngredientDept();
	}
	
	private void updateIngredientDept( ) {
		
		double currentIngredients;
		currentIngredients = dish.calculateIngredientCost() + beverage.calculateIngredientCost();
		
		double ingredientsCostWeekly = GameController.player.getRestaurant().getIngredientsCostWeekly();
		GameController.player.getRestaurant().setIngredientsCostWeekly(ingredientsCostWeekly + currentIngredients);
		
	}

	private void addToBudget( ) {
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
	

	public Dish getDish( ) {
		return dish;
	}

	public Beverage getBeverage( ) {
		return beverage;
	}
	
	
	
	
}
