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
 * 	This EndOfItineraryException is an extension of the Exception class. Used
 * when the node is read as null.
 */
/**--------------------------------------------------------------------------*/

public class EndOfItineraryException extends Exception 
{
	public EndOfItineraryException(String exception) 
	{
		super(exception);
	}
}