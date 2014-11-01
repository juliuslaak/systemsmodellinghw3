import java.util.Scanner;


public class GameController {
	
	private static final long DAY_LENGTH = 1000; //day length in milliseconds
	private static Scanner in;
	
	private static Player player;
	private static RankingList rankingList;
	
	private static int currentDay;
	
	public static void main( String[] args ) {
		
	    in = new Scanner(System.in);
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
			int input = in.nextInt();
			
			switch (input) {
				case 1:
					startGame();
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


	private static void clearScreen( ) {
		for(int i = 0; i < 10; i++){
			System.out.println();
		}
	}


	private static void showRankings( RankingList rankingList ) {
		// TODO Auto-generated method stub
		System.out.println("Here are the rankings");
	}


	private static void showMainMenu( ) {
		System.out.println("***RESTAURANT GAME***\n");
		
		System.out.println("Menu:");
		System.out.println("1. Start new game");
		System.out.println("2. View high score");
		System.out.println("3. Quit");
		
		System.out.print("Enter number:");
	}
	
	private static void startGame( ) {
		player = new Player();
		
		currentDay = 1;
		long beginTime = System.currentTimeMillis();
		boolean correctInput = true;
		
		while(currentDay <= 30){
			
			//If previous input was wrong print error message
			if(!correctInput){
				System.out.println("Wrong input!\n");
				correctInput = true;
			}
			
			showGameStateAndOperations();
			int operationNr = in.nextInt();
			
			switch (operationNr) {
				case 1:
					break;
				case 2:
					break;
				default:
					correctInput = false;
					break;
			}
			
			
			//Calculates current day
			long timePassed = System.currentTimeMillis() - beginTime;
			if( timePassed > DAY_LENGTH){
				currentDay = currentDay + (int)(timePassed / DAY_LENGTH);	
				beginTime = System.currentTimeMillis();
			}
			
			clearScreen();
		}
	}

    /**
	 * Prints everything that user has to see ...
	 */
	private static void showGameStateAndOperations( ) {
		//TODO
		System.out.println("HERE SHOULD BE ALL THE STUFF THAT PLAYER NEEDS TO SEE!");
	}

}
