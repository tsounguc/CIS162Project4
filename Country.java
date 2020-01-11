import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Write a description of class Country here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Country implements Comparable
{
    // instance variables 
    private String nameOfCountry;
    
    private String continentOfCountry;
    
    private int areaOfCountry;
    
    private double populationOfCountry;
    
    private double gdpOfCountry;
    
    private String capitalOfCountry;
    
    
    

    /**
     * Constructors for objects of class Country
     */
    public Country()
    {
        // initialise instance variables
        nameOfCountry = "Default";
    }

    public Country (String name, String continent, int area, double population, double gdp, String capital)
    {
        nameOfCountry = name;
        continentOfCountry = continent;
        areaOfCountry = area;
        populationOfCountry = population;
        gdpOfCountry = gdp;
        capitalOfCountry = capital;

    }

    /**
     * Accessor (getter)
     * 
     */
    
    public String getNameOfCountry()
    {
        return nameOfCountry;
    }
    
    public String getContinentOfCountry()
    {
        return continentOfCountry;
    }
    
    public int getAreaOfCountry()
    {
        return areaOfCountry;
    }
    
    public double getPopulationOfCountry()
    {
        return populationOfCountry;
    }        
    
    public double getGdpOfCountry()
    {
        return gdpOfCountry;
    }
    
    public String getCapitalOfCountry()
    {
        return capitalOfCountry;
    }
    
    /**
     * Mutators (setters)
     */ 
    
    public void setNameOfCountry(String name)
    {
        nameOfCountry = name;
    }
    
    public void setContinentOfCountry(String continent)
    {
        continentOfCountry = continent;
    }
    
    public void setAreaOfCountry(int area)
    {
         areaOfCountry = area;
    }
    
    public void setPopulationOfCountry(double population)
    {
        populationOfCountry = population;
    }        
    
    public void setGdpOfCountry(double gdp)
    {
        gdpOfCountry = gdp;
    }
    
    public void setCapitalOfCountry(String capital)
    {
        capitalOfCountry = capital;
    }
    
    public String toString()
    {
        DecimalFormat fmt = new DecimalFormat ("#,###");
        double gdpInBillion = gdpOfCountry / 1000000000;
        double perCapita =(gdpOfCountry/populationOfCountry);
        return nameOfCountry + ", Captial: " + capitalOfCountry 
        + ", GDP: " + fmt.format(gdpInBillion) + " billion, Per Capita GDP: "
        + fmt.format(perCapita);
    }
    
    public static void main (String [] args)
    {
        System.out.println("Starting test...");
        Country t = new Country();
        
        Scanner scnr = new Scanner(System.in);
        
        String a;
        String b;
        int c;
        double d;
        double e;
        String f;
        
        System.out.println("Country: " + t.getNameOfCountry());
        System.out.println("Continent: " + t.getContinentOfCountry());
        System.out.println("Area: " + t.getAreaOfCountry());
        System.out.println("Population: " + t.getPopulationOfCountry());
        System.out.println("GDP: " + t.getGdpOfCountry());
        System.out.println("Capital: " + t.getCapitalOfCountry());
        
        System.out.println("Enter Country: ");
        System.out.print("> ");
        String country = scnr.nextLine();
        t.setNameOfCountry(country);
                
        System.out.println("Enter Continent: ");
        System.out.print("> ");
        String continent = scnr.nextLine();
        t.setContinentOfCountry(continent);
        
        System.out.println("Enter Capital: ");
        System.out.print("> ");
        String cap = scnr.nextLine();
        t.setCapitalOfCountry(cap);
        
        
        System.out.println("Enter Area: ");
        System.out.print("> ");
        int area = scnr.nextInt();
        t.setAreaOfCountry(area);
        
        System.out.println("Enter Population: ");
        System.out.print("> ");
        double pop = scnr.nextDouble();
        t.setPopulationOfCountry(pop);
        
        
        System.out.println("Enter GDP: ");
        System.out.print("> ");
        double GDP = scnr.nextDouble();
        t.setGdpOfCountry(GDP);
        
        a = t.getNameOfCountry();
        
        b = t.getContinentOfCountry();
        
        c = t.getAreaOfCountry();
        
        d = t.getPopulationOfCountry();
        
        e = t.getGdpOfCountry();
        
        f = t.getCapitalOfCountry();
        
        Country t2 = new Country(a, b, c, d, e, f);
        
        System.out.println( t2.toString());
        
        System.out.println("Testing Complete");
    }
    
    public int compareTo(Object other)
    {
        Country c = (Country) other;
        return (int) (c.gdpOfCountry - gdpOfCountry);
        
    }
}
