//Programmer: Ryan Paik

import java.util.ArrayList;

public class Loan
{
  //instance variables
  private int ID;
  private double loanAmount;
  private String country;
  private int daysToFund;
  private int numLenders;

  //constructor
  public Loan(int ID, double loanAmount, String country, int daysToFund, int numLenders)
  {
    this.ID = ID;
    this.loanAmount = loanAmount;
    this.country = country;
    this.daysToFund = daysToFund;
    this.numLenders = numLenders;
  }
  //accessor methods
  public int getID()
  {
    return ID;
  }
  public double getLoanAmount()
  {
    return loanAmount;
  }
  public String getCountry()
  {
    return country;
  }
  public int getDaysToFund()
  {
    return daysToFund;
  }
  public int getNumLenders()
  {
    return numLenders;
  }

  //modifier methods
  public void setID(int id)
  {
    ID = id;
  }
  public void setLoanAmount(int la)
  {
    loanAmount = la;
  }
  public void setCountry(String c)
  {
    country = c;
  }
  public void setDaysToFund(int dtf)
  {
    daysToFund = dtf;
  }
  public void setNumLenders(int nl)
  {
    numLenders = nl;
  }

  //toString
  public String toString()
  {
    return "ID: " + ID + " loan amount: " + loanAmount + " country: " + country + " days to fund: " + daysToFund + " num lenders: " + numLenders;
  }
}
