import java.util.ArrayList;
import java.util.List;
//----------------------------------------------------- 
// Title: CityList Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class manages a list of City objects.
//-----------------------------------------------------
public class CityList {
    private List<City> cities; // List of cities

    public CityList() {
        //--------------------------------------------------------
        // Summary: Constructor to initialize the CityList with an empty list of cities.
        // Precondition: None.
        // Postcondition: A CityList object is created with an empty list of cities.
        //--------------------------------------------------------
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        //--------------------------------------------------------
        // Summary: Adds a city to the list.
        // Precondition: city is a non-null City object.
        // Postcondition: The city is added to the list.
        //--------------------------------------------------------
        if (city != null) {
            cities.add(city);
        }
    }

    public City findCity(String cityName) {
        //--------------------------------------------------------
        // Summary: Finds a city by its name.
        // Precondition: cityName is a non-null string.
        // Postcondition: Returns the City object if found, otherwise returns null.
        //--------------------------------------------------------
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null; 
    }

    public List<City> getCities() {
        //--------------------------------------------------------
        // Summary: Gets a list of all cities.
        // Precondition: None.
        // Postcondition: Returns a new list containing all City objects.
        //--------------------------------------------------------
        return new ArrayList<>(cities); 
    }

    public boolean containsCity(String sourceCity) {
        //--------------------------------------------------------
        // Summary: Checks if a city with the given name exists in the list.
        // Precondition: sourceCity is a non-null string.
        // Postcondition: Returns true if the city exists, otherwise returns false.
        //--------------------------------------------------------
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(sourceCity)) {
                return true;
            }
        }
        return false;
    }
}
