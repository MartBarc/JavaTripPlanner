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
 * 	Runs the user interface with all the required functions as a trip planner.
 * The trip planner contains two itineraries to allow user to plan two trips.
 * Each are completely independent of the other. To facilitate switching 
 * between the methods, all functions use a itineraryPointer to switch between
 * the two itineraries. The whole process is inside a do-while loop as the 
 * quit function takes the program out of the loop.
 */
/**--------------------------------------------------------------------------*/
import java.util.Scanner;

public class TripPlanner {

	public static void main(String[] args) {

		/**
		 * Initializes the two itineraries and scan function. Also sets the 
		 * initial pointer to itinerary01. The user is notified of the function
		 * and the program termination condition is set before the do-while 
		 * loop 
		 */
		Scanner scan = new Scanner (System.in);
		Itinerary itinerary01 = new Itinerary();
		Itinerary itinerary02 = new Itinerary();

		Itinerary itineraryPointer = itinerary01;

		System.out.println("Welcome to CSE Travel Planner!");
		System.out.println("Menu:");
		System.out.println("F-Cursor forward");
		System.out.println("B-Cursor backward");
		System.out.println("I-Insert before cursor");
		System.out.println("A-Append to tail");
		System.out.println("D-Delete and move cursor forward");
		System.out.println("H-Cursor to Head");
		System.out.println("T-Cursor to Tail");
		System.out.println("E-Edit cursor");
		System.out.println("S-Switch itinerary");
		System.out.println
		("O-Insert cursor from other itinerary before cursor from this "
				+ "itinerary");
		System.out.println
		("R-Replace this itinerary with a copy of the other itinerary");
		System.out.println("P-Print current itinerary, including summary");
		System.out.println("C-Clear current itinerary");
		System.out.println("Q-Quit");
		System.out.println();

		boolean terminateProgram = true;

		do //Beginnning of the program.
		{
			//Prompt the user to select the function
			System.out.print("Select operation: ");
			String userInput = scan.nextLine();

			/**
			 * Moves the cursor forward.
			 */
			if (userInput.equalsIgnoreCase("F"))
			{
				System.out.println("Moving cursor forward...");
				try
				{
					itineraryPointer.cursorForward();
				}
				catch (EndOfItineraryException e)
				{
					System.out.println("ERROR: End of itinerary");
				}
				System.out.println("Done!");
			}
			/**
			 * Moves the cursor backwards. 
			 */
			else if (userInput.equalsIgnoreCase("B"))
			{
				System.out.println("Moving cursor backward...");
				try
				{
					itineraryPointer.cursorBackward();
				}
				catch (EndOfItineraryException e)
				{
					System.out.println("ERROR: End of itinerary");
				}
				System.out.println("Done!");
			}
			/**
			 * Adds a new cursor before currently selected cursor.
			 */
			else if (userInput.equalsIgnoreCase("I"))
			{
				System.out.print("Enter location: ");
				String location = scan.nextLine();
				System.out.print("Enter Activity: ");
				String activity = scan.nextLine();
				System.out.print("Enter Distance: ");
				int distance=scan.nextInt();
				System.out.println("Entering travel information...");
				TripStop tripStop = new TripStop();
				tripStop.setLocation(location);
				tripStop.setActivity(activity);
				boolean validDistance = true;
				while (validDistance)
				{
					try
					{
						tripStop.setDistance(distance);
						validDistance=false;
					}
					catch (IllegalArgumentException e) //Catches exception.
					{
						System.out.println
						("This distance is invalid -- distances must be >=0."
								+ " Try Again.");
						distance=scan.nextInt();
						validDistance=true;
					}
				}
				itineraryPointer.insertBeforeCursor(tripStop);
				System.out.println("Done!");
				scan.nextLine();
			}
			/**
			 * Adds a new node after the tail of the linked list
			 */
			else if (userInput.equalsIgnoreCase("A"))
			{
				System.out.print("Enter location: ");
				String location = scan.nextLine();
				System.out.print("Enter Activity: ");
				String activity = scan.nextLine();
				System.out.print("Enter Distance: ");
				int distance=scan.nextInt();
				System.out.println("Entering travel information...");
				TripStop tripStop = new TripStop();
				tripStop.setLocation(location);
				tripStop.setActivity(activity);
				boolean validDistance = true;
				while (validDistance)
				{
					try
					{
						tripStop.setDistance(distance);
						validDistance=false;
					}
					catch (IllegalArgumentException e)
					{
						System.out.println
						("This distance is invalid -- distances must be >=0."
								+ " Try Again.");
						distance=scan.nextInt();
						validDistance=true;
					}
				}
				itineraryPointer.appendToTail(tripStop);
				System.out.println("Done!");
				scan.nextLine();
			}
			
			/**
			 * Deletes the current cursor moves cursor forward.
			 */
			else if (userInput.equalsIgnoreCase("D"))
			{
				try
				{
					System.out.println("Removing cursor...");
					itineraryPointer.removeCursor();
				}
				catch(EndOfListException e)
				{
					System.out.println("ERROR: End of itinerary");
				}
				System.out.println("Done!");
			}
			
			/**
			 * Moves the cursor to the head of the linked list.
			 */
			else if (userInput.equalsIgnoreCase("H"))
			{
				System.out.println("Moving cursor to head...");
				itineraryPointer.resetCursorToHead();
				System.out.println("Done!");
			}
			
			/**
			 * Moves the cursor to the tail of the linked list.
			 */
			else if (userInput.equalsIgnoreCase("T"))
			{
				System.out.println("Moving cursor to tail...");
				itineraryPointer.resetCursorToTail();
				System.out.println("Done!");
			}
			
			/**
			 * Edits the cursor by removing the cursor and adding a new cursor.
			 */
			else if (userInput.equalsIgnoreCase("E"))
			{
				if(itineraryPointer.getStopsCount()>0)
				{
					TripStop temp = itineraryPointer.getCursorStop();
					try
					{
						itineraryPointer.removeCursor();
					}
					catch (EndOfListException e)
					{
						System.out.println("ERROR: End of itinerary");
						scan.nextLine();
					}

					String locationTemp = temp.getLocation();
					String activityTemp = temp.getActivity();
					int distanceTemp = temp.getDistance();

					System.out.print
					("Enter location, or press enter without typing anything"
							+ " to keep: ");
					String location = scan.nextLine();
					System.out.print
					("Enter Activity, or press enter without typing anything"
							+ " to keep: ");
					String activity = scan.nextLine();
					System.out.print
					("Enter Distance, or press -1 without typing anything"
							+ " to keep: ");
					int distance=scan.nextInt();
					System.out.println("Entering travel information...");
					TripStop tripStop = new TripStop();
					//Checks and, if necessary, replaces the values if an empty
					//value is detected.
					if (location != null && !location.equals(""))
					{
						locationTemp = location;
					}
					if (activity != null && !activity.equals(""))
					{
						activityTemp = activity;
					}
					if (distance != -1)
					{
						boolean validDistance = true;
						distanceTemp=distance;
						while (validDistance)
						{
							try
							{
								tripStop.setDistance(distanceTemp);
								validDistance=false;
							}
							catch (IllegalArgumentException e)//Exception caught.
							{
								System.out.println
								("This distance is invalid -- distances must be"
										+ " >=0. Try Again.");
								distance=scan.nextInt();
								validDistance=true;
							}
						}
					}
					else //Sets all relevant data.
					{
						tripStop.setDistance(distanceTemp);
					}
					tripStop.setLocation(locationTemp);
					tripStop.setActivity(activityTemp);
					itineraryPointer.insertBeforeCursor(tripStop);
					System.out.println("Done!");
					scan.nextLine();
				}
				else
				{
					System.out.println("No stops to edit.");
				}
			}
			
			/**
			 * Switches the itineraries to edit. Done by changing itinerary 
			 * pointer.
			 */
			else if (userInput.equalsIgnoreCase("S"))
			{
				System.out.println("Switching itineraries...");
				if (itineraryPointer == itinerary01) //If itinerary01 then 2
				{
					itineraryPointer = itinerary02;
					System.out.println("You are now in itinerary 2...");
				}
				else //If itinerary02 then set to 1
				{
					itineraryPointer = itinerary01;
					System.out.println("You are now in itinerary 1...");
				}
			}
			
			/**
			 * Copies the cursor of the opposite itinerary and adds it to list.
			 */
			else if (userInput.equalsIgnoreCase("O"))
			{
				System.out.println("Copying cursor from other itinerary...");
				if (itineraryPointer == itinerary01)
				{
					itinerary01.insertBeforeCursor
					(itinerary02.getCursorStop());
				}
				else
				{
					itinerary02.insertBeforeCursor
					(itinerary01.getCursorStop());
				}
				System.out.println("Done!");
			}
			
			/**
			 * Hard copies whole itinerary list of the opposite itinerary 
			 * selected.
			 */
			else if (userInput.equalsIgnoreCase("R"))
			{
				System.out.println("Copying itinerary...");
				Itinerary temp = itineraryPointer;
				if (itineraryPointer == itinerary01)
				{
					temp=itinerary02.toClone();
					itinerary01=temp;
					System.out.println("Itinerary 2 copied!");
				}
				else
				{
					System.out.println("Itinerary 1 copied!");
					temp=itinerary01.toClone();
					itinerary02=temp;
				}
				itineraryPointer = temp;
			}
			
			/**
			 * Prints selected itinerary. Also prints information about number
			 * of stops, total distance, number of stops before and after the 
			 * cursor.
			 */
			else if (userInput.equalsIgnoreCase("P"))
			{
				if (itineraryPointer == itinerary01)
				{
					System.out.println("Printing itinerary1...");
				}
				else
				{
					System.out.println("Printing itinerary2...");
				}
				itineraryPointer.printItinerary();
				System.out.println();
				System.out.println("Summary: This trip has "
						+itineraryPointer.getStopsCount()
						+" stop(s), totaling "
						+itineraryPointer.getTotalDistance()
						+" miles. There are "
						+itineraryPointer.stopsBeforeCursor()
						+" stop(s) before the cursor and "
						+itineraryPointer.stopsAfterCursor()
						+" stop(s) after the cursor.");
				System.out.println();
			}
			
			/**
			 * Clears all the stops in the selected itinerary by removing each
			 * one by one.
			 */
			else if (userInput.equalsIgnoreCase("C"))
			{
				System.out.println("Removing all stops...");
				while(itineraryPointer.getStopsCount()>0)
				{ 
					try
					{
						itineraryPointer.removeCursor();
					}
					catch (EndOfListException e)
					{
						System.out.println("ERROR: End of itinerary");
					}
				}
				System.out.println("Done!");
			}
			
			/**
			 * Ends loop of the program.
			 */
			else if (userInput.equalsIgnoreCase("Q"))
			{
				System.out.println("Quitting program...");
				terminateProgram = false;
			}

			/**
			 * If none of the letters are entered by the user, the program will
			 * prompt the user to enter it again and inform the user
			 */
			else
			{
				System.out.println("User input not found, please try again.");
				terminateProgram = true;
			}
		}
		while(terminateProgram); //Ending condition.
		{
			System.out.println("Thank you for using CSE Travel Planner!");
		}

	}
}