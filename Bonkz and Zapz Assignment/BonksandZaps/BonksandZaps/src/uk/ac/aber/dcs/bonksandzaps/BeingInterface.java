package uk.ac.aber.dcs.bonksandzaps;

import javax.swing.text.Position;

/**
 * Represents an inhabitant of GridWorld
 * 
 * @author cwl
 * @version 1.0
 */
public abstract interface BeingInterface {

	/**
	 * Every inhabitant on GridWorld must have a name given to them at birth or
	 * creation. It is fixed, but can be discovered via this method
	 * 
	 * @return The name
	 */
	public String getName();

	/**
	 * When called the Being does its stuff, e.g. move. So this represents
	 * behaviour. What this is will vary between different kinds of Being
	 * 
	 * @throws CannotActException
	 *             Thrown if the state of the Being prevents it from acting
	 */
	public void act();

	/**
	 * Returns the current location of the Being (which Room it's in)
	 * 
	 * @return Returns a Position that encapsulates its coordinates in Grid
	 *         World
	 */
	public Location getLocation();

	/**
	 * Allows the relocation of the Being to another Room in Grid World
	 * 
	 * @param location
	 */
	public void setLocation(Location location);

	public Gender getGender();

	public boolean hasMated();

	public void isAlive();

}
