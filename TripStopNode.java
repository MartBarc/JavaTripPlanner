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
 * 	This node contains the TripStop data. As a node part of a doubly linked
 * list, it connects with previous node and nodes next to itself. These nodes
 * are stored as private fields. The data is stored as private as well. The
 * constructor takes data and sets it to TripStop data as well as setting the
 * next node null and the previous node null. This node is mutable, with set 
 * and get methods for the data, previous nodes and next nodes. The constructor
 *  and setData methods throw an IllegalArgumentException when the data input
 *  is null.
 */
/**--------------------------------------------------------------------------*/

public class TripStopNode {

	/**
	 * Sets the TripStop data,TripStopNode next, and TripStopNode prev to a
	 * private field.
	 */
	private TripStop data;
	private TripStopNode next;
	private TripStopNode prev;

	/**
	 * The constructor for the object sets the previous node to null and the
	 * next node to null. It also takes TripStop initData and sets it to
	 * the TripStopNode's data. Throws an IllegalArgumentException when
	 * initData is null.
	 * 
	 * @param initData-the data containing information on location,activity and
	 * 				   distance of the trip stop.
	 * @throws IllegalArgumentException-if the input data is null.
	 */
	public TripStopNode(TripStop initData) throws IllegalArgumentException
	{
		if (initData != null)
		{
		this.data=initData;
		}
		else
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		this.next=null;
		this.prev=null;
	}
	
	/**
	 * Returns the specified TripStopNode TripStop data.
	 * 
	 * @return the data containing location, activity and distance of the trip
	 * 		   stop.
	 */
	public TripStop getData()
	{
		return this.data;
	}
	
	/**
	 * Sets the input data to the specified TripStopNode data. Throws an
	 * IllegalArgumentException when the data input is null.
	 * 
	 * @param newData-contains the location, activity and distance of the trip
	 *                stop.
	 * @throws IllegalArgumentException-if the input data is null.
	 */
	public void setData(TripStop newData) throws IllegalArgumentException
	{
		if (newData != null)
		{
		this.data=newData;
		}
		else
		{
			throw new IllegalArgumentException("Invalid Input");
		}
	}

	/**
	 * Returns the node connected next to the specified TripStopNode.
	 * 
	 * @return the node connected following to the current node.
	 */
	public TripStopNode getNext()
	{
		return this.next;
	}
	
	/**
	 * Takes a input node and connects it to the specified node. It specifies
	 * this input node as the next node on the list.
	 * 
	 * @param newNext-the node for which the specified node is connecting to.
	 */
	public void setNext(TripStopNode newNext)
	{
		this.next=newNext;
	}
	
	/**
	 * Returns the node connected previously to the specified TripStopNode.
	 * 
	 * @return the node connected previously to the current node.
	 */
	public TripStopNode getPrev()
	{
		return this.prev;
	}
	
	/**
	 * Takes a input node and connects it to the specified node. It specifies
	 * this input node as the previous node on the list.
	 * 
	 * @param newPrev-the node for which the specified node is connecting to.
	 */
	public void setPrev(TripStopNode newPrev)
	{
		this.prev=newPrev;
	}
}
