/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs240project4;

/**
 *
 * @author mrfre
 */
public class Assignment implements Comparable<Assignment> {
   private String title;
	private int value;
	private int daysTilDue;
        
        // -----------------------------------------------------------------------------
        public Assignment(){
                                                                                    //default constructor to be able to create an instance of it with nothing in it in the driver    
        }
        // -----------------------------------------------------------------------------

	// -----------------------------------------------------------------------------
	public Assignment ( String title, int value, int daysTilDue )
	{
		this.title = title;                                                 //constructor for the assignment class
		this.value = value;
		this.daysTilDue = daysTilDue;
	}

	// -----------------------------------------------------------------------------
	public String getTitle ()
	{
		return title;                                                       //returns title
	}

	// -----------------------------------------------------------------------------
	public void setTitle ( String title )
	{
		this.title = title;                                                 //sets title
	}

	// -----------------------------------------------------------------------------
	public int getValue ()
	{
		return value;                                                      //gets value of assignment
	}

	// -----------------------------------------------------------------------------
	public void setValue ( int value )
	{
		this.value = value;                                                //sets value of assignment
	}

	// -----------------------------------------------------------------------------
	public int getDaysTilDue ()
	{
		return daysTilDue;                                                //gets days till assignment is due
	}

	// -----------------------------------------------------------------------------
	public void setDaysTillDue ( int daysTilDue )
	{
		this.daysTilDue = daysTilDue;                                    //sets days till due
	}

	// -----------------------------------------------------------------------------
	public int compareTo ( Assignment that )
	{
		return this.value / (this.daysTilDue+1) - that.value / (that.daysTilDue+1);        //slight change to make it so assignments with 0 days till due are highest priority, professor doesn't accept late assignments
	}

	// -----------------------------------------------------------------------------
	public String toString ()
	{
		return "Title: " + this.title +                                     //toString the prints assignment object
			   "\nValue: " + this.value + 
			   "\nDays Until Due: " + this.daysTilDue + "\n";
	}
	// -----------------------------------------------------------------------------
}
