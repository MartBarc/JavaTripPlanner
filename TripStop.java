/**-------------------------------------Info---------------------------------*/
/**
 *		Name: 						Date:					Current Version:
 *		Martin Barcelon				09-20-2016				1.0
 *
 *		Email:					
 *		martin.barcelon@stonybrook.edu
 *
 *		Student ID:					Section Number:
 *		110250249					R05
 */
/**-------------------------------Short Description--------------------------*/
/**	
 * 	This object contains the private data fields Location, Distance, and 
 *  Activity.  TripStop is mutable, with set methods and get methods for each
 *  of the fields. The Distance field throws an IllegalArgumentException when
 *  the distance entered is less than 0. The constructor sets Location to "",
 *  Distance to 0, and Activity to "".
 */
/**--------------------------------------------------------------------------*/

public class TripStop {

	/**	
	 * 	Sets Location, Distance and Activity to a private field.
	 */
	private String Location;
	private int Distance;
	private String Activity;

	/**	
	 * 	This default constructor which sets Location to "", Distance to 0, and
	 * Activity to "".
	 */
	public TripStop()
	{
		this.Location="";
		this.Distance=0;
		this.Activity="";
	}
	/**	
	 * 	This overloaded constructor takes 3 field parameters and sets them
	 * to Location, Activity and Distance. When distance is less than 0, the
	 * constructor throws an IllegalArgumentException.
	 * 
	 * @param  location-an string giving the location of the trip stop.
	 * @param  activity-an string giving the activity of the trip stop.
	 * @param  distance-an integer giving the distance relative to the trip 
	 * 					stop.
	 * @throws IllegalArgumentException-if the distance is less than 0.
	 */
	public TripStop(String location, String activity, int distance) 
			throws IllegalArgumentException
	{
		this.Location=location;
		this.Activity=activity;
		if (distance>=0)
		{
			this.Distance=distance;
		}
		else
		{
			throw new IllegalArgumentException("ERROR: Invalid Input");
		}
	}

	/**	
	 * 	Sets the entered string to the Location of the TripStop object.
	 * 
	 * @param input-the string giving the location of the trip stop.
	 */
	public void setLocation(String input)
	{
		this.Location=input;
	}

	/**	
	 * 	Returns the String Location from the object.
	 * 
	 *  @return the location of the specified TripStop.
	 */
	public String getLocation()
	{
		return this.Location;
	}

	/**	
	 * Sets the entered integer to the distance of the TripStop object. Also
	 * throws an IllegalArgumentException when input is less than 0.
	 * 
	 * @param  input-an integer giving the distance relative to the trip stop.
	 * @throws IllegalArgumentException-if the distance is less than 0.
	 */
	public void setDistance(int input) throws IllegalArgumentException
	{
		if (input>=0)
		{
			this.Distance=input;
		}
		else
		{
			throw new IllegalArgumentException("Invalid Input");
		}
	}

	/**
	 * Returns the integer Distance from the object.
	 * 
	 * @return the distance relative to the trip stop.
	 */
	public int getDistance()
	{
		return this.Distance;
	}

	/**
	 * Sets the entered string to the activity of the TripStop object.
	 * 
	 * @param input-an string giving the activity of the trip stop.
	 */
	public void setActivity (String input)
	{
		this.Activity = input;
	}

	/**
	 * Returns the String Activity from the object.
	 * 
	 * @return the activity of the specified TripStop.
	 */
	public String getActivity()
	{
		return this.Activity;
	}

	/**
	 * Returns a formatted string consisting of all the data fields. This 
	 * method was used solely for testing purposes.
	 * 
	 * @return all three data fields.
	 */
	public String toString()
	{
		return (this.Location+" "+this.Activity+" "+this.Distance);
	}
}
