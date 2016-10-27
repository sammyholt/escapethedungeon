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
 * This class represents a {@link Pistol}.
 * 
 * The {@link Pistol} has a {@link #damage} value of
 * {@code 1}, an {@link #accuracy} value of 75, and 
 * a {@link #maxAmmo} value of 15.
 * 
 * @author Samuel Holt
 *
 */
public class Pistol extends Gun {
	
	/**
	 * The default constructor for the {@link Pistol}.
	 */
	public Pistol(){
		// Damage value 1, Accuracy 75%, Max Ammo 15
		super(1, 75, 15);
	}

}
