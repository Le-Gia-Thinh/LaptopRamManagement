package util;

import dto.RAMItem;

import java.util.Comparator;

public class Sort {
    // Sắp xếp theo loại RAM
    public static Comparator<RAMItem> sortByType() {
        return new Comparator<RAMItem>() {
            @Override
            public int compare(RAMItem item1, RAMItem item2) {
                return item1.getType().compareTo(item2.getType());
            }
        };
    }

    // Sắp xếp theo bus RAM
    public static Comparator<RAMItem> sortByBus() {
        return new Comparator<RAMItem>() {
            @Override
            public int compare(RAMItem item1, RAMItem item2) {
                return item1.getBus().compareTo(item2.getBus());
            }
        };
    }

    // Sắp xếp theo thương hiệu RAM
    public static Comparator<RAMItem> sortByBrand() {
        return new Comparator<RAMItem>() {
            @Override
            public int compare(RAMItem item1, RAMItem item2) {
                return item1.getBrand().compareTo(item2.getBrand());
            }
        };
    }
}
