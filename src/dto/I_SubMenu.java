package dto;

import controllers.RAMList;

import java.util.List;

public interface I_SubMenu {
    void searchByType(RAMList ramList);

    void searchByBrand(RAMList ramList);

    void searchByBus(RAMList ramList);

    void displaySearchResults(List<RAMItem> results, String searchCriteria, String type);
}
