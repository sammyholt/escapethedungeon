package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * @author Samuel Holt
 *
 */ 
public class GameEngine {
	
	/**
	 * This field represents the 
	 * current {@link Player} of the game.
	 */
	public Player currentPlayer;
	
	/**
	 * This field represents the current state of the game.
	 */
	public GameState currentState;
	
	/**
	 * This enum is used to represent the current state of the game.
	 * 
	 * @author Samuel Holt
	 *
	 */
	public enum GameState{
		WON, LOST, TURN, MINIGAME
	}
	
	/**
	 * This is the default constructor for the {@link GameEngine}.
	 */
	public GameEngine(){
		currentPlayer = new Player();
		currentState = GameState.TURN;
	}
	
	/**
	 * This method will be used to move the 
	 * user forward one space and decide if
	 * a random encounter will occur.
	 */
	public GameState takeTurn(){
		// initialize variables used for chance calculation
		int chanceOfEncounter = 15;
		int randomInt = (int) (Math.random() * 100);
		
		// move Player forward
		currentPlayer.moveForward();
		
		if(randomInt < chanceOfEncounter){
			return GameState.MINIGAME;
		}else if(playerWon()){
			return GameState.WON;
		}else if(playerLost()){
			return GameState.LOST;
		}else{
			return GameState.TURN;
		}
	}
	
	/**
	 * This method returns true if the player has
	 * met a game losing condition.  The only game losing condition
	 * is dying.
	 * @return
	 * playerLost
	 */
	public boolean playerLost(){
		if(currentPlayer.getCurrentHitpoints() <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This method returns true if the player has
	 * met a game winning condition.  The only game winning condition
	 * is reaching the last position.
	 * @return
	 * playerWon
	 */
	public boolean playerWon(){
		if(currentPlayer.getCurrentPosition() <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This method will set the {@link Gun} of the {@link Player}.
	 * 
	 * @param choice
	 */
	public void chooseGun(int choice){
		switch(choice){
		case 1:
			currentPlayer.setGun(new Pistol());
			break;
		case 2:
			currentPlayer.setGun(new Rifle());
			break;
		case 3:
			currentPlayer.setGun(new Shotgun());
			break;
		default:
			currentPlayer.setGun(new Pistol());
			break;
		}
	}

}
