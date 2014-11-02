import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.IOException;



public class GameController {
	
	static BufferedReader in;
	
	private static Player player;
	
	private static java.util.List<Person> persons;
	
	private static java.util.List<Client> clients;
	
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
		
		persons = new ArrayList<Person>();
		persons.add(new Person("Client1","Surname1", "1-800-900-32", "10055"));
		persons.add(new Person("Client2","Surname2", "2-800-900-32", "20055"));
		persons.add(new Person("Client3","Surname3", "3-800-900-32", "30055"));
		persons.add(new Person("Client4","Surname4", "4-800-900-32", "40055"));
		persons.add(new Person("Client5","Surname5", "5-800-900-32", "50055"));
		persons.add(new Person("Client6","Surname6", "6-800-900-32", "60055"));
		persons.add(new Person("Client7","Surname7", "7-800-900-32", "70055"));
		persons.add(new Person("Client8","Surname8", "8-800-900-32", "80055"));
		persons.add(new Person("Client9","Surname9", "9-800-900-32", "90055"));
		persons.add(new Person("Client10","Surname10", "10-800-900-32", "100055"));
		persons.add(new Person("Client11","Surname11", "11-800-900-32", "110055"));
		persons.add(new Person("Client12","Surname12", "12-800-900-32", "120055"));
		persons.add(new Person("Client13","Surname13", "13-800-900-32", "130055"));
		persons.add(new Person("Client14","Surname14", "14-800-900-32", "140055"));
		persons.add(new Person("Client15","Surname15", "15-800-900-32", "150055"));
		persons.add(new Person("Client16","Surname16", "16-800-900-32", "160055"));
		persons.add(new Person("Client17","Surname17", "17-800-900-32", "170055"));
		persons.add(new Person("Client18","Surname18", "18-800-900-32", "180055"));
		
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
				case 4:
					startDay();
					break;
				
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
	
	private static void startDay() {
		
		for (Waiter w : player.getRestaurant().getWaiters()) {
			w.nrOfTablesAssigned = 0;
		}
		
		assignWaitersToTables();
		
		chooseClients();
		
	}

	private static void assignWaitersToTables() {
		/**
		 * Randomly assigns tables for waiters who have less than 3 tables assigned
		 */
		
		List<Waiter> waiters = player.getRestaurant().getWaiters();
		Collections.shuffle(waiters);
		
		for (Table t : player.getRestaurant().tables) {
			for (Waiter w : waiters) {
				if (w.nrOfTablesAssigned <= 3) {
					t.waiter = w;
					break;
				}
			}
		}
	}

	private static void chooseClients() {
		
		int reputation = player.getRestaurant().reputation;
		clients = new ArrayList<Client>();
		
		if (reputation < 15) {
			for (int i = 1;i<=2;i++) {
				clients.add(new Client());
			}
		}
		else if (reputation > 29) {
			
		}
		else {
			
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
		
		System.out.println("------ Beginning of a Day ---------");
		System.out.println("Day: " + Integer.toString(currentDay) + "\tBudget: " + player.getRestaurant().getBudget()
				+ "\tReputation: " + rest.toString());
		System.out.println(" ");
		System.out.println("Actions");
		System.out.println("1. Train workers");
		System.out.println("2. Assign tables");
		System.out.println("3. Design menu");
		System.out.println("4. Start day / Open restaurant");
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
