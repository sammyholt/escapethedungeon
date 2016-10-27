package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * @author Samuel Holt
 *
 */
public class Enemy implements ActiveAgent {
	
	/**
	 * This field represents the {@link #maxHitpoints} value
	 * of the {@link Enemy}.
	 */
	private int maxHitpoints;
	
	/**
	 * This field represents the {@link #currentHitpoints} value
	 * of the {@link Enemy};
	 */
	private int currentHitpoints;
	
	/**
	 * This field represents the {@link Gun} an {@link Enemy} spawns with.
	 */
	public Gun enemyWeapon;
	
	/**
	 * The default constructor for the {@link Enemy}.
	 */
	public Enemy(){
		maxHitpoints = 5;
		currentHitpoints = maxHitpoints;
		
		// Generate a random int between 0 and 100.
		int percentChance = (int) (Math.random() * 100);
		
		// determine which gun the enemy spawns with
		if(percentChance >= 0 && percentChance < 50){
			// pistol
			enemyWeapon = new Pistol();
		}else if(percentChance >= 50 && percentChance <= 85){
			// rifle
			enemyWeapon = new Rifle();
		}else{
			// shotgun
			enemyWeapon = new Shotgun();
		}
	}
	
	/**
	 * This method returns the {@link #currentHitpoints} value
	 * of the {@link Enemy}.
	 * @return
	 * {@link #currentHitpoints}
	 */
	public int getCurrentHitpoints(){
		return currentHitpoints;
	}
	
	/**
	 * This method allows the {@link Enemy} to {@link #fire()} the {@link Gun};
	 * @return
	 * damage
	 */
	public int fire(){
		return enemyWeapon.shoot();
	}
	
	/**
	 * This method will allow the {@link Enemy} to {@link #takeDamage(int)}.
	 * If the amount will cause the {@link Enemy} to fall to or below zero, the {@link #currentHitpoints}
	 * will be set to zero.
	 * 
	 * @param amount
	 */
	public void takeDamage(int amount){
		if((currentHitpoints - amount) <= 0){
			currentHitpoints = 0;
		}else{
			currentHitpoints -= amount;
		}
	}

}
