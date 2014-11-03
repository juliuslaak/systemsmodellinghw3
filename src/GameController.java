import java.util.ArrayList;
import java.io.BufferedWriter;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.File;
import java.util.Collections;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;


public class GameController {
	
	static BufferedReader in;
	
	public static Player player;
	
	private static java.util.List<Person> persons;
	
	private static Integer currentDay;
	
	private static Integer[] daysOfWeekends = {7,14,21,28};
	
	public static void main( String[] args ) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean running = true;
		boolean correctInput = true;
		
		while(running) {
			
			showMainMenu();
			
			Integer input = inputFromPlayer(3);
			
			System.out.println();
			
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
					System.out.println("Bye bye!");
					break;
				default:
					correctInput = false;
					break;
			}
			
			if(!correctInput){
				System.out.println("Wrong input!");
				correctInput = true;
			}
		}
	}

	private static Integer inputFromPlayer( Integer maxAllowed ) throws IOException {

		Integer operationNr = 0;
		
		while (true) {
			System.out.print("\nEnter action number: ");
			String input = in.readLine();
			
			try {
				operationNr = Integer.parseInt(input);
				if (operationNr < 1 || operationNr > maxAllowed) {
					System.out.println("Action not defined!");
				} else { 
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("Action must be INTEGER!");
			}

		}
		
		return operationNr;
	}
	
	
	private static Integer inputFromPlayer(  ) throws IOException {

		Integer operationNr = 0;
		
		while (true) {
			System.out.print("\nEnter action number: ");
			String input = in.readLine();
			
			try {
				operationNr = Integer.parseInt(input);
				if (operationNr < 1 ) {
					System.out.println("Action not defined!");
				} else { 
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("Action must be INTEGER!");
			}

		}
		
		return operationNr;
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
		
		while(currentDay <= 30){
			
			showGameStateAndOperations();
			Integer input = inputFromPlayer(4);
		
			switch (input) {
				case 1:
					showTrainingOptionsAndTrain();
					break;
				case 2:
					designMenu();
					break;
				case 3:
					startDay();
					break;
				case 4:
					System.out.println("By quitting before the end of the game you lose your game.");
					System.out.print("Are you sure you wish to quit game now (y/n)? ");
					String answer = in.readLine();
					if(answer.equals("y")){
						quitGame = true;
						System.out.println("Restaurant closes and game ends!");
						break;
					}else{
						correctInput = false;
					}
					break;
				default:
					correctInput = false;
					break;
			}
			
			if(!correctInput){
				System.out.println("Wrong input!");
				correctInput = true;
			}
			

			if (player.getRestaurant().budgetNegative()) {
				quitGame = true;
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("--------------------------------");
				System.out.println("Budget was found negative at the end of the day!");
				System.out.println("Restaurant closes and game ends!");
				System.out.println("--------------------------------");
				System.out.println("--------------------------------");
				break;
			}
			
			clearScreen();
		}
		
		// If the game was ended after 30 days (i.e. budget was not negative)
		if (!quitGame) {
			player.getRestaurant().payMonthlyCosts();
			updateRankings();
			System.out.println("--------------------------------");
			System.out.println("------ End of the game ---------");
			System.out.println("--------------------------------");
			System.out.println("30 days is over - good job!");
			System.out.print("Your SCORE for the game is: ");
			System.out.println(player.getRestaurant().getBudget());
			System.out.println("--------------------------------");
			System.out.println("--------------------------------");
			showClientStatistics();
		}
	}
	
	private static void showClientStatistics( ) {
		System.out.println("--------------------------------");
		System.out.println("------ Client Statistics -------");
		System.out.println("--------------------------------");
		System.out.println("Full name\t\tDishes\t"
				+ "Calories\tBeverages\tVolume\tMoney spent" );
		for (Person p : persons) {
			p.displayPersonStats();
		}
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		System.out.println();
	}

	private static void designMenu( ) throws NumberFormatException, IOException {
		
		boolean finished = false;
		List<Dish> dishMenu = player.getRestaurant().getDishes();
		List<Beverage> beverageMenu = player.getRestaurant().getBeverages();
		
		while(!finished){
			System.out.println("\tActions");
			System.out.println("\t1.Show menu");
			System.out.println("\t2.Pick low quality price for dishes");
			System.out.println("\t3.Pick high quality price for dishes");
			System.out.println("\t4.Pick low quality price for beverages");
			System.out.println("\t5.Pick high quality price for beverages");
			System.out.println("\t6.Pick number of high quality dishes");
			System.out.println("\t7.Pick number of high quality beverages");
			System.out.println("\t8.Back");
			
			Integer input = inputFromPlayer(8);
			
			switch (input) {
				case 1:
					printMenu();
					System.out.println("Press enter to continue");
					in.readLine();
					break;
				case 2:
					System.out.print("\tEnter low quality dish price:");
					Integer lowPriceDish = inputFromPlayer();
					Dish.lowQualityPrice = lowPriceDish;
					break;
				case 3:
					System.out.print("\tEnter high quality dish price:");
					Integer highPriceDish = inputFromPlayer();
					Dish.highQualityPrice = highPriceDish;
					break;
				case 4:
					System.out.print("\tEnter low quality beverage price:");
					Integer lowPriceBeverage = inputFromPlayer();
					Beverage.lowQualityPrice = lowPriceBeverage;
					break;
				case 5:
					System.out.print("\tEnter high quality beverage price:");
					Integer highPriceBeverage = inputFromPlayer();
					Beverage.highQualityPrice = highPriceBeverage;
					break;
				case 6:
					System.out.print("Enter number of high quality dishes(1 to 5):");
					Integer nrOfHighQualityDishes = inputFromPlayer(5);
					
					for(int i = 0; i < dishMenu.size(); i++){
						if(i < nrOfHighQualityDishes){
							dishMenu.get(i).setQualityLevel(QualityLevel.HIGH);
						}else{
							dishMenu.get(i).setQualityLevel(QualityLevel.LOW);
						}
					}
					break;
				case 7:
					System.out.print("Enter number of high quality beverages(1 to 5):");
					Integer nrOfHighQualityBeverages = inputFromPlayer(5);
					
					for(int i = 0; i < beverageMenu.size(); i++){
						if(i < nrOfHighQualityBeverages){
							beverageMenu.get(i).setQualityLevel(QualityLevel.HIGH);
						}else{
							beverageMenu.get(i).setQualityLevel(QualityLevel.LOW);
						}
					}
					break;
				case 8:
					finished = true;
					break;
				default:
					System.out.println("Oops! Something is wrong with the inserted action!");
					break;
			}
		}
	}

	private static void printMenu( ) {
		System.out.println("\n\tMENU");
		List<Dish> dishMenu = player.getRestaurant().getDishes();
		for(MenuItem item : dishMenu){
			System.out.println("\t" + item.name + "\t\t\tPrice: " + item.getPrice() + "\tQuality: " + item.qualityLevel);
		}
		List<Beverage> beverageMenu = player.getRestaurant().getBeverages();
		for(MenuItem item : beverageMenu){
			System.out.println("\t" + item.name + "\t\t\tPrice: " + item.getPrice() + "\tQuality: " + item.qualityLevel);
		}
		System.out.println();
	}
	
	private static void startDay( ) {
		
		for (Waiter w : player.getRestaurant().getWaiters()) {
			w.nrOfTablesAssigned = 0;
		}
		
		assignWaitersToTables();
		
		List<Client> clients = new ArrayList<Client>();
		chooseClients(clients);
		
		System.out.println("------ End of a Day ---------");
		
		// Pay salaries and if budget is negative, quit game
		if (Arrays.asList(daysOfWeekends).contains(currentDay)) {
			
			System.out.println("A week is passed: paying salaries and costs!");
			Restaurant restaurant = player.getRestaurant();
			
			Chef chef = restaurant.getChef();
			player.getRestaurant().payWeeklySalaries(chef.computePay());
			
			Barman barman = restaurant.getBarman();
			player.getRestaurant().payWeeklySalaries(barman.computePay());
			
			for(Waiter w : restaurant.getWaiters()){
			player.getRestaurant().payWeeklySalaries(w.computePay());
			}
			
			player.getRestaurant().paySuppliers();
		}
		
		initializeWaiter();
		initializeTables();
		clientsLeaveRestaurant();
		clients = null;
		currentDay++;
		
	}

	private static void clientsLeaveRestaurant( ) {
		for (Person p : persons) {
			p.setcurrentlyClient(false);
		}
	}

	private static void initializeTables( ) {
		
		for (Table t : player.getRestaurant().tables) {
			t.waiter = null;
		}
		
	}

	private static void initializeWaiter( ) {
		
		List<Waiter> waiters = player.getRestaurant().getWaiters();
		
		for (Waiter w : waiters) {
			w.nrOfTablesAssigned = 0;
		}
		
	}

	private static void assignWaitersToTables( ) {
		/**
		 * Randomly assigns tables for waiters who have less than 3 tables assigned
		 */
		
		List<Waiter> waiters = player.getRestaurant().getWaiters();
		Collections.shuffle(waiters);
		

		for (Table t : player.getRestaurant().tables) {
			for (Waiter w : waiters) {
				if (w.nrOfTablesAssigned <= 3) {
					t.waiter = w;
					w.nrOfTablesAssigned++;
					break;
				}
			}
		}
	}

	private static void chooseClients( List<Client> clients ) {
		
		int reputation = player.getRestaurant().reputation;
		
		List<Person> personsToChooseFrom = new ArrayList<Person>(persons.size());
		personsToChooseFrom.addAll(persons);
		Collections.shuffle(personsToChooseFrom);
		
		List<Table> tablesToChooseFrom = new ArrayList<Table>(player.getRestaurant().tables.size());
		tablesToChooseFrom.addAll(player.getRestaurant().tables);
				
		if (reputation < 15) {
			System.out.println("2 tables filled with clients. Rise reputation!");
			for (int i = 1; i<=2; i++) {
				generateClient(clients, personsToChooseFrom, tablesToChooseFrom);
			}
		}
		else if (reputation > 29) {
			System.out.println("All tables filled with clients. WOW!");
			for (int i = 1; i<=9; i++) {
				generateClient(clients, personsToChooseFrom, tablesToChooseFrom);
			}
		}
		else {
			System.out.println("5 tables filled with clients. Good!");
			for (int i = 1; i<=5; i++) {
				generateClient(clients, personsToChooseFrom, tablesToChooseFrom);
			}
		}
		
	}

	private static void generateClient( List<Client> clients, List<Person> personsToChooseFrom, List<Table> tablesToChooseFrom ) {
		
		// Pick random table from empty tables
		Random randomGenerator = new Random();
		int indexOfTable = randomGenerator.nextInt(tablesToChooseFrom.size());
        Table t = tablesToChooseFrom.get(indexOfTable);
		
        // Assign two clients to that table
        for (int i = 1; i<=2; i++) {
			for (Person p : personsToChooseFrom) {
				if (p.getcurrentlyClient() == false) {
					
					clients.add(new Client(p,t));
					p.setcurrentlyClient(true);
					
					personsToChooseFrom.remove(p);
					
					break;
				}
			}
		}
        
        // That table is full now
		tablesToChooseFrom.remove(t);
		
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
		
		Integer input = inputFromPlayer(6);
		
		Employee employee = null;
		switch (input) {
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
			case 6:
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
		System.out.println("2. View ranking list");
		System.out.println("3. Quit");
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

			System.out.println(">>> Current RANKING LIST");
			System.out.println(">>> Player\tScore");
			
			String line = null;
			if (file.length() == 0) {
				System.out.println(">>> Ranking list is empty! Start a new game!");
			}
			while ((line = br.readLine()) != null) {
				System.out.println(">>> " + line);
			}
		 
			br.close();
		}
	}
	private static void updateRankings( ) throws IOException {
		
		try{
 
    		File dir = new File(".");
    		File file = new File(dir.getCanonicalPath() + File.separator + "ranking.txt");
    		
    		if(!file.exists()) {
    		    file.createNewFile();
    		    System.out.println("No ranking list existed, created one.");
    		}
    		
    		String playerStats = player.getName() + "\t" + player.getRestaurant().getBudget() + "\n";
 
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write(playerStats);
	        bufferWritter.close();
 
	        System.out.println("Ranking list updated.");
	        
 
    	}catch(IOException e){
    		e.printStackTrace();
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
		System.out.println("2. Design menu");
		System.out.println("3. Start day / Open restaurant");
		System.out.println("4. Quit game");
	}
	
	private static void clearScreen( ) {
		for(int i = 0; i < 2; i++){
			System.out.println();
		}
	}
	
}
