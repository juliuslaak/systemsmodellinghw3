import java.io.BufferedReader;
import java.util.Timer;
import java.io.FileReader;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.TimerTask;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.IOException;



public class GameController extends TimerTask {
	
	static BufferedReader in;
	
	private static Player player;
	
	private static int currentDay;
	
	
	private static final long DAY_LENGTH = 1000;
	
	
	private static RankingList rankingList;
	
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
	 */
	private static void showTrainingOptions( ) {
		//TODO
		System.out.println("Table of workers should be here ...");
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
		System.out.println("4. Quit game\n");
	    
		System.out.print("Enter action number: ");
	}
	
	private static void clearScreen( ) {
		for(int i = 0; i < 2; i++){
			System.out.println();
		}
	}


	/**
	 * Operations that will be done in the beginning of every new day
	 */
	@Override
	public void run( )
	{
		
	}
	
	

	private static void showRankings( RankingList rankingList )
	{
		
	}
	
	
}
