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
 * This class represents a {@link Rifle}.
 * 
 * The {@link Rifle} has a {@link #damage} value of
 * {@code 2}, an {@link #accuracy} value of 65, and 
 * a {@link #maxAmmo} value of 10.
 * 
 * @author Samuel Holt
 *
 */
public class Rifle extends Gun {
	
	/**
	 * The default constructor for the {@link Rifle}.
	 */
	public Rifle(){
		// Damage value 2, Accuracy 65%, Max Ammo 10
		super(2, 65, 10);
	}
}
