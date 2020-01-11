import java.util.ArrayList;
/**
 * Write a description of class CountryTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CountryTest
{
    public static void main(String args[]){
        CountryDatabase db = new CountryDatabase();

        // read the countries of the world file
        db.readCountriesData("Countries.csv");

        System.out.println("****Begin test***");

        // check number of records
        if(db.countAllCountries() != 195){
            System.out.println("Error: Number of countries should be 195");
        }

        // Testing getAllCountries() method
        ArrayList <Country> access = db.getAllCountries();
        if(access.size() != 195)
        {
            System.out.println("Error: Number of countries should be 195");
        }
        
        // Testing highestGdp(String continent) method
        Country s = db.highestGdp("North America");
        if(!(s.getNameOfCountry().equalsIgnoreCase("United States")))
        {
            System.out.println("Error: Country should be United States");
        }
        
        // Testing smallestArea(String continent) method
        Country sA = db.smallestArea("Africa");
        if(!sA.getNameOfCountry().equalsIgnoreCase("Seychelles"))
        {
            System.out.println("Error: Country should be Seychelles");
        }

        // Testing searchForCapital(String countryName) method
        String capital = db.searchForCapital("Chad");
        if(!capital.equalsIgnoreCase("N'Djamena"))
        {
            System.out.println("Error: Capital should be N'Djamena");
        }
        
        // Testing findCountryDetails(String countryName)
        Country cD = db.findCountryDetails("Cameroon");
        if(!cD.getCapitalOfCountry().equalsIgnoreCase("Yaounde"))
        {
            System.out.println("Error: Country should be Cameroon and Capital should be Yaounde");
        }
        
        // Testing searchCountriesInContinent(String continent)
        ArrayList <Country> countryList = db.searchCountriesInContinent("Africa");
        if(countryList.size() != 53)
        {
            System.out.println("Error: There should be 53 countries with a from Africa");
        }
        
        // Testing population - countries with a population > 900 million
        ArrayList <Country> tempList = db.searchCountriesWithPopulation(900000000);

        if(tempList.size() != 2){
            System.out.println("Error: it should be two countries with a " + 
                "population greater than 900 million");
        }

        // Testing topTenGdpCountries (String continent)
        ArrayList <Country> tenCountries = db.topTenGdpCountries("Asia");
        if(tenCountries.size() != 10 
        && !tenCountries.get(0).getNameOfCountry().equalsIgnoreCase("China"))
        {
            System.out.println("Error: The Country highest gdp in Asia is China"); 
        }
        
        
        
        System.out.println("*** Test complete***");
    }
}
