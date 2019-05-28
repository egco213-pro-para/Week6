


import java.util.*;
import java.io.*;

class CookingOil implements Comparable <CookingOil> {
   private String name;
   private int    mono, poly, sat;
   
   public CookingOil (String n, int f, int a, int d)
   {
       name = n;
       mono = f;
       poly = a;
       sat = d;
   }
   
   public void report()                 
   {
       System.out.printf("%-30s mono = %5d  poly = %5d sat = %5d\r\n",name,mono,poly,sat);
   }
   
   @Override
   
   public int compareTo(CookingOil other)  
   {
       if (this.mono > other.mono) return -1;
       else if (this.mono < other.mono) return 1;
       
       if (this.poly > other.poly) return -1;
       else if (this.poly < other.poly) return 1;
       
       
       if (this.sat > other.sat) return -1;
       else if (this.sat < other.sat) return 1;
       
       
       if (this.name.compareToIgnoreCase(other.name) < 0) return -1;
       else return 1;
   }
}


public class Exercise5 {

    public static void main(String[] args) {
            String infile = "fat.txt";
            ArrayList <CookingOil> A = new ArrayList <CookingOil> ();
            boolean correct_file = true;
            
              while (correct_file)
        {
            try
            {
                Scanner scan_name = new Scanner (System.in);
                System.out.printf("File name: ");
                String file_name = scan_name.next();
                Scanner input = new Scanner (new File (file_name + ".txt"));
            
                correct_file = false;

                try
                {
                    while (input.hasNext())
                    {
                        String line = input.nextLine();
                        String[] buffer = line.split(",");
                        try
                        {
                            
                            
                            //if (buffer.length > 3) throws 0;
                            
                            String name = buffer[0];
                            int mono = Integer.parseInt(buffer[1].trim());
                            int poly = Integer.parseInt(buffer[2].trim());
                            int sat = Integer.parseInt(buffer[3].trim());
                
                            CookingOil temp = new CookingOil (name,mono,poly,sat);
                            A.add(temp);
                        }
                        catch (Exception e)
                        {
                            System.out.printf(" INput << %s \r\n",line);
                            System.out.println(e);
                            
                        }
                        
                    }
                }
                catch (RuntimeException e)
                {
                    
                    System.err.print(e);
                }
                finally
                {
                    
                    continue;
                }
            }
            catch (Exception e)
            {
                
                System.err.println(e);
            }
        }
        
        
        Collections.sort(A);
        
        for (int i = 0; i < A.size(); i++)
        {
            A.get(i).report();
        }
    
}
}