import java.util.ArrayList;

public class ComputingStatistics {
   /**
   * The ArrayList containing all of the loan data.
   */
   private ArrayList<Loan> data;
   
   /**
    * Creates a new ComputingStatistics object with an empty ArrayList 
    */
   public ComputingStatistics() {
      data = new ArrayList<Loan>();
   }
   
   /**
    * Creates a new ComputingStatistics object with the data passed in
    */
   public ComputingStatistics(ArrayList<Loan> d) {
      data = d;
   }
   
   /**
    * Calclates the total amount funded from all of the loans in the file.
    * @return the total loan amount.
    */
   public double totalAmount() {
      double amount = 0.0;
      for(int i = 0; i < data.size(); i++) {
         amount = amount + data.get(i).getLoanAmount();
      }
      return amount;
   }

   public double avgLoan() {
     double total = 0.0;
     int count = 0;
     for(int i = 0; i < data.size(); i++) {
     total = total + data.get(i).getLoanAmount();
     count++;
     }
     return total / count;
   }

   public double largestLoan() {
     double largestLoan = data.get(0).getLoanAmount();
     for (int i = 1; i < data.size(); i++)
     {
       if(data.get(i).getLoanAmount() > largestLoan)
       {
         largestLoan = data.get(i).getLoanAmount();
       }
     }
     return largestLoan;
   }

   public double smallestLoan() {
     double smallestLoan = data.get(0).getLoanAmount();
     for (int i = 1; i < data.size(); i++)
     {
       if(data.get(i).getLoanAmount() < smallestLoan)
       {
         smallestLoan = data.get(i).getLoanAmount();
       }
     }
     return smallestLoan;
   }

   public String largestLoanCountry() {
      Loan largest = data.get(0);
      for(int i = 0; i < data.size(); i++)
      {
        if(data.get(i).getLoanAmount() > largest.getLoanAmount())
        {
          largest = data.get(i);
        }
      }
      return largest.getCountry();
    }

    public String smallestLoanCountry() {
      Loan smallest = data.get(0);
      for(int i = 0; i < data.size(); i++)
      {
        if(data.get(i).getLoanAmount() < smallest.getLoanAmount()) 
        {
          smallest = data.get(i);
        }
      }
      return smallest.getCountry();
    }

   public double avgDaysToFund() {
      double total = 0.0;
      for(int i = 0; i < data.size(); i++)
      {
        total = total + data.get(i).getDaysToFund();
      }
      return total / data.size();
    }

   public double largestLoanKenya() {
      double largest = 0;
      for(int i = 0; i < data.size(); i++)
      {
      if (data.get(i).getCountry().equals("Kenya"))
      {
        if(data.get(i).getLoanAmount() > largest)
        {
          largest = data.get(i).getLoanAmount();
        } 
      }
      }
      return largest;
    }

   public double avgLoanPhilippines() {
      double total = 0.0 ;
      int count = 0;
      for(int i = 0; i < data.size(); i++) 
      {
        if(data.get(i).getCountry().equals("Philippines"))
        {
          total += data.get(i).getLoanAmount();
          count++;
        }
      }
      return total / count;
    }

   public String longestToFundCountry() {
      Loan largest = data.get(0);
      for(int i = 0; i < data.size(); i++)
      {
      if (data.get(i).getDaysToFund() > largest.getDaysToFund())
      {
        largest = data.get(i);
      }
      }
      return largest.getCountry();
    }

    public double variance() {
      double total = 0;
      for(int i = 0; i < data.size(); i++) 
        total += data.get(i).getLoanAmount();
      double mean = (double)total / (double)data.size();
      double diffSq = 0;
      for(int i = 0; i < data.size(); i++)
        diffSq += (data.get(i).getLoanAmount() - mean) * (data.get(i).getLoanAmount() - mean);
      return (double)diffSq / data.size();
    }

    public double standardDeviation() {
      return Math.sqrt(variance());
    }

    public boolean empiricalRule() { 
      int count = 0;
      for(int i = 0; i < data.size(); i++)
      {
        count += data.get(i).getLoanAmount();
      }
      double low = avgLoan() - standardDeviation();
      double high = avgLoan() + standardDeviation();
      if(totalAmount() > low && totalAmount() < high)
      {
        count++;
      }
      return count >= .68 * data.size();
    }
}