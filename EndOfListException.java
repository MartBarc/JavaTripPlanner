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
 * 	This EndOfListException is an extension of the Exception class. Used when
 * the node has reached the end of its respective list.
 */
/**--------------------------------------------------------------------------*/

public class EndOfListException extends Exception 
{
	public EndOfListException(String exception) 
	{
		super(exception);
	}
}