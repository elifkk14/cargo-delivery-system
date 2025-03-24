import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//----------------------------------------------------- 
// Title: Tester Class
// Author: Elif Konak
// ID: 15235113326
// Section: 02
// Assignment: 01
// Description: This class tests the functionality of the CityList and related classes by running test scenarios.
//-----------------------------------------------------

public class Tester {

    public static void runTestScenario(String folderName) {
        //--------------------------------------------------------
        // Summary: Runs a test scenario using the specified folder name.
        // Precondition: folderName is a non-null string representing the folder containing test files.
        // Postcondition: Reads data from the specified folder, executes missions, and validates results.
        //--------------------------------------------------------
        System.out.println("======================================");
        System.out.println("🚀 Starting test for folder: " + folderName);
        System.out.println("======================================\n");
        
        CityList cityList = new CityList();
        StringBuilder resultLog = new StringBuilder();
    
        Main.readCities(folderName + "cities.txt", cityList);
        Main.readVehicles(folderName + "vehicles.txt", cityList);
        Main.readPackages(folderName + "packages.txt", cityList);
        Main.readMissions(folderName + "missions.txt", cityList, resultLog);
    
        if (cityList.getCities().isEmpty()) {
            System.out.println("⚠️ Warning: No cities were loaded. Please check the input files.\n");
            return;
        }
    
        String resultFile = folderName + "result.txt";
        String expectedResultFile = folderName + "expectedResult.txt";
    
        if (resultLog.length() > 0) {
            System.out.println("💥 Issues detected during mission execution. Saving error log only.\n");
            Main.writeResults(folderName, cityList, resultLog);
        } else {
            System.out.println("🎉 No errors found. Logging full city details.\n");
            Main.writeResults(folderName, cityList, new StringBuilder());
        }
    
        boolean testPassed = validateResult(resultFile, expectedResultFile);
    
        if (testPassed) {
            System.out.println("✅ Test passed for: " + folderName + " ✅\n");
        } else {
            System.out.println("❌ Test failed for: " + folderName + " ❌\n");
        }
    }
    
    private static boolean validateResult(String resultFile, String expectedResultFile) {
        //--------------------------------------------------------
        // Summary: Validates the result by comparing the result file with the expected result file.
        // Precondition: resultFile and expectedResultFile are non-null strings representing file paths.
        // Postcondition: Returns true if the files match, otherwise returns false.
        //--------------------------------------------------------
        try {
            String resultContent = new String(Files.readAllBytes(Paths.get(resultFile)));
            String expectedContent = new String(Files.readAllBytes(Paths.get(expectedResultFile)));

            if (resultContent.equals(expectedContent)) {
                System.out.println("✓ TEST PASSED: " + resultFile + " matches expected result.");
                return true;
            } else {
                System.out.println("✗ TEST FAILED: " + resultFile + " does NOT match expected result.");
                printDifferences(resultContent, expectedContent);
                return false;
            }
        } catch (IOException e) {
            System.err.println("\n⚠️ Error reading files for validation:");
            System.err.println("❌ Failed to read either result or expected file.");
            System.err.println("🔍 Possible causes:");
            System.err.println("  1. File does not exist.");
            System.err.println("  2. Incorrect file path.");
            System.err.println("  IOException: " + e.getMessage());
            return false;
        }
    }

    private static void printDifferences(String resultContent, String expectedContent) {
        //--------------------------------------------------------
        // Summary: Prints the differences between the result content and the expected content.
        // Precondition: resultContent and expectedContent are non-null strings.
        // Postcondition: Outputs the differences to the console.
        //--------------------------------------------------------
        System.out.println("\n===============================");
        System.out.println("📝 Expected Result:");
        System.out.println("-------------------------------");
        System.out.println(expectedContent);
        System.out.println("\n===============================");
        System.out.println("📝 Actual Result:");
        System.out.println("-------------------------------");
        System.out.println(resultContent);
        System.out.println("\n===============================\n");
    }
}
