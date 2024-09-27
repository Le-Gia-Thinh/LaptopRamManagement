package util;

import controllers.Program;

import controllers.RAMList;
import controllers.SubMenu;
import dto.I_Program;

public class Service {
    public static void searchMenu(SubMenu subMenu, RAMList ramList) {
        I_Program submenu2 = new Program();
        submenu2.addItem("|               RAM Search Menu                  |");
        submenu2.addItem(" -------------------------------------------------");
        submenu2.addItem("| 1. Search by Type                               |");
        submenu2.addItem("| 2. Search by Bus                                |");
        submenu2.addItem("| 3. Search by Brand                              |");
        submenu2.addItem("| 4. Return to Main Menu                          |");
        submenu2.showMenu();

        int subChoice = submenu2.getChoice();
        switch(subChoice) {
            case 1:
                subMenu.searchByType(ramList);
                break;
            case 2:
                subMenu.searchByBus(ramList);
                break;
            case 3:
                subMenu.searchByBrand(ramList);
                break;
            case 4:
                // Có thể không cần xử lý gì ở đây, vì đã quay về menu chính
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

}
