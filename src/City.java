//----------------------------------------------------- 
// Title: City Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class represents a city with a stack of cargos and a queue of vehicles.
//-----------------------------------------------------

public class City {
    private String name; // name of the city
    private Stack<CargoPackage> cargos; // stack of cargos
    private DoublyLinkedList<Vehicle> vehicles; // queue of vehicles 


    public City(String name) {
    //--------------------------------------------------------
    // Summary: Constructor to initialize the city with a name.
    // Precondition: name is a non-null string.
    // Postcondition: A City object is created with an empty stack of cargos and an empty queue of vehicles.
    //--------------------------------------------------------
        this.name = name;
        this.cargos = new Stack<>();
        this.vehicles = new DoublyLinkedList<>();
    }

    public String getName() {
    //--------------------------------------------------------
    // Summary: Gets the name of the city.
    // Precondition: None.
    // Postcondition: Returns the name of the city.
    //--------------------------------------------------------
        return name;
    }

    public void addCargo(CargoPackage cargo) {
    //--------------------------------------------------------
    // Summary: Adds a cargo to the city's stack of cargos.
    // Precondition: cargo is a non-null Cargo object.
    // Postcondition: The cargo is added to the top of the stack.
    //--------------------------------------------------------
        cargos.push(cargo);
    }

    public void addVehicle(Vehicle vehicle) {
    //--------------------------------------------------------
    // Summary: Adds a vehicle to the city's queue of vehicles.
    // Precondition: vehicle is a non-null Vehicle object.
    // Postcondition: The vehicle is added to the end of the queue.
    //--------------------------------------------------------
        vehicles.addLast(vehicle);
    }

    public CargoPackage removeCargo() {
    //--------------------------------------------------------
    // Summary: Removes a cargo from the city's stack of cargos.
    // Precondition: The stack is not empty.
    // Postcondition: The top cargo is removed and returned. Returns null if the stack is empty.
    //--------------------------------------------------------
        if (cargos.isEmpty()) {
            return null;
        }
        return cargos.pop();
    }

    public Vehicle removeVehicleQueue() {
    //--------------------------------------------------------
    // Summary: Removes a vehicle from the city's queue of vehicles.
    // Precondition: The queue is not empty.
    // Postcondition: The first vehicle is removed and returned. Returns null if the queue is empty.
    //--------------------------------------------------------
        if (vehicles.isEmpty()) {
            return null;
        }
        return vehicles.removeFirst();
    }


    public CargoPackage[] getCargos() {
    //--------------------------------------------------------
    // Summary: Gets an array of all cargos in the city's stack.
    // Precondition: None.
    // Postcondition: Returns an array of Cargo objects.
    //--------------------------------------------------------
        CargoPackage[] cargoArray = new CargoPackage[cargos.size()];
        Stack<CargoPackage> tempStack = new Stack<>();

        
        while (!cargos.isEmpty()) {
            tempStack.push(cargos.pop());
        }

        
        int i = 0;
        while (!tempStack.isEmpty()) {
            CargoPackage cargo = tempStack.pop();
            cargoArray[i++] = cargo;
            cargos.push(cargo);
        }

        return cargoArray;
    }

    public Vehicle[] getVehicles() {
    //--------------------------------------------------------
    // Summary: Gets an array of all vehicles in the city's queue.
    // Precondition: None.
    // Postcondition: Returns an array of Vehicle objects.
    //--------------------------------------------------------
        return vehicles.toArray(new Vehicle[vehicles.size()]);
    }

    @Override
    public String toString() {
    //--------------------------------------------------------
    // Summary: Returns the name of the city.
    // Precondition: None.
    // Postcondition: Returns the name of the city as a string.
    //--------------------------------------------------------
        return name;
    }

    public boolean isCargoEmpty() {
    //--------------------------------------------------------
    // Summary: Checks if the city's stack of cargos is empty.
    // Precondition: None.
    // Postcondition: Returns true if the stack is empty, false otherwise.
    //--------------------------------------------------------
        return cargos.isEmpty();
    }

    public boolean isVehicleEmpty() {
    //--------------------------------------------------------
    // Summary: Checks if the city's queue of vehicles is empty.
    // Precondition: None.
    // Postcondition: Returns true if the queue is empty, false otherwise.
    //--------------------------------------------------------
        return vehicles.isEmpty();
    }
}
