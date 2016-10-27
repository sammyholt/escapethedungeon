/**
 * 
 */
package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * @author Samuel Holt
 *
 */
public class HealthPack implements Item {
	
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
	public int getHp(){
		return hpReplenished;
	}
}
