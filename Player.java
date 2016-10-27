/**
 * 
 */
package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * @author Samuel Holt
 *
 */
public class Player implements ActiveAgent {
	
	/**
	 * This field represents the {@link #maxHitpoints} value
	 * of the {@link Player}.  This field can only be modified
	 * by the constructor.
	 */
	private int maxHitpoints;
	
	/**
	 * This field represents the {@link #currentHitpoints} value
	 * of the {@link Player}.  This field can be modified by 
	 * taking damage from an {@link Enemy} or by receiving a
	 * {@link HealthPack}.
	 */
	private int currentHitpoints;
	
	/**
	 * This field represents the {@link #currentPosition} of the
	 * {@link Player} in the dungeon.  This field can only be modified
	 * by the constructor.
	 */
	private int currentPosition;
	
	/**
	 * This field represents the {@link Player}'s chosen {@link Gun}.
	 */
	private Gun chosenGun;
	
	/**
	 * The default constructor for the {@link Player}.
	 */
	public Player(){
		maxHitpoints = 20;
		currentHitpoints = maxHitpoints;
		currentPosition = 10;
		chosenGun = null;
	}
	
	/**
	 * This method allows the player to {@link #fire()} the {@link Gun};
	 * @return
	 * damage
	 */
	public int fire(){
		return chosenGun.shoot();
	}
	
	/**
	 * This method will set the {@link #chosenGun} of
	 * the {@link Player}.
	 * 
	 * @param currentGun
	 */
	public void setGun(Gun currentGun){
		chosenGun = currentGun;
	}
	
	/**
	 * This method will reload the current {@link Gun} to the
	 * maximum ammo level.
	 */
	public void reload(){
		chosenGun.refillClip();
	}
	
	/**
	 * Returns the current ammo level of the {@link Player}'s {@link Gun}.
	 * @return ammo
	 */
	public int getCurrentAmmo(){
		return chosenGun.getAmmo();
	}
	
	/**
	 * This method will return the {@link #currentHitpoints}.
	 * 
	 * @return
	 * currentHitpoints
	 */
	public int getCurrentHitpoints(){
		return currentHitpoints;
	}
	
	/**
	 * This method will allow the {@link Player} to {@link #takeDamage(int)}.
	 * If the amount will cause the player to fall to or below zero, the {@link #currentHitpoints}
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
	
	/**
	 * This method will {@link #heal()} the player using a {@link HealthPack}.
	 * It will add the hitpoints value of the pack to the {@link Player}'s {@link #currentHitpoints},
	 * or replenish the {@link Player} to {@link #maxHitpoints}.
	 * @param pack
	 */
	public void heal(HealthPack pack){
		if((pack.getHp() + currentHitpoints) >= maxHitpoints){
			currentHitpoints = maxHitpoints;
		}else{
			currentHitpoints += pack.getHp();
		}
	}
	
	/**
	 * This method returns the {@link #currentPosition} of the {@link Player}.
	 * @return
	 */
	public int getCurrentPosition(){
		return currentPosition;
	}
	
	/**
	 * This method will subtract one from the
	 * {@link Player}'s {@link #currentPosition}.
	 */
	public void moveForward(){
		currentPosition--;
	}
	
	/**
	 * This method will add one to the
	 * {@link Player}'s {@link #currentPosition}.
	 */
	public void moveBackward(){
		currentPosition++;
	}
}
