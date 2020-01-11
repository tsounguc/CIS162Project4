import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.IOException;

/*************************************************************
 * GUI for a Country Database class
 * 
 * @Ana Posada
 * @version March 2018
 ************************************************************/
public class CountryGUI extends JFrame implements ActionListener{

    // FIX ME: Define a CountryDatabase object
    CountryDatabase world;

    /** JButtons */
    private JButton smallestArea;
    private JButton highestGdp;
    private JButton countriesInContinent;    
    // FIX ME: Define the rest of buttons
    private JButton topTenGdp;
    private JButton populationBtn;
    private JButton capital;
    private JButton details;

    /** JTextFields */
    private JTextField continent;
    // FIX ME: Define the JTextFields for countryName and population
    private JTextField countryName;
    private JTextField population;

    /** Results text area */
    private JTextArea resultsArea;

    /** menu items */
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenuItem listAllItem;
    private JMenuItem quitItem;
    private JMenuItem openItem;
    private JMenuItem countItem;

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        CountryGUI gui = new CountryGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Countries of the world");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public CountryGUI(){

        // FIX ME: instantiate an object of type CountryDatabase  
        // This will allow you to invoke methods of the CountryDatabase class
        world = new CountryDatabase();
        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 10 rows
        resultsArea = new JTextArea(20,30);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 10;  
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 20;
        add(scrollPane, loc);  

        // create Results label
        loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        loc.insets.bottom = 20;
        loc.insets.top = 20;
        add(new JLabel("Results"), loc);

        // create Searches label
        loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridy = 0;
        loc.gridwidth = 2;
        add(new JLabel("Searches"), loc);     

        // FIX ME: instantiate the JTextFields and JButtons 
        // we are providing a few - complete the rest
        smallestArea = new JButton ("Smallest Area");
        highestGdp = new JButton ("Highest GDP");

        // FIX ME: complete the rest of the 5 JButton
        countriesInContinent = new JButton ("Countries in Continent") ;    
        topTenGdp = new JButton ("Top ten GDP");
        populationBtn = new JButton("Population");
        capital = new JButton("Capital");
        details = new JButton("Details");

        continent = new JTextField (20);
        // FIX ME: complete the JTextFields for countryName and Population
        countryName = new JTextField(20);
        population = new JTextField(20);

        // adding labels and buttons
        loc = new GridBagConstraints();

        //adding the JLabel for the Continent 
        loc.anchor = GridBagConstraints.LINE_END;
        loc.insets = new Insets(5,5,5,5);
        loc.gridx = 1;
        loc.gridy = 1;
        add(new JLabel ("Continent"), loc);

        //adding the JTextField for the continent
        loc.gridx = 2;
        loc.gridy = 1;
        loc.anchor = GridBagConstraints.LINE_START;
        add(continent, loc);

        //adding the smallestArea JButton
        loc.gridy = 2;
        add(smallestArea, loc);

        // FIX ME: complete adding the rest of the JButtons
        // associated with the continent search options
        loc.gridy = 3;
        add(highestGdp,loc);

        loc.gridy = 4;
        add(topTenGdp,loc);

        loc.gridy = 5;
        add(countriesInContinent, loc);

