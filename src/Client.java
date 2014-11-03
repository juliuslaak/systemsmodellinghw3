
import java.util.Random;

public class Client
{
	private Person person;
	
	private Order order;
	
	private Table table;
	
	public Client( Person p, Table t ) {
		this.person = p;
		this.table = t;
		
		Order o = new Order();
		this.order = o;
		
		calSatisfactionService();
		calSatisfactionDish();
		calSatisfactionBev();
		updatePerson();
	}

	private Integer dishCostAndPriceDifference( ) {
		double costDifference = order.getDish().getPrice() - order.getDish().calculateIngredientCost();
		Integer difference = (int) Math.floor(costDifference/3);		
		return difference;
	}
	private Integer bevCostAndPriceDifference( ) {
		double costDifference = order.getBeverage().getPrice() - order.getBeverage().calculateIngredientCost();
		Integer difference = (int) Math.floor(costDifference/3);		
		return difference;
	}


	public void updatePerson( ) {
		person.setNrOfBev(person.getNrOfBev()+1);
		person.setNrOfDishes(person.getNrOfDishes()+1);
		person.setCalCount(person.getCalCount()+order.getDish().getCalorieCount());
		person.setVolCount(person.getVolCount()+order.getBeverage().getVolume());
		person.setMoneySpent(person.getMoneySpent()+order.getBeverage().getPrice() +
				order.getDish().getPrice());
	}
	
	
	public void calSatisfactionService( ) {
		
		boolean satisfied = true;
		LevelOfExperience waiterLvl = table.waiter.getExperience();

		Random generator = new Random();
		
		if (waiterLvl == LevelOfExperience.HIGH) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 9) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (waiterLvl == LevelOfExperience.MEDIUM) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 8) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (waiterLvl == LevelOfExperience.LOW) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 6) {
				satisfied = true;
			} else { satisfied = false; }
		}
		
		updateReputation(satisfied);
	}
	
	
	public void calSatisfactionDish( ) {
		
		boolean satisfied = true;
		LevelOfExperience chefLvl = GameController.player.getRestaurant().getChef().getExperience();

		Integer difference = dishCostAndPriceDifference();
		
		Integer extraSatisfaction = 0;
		if (order.getDish().qualityLevel == QualityLevel.HIGH) {
			extraSatisfaction = 2;
		}
		
		Random generator = new Random();
		
		if (chefLvl == LevelOfExperience.HIGH) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 8+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (chefLvl == LevelOfExperience.MEDIUM) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 6+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (chefLvl == LevelOfExperience.LOW) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 4+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		}
		
		updateReputation(satisfied);
	}
	
	
	public void calSatisfactionBev( ) {
		
		boolean satisfied = true;
		LevelOfExperience barmanLvl = GameController.player.getRestaurant().getBarman().getExperience();

		Integer difference = bevCostAndPriceDifference();
		
		Integer extraSatisfaction = 0;
		if (order.getBeverage().qualityLevel == QualityLevel.HIGH) {
			extraSatisfaction = 2;
		}
		
		Random generator = new Random();
		
		if (barmanLvl == LevelOfExperience.HIGH) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 8+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (barmanLvl == LevelOfExperience.MEDIUM) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 6+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		} else if (barmanLvl == LevelOfExperience.LOW) {
			int randNr = generator.nextInt(10) + 1;
			if (randNr <= 4+extraSatisfaction-difference) {
				satisfied = true;
			} else { satisfied = false; }
		}
		
		updateReputation(satisfied);
	}
	
	
	public void updateReputation( boolean satisfied ) {
		if (satisfied) {
			GameController.player.getRestaurant().reputation += 1;
		} else {
			GameController.player.getRestaurant().reputation -= 1;
		}
	}	
}
