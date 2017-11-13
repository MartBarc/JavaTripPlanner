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
 *  This object contains fields which hold links to a doubly linked list. This
 * list contains TripStopNodes which each node links to the previous links and
 * links next to itself and/or links of null value. Furthermore, the Itinerary
 * object holds fields containing the number of trip stops and total distance.
 * All fields are set to private. The constructor sets the three fields, head,
 * tail, and cursor, and sets the to null as-well as setting stopsCount and
 * totalDistance to 0. The object has methods getting the stopsCount and 
 * totalDistance. Furthermore, there is a get method data from the cursor (the 
 * selected node). The stopsBeforeCursor and stopsAfterCursor methods returns
 * the number of stops before and after the trip stops respectively. The 
 * resetCursorToHead and resetCursorToTail methods each set the current cursor
 * to the head or the tail of the list. The object provides a way of navigating
 * the list by moving the cursor forward and backward with the methods
 * cursorForward and cursorBackward. To add nodes to the list, the 
 * insertBeforeCursor method places the new node before the cursor, and the 
 * appendToTail method places the new node after the tail of the list. To 
 * remove nodes, the removeCursor removes the current Cursor from the list.
 * The toClone method hard copies the Itinerary object. And the printItinerary
 * method prints a formatted list of all nodes in the object. 
 */
/**--------------------------------------------------------------------------*/

public class Itinerary {

	/**
	 * Sets the head, tail and cursor node list to private fields. Also sets
	 * the stopsCount and totalDistance to private. These fields hold an 
	 * integer of trip stops and total distance respectively. 
	 */
	private TripStopNode head;
	private TripStopNode tail;
	private TripStopNode cursor;
	int stopsCount;
	int totalDistance;

	/**
	 * The constructor that sets the head,tail and cursor to null. It also 
	 * sets the stopsCount and totalDistance to 0.
	 */
	public Itinerary()
	{
		this.head=null;
		this.tail=null;
		this.cursor=null;
		this.stopsCount=0;
		this.totalDistance=0;
	}

	/**
	 * Returns the number of stops of the specified list.
	 * 
	 * @return the number of stops.
	 */
	public int getStopsCount()
	{
		return this.stopsCount;
	}