        //adding the JLabel for population 
        loc.gridx = 1;
        loc.gridy = 7;
        loc.insets = new Insets(30,5,5,5);
        loc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel ("Population"), loc);

        //adding the JTextField for the population
        loc.gridx = 2;
        loc.gridy = 7;
        add(population, loc);

        //adding the JButton for the population
        loc.gridy = 8;
        loc.insets = new Insets(5,5,5,5);
        loc.anchor = GridBagConstraints.LINE_START;
        add(populationBtn, loc);

        // FIX ME: add the JLabel, JTextField and JButtons for the country

        // adding the JLabel for country
        loc.gridx = 1;
        loc.gridy = 10;
        loc.insets = new Insets(30,5,5,5);
        loc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel ("Country"), loc);
        //registering the listeners for the buttons
        highestGdp.addActionListener(this); 
        smallestArea.addActionListener(this); 

        // adding the JTextField for country
        loc.gridx = 2;
        loc.gridy = 10;
        add(countryName, loc);

        //adding the JButtons for the country
        loc.gridy = 11;
        loc.insets = new Insets(5,5,5,5);
        loc.anchor = GridBagConstraints.LINE_START;
        add(capital, loc);

        loc.gridy = 12;
        loc.insets = new Insets(5,5,5,5);
        loc.anchor = GridBagConstraints.LINE_START;
        add(details, loc);

        // FIX ME: complete for the rest of the JButtons - register listeners for the buttons

        topTenGdp.addActionListener(this); 
        countriesInContinent.addActionListener(this);
        populationBtn.addActionListener(this);
        capital.addActionListener(this);
        details.addActionListener(this);
        // hide details of creating menus
        setupMenus();
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){

        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        // loads the file with the countries of the world    
        if (buttonPressed == openItem){
            openFile();
        }  

        // quit item 
        if (buttonPressed == quitItem){
            System.exit(1);
        }  

        if (world.countAllCountries() == 0)
            JOptionPane.showMessageDialog(this, "Forgot to read the file?");
        else { 
            if (buttonPressed == countItem)
            {
                displayCounts();
            }
            else if (buttonPressed == listAllItem)
            {
                displayCountries (world.getAllCountries ());
            } 

            // FIX ME: write an else if for the rest of JButtons pressed 
            else if (buttonPressed == smallestArea)
            {
                displaySmallestArea();
            }

            else if (buttonPressed == highestGdp)
            {
                displayHighestGdp();
            }

            else if (buttonPressed == topTenGdp)
            {
                displayTopTen();
            }

            else if(buttonPressed == countriesInContinent)
            {
                displayCountriesInContinent();
            }

            else if(buttonPressed == populationBtn)
            {
                displayPopulation();
            }

            else if(buttonPressed == capital)
            {
                displaySearchForCapital();
            }

            else if(buttonPressed == details)
            {
                displaySearchForCountry();
            }

        }
    }

    /*****************************************************************
     * displays the ArrayList passed as input parameter
     * @param - ArrayList <Country>
     ****************************************************************/ 
    private void displayCountries(ArrayList <Country> list) {
        // FIX ME: complete the code for this method. See example
        // on project description on page 7
        resultsArea.setText("");

        for(Country c: list)
        {
            resultsArea.append("\n " + c.toString() + "\n");
        }
        resultsArea.append("\nThere are " + list.size() + " countries");
    }

    /*****************************************************************
     * display country with smallest area
     ****************************************************************/ 
    private void displaySmallestArea (){
        // FIX ME: complete the code for this method.
        resultsArea.setText("");
        String continentInput = continent.getText();
        if(continentInput.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Provide a continent");
        }
        else{
            resultsArea.append("" + world.smallestArea(continentInput));
        }
    }

    /*****************************************************************
     * display country with highest GDP
     ****************************************************************/ 
    private void displayHighestGdp ()  {
        // FIX ME: complete the code for this method. 

        resultsArea.setText("");
        String continentInput = continent.getText();
        if(continentInput.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Provide a continent");
        }
        else{

            resultsArea.append("" + world.highestGdp(continentInput));
        }
    }

    /*****************************************************************
     * display the countries in a particular continent
     ****************************************************************/ 
    private void displayCountriesInContinent() {
        if (continent.getText().length() > 0) 
            displayCountries(world.searchCountriesInContinent (continent.getText()));     
        else
            JOptionPane.showMessageDialog(this, "Enter a continent");

    }

    /*****************************************************************
     * display top ten GDP countries
     ****************************************************************/ 
    private void displayTopTen () {
        // FIX ME: complete the code for this method. 
        resultsArea.setText("");
        int i = 1;
        String continentInput = continent.getText();
        if(continentInput.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Enter a Continent");
        }else
        {
            for (Country c: world.topTenGdpCountries(continentInput))
            {
                resultsArea.append("\n" + i + ". " + c.toString() + " \n");
                i++;
            }
            resultsArea.append("\n There are " + 
            world.topTenGdpCountries(continentInput).size() +
            " countries");
        }
    }

    /*****************************************************************
     * display the capital for a particular country
     ****************************************************************/ 
    private void displaySearchForCapital ()  {
        // FIX ME: complete the code for this method. 
        resultsArea.setText("");
        String countryInput = countryName.getText();
        if(countryInput.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Enter a Country");
        }else{
            resultsArea.append(" " +  world.searchForCapital(countryInput));
        }
    }

    /*****************************************************************
     * display the facts about a country
     ****************************************************************/ 
    private void displaySearchForCountry ()  {
        DecimalFormat fmt = new DecimalFormat ("###,###,###,###");
        if (countryName.getText().length() > 0){
            Country country = world.findCountryDetails (countryName.getText());
            if (country != null){
                resultsArea.setText ("\nCountry Name:\t" + country.getNameOfCountry() + 
                    "\nContinent:\t" + country.getContinentOfCountry() +
                    "\nCapital:\t" + country.getCapitalOfCountry() +
                    "\nArea in sq km:\t" + fmt.format(country.getAreaOfCountry()) +
                    "\nPopulation:\t" + fmt.format (country.getPopulationOfCountry() / 1000000) + " million" +
                    "\nGDP:\t" + fmt.format (country.getGdpOfCountry() / 1000000000) + " billion" +
                    "\nPerCapita GDP:\t" + fmt.format (country.getGdpOfCountry() / country.getPopulationOfCountry()) );
            }
            else 
                resultsArea.setText ("Country not found");
        }
        else
            JOptionPane.showMessageDialog(this, "Enter a country");
    }

    /*****************************************************************
     * display counts - total number of countries
     ****************************************************************/ 
    private void displayCounts () {
        // FIX ME: complete the code for this method. 
        resultsArea.setText("");
        resultsArea.append("There are " + world.countAllCountries() + " countries");

    }

    /*****************************************************************
     * display countries with a population greater than a specific value
     ****************************************************************/ 
    private void displayPopulation () {
        try {
            double people = Double.parseDouble(population.getText());
            displayCountries (world.searchCountriesWithPopulation(people));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Enter a valid number for population");
        }

    }

    /*****************************************************************
     * open a data file with the name selected by the user
     ****************************************************************/ 
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();

            // FIX ME: change the following line as needed
            // change world to the name of your instance variable
            world.readCountriesData(filename);

        }
    }

    /*******************************************************
     * Creates the menu items
     *******************************************************/    
    private void setupMenus(){
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        countItem = new JMenuItem("Counts");
        listAllItem = new JMenuItem("List Countries");
        openItem = new JMenuItem("Open...");

        fileMenu.add(openItem);
        fileMenu.add(countItem);
        fileMenu.add(listAllItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // register the menu items with the action listener
        countItem.addActionListener(this); 

        // FIX ME: complete the other three menu items.
        fileMenu.addActionListener(this);
        quitItem.addActionListener(this);
        listAllItem.addActionListener(this);
        openItem.addActionListener(this);

    }
}