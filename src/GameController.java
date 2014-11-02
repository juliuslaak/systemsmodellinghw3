import java.io.BufferedReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;



public class GameController {
	
	private static final long DAY_LENGTH = 1000; //day length in milliseconds
	private static Scanner in;
	
	private Player player;
	private RankingList rankingList;
	
	private static int currentDay;
	
	public static void main( String[] args ) {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		rankingList = new RankingList();
		boolean running = true;
		boolean correctInput = true;
		
		while(running){
			
			//If previous input was wrong print error message
			if(!correctInput){
				System.out.println("Wrong input!\n");
				correctInput = true;
			}
			
			showMainMenu();
			int input = -1;
			try {
				input = Integer.parseInt(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			switch (input) {
				case 1:
					try {
						startGame();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					showRankings(rankingList);
					break;
				case 3:
					running = false;
					System.out.println("Exiting game!");
					break;
				default:
					correctInput = false;
					break;
			}
			
			clearScreen();
		}

	}

	private static void startGame( ) {
		
		player = new Player();
		
		currentDay = 0;
		
		//Timer for counting days
		Timer timer = new Timer();
		timer.schedule(new GameController(), 0, DAY_LENGTH);
		
		boolean correctInput = true;
		boolean quitGame = false;
		
		while(currentDay <= 30 && !quitGame){
			
			//If previous input was wrong print error message
			if(!correctInput){
				System.out.println("Wrong input!\n");
				correctInput = true;
			}
			
			showGameStateAndOperations();
			int operationNr = Integer.parseInt(in.readLine());
			
		
			switch (operationNr) {
				//train workers
				case 1:
					showTrainingOptions();
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
				//Quit to main menu
				case 4:
					System.out.println("Are you sure you wish to quit game?(y/n)");
					String answer = in.readLine();
					if(answer.equals("y")){
						quitGame = true;
						timer.cancel();
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
			
			clearScreen();
		}
	}
	
	/**
	 * Shows table of workers together with their level of experience
	 * and cost of training.
	 */
	private static void showTrainingOptions( ) {
		//TODO
		System.out.println("Table of workers should be here ...");
	}

	private static void showMainMenu( ) {
		System.out.println("***THE RESTAURANT OWNER***\n");
		
		System.out.println("Menu:");
		System.out.println("1. Start new game");
		System.out.println("2. View high score");
		System.out.println("3. Quit");
		
		System.out.print("Enter number:");
	}

    
	private static void showRankings( RankingList rankingList ) {
		// TODO Auto-generated method stub
		System.out.println("Here should be the rankings");
	}

    /**
	 * Prints everything that user has to see ...
	 */
	private static void showGameStateAndOperations( ) {
	
		System.out.println("--------------------------------------------");
		System.out.println("Day: " + Integer.toString(currentDay) + "\tBudget: " + player.getRestaurant().getBudget() + 
				"\tPlayer:" + player.getName()+"\n\n");
		System.out.println("1. Train workers");
		System.out.println("2. Assign tables");
		System.out.println("3. Design menu");
		System.out.println("4. Quit game");
	    
		System.out.println("Enter number:");
	}
	
	private static void clearScreen( ) {
		for(int i = 0; i < 10; i++){
			System.out.println();
		}
	}
	
	/**
	 * Operations that will be done in the beginning of every new day
	 */
	@Override
	public void run( ) {
		//TODO
		currentDay+=1;
	}

}
