import java.io.IOException;

public class Player
{
	private String name;
	private Restaurant restaurant;
	
	public Player( ) throws IOException {
		System.out.print("\nPlayer NAME: ");
		name = GameController.in.readLine();
		
		restaurant = new Restaurant();
	}
	
	public Restaurant getRestaurant( ) {
		return restaurant;
	}

	public String getName( ) {
		return name;
	}
	
}
