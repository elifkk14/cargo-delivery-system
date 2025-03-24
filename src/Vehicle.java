//----------------------------------------------------- 
// Title: Vehicle Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class represents a vehicle with an ID, city, capacity, and a list of cargos.
//-----------------------------------------------------

public class Vehicle extends CargoPackage {
    private String city;  // City where the vehicle is located
    private double capacity;  // Capacity of the vehicle
    private DoublyLinkedList<CargoPackage> cargoList;  // List of cargosin the vehicle 

    public Vehicle(String id, String city, double capacity) {
        super(id); // Cargo sınıfının id'yi ayarlayan yapıcı metodunu çağırır.
        this.city = city;
        this.capacity = capacity;
        this.cargoList = new DoublyLinkedList<>();
    }

    @Override
    public int compareTo(CargoPackage other) {
        //--------------------------------------------------------
        // Summary: Compares this vehicle with another vehicle based on capacity.
        // Precondition: other is a non-null Vehicle object.
        // Postcondition: Returns a negative integer, zero, or a positive integer as this vehicle's capacity is less than, equal to, or greater than the other vehicle's capacity.
        //--------------------------------------------------------
        return Double.compare(this.capacity, ((Vehicle) other).capacity);
    }

    @Override
    public String getId() {
        //--------------------------------------------------------
        // Summary: Gets the ID of the vehicle.
        // Precondition: None.
        // Postcondition: Returns the ID of the vehicle.
        //--------------------------------------------------------
        return id;
    }

    public String getCity() {
        //--------------------------------------------------------
        // Summary: Gets the city where the vehicle is located.
        // Precondition: None.
        // Postcondition: Returns the city of the vehicle.
        //--------------------------------------------------------
        return city;
    }

    public double getCapacity() {
        //--------------------------------------------------------
        // Summary: Gets the capacity of the vehicle.
        // Precondition: None.
        // Postcondition: Returns the capacity of the vehicle.
        //--------------------------------------------------------
        return capacity;
    }

    public void setCity(String city) {
        //--------------------------------------------------------
        // Summary: Sets the city where the vehicle is located.
        // Precondition: city is a non-null string.
        // Postcondition: The city of the vehicle is updated.
        //--------------------------------------------------------
        this.city = city;
    }

    public void setCapacity(double capacity) {
        //--------------------------------------------------------
        // Summary: Sets the capacity of the vehicle.
        // Precondition: capacity is a non-negative double.
        // Postcondition: The capacity of the vehicle is updated.
        //--------------------------------------------------------
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        //--------------------------------------------------------
        // Summary: Checks if the vehicle's cargo list is empty.
        // Precondition: None.
        // Postcondition: Returns true if the cargo list is empty, false otherwise.
        //--------------------------------------------------------
        return cargoList.isEmpty();  
    }

    public void addCargo(CargoPackage cargo) {
        //--------------------------------------------------------
        // Summary: Adds a cargo to the vehicle's cargo list.
        // Precondition: cargo is a non-null Cargo object.
        // Postcondition: The cargo is added to the end of the cargo list.
        //--------------------------------------------------------
        cargoList.addLast(cargo);  
    }

    public CargoPackage removeCargo() {
        //--------------------------------------------------------
        // Summary: Removes the last cargo from the vehicle's cargo list.
        // Precondition: The cargo list is not empty.
        // Postcondition: The last cargo is removed and returned. Returns null if the cargo list is empty.
        //--------------------------------------------------------
        if (!cargoList.isEmpty()) {
            return cargoList.removeLast();  
        }
        return null;
    }

    public CargoPackage removeCargoAtIndex(int dropIndex) {
        //--------------------------------------------------------
        // Summary: Removes the cargo at the specified index from the vehicle's cargo list.
        // Precondition: dropIndex is a valid index within the cargo list.
        // Postcondition: The cargo at the specified index is removed and returned. Returns null if the index is invalid.
        //--------------------------------------------------------
        if (!cargoList.isEmpty()) {
            return cargoList.removeAtIndex(dropIndex);  
        }
        return null;
    }

    @Override
    public String toString() {
        //--------------------------------------------------------
        // Summary: Returns a string representation of the vehicle.
        // Precondition: None.
        // Postcondition: Returns a string containing the ID, city, and capacity of the vehicle.
        //--------------------------------------------------------
        return id + " (" + city + ", Capacity: " + capacity + ")";
    }

    public int getVehicleCargoCount() {
        //--------------------------------------------------------
        // Summary: Gets the number of cargos in the vehicle's cargo list.
        // Precondition: None.
        // Postcondition: Returns the number of cargos in the cargo list.
        //--------------------------------------------------------
        return cargoList.size();
    }

    
}
