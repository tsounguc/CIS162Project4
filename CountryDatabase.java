import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
/**
 * Description: maintains the collection of the countries of
 * the world – an ArrayList of elements of the class Country. 
 *
 * @author Christian Tsoungui Nkoulou
 * @version 3/17/18
 */
public class CountryDatabase
{
    // instance variables - replace the example below with your own
    private ArrayList <Country > list;

    /**
     * Constructor for objects of class CountryDatabase
     */
    public CountryDatabase()
    {
        // initialise instance variables
        list = new ArrayList <Country>();
    }

    public void readCountriesData(String filename)
    {
        // Read the full set of data from a text file
        try{ 

            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream(filename);
            Scanner scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");

            // keep reading as long as there is more data
            while(scnr.hasNext()) {

                // reading the fields from the record one at the time
                String name = scnr.next();
                String continent = scnr.next();

                // FIX ME: capture the area, population, GDP, and capital
                int area = scnr.nextInt(); 
                double population = scnr.nextDouble();
                double gdp = scnr.nextDouble();
                String capital = scnr.next();
                // instantiate a new Country with the data that was read
                Country entry = new Country(name, continent, area, population,
                        gdp, capital);

                // FIX ME: Add the Country created on previous instruction
                // to the ArrayList
                list.add(entry);
            }
            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: " + filename);
        }
    }

    public int countAllCountries ()
    {
        return list.size();
    }

    public ArrayList <Country> getAllCountries() 
    {
        return list;
    }

    public Country highestGdp(String continent)
    {
        Country highestCountry = new Country();
        highestCountry.setGdpOfCountry(0);

        for(Country c: list)
        {
            if(c.getGdpOfCountry()>= highestCountry.getGdpOfCountry() 
            && c.getContinentOfCountry().equalsIgnoreCase(continent))
            {
                highestCountry = c;
            }
        }
        return highestCountry;
    }

    public Country smallestArea(String continent)
    {
        Country smallestCountry = new Country();
        smallestCountry = list.get(0);
        for(Country c: list)
        {
            if(c.getAreaOfCountry() < smallestCountry.getAreaOfCountry() 
            && c.getContinentOfCountry().equalsIgnoreCase(continent)) 
            {
                smallestCountry = c;
            }
        }
        return smallestCountry;
    }

    public String searchForCapital(String countryName)
    {
        for(Country c: list)
        {
            if(c.getNameOfCountry().equalsIgnoreCase(countryName))
            {
                return c.getCapitalOfCountry();
            }
        }
        return null;
    }

    public Country findCountryDetails(String countryName)
    {
        for(Country c: list)
        {
            if(c.getNameOfCountry().equalsIgnoreCase(countryName))
            {
                return c;
            }
        }
        return null;
    }

    public ArrayList <Country> searchCountriesInContinent(String continent)
    {
        ArrayList <Country> countriesInContinent = new ArrayList <Country>();
        for(Country c: list)
        {
            if(c.getContinentOfCountry().equalsIgnoreCase(continent))
            {
                countriesInContinent.add(c);
            }
        }
        Collections.sort(countriesInContinent);
        return countriesInContinent;
    }
    
    public ArrayList <Country> searchCountriesWithPopulation (double population)
    {
        ArrayList <Country> countriesWithPopulation = new ArrayList<Country>();
        for(Country c: list)
        {
            if(c.getPopulationOfCountry() >= population)
            {
                countriesWithPopulation.add(c);
            }
        }
        return countriesWithPopulation;
    }
    
    public ArrayList <Country> topTenGdpCountries (String continent)
    {
        ArrayList <Country> countriesInContinent = new ArrayList <Country>();
        ArrayList <Country> tenGdpCountries = new ArrayList <Country>();
        countriesInContinent = searchCountriesInContinent(continent);
        
        for(int i = 0; i < 10; i++)
        {
            tenGdpCountries.add(countriesInContinent.get(i));
            countriesInContinent.remove(i);
        }
        
        return tenGdpCountries;
    }
}

