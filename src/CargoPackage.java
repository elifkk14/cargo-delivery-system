//-----------------------------------------------------
// Title: Cargo Package Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class represents a cargo with a unique ID.
//-----------------------------------------------------
public class CargoPackage implements Comparable<CargoPackage>  {
    public String id; // ID of the cargo

    public CargoPackage(String id) {
        //-------------------------------------------------------- 
        // Summary: Constructs a new Cargo object with the given ID.
        // Precondition: id is not null and not empty.
        // Postcondition: A new Cargo Package object is created with the given ID. 
        //-------------------------------------------------------- 
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }
        this.id = id;
    }
    public String getId() {
        //-------------------------------------------------------- 
        // Summary: Returns the ID of the cargo.
        // Precondition: None.
        // Postcondition: The ID of the cargo package is returned. 
        //-------------------------------------------------------- 
        return id;
    }

    @Override
    public int compareTo(CargoPackage other) {
        //-------------------------------------------------------- 
        // Summary: Compares this Cargo object with another Cargo package object based on their IDs.
        // Precondition: other is not null.
        // Postcondition: Returns a negative integer, zero, or a positive integer as this Cargo package object's ID
        // is less than, equal to, or greater than the other Cargo package object's ID. 
        //-------------------------------------------------------- 
        if (other == null) {
            throw new NullPointerException("The other Cargo object is null.");
        }
        return this.id.compareTo(other.id);  
    }

    @Override
    public boolean equals(Object obj) {
        //-------------------------------------------------------- 
        // Summary: Checks if this Cargo object is equal to another object.
        // Precondition: None.
        // Postcondition: Returns true if the given object is a Cargo package object with the same ID, false otherwise. 
        //-------------------------------------------------------- 
        if (this == obj) return true;  
        if (obj == null || getClass() != obj.getClass()) return false;  
        CargoPackage other = (CargoPackage) obj;
        return this.id.equals(other.id); 
    }

    @Override
    public int hashCode() {
        //-------------------------------------------------------- 
        // Summary: Returns the hash code of the Cargo package object, based on its ID.
        // Precondition: None.
        // Postcondition: Returns the hash code of the Cargo package object. 
        //-------------------------------------------------------- 
        return id.hashCode();  
    }

    @Override
    public String toString() {
        //-------------------------------------------------------- 
        // Summary: Returns a string representation of the Cargo package object.
        // Precondition: None.
        // Postcondition: Returns the ID of the Cargo package object. 
        //-------------------------------------------------------- 
        return id;  
    }
}