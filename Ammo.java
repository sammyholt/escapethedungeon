/**
 * 
 */
package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * @author Samuel Holt
 *
 */
public class Ammo implements Item {
	
	/**
	 * This field represents the 
	 * amount of hitpoints that
	 * the {@link HealthPack} will replenish.
	 */
	private int hpReplenished = 5;
	
	/**
	 * 
	 * This method returns the {@link #hpReplenished} by the {@link HealthPack}.
	 * 
	 * @return
	 * {@link #hpReplenished}
	 */
	public int getHpReplenished(){
		return hpReplenished;
	}
	
	/**
	 * This method will add the value of {@link #hpReplenished} to the {@link Player}'s hitpoints.
	 * If the added value is bigger than the {@link Player}'s maximum health, the method will heal
	 * the {@link Player} to full maximum health.
	 * 
	 * @param currentPlayer
	 */
	public void healPlayer(Player currentPlayer){
		// TODO
	}

}
