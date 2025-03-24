//----------------------------------------------------- 
// Title: Mission Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class represents a mission with source, middle, destination, total source packages, total middle packages, and drop indices.
//-----------------------------------------------------
public class Mission {
    private String sourceCity;
    private String middleCity;
    private String destCity;
    private int totalSourcePackages;
    private int totalMiddlePackages;
    private int[] dropIndices;

    public Mission(String sourceCity, String middleCity, String destCity, 
                   int totalSourcePackages, int totalMiddlePackages, int[] dropIndices) {
        //----------------------------------------
        // Summary: Constructs a new Mission object
        // Precondition: sourceCity, middleCity, destCity, totalSourcePackages, totalMiddlePackages, and dropIndices are valid
        // Postcondition: A new Mission object is created
        //----------------------------------------
        this.sourceCity = sourceCity;
        this.middleCity = middleCity;
        this.destCity = destCity;
        this.totalSourcePackages = totalSourcePackages;
        this.totalMiddlePackages = totalMiddlePackages;
        this.dropIndices = dropIndices;
    }

    public String getSourceCity() {
        //----------------------------------------
        // Summary: Returns the source city of the mission
        // Precondition: None
        // Postcondition: The source city is returned
        //----------------------------------------
        return sourceCity;
    }

    public String getMiddleCity() {
        //----------------------------------------
        // Summary: Returns the middle city of the mission
        // Precondition: None
        // Postcondition: The middle city is returned
        //----------------------------------------
        return middleCity;
    }

    public String getDestCity() {
        //----------------------------------------
        // Summary: Returns the destination city of the mission
        // Precondition: None
        // Postcondition: The destination city is returned
        //----------------------------------------
        return destCity;
    }

    public int getTotalSourcePackages() {
        //----------------------------------------
        // Summary: Returns the total source packages of the mission
        // Precondition: None
        // Postcondition: The total source packages are returned
        //----------------------------------------
        return totalSourcePackages;
    }

    public int getTotalMiddlePackages() {
        //----------------------------------------
        // Summary: Returns the total middle packages of the mission
        // Precondition: None
        return totalMiddlePackages;
    }

    public int[] getDropIndices() {
        //----------------------------------------
        // Summary: Returns the drop indices of the mission
        // Precondition: None
        // Postcondition: The drop indices are returned
        //----------------------------------------
        return dropIndices;
    }
}
