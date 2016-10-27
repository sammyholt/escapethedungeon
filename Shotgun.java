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
 * This class represents a {@link Shotgun}.
 * 
 * The {@link Shotgun} has a {@link #damage} value of
 * {@code 5}, an {@link #accuracy} value of {@code 40}, and 
 * a {@link #maxAmmo} value of {@code 5}.
 * 
 * @author Samuel Holt
 *
 */
public class Shotgun extends Gun {
	
	/**
	 * The default constructor for the {@link Shotgun}.
	 */
	public Shotgun(){
		// Damage value 5, Accuracy 40%, Max Ammo 5
		super(5, 40, 5);
	}

}
