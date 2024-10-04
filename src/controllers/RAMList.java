package controllers;

import dto.I_List;
import dto.RAMItem;
import util.Service;
import util.Sort;
import util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// The RAMList class extends ArrayList<RAMItem> and implements the I_List interface
public class RAMList extends ArrayList<RAMItem> implements I_List {

    // Constructor: Initializes the list and loads data from the file
    public RAMList() {
        this.loadFromFile();
    }

    // Method to check the existence of a RAM item by its code
    public int checkExist(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equalsIgnoreCase(code)) {
                return i; // Return the index of the item if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Method to add a new RAM item
    @Override
    public void addItem() {
        String type = Service.TypeMenu("Enter RAM Type: "); // Call type selection menu
        int currentCount = this.size();
        String code = Util.generateUniqueRAMCode(type, currentCount); // Generate unique code

        // Collect the remaining information for the new RAM item
        String bus = Service.BusMenu("Enter RAM Bus: "); // Call bus selection menu
        String brand = Util.getString("Enter RAM Brand: ");
        int quantity = Util.getInt("Enter RAM Quantity: ");
        String production_month_year = Util.getDate();

        RAMItem newItem = new RAMItem(code, type, bus, brand, quantity, production_month_year, true);
        this.add(newItem);
        System.out.println("RAM item added successfully!");

        if (Util.confirmYesNo("Do you want to add another item? (y = yes /n = no )")) {
            addItem();
        }
    }


    // Method to update an existing RAM item
    @Override
    public void update() {
        String code = Util.getString("Enter the RAM item code to update: ");
        int index = checkExist(code); // Check if the item exists

        // If not found, notify and exit
        if (index == -1) {
            System.out.println("RAM item with the specified code does not exist.");
            return;
        }

        RAMItem item = this.get(index); // Get the item to update
        System.out.printf("Current Information: %s%n", item.toString()); // Display current information

        // Update each attribute of the item
        item.setType(Service.TypeMenu("Enter new RAM Type (leave empty to retain current): "));
        item.setBus(Service.BusMenu("Enter new RAM Bus Speed (leave empty to retain current): "));
        item.setBrand(Util.updateString("Enter new RAM Brand (leave empty to retain current): ", item.getBrand()));
        item.setQuantity(Util.updateInt("Enter new Quantity (leave empty to retain current): ", item.getQuantity()));

        System.out.println("RAM item updated successfully!");
    }

    // Method to delete a RAM item
    @Override
    public void delete() {
        String code = Util.getString("Enter the RAM code to delete: ");
        int index = checkExist(code); // Check if the item exists

        // If not found, notify and exit
        if (index == -1) {
            System.out.println("Error: RAM item not found.");
            return;
        }
        // Confirm if the user wants to delete the item
        if (Util.confirmYesNo("Are you sure you want to delete this item? (y = yes /n = no )")) {
            this.get(index).setActive(false); // Mark the item as inactive
            System.out.println("RAM item marked as inactive.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    // Method to display all active RAM items
    @Override
    public void displayAll() {
        List<RAMItem> activeItems = new ArrayList<>();
        for (RAMItem item : this) {
            if (item.isActive()) {
                activeItems.add(item); // Add active items to the list
            }
        }

        int sortChoice = Service.displaySortMenu(); // Display
        switch (sortChoice) {
            case 1:
                activeItems.sort(Sort.sortByType());
                break;
            case 2:
                activeItems.sort(Sort.sortByBus());
                break;
            case 3:
                activeItems.sort(Sort.sortByBrand());
                break;
            case 4:
                return; // Back MENU
            default:
                System.out.println("Invalid choice! Please try again.");
                return;
        }

        System.out.println("Active RAM Items:");
        for (RAMItem item : activeItems) {
            System.out.printf("Code: %s, Type: %s, Bus: %s, Brand: %s, Quantity: %d, Production Date: %s%n",
                    item.getCode(), item.getType(), item.getBus(), item.getBrand(), item.getQuantity(), item.getProduction_month_year());
        }
    }

    // Method to load RAM items from a file
    @Override
    public void loadFromFile() {
        File file = new File("RAMModules.dat");
        System.out.println("Loading data from: " + file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("File not found. Starting with an empty list.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                RAMItem item = (RAMItem) ois.readObject(); // Read items from the file
                this.add(item); // Add each item to the list
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Method to save RAM items to a file
    @Override
    public void saveToFile() {
        File file = new File("RAMModules.dat");
        System.out.println("Saving data to: " + file.getAbsolutePath());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (RAMItem item : this) {
                if (item.isActive()) {
                    oos.writeObject(item); // Write only active items to the file
                }
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
