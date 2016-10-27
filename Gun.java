/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #2
 *
 * You will implement a mini-game of Escape the Dungeon! 
 * When the game starts, the player is 10 steps away from the dungeon's exit. 
 * On every turn there's only one action, 'Take one step', and with each step the player 
 * is closer to the exit.
 *
 *
 * Samuel Holt
 */

package edu.cpp.cs.cs141.prog_assignment_2;

/**
 * 
 * An abstract class representing the gun objects. 
 * Each type of gun is represented by a respective subclass that is a 
 * subtype of the Gun class.
 * 
 * @author Samuel Holt
 *
 */
public abstract class Gun {
	
	/**
	 * This field represents the {@link #damage} value of the {@link Gun}.
	 * This will determine how much {@link #damage} the {@link Gun} will do
	 * to the target.
	 */
	private int damage;
	
	/**
	 * This field represents the accuracy
	 * percentage of the {@link Gun}.  This field is used
	 * as a percent chance of hitting the target.
	 */
	private int accuracy;
	
	/**
	 * This field represents the current
	 * {@link #ammo} value of the {@link Gun}.  This is used
	 * to determine if the {@link Gun} is able to {@link #shoot()}.
	 * By default, the field is initialized to the {@link #maxAmmo}
	 * value of the gun.  The field can be changed by the {@link #reload()}
	 * method.
	 */
	private int ammo;
	
	/**
	 * This field represents the maximum
	 * {@link #ammo} value of the gun.
	 */
	private int maxAmmo;
	
	/**
	 * The default constructor for the {@link Gun}.
	 * @param damage
	 * @param accuracy
	 * @param maxAmmo
	 */
	public Gun(int damage, int accuracy, int maxAmmo){
		this.damage = damage;
		this.accuracy = accuracy;
		this.maxAmmo = maxAmmo;
		this.ammo = maxAmmo;
	}
	
	/**
	 * Returns the current {@link #damage} value.
	 * 
	 * @return
	 * {@link #damage}
	 */
	public int getDamage(){
		return damage;
	}
	
	/**
	 * Returns the current {@link #ammo} value.
	 * 
	 * @return
	 * {@link #ammo}
	 */
	public int getAmmo(){
		return ammo;
	}
	
	/**
	 * Returns the {@link #accuracy} value of the {@link Gun}.
	 * 
	 * @return
	 * {@link #accuracy}
	 */
	public int getAccuracy(){
		return accuracy;
	}
	
	/**
	 * This method takes one shot away from
	 * the {@link Gun} by subtracting one from the
	 * {@link #ammo} value.
	 */
	public void takeShot(){
		ammo--;
	}
	
	/**
	 * This method will reset the {@link #ammo} value to
	 * the value of {@link #maxAmmo}.
	 */
	public void refillClip(){
		ammo = maxAmmo;
	}
	
	/**
	 * This method will use the {@link #hit} method to determine if the target was hit based on the 
	 * {@link #accuracy} percentage of the gun.  The method will subtract one from the {@link #ammo} value.
	 * The method will return an {@code int} with the amount of {@link #damage} given to the target.  If the target is missed,
	 * the method will return {@code 0}.  If the gun is out of {@link #ammo}, the method
	 * returns {@code -1}.
	 */
	public int shoot() {
		if(getAmmo() != 0){
			takeShot();
			if(hit()){
				return getDamage();
			}else{
				return 0;
			}
		}else{
			return -1;
		}
	}
	
	/**
	 * 
	 * This method returns {@code true} if the target was {@link #hit()} and
	 * {@code false} if the target was missed.  This is determined using
	 * the {@link #accuracy} value of the {@link Gun}.  This method should
	 * only be used to determine if a target was {@link #hit()} using the
	 * {@link #shoot()} method, therefore the method is {@code private}.
	 */
	private boolean hit(){
		
		/**
		 * Generate a random int between 0 and 100.
		 */
		int percentChance = (int) (Math.random() * 100);
		
		/**
		 * If the random int generated above is less than the accuracy value, then the target was hit.
		 */
		if(percentChance < getAccuracy()){
			return true;
		}else{
			return false;
		}
	}
	
	

}
