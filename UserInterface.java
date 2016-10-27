package edu.cpp.cs.cs141.prog_assignment_2;

import java.util.Scanner;

import edu.cpp.cs.cs141.prog_assignment_2.GameEngine.GameState;

/**
 * @author Samuel Holt
 *
 */
public class UserInterface {
	
	/**
	 * Running the game with an enum switch.
	 */
	public void gameLoop(){
		GameEngine game = new GameEngine();
		printWelcome();
		game.chooseGun(getGunChoice());
		
		while(game.currentState != GameState.WON && game.currentState != GameState.LOST){
			switch(game.currentState){
			case TURN:
				printCurrentStats(game);
				game.currentState = game.takeTurn();
				break;
			case MINIGAME:
				printCurrentStats(game);
				System.out.print("You encountered an enemy!");
				game.currentState = miniGame(game);
				break;
			case WON:
				System.out.print("You won the game!");
				break;
				default:
					System.out.print("Shouldn't hit.");
			}
		}
		
		System.out.print("You " + game.currentState);
	}
	
	/**
	 * Running the game with a do while.
	 */
	public void runGame(){
		GameEngine game = new GameEngine();
		boolean won = false;
		
		printWelcome();
		game.chooseGun(getGunChoice());
		
		do{
			//takeStep();
			game.takeTurn();
			printCurrentStats(game);
			
			if(game.currentPlayer.getCurrentPosition() == 0)
				won = true;
		}while(!won);
		
		System.out.print("You won the game!");
	}
	
	/**
	 * This method will return true if the user enters {@code 1} to
	 * take a step.  Otherwise, it will keep asking for the user to 
	 * enter 1.
	 * @return
	 * true
	 * 
	 */
	public boolean takeStep(){
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		boolean invalid = true;
		
		do{
			System.out.print("Enter 1 to take one step: ");
			choice = keyboard.nextInt();
			if(choice != 1)
				invalid = false;
			else
				System.out.println("Invalid Choice!\n");
		}while(invalid);
		
		keyboard.close();
		return true;
	}
	
	/**
	 * This method will return true if the user enters {@code 1} to
	 * take a step.  Otherwise, it will keep asking for the user to 
	 * enter 1.
	 * @return
	 * true
	 * 
	 */
	public int getMiniGameChoice(){
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		boolean invalid = true;
		String debug = null;
		
		do{
			System.out.print("Press 1 to shoot or 2 to try to escape: ");

		    choice = keyboard.nextInt(); 
			
			if(choice == 1 || choice == 2)
				invalid = false;
			else
				System.out.println("Invalid Choice!\n");
		}while(invalid);
		
		keyboard.close();
		return choice;
	}
	
	/**
	 * This method will obtain an integer representation of the
	 *  choice of {@link Gun} from the user.
	 * 
	 * @return choice
	 */
	public int getGunChoice(){
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		boolean invalid = true;
		
		do{
			System.out.print("Which gun would you like? Enter 1 for Pistol, 2 for Rifle, or 3 for Shotgun: ");
			choice = keyboard.nextInt();
			if(isValidGunChoice(choice))
				invalid = false;
			else
				System.out.println("Invalid Choice!\n");
		}while(invalid);
		
		keyboard.close();
		return choice;
	}
	
	/**
	 * This method will determine if the user's entered choice is valid.
	 * 
	 * @param choice
	 * @return isValidGunChoice
	 */
	private boolean isValidGunChoice(int choice){
		if(choice == 1 || choice == 2 || choice == 3){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This method runs the encounter Minigame.
	 * 
	 * @return
	 */
	public GameState miniGame(GameEngine game){
		Enemy hostile = new Enemy();
		GameState returnState = null;
		boolean playing = true;
		int choice = 0;
		int shot = -1;
		int hostileShot = -1;
		
		System.out.print("Enemy encountered!");
		
		do{
			
			choice = getMiniGameChoice();
			
			if(choice == 1){
				// player takes a shot
				shot = game.currentPlayer.fire();
				
				
				if(shot != 0){
					// the player shot hits
					
					hostile.takeDamage(shot);
					System.out.println("Hostile took " + shot + " damage!");
					
					
					if(hostile.getCurrentHitpoints() <= 0){
						// hostile is dead
						System.out.println("You defeated the hostile!");
						// TODO give an item
						playing = false;
						returnState = GameState.TURN;
					}else{
						// hostile still alive
						
						// hostile takes a shot
						hostileShot = hostile.fire();
						
						
						if(hostileShot != 0){
							// the hostile shot hits
							
							game.currentPlayer.takeDamage(hostileShot);
							System.out.println("You took " + hostileShot + " damage!");
							
							
							if(game.currentPlayer.getCurrentHitpoints() <= 0){
								// player is dead
								playing = false;
								returnState = GameState.LOST;
							}else{
								// player is alive
							}
						}else{
							// the hostile shot misses
							System.out.println("The hostile missed!");
						}
					}
				}else{
					// the player shot misses
					System.out.print("You missed!");
					
				}
			}else{
				
				// TODO player tries to run
				returnState = GameState.TURN;
				
			}
		}while(playing);
		
		return returnState;
	}
	
	/**
	 * This method prints stats about the current game.
	 * 
	 * @param game
	 */
	public void printCurrentStats(GameEngine game){
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Current Position: " + game.currentPlayer.getCurrentPosition());
		System.out.println("Current Health: " + game.currentPlayer.getCurrentHitpoints());
		System.out.println("Current Ammo: " + game.currentPlayer.getCurrentAmmo());
		System.out.println("------------------------------");
		System.out.println();
	}
	
	public void printWelcome(){
		System.out.println("Welcome to Escape the Dungeon!");
		System.out.println();
	}

}
