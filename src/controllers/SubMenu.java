package controllers;

import dto.I_SubMenu;
import dto.RAMItem;
import util.Util;
import java.util.ArrayList;
import java.util.List;

public class SubMenu extends ArrayList<RAMItem> implements I_SubMenu {

    public SubMenu() {
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
        displaySearchResults(results, "Type: " + type, "type");
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
        displaySearchResults(results, "Brand: " + brand, "brand");
    }

    @Override
    public void searchByBus(RAMList ramList) {
        int bus = Util.getInt("Enter RAM Bus Speed (MHz) to search: ");
        List<RAMItem> results = new ArrayList<>();
        for (RAMItem item : ramList) {
            if (Integer.parseInt(item.getBus()) == bus) {
                results.add(item);
            }
        }
        displaySearchResults(results, "Bus Speed: " + bus + " MHz", "bus");
    }

    @Override
    public void displaySearchResults(List<RAMItem> results, String searchCriteria, String type) {
        if (results.isEmpty()) {
            System.out.println("No RAM items found matching your criteria.");
        } else {
            System.out.printf("Search Results for %s:%n", searchCriteria);
            for (RAMItem item : results) {
                switch (type) {
                    case "type":
                        System.out.printf("Code: %s, Type: %s, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getType(),
                                item.getProductionMonthYear(),
                                item.getQuantity());
                        break;
                    case "brand":
                        System.out.printf("Code: %s, Brand: %s, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getBrand(),
                                item.getProductionMonthYear(),
                                item.getQuantity());
                        break;
                    case "bus":
                        System.out.printf("Code: %s, Bus Speed: %s MHz, Production Month/Year: %s, Quantity: %d%n",
                                item.getCode(),
                                item.getBus(),
                                item.getProductionMonthYear(),
                                item.getQuantity());
                        break;
                }
            }
        }
    }
}
