package controllers;


import dto.I_SubMenu;
import dto.RAMItem;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class SubMenu extends ArrayList <RAMItem> implements I_SubMenu {

    public SubMenu(){

    }
    @Override
    public void searchByType(RAMList ramList) {
        String type = Util.getString("Enter RAM Type to search: ");
        List<RAMItem> results = new ArrayList<>();
        for (RAMItem item : ramList) {
            if (item.getType().equalsIgnoreCase(type)) {
                results.add(item);
            }
        }
        displaySearchResults(results, "Type: " + type);
    }

    @Override
    public void searchByBrand(RAMList ramList) {
        String brand = Util.getString("Enter RAM Brand to search: ");
        List<RAMItem> results = new ArrayList<>();
        for (RAMItem item : ramList) {
            if (item.getBrand().equalsIgnoreCase(brand)) {
                results.add(item);
            }
        }
        displaySearchResults(results, "Brand: " + brand);
    }

    @Override
    public void searchByBus(RAMList ramList) {
        int bus = Util.getInt("Enter RAM Bus Speed (MHz) to search: ");
        List<RAMItem> results = new ArrayList<>();
        for (RAMItem item : ramList) {
            if (item.getBus().equalsIgnoreCase(String.valueOf(bus))) {
                results.add(item);
            }
        }
        displaySearchResults(results, "Bus Speed: " + bus + " MHz");
    }

    @Override
    public void displaySearchResults(List<RAMItem> results, String searchCriteria) {

        if (results.isEmpty()) {
            System.out.println("No RAM items found matching your criteria.");
        } else {
            System.out.printf("Search Results for %s:%n", searchCriteria);
            for (RAMItem item : results) {
                System.out.printf("Code: %s, Type: %s, Bus: %s, Production Month/Year: %s, Quantity: %d%n",
                        item.getCode(),
                        item.getType(),
                        item.getBus(),
                        item.getProductionMonthYear(),
                        item.getQuantity());
            }
        }
    }
}