	/**
	 * Returns the number of stops before not including the cursor. Returns 0 
	 * if the cursor is also the head.
	 * 
	 * @return the number of stops before the cursor
	 */
	public int stopsBeforeCursor()
	{
		int numberStops=0;
		TripStopNode current = this.head;
		if(this.head!=this.cursor)
		{
			while(current != this.cursor)
			{
				numberStops++;
				current = current.getNext();
			}
			return numberStops;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Returns the number of stops after not including the cursor. Returns 0 
	 * if the cursor is also the tail.
	 * 
	 * @return the number of stops after the cursor.
	 */
	public int stopsAfterCursor()
	{
		int numberStops=0;
		TripStopNode current = this.cursor;
		if (this.tail !=this.cursor)
		{
			//Changes the current node to the next one to not include itself
			current = current.getNext();
			while(current != null)
			{
				numberStops++;
				current = current.getNext();
			}
			return numberStops;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Returns the total distance from all the list objects.
	 * 
	 * @return the total distance covered in the trip.
	 */
	public int getTotalDistance()
	{
		return this.totalDistance;
	}

	/**
	 * Returns the data of the cursor.
	 * 
	 * @return the TripStop object at the cursor.
	 */
	public TripStop getCursorStop()
	{
		return cursor.getData();
	}

	/**
	 * Changes the current cursor to the head of the list.
	 */
	public void resetCursorToHead()
	{
		if (this.head!=null)
		{
			this.cursor=this.head;
		}
		else
		{
			this.cursor = null;
		}
	}

	/**
	 * Changes the current cursor to the tail of the list.
	 */
	public void resetCursorToTail()
	{
		if (this.tail!=null)
		{
			this.cursor=this.tail;
		}
		else
		{
			this.cursor=null;
		}
	}

	/**
	 * Changes the current cursor to the node forward of itself. If the cursor
	 * is equal to the tail the method throws an EndOfItineraryExpression 
	 * error.
	 * 
	 * @throws EndOfItineraryException-when the cursor is already the tail
	 */
	public void cursorForward() throws EndOfItineraryException
	{
		TripStopNode next = this.cursor.getNext();
		if (this.cursor != this.tail)
		{
			this.cursor=next;
		}
		else
		{
			throw new EndOfItineraryException("End of itinerary");
		}
	}

	/**
	 * Changes the current cursor to the node backwards of itself. If the 
	 * cursor is equal to the head the method throws an 
	 * EndOfItineraryExpression error.
	 * 
	 * @throws EndOfItineraryException-when the cursor is already the head.
	 */
	public void cursorBackward() throws EndOfItineraryException
	{
		TripStopNode prev = this.cursor.getPrev();
		if (this.cursor != this.head)
		{
			this.cursor=prev;
		}
		else
		{
			throw new EndOfItineraryException("End of itinerary");
		}
	}

	/**
	 * Inserts the new cursor before the pre-exisitng cursor. If there is no
	 * nodes set, then the new node becomes the head, cursor, and tail.
	 * If the head is the cursor, the current cursor is set after the new 
	 * cursor. Else, the cursor is simply added before the cursor. The number
	 * of stops is added to the stopsCount counter.
	 * 
	 * @param newStop-the new data to be added to the node.
	 */
	public void insertBeforeCursor(TripStop newStop)
	{
		TripStopNode newNode =  new TripStopNode (newStop);
		this.totalDistance += newStop.getDistance();
		if (this.cursor == null && this.head ==null && this.tail == null)
		{
			this.head=newNode;
			this.cursor=newNode;
			this.tail=newNode;
			this.stopsCount=1;
		}
		else if(this.head==this.cursor)
		{
			TripStopNode current = this.cursor;
			this.cursor=newNode;
			
			current.setPrev(this.cursor); //Sets the previous node to the 
			this.cursor.setNext(current); //new cursor.
			this.head=this.cursor;
			this.stopsCount++;
		}
		else
		{
			TripStopNode current = this.cursor;
			this.cursor=newNode;
			current.setPrev(this.cursor);
			this.cursor.setNext(current);
			this.stopsCount++;
		}
	}

	/**
	 * Adds a new node after the tail of the list. If there is no nodes set,
	 * then the new node becomes the head,cursor and tail. Otherwise, the node
	 * is simply added after the tail. Each node added adds 1 to the stopsCount
	 * counter.
	 * 
	 * @param newStop
	 */
	public void appendToTail(TripStop newStop)
	{
		TripStopNode newNode =  new TripStopNode (newStop);
		this.totalDistance += newStop.getDistance();
		if (newNode != null)
		{
			if (this.cursor == null && this.head ==null && this.tail == null)
			{
				this.head=newNode;
				this.cursor=newNode;
				this.tail=newNode;
				this.stopsCount++;
			}
			else
			{
				TripStopNode current = this.cursor;
				this.tail.setNext(newNode);
				newNode.setPrev(tail); //Sets the new node to the 
				this.tail=newNode;     //tail of list.
				this.stopsCount++;
			}
		}
	}

	/**
	 * Removes the current cursor. The method takes the cursor and sets its 
	 * next node as the cursor and takes the original previous node as its 
	 * new previous node. Each time a cursor is removed the stopsCount 
	 * subtracts -1 from the counter. If the head is the tail (meaning no
	 * elements in list) then cursor,head and tail is set to null (stopsCount 
	 * is set to 0). If the cursor is the tail it becomes the new tail, and
	 * if the cursor is the head then the head is moves to the next node.
	 * 
	 * @return the data of the TripStopNode that got removed from the list.
	 * @throws EndOfListException-when there is no cursor or object to remove.
	 */
	public TripStop removeCursor() throws EndOfListException
	{
		TripStopNode current = this.cursor;
		this.totalDistance -= current.getData().getDistance();
		if(this.cursor != null)
		{
			if (this.head==this.tail)
			{
				this.cursor=null;
				this.head=null;
				this.tail=null;
				this.stopsCount=0;
			}
			else if(this.cursor==this.tail)
			{
				this.tail= this.tail.getPrev();
				this.cursor = this.tail;
				this.tail.setNext(null);
				this.stopsCount--;
			}
			else if (this.cursor==this.head)
			{
				this.head= this.head.getNext();
				this.cursor = current.getNext();
				this.head.setPrev(null);
				this.stopsCount--;
			}
			else
			{
				this.cursor = current.getNext();
				this.cursor.setPrev(current.getPrev());
				this.cursor.getPrev().setNext(this.cursor);
				this.stopsCount--;
			}
		}
		else
		{
			throw new EndOfListException("No object to remove");
		}
		return current.getData();
	}

	/**
	 * Returns the specified cloned linked list. This method hard copies the
	 * specified linked list and sets it to a temporary Itinerary which is
	 * the Itinerary returned. The stopsCount and totalDistance are copied.
	 * 
	 * @return the copied linked list along with total distance and stops
	 */
	public Itinerary toClone()
	{
		TripStopNode current = this.head;
		Itinerary temp = new Itinerary();
		while(current != null)
		{
			String location = current.getData().getLocation();
			String activity = current.getData().getActivity();
			int distance = current.getData().getDistance();
			temp.totalDistance += distance;
			temp.stopsCount++;
			TripStop currentCopy = new TripStop(location,activity,distance);
			temp.appendToTail(currentCopy);
			current = current.getNext();
		}
		return temp;
	}

	/**
	 * Prints a formatted linked list Itinerary object. If there is no head,
	 * then the method prints no stops and notifies user. Adds a ">" to the
	 * line containing the cursor.
	 */
	public void printItinerary()
	{
		if(this.head != null)
		{
			TripStopNode current = this.head;
			System.out.printf
			("%-30s%-45s%s\n"," Location","Activity","Distance");
			while(current != null)
			{ 
				//Adds > to indicate the cursor.
				if(current.equals(cursor))
				{
					System.out.printf
					("%-30s%-45s%s\n",
							">"+current.getData().getLocation(),
							current.getData().getActivity(),
							current.getData().getDistance()+" mile(s)");
				}
				else
				{
					System.out.printf
					("%-30s%-45s%s\n",
							" "+current.getData().getLocation(),
							current.getData().getActivity(),
							current.getData().getDistance()+" mile(s)");
				}
				current = current.getNext();
			}
		}
		else
		{
			System.out.println("This trip has no stops");
		}
	}
}