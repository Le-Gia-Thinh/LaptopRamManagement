package controllers;

import dto.I_List;
import dto.RamItem;
import util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class RamList extends ArrayList<RamItem> implements I_List {

    public int checkExist(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addItem() {
        String code = Util.formatCode("Input ID for RAM (format: RAMx_y): ");
        if (checkExist(code) != -1) {
            System.out.println("Error: RAM ID already exists. Please enter a unique ID.");
            return;
        }

        String name = Util.getString("Enter RAM Name: ");
        String type = Util.getString("Enter RAM Type (e.g., LPDDR5, DDR5, LPDDR4, DDR4): ");
        String bus = Util.getString("Enter RAM Bus Speed (MHz): ");
        String brand = Util.getString("Enter RAM Brand: ");
        int quantity = Util.getInt("Enter RAM Quantity: ");
        String productionDate = Util.getString("Enter Production Month/Year: ");

        RamItem newItem = new RamItem(code, name, type, bus, brand, quantity, productionDate, true);
        this.add(newItem);
        System.out.println("RAM item added successfully!");

        // Prompt to continue adding or return to main menu
        if (Util.confirmYesNo("Do you want to add another item? (yes/no)")) {
            addItem();
        }
    }

    @Override
    public void update() {
        String code = Util.getString("Enter the RAM code to update: ");
        int index = checkExist(code);

        if (index == -1) {
            System.out.println("Error: RAM item not found.");
            return;
        }

        RamItem item = this.get(index);
        String newType = Util.getString("Enter new RAM Type (leave blank to keep current): ");
        if (!newType.isEmpty()) item.setType(newType);

        int newBus = Util.getInt("Enter new RAM Bus Speed (leave blank to keep current, or input -1): ");
        if (newBus >= 0) item.setBus(String.valueOf(newBus));

        String newBrand = Util.getString("Enter new RAM Brand (leave blank to keep current): ");
        if (!newBrand.isEmpty()) item.setBrand(newBrand);

        int newQuantity = Util.getInt("Enter new RAM Quantity (leave blank to keep current, or input -1): ");
        if (newQuantity >= 0) item.setQuantity(newQuantity);

        System.out.println("RAM item updated successfully!");
    }

    @Override
    public void delete() {
        String code = Util.getString("Enter the RAM code to delete: ");
        int index = checkExist(code);

        if (index == -1) {
            System.out.println("Error: RAM item not found.");
            return;
        }
        if (Util.confirmYesNo("Are you sure you want to delete this item? (yes/no)")) {
            this.get(index).setActive(false);
            System.out.println("RAM item marked as inactive.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    @Override
    public void displayAll() {
        List<RamItem> activeItems = new ArrayList<>();
        for (RamItem item : this) {
            if (item.isActive()) {
                activeItems.add(item);
            }
        }
        activeItems.sort(Comparator.comparing(RamItem::getType).thenComparing(RamItem::getBus).thenComparing(RamItem::getBrand));

        System.out.println("Active RAM Items:");
        for (RamItem item : activeItems) {
            System.out.printf("Code: %s, Type: %s, Bus: %s, Brand: %s, Quantity: %d, Production Date: %s%n",
                    item.getCode(), item.getType(), item.getBus(), item.getBrand(), item.getQuantity(), item.getProductionMonthYear());
        }
    }

    @Override
    public void loadFromFile() {
        File file = new File("RAMModules.dat");
        System.out.println("Loading data from: " + file.getAbsolutePath()); // Hiển thị đường dẫn
        if (!file.exists()) {
            System.out.println("File not found. Starting with an empty list.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                RamItem item = (RamItem) ois.readObject();
                this.add(item);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    @Override
    public void saveToFile() {
        File file = new File("RAMModules.dat");
        System.out.println("Saving data to: " + file.getAbsolutePath()); // Hiển thị đường dẫn
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (RamItem item : this) {
                if (item.isActive()) {
                    oos.writeObject(item);
                }
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
