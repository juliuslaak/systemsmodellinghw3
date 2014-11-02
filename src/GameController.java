import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.util.TimerTask;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.IOException;



public class GameController {
	
	static BufferedReader in;
	
	private static Player player;
	
	private static int currentDay;
	
	public static void main( String[] args ) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean running = true;
		boolean correctInput = true;
		
		while(running) {
			
			showMainMenu();
			int input = -1;
			try {
				input = Integer.parseInt(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(" ");
			
			switch (input) {
				case 1:
					try {
						startGame();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					showRankings();
					break;
				case 3:
					running = false;
					System.out.println("Exiting game!");
					break;
				default:
					correctInput = false;
					break;
			}
			
			if(!correctInput){
				System.out.println("Wrong input!\n");
				correctInput = true;
			}
			
			clearScreen();
		}

	}

	private static void startGame( ) throws IOException {
		
		player = new Player();
		
		currentDay = 0;
		
		
		boolean correctInput = true;
		boolean quitGame = false;
		
		while(currentDay <= 30 && !quitGame){
			
			
			showGameStateAndOperations();
			int operationNr = Integer.parseInt(in.readLine());
			
		
			switch (operationNr) {
				//train workers
				case 1:
					showTrainingOptionsAndTrain();
					break;
				//Assign tables
				case 2:
					//Here should be some code that lets player
					//assign tables to waiters
					//TODO
					break;
				//Design menu
				case 3:
					//Here should be some code that lets player
					//choose foodItems for Menu
					//TODO
					break;
				//Open restaurant for new day
				case 4:
					//TODO
					break;
				//Quit to main menu
				case 5:
					System.out.println("Are you sure you wish to quit game?(y/n)");
					String answer = in.readLine();
					if(answer.equals("y")){
						quitGame = true;
					}else if(answer.equals("n")){
						quitGame = false;
					}else{
						correctInput = false;
					}
					break;
				default:
					correctInput = false;
					break;
			}			
			
			if(!correctInput){
				System.out.println("Wrong input!\n");
				correctInput = true;
			}
			
			clearScreen();
		}
	}
	
	/**
	 * Shows table of workers together with their level of experience
	 * and cost of training.
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	private static void showTrainingOptionsAndTrain( ) throws NumberFormatException, IOException {
		Restaurant restaurant = player.getRestaurant();
		
		System.out.println("\tTrain worker:");
		
		Chef chef = restaurant.getChef();
		System.out.println("\t" + "1. Chef: " + chef.getName() + " " + chef.getSurname() + "\t\tExp: " + chef.getExperience() + 
				"\t\tTrainging cost: " + chef.getCourseCost());
		
		Barman barman = restaurant.getBarman();
		System.out.println("\t" + "2. Barman: " + barman.getName() + " " + barman.getSurname() + "\tExp: " + barman.getExperience() + 
				"\t\tTrainging cost: " + barman.getCourseCost());
		
		int i = 3;
		for(Waiter w : restaurant.getWaiters()){
			System.out.println("\t" + i + ". Waiter: " + w.getName() + " " + w.getSurname() + "\t\tExp: " + w.getExperience() + 
					"\t\tTrainging cost: " + w.getCourseCost());
			i++;
		}
		
		System.out.println("\t"+i+". Back");
		System.out.print("\tEnter acion number:");
		
		//pick correct employee
		int operationNr = Integer.parseInt(in.readLine());
		Employee employee = null;
		switch (operationNr) {
			case 1:
				employee = chef;
				break;
			case 2:
				employee = barman;
				break;
			case 3:
				employee = restaurant.getWaiters().get(0);
				break;
			case 4:
				employee = restaurant.getWaiters().get(1);
				break;
			case 5:
				employee = restaurant.getWaiters().get(2);
				break;
			default:
				break;
		}
		
		//Train worker
		if(employee != null){
			if(restaurant.checkIfBudgetEnough(employee.getCourseCost())){
				employee.raiseEmployeeExperience();
				restaurant.setBudget(restaurant.getBudget()-employee.getCourseCost());
				System.out.println("Experience increased!");
			}else{
				System.out.println("Not enough money.");
			}
		}		
	}

	private static void showMainMenu( ) {
		System.out.println("------ The Restaurant Game---------");
		
		System.out.println("Actions");
		System.out.println("1. Start new game");
		System.out.println("2. View high score");
		System.out.println("3. Quit");
		
		System.out.print("Enter action number: ");
	}

    
	private static void showRankings( ) throws IOException {
		
		File dir = new File(".");
		File file = new File(dir.getCanonicalPath() + File.separator + "ranking.txt");
		
		if(!file.exists()) {
		    file.createNewFile();
		    System.out.println("No ranking list existed, created one. Start a new game and be the first one to be in the ranking list!");
		}
		else {
		
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = null;
			if (file.length() == 0) {
				System.out.println(">>> Ranking list is empty! Start a new game!");
			}
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		 
			br.close();
		}
	}

	/**
	 * Prints everything that user has to see ...
	 */
	private static void showGameStateAndOperations( ) {
	
		Integer rest = player.getRestaurant().reputation;
		
		System.out.println("--------------------------------------------");
		System.out.println("Day: " + Integer.toString(currentDay) + "\tBudget: " + player.getRestaurant().getBudget()
				+ "\tReputation: " + rest.toString());
		System.out.println(" ");
		System.out.println("Actions");
		System.out.println("1. Train workers");
		System.out.println("2. Assign tables");
		System.out.println("3. Design menu");
		System.out.println("4. Open restaurant");
		System.out.println("5. Quit game\n");
	    
		System.out.print("Enter action number: ");
	}
	
	private static void clearScreen( ) {
		for(int i = 0; i < 2; i++){
			System.out.println();
		}
	}
	
	

	/**
	 * Shows table of workers together with their level of experience
	 * and cost of training.
	 */
	private static void showTrainingOptions( )
	{
		
	}
	
	
}
