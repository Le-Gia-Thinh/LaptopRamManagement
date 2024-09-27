package dto;

import controllers.RamList;

import java.util.List;

public interface I_SubMenu {
    void searchByType(RamList ramList);

    void searchByBrand(RamList ramList);

    void searchByBus (RamList ramList);

    void displaySearchResults(List<RamItem> results, String searchCriteria);
}
