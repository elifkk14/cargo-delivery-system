import java.io.*;
import java.util.*;
//----------------------------------------------------- 
// Title: Main Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class provides the main method to run the test scenarios.
//-----------------------------------------------------

public class Main {

    public static void main(String[] args) {
        //----------------------------------------
        // Summary: Main method that runs the test scenarios(test1, test2, test3, test4).
        // Precondition: None
        // Postcondition: None
        //----------------------------------------

        System.out.println("\n===============================");
        System.out.println("Running Test Scenario 1:");
        Tester.runTestScenario("input_output/test1/");
        
    
        System.out.println("\n===============================");
        System.out.println("Running Test Scenario 2:");
        Tester.runTestScenario("input_output/test2/");
       
        System.out.println("\n===============================");
        System.out.println("Running Test Scenario 3:");
        Tester.runTestScenario("input_output/test3/");
       
    
        System.out.println("\n===============================");
        System.out.println("Running Test Scenario 4:");
        Tester.runTestScenario("input_output/test4/");
        if (args.length != 5) { 
            System.out.println("Usage: java Main cities.txt packages.txt vehicles.txt missions.txt result.txt");
        }

       
    }
    
    
    public static void readCities(String citiesFile, CityList cityList) {
        //--------------------------------------------------------
        // Summary: Reads cities from the specified file and adds them to the list.
        // Precondition: citiesFile is a non-null string representing the file path.
        // Postcondition: The cities are added to the list.
        //--------------------------------------------------------
        try (Scanner scanner = new Scanner(new File(citiesFile))) {
            while (scanner.hasNextLine()) {
                String city = scanner.nextLine().trim();
                cityList.addCity(new City(city));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading cities file: " + e.getMessage());
        }
    }

    public static void readPackages(String packagesFile, CityList cityList) {
        //--------------------------------------------------------
        // Summary: Reads packages from the specified file and adds them to the list.
        // Precondition: packagesFile is a non-null string representing the file path.
        // Postcondition: The packages are added to the list.
        //--------------------------------------------------------
        try (Scanner scanner = new Scanner(new File(packagesFile))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split(" ");
                String packageId = parts[0];
                String city = parts[1];
                City c = cityList.findCity(city);
                if (c != null) {
                    c.addCargo(new CargoPackage(packageId));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading packages file: " + e.getMessage());
        }
    }

    
    public static void readVehicles(String vehiclesFile, CityList cityList) {
        //--------------------------------------------------------
        // Summary: Reads vehicles from the specified file and adds them to the list.
        // Precondition: vehiclesFile is a non-null string representing the file path.
        // Postcondition: The vehicles are added to the list.
        //--------------------------------------------------------
        try (Scanner scanner = new Scanner(new File(vehiclesFile))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().trim().split(" ");
                String vehicleId = parts[0];
                String city = parts[1];
                double capacity = Double.parseDouble(parts[2]);
                City c = cityList.findCity(city);
                if (c != null) {
                    c.addVehicle(new Vehicle(vehicleId, city, capacity));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading vehicles file: " + e.getMessage());
        }
    }


        public static void readMissions(String fileName, CityList cityList, StringBuilder resultLog) {
            //--------------------------------------------------------
            // Summary: Reads missions from the specified file and executes them.
            // Precondition: fileName is a non-null string representing the file path.
            // Postcondition: The missions are executed.
            //--------------------------------------------------------
            try {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    boolean errorOccurred = false; 
                    
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("-");
                        if (parts.length < 6) { 
                            if (!errorOccurred) {
                                errorOccurred = true;
                                resultLog.append("Errors:\n"); 
                            }
                            resultLog.append("Error: Invalid mission format in line: ").append(line).append("\n");
                            continue;
                        }
                        
                        String sourceCity = parts[0];
                        String middleCity = parts[1];
                        String destinationCity = parts[2];
                        int totalSourcePackages = Integer.parseInt(parts[3]);
                        int totalMiddlePackages = Integer.parseInt(parts[4]);
                        int[] dropIndices = parseDropIndices(parts[5]);
                        
                       
                        if (!cityList.containsCity(sourceCity) || !cityList.containsCity(middleCity) || !cityList.containsCity(destinationCity)) {
                            if (!errorOccurred) {
                                resultLog.append("Errors:\n"); 
                                errorOccurred = true;
                            }
                            resultLog.append("Error: One or more cities not found for the mission.\n");
                            break; 
                        } else {
                            
                            performMission(sourceCity, middleCity, destinationCity, totalSourcePackages, totalMiddlePackages, dropIndices, cityList, resultLog);
                        }
                    }
                }
            } catch (IOException e) {
                resultLog.append("Error reading missions file: ").append(e.getMessage()).append("\n");
            }
        }
    
        
        private static int[] parseDropIndices(String dropIndicesStr) {
            //--------------------------------------------------------
            // Summary: Parses the drop indices from a string.
            // Precondition: dropIndicesStr is a non-null string representing the drop indices.
            // Postcondition: The drop indices are parsed and returned as an array.
            //--------------------------------------------------------
            String[] indices = dropIndicesStr.split(",");
            int[] dropIndices = new int[indices.length];
            for (int i = 0; i < indices.length; i++) {
                dropIndices[i] = Integer.parseInt(indices[i].trim());
            }
            return dropIndices;
        }
        
        public static void performMission(String sourceCity, String middleCity, String destCity,
                                  int totalSourcePackages, int totalMiddlePackages, int[] dropIndices,
                                  CityList cityList, StringBuilder resultLog) {
            //--------------------------------------------------------
            // Summary: Performs a mission with the specified parameters.
            // Precondition: sourceCity, middleCity, destCity, totalSourcePackages, totalMiddlePackages, and dropIndices are valid.
            // Postcondition: The mission is performed.
            //--------------------------------------------------------
            
            
            City source = cityList.findCity(sourceCity); // Find the source city
            City middle = cityList.findCity(middleCity); // Find the middle city
            City destination = cityList.findCity(destCity); // Find the destination city

            if (source == null || middle == null || destination == null) {
                String errorMessage = "Error: One or more cities not found for the mission.";
                System.out.println(errorMessage);
                resultLog.append(errorMessage).append("\n");
                return;
            }
            
            Vehicle vehicle = source.removeVehicleQueue(); // Remove a vehicle from the source city
            if (vehicle == null) {
                String errorMessage = "Error: No vehicle available for mission in " + sourceCity;
                System.out.println(errorMessage);
                resultLog.append(errorMessage).append("\n");
                return;
            }
            
            List<CargoPackage> sourceTempList = new ArrayList<>(); // Create a temporary list for the source city
            for (int i = 0; i < totalSourcePackages && !source.isCargoEmpty(); i++) {
            CargoPackage cargo = source.removeCargo(); // Remove cargo from the source city
            if (cargo != null) {
                sourceTempList.add(cargo); // Add cargo to the temporary list
            }
        }
        
        List<CargoPackage> middleTempList = new ArrayList<>(); // Create a temporary list for the middle city
        for (int i = 0; i < totalMiddlePackages && !middle.isCargoEmpty(); i++) {
            CargoPackage cargo = middle.removeCargo(); // Remove cargo from the middle city
            if (cargo != null) {
                middleTempList.add(cargo);  // Add cargo to the temporary list
            }
        }
        
        List<CargoPackage> droppedAtMiddle = new ArrayList<>(); // Create a list for dropped cargo at the middle city
        for (int dropIndex : dropIndices) {
            if (dropIndex < sourceTempList.size()) {
                CargoPackage cargoToDrop = sourceTempList.get(dropIndex); // Get cargo to drop from the source city 
                droppedAtMiddle.add(cargoToDrop); // Add cargo to the dropped at middle list
            }
        }
        
        for (CargoPackage cargo : droppedAtMiddle) { // Remove cargo from the source city
            sourceTempList.remove(cargo);
        }

        for (CargoPackage cargo : droppedAtMiddle) { // Add cargo to the middle city
            middle.addCargo(cargo);
        }

        for (CargoPackage cargo : sourceTempList) { // Add cargo to the destination city
            destination.addCargo(cargo);
        }

        for (CargoPackage cargo : middleTempList) { // Add cargo to the destination city 
            destination.addCargo(cargo);
        }
        
        destination.addVehicle(vehicle); // Add the vehicle to the destination city
    }

        public static void writeResults(String testCaseDir, CityList cityList, StringBuilder resultLog) {
            //--------------------------------------------------------
            // Summary: Writes the results to a file.
            // Precondition: testCaseDir, cityList, and resultLog are non-null.
            // Postcondition: The results are written to a file.
            //--------------------------------------------------------
            try {
                File resultFileObj = new File(testCaseDir + "/result.txt");  
                System.out.println("Writing results to: " + resultFileObj.getAbsolutePath() + "\n");
        
                try (FileWriter writer = new FileWriter(resultFileObj)) {
                    if (resultLog.length() > 0) {
                        writer.write(resultLog.toString());
                    } else {
                        for (City city : cityList.getCities()) {
                            writer.write(city.getName() + "\n");
        
                            writer.write("Packages:\n");
                            CargoPackage[] cargoList = city.getCargos();
                            
                            
                            for (int i = cargoList.length - 1; i >= 0; i--) {
                                writer.write(cargoList[i].getId() + "\n");
                            }
        
                            writer.write("Vehicles:\n");
                            Vehicle[] vehicleList = city.getVehicles();
                            
                            
                            for (Vehicle vehicle : vehicleList) {
                                writer.write(vehicle.getId() + "\n");
                            }
        
                            writer.write("-------------\n");
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error writing result file: " + e.getMessage());
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        
    }
    
    
    

