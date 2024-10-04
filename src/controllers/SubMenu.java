package controllers;

import dto.I_SubMenu;
import dto.RAMItem;
import util.Service;
import util.Util;
import java.util.ArrayList;
import java.util.List;

public class SubMenu extends ArrayList<RAMItem> implements I_SubMenu {

    public SubMenu() {
    }

    // Method to search RAM by type
    @Override
    public void searchByType(RAMList ramList) {
        // Prompt user to input RAM type
        String type = Service.TypeMenu("Enter RAM Type to search: ");

        // List to store search results
        List<RAMItem> results = new ArrayList<>();

        // Loop through RAMList to find matching items
        for (RAMItem item : ramList) {
            if (item.getType().equalsIgnoreCase(type)) {
                results.add(item);
            }
        }
        // Display search results based on type
        displaySearchResults(results, "Type: " + type, "type");
        // Return to main menu or continue searching
        returnToMainMenu(this, ramList);
    }

    // Method to search RAM by bus speed
    @Override
    public void searchByBus(RAMList ramList) {
        // Prompt user to input RAM bus speed
        String bus = Service.BusMenu("Enter RAM Bus Speed to search: ");

        // List to store search results
        List<RAMItem> results = new ArrayList<>();

        // Loop through RAMList to find matching items
        for (RAMItem item : ramList) {
            if (item.getBus().equalsIgnoreCase(bus)) {
                results.add(item);
            }
        }

        // Display search results based on bus speed
        displaySearchResults(results, "Bus Speed: " + bus + " MHz", "bus");

        // Return to main menu or continue searching
        returnToMainMenu(this, ramList);
    }

    // Method to search RAM by brand
    @Override
    public void searchByBrand(RAMList ramList) {
        // Prompt user to input RAM brand
        String brand = Util.getString("Enter RAM Brand to search: ");

        // List to store search results
        List<RAMItem> results = new ArrayList<>();

        // Loop through RAMList to find matching items
        for (RAMItem item : ramList) {
            if (item.getBrand().equalsIgnoreCase(brand)) {
                results.add(item);
            }
        }

        // Display search results based on brand
        displaySearchResults(results, "Brand: " + brand, "brand");

        // Return to main menu or continue searching
        returnToMainMenu(this, ramList);
    }

    // Method to display search results
    @Override
    public void displaySearchResults(List<RAMItem> results, String searchCriteria, String type) {
        // Check if results are empty
        if (results.isEmpty()) {
            System.out.println("No RAM items found matching your criteria.");
        } else {
            // Print search criteria and display each matching RAM item
            System.out.printf("Search Results for %s:%n", searchCriteria);
            for (RAMItem item : results) {
                switch (type) {
                    case "type":
                        // Display details when searching by type
                        System.out.printf("Code: %s, Type: %s, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getType(),
                                item.getProduction_month_year(),
                                item.getQuantity());
                        break;
                    case "brand":
                        // Display details when searching by brand
                        System.out.printf("Code: %s, Brand: %s, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getBrand(),
                                item.getProduction_month_year(),
                                item.getQuantity());
                        break;
                    case "bus":
                        // Display details when searching by bus speed
                        System.out.printf("Code: %s, Bus Speed: %s MHz, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getBus(),
                                item.getProduction_month_year(),
                                item.getQuantity());
                        break;
                }
            }
        }
    }

    // Method to return to main menu or continue searching
    public void returnToMainMenu(SubMenu subMenu, RAMList ramList) {
        // Prompt user to return to main menu or continue searching
        if (Util.confirmYesNo("Do you want to return to the main menu? (y = yes /n = no )")) {
            // If yes, create new Program instance and show the main menu
            Program menu = new Program();
            menu.showMenu();
        } else {
            // If no, continue with search functionality
            System.out.println("Continuing the search...");
            Service.searchMenu(subMenu, ramList);
        }
    }

}
