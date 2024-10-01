package util;

import controllers.Program;
import controllers.RAMList;
import controllers.SubMenu;
import dto.Enum;
import dto.I_Program;

public class Service {

    public static void searchMenu(SubMenu subMenu, RAMList ramList) {
        I_Program subMenu_1 = new Program();
        subMenu_1.addItem("|               RAM Search Menu                  |");
        subMenu_1.addItem(" -------------------------------------------------");
        subMenu_1.addItem("| 1. Search by Type                               |");
        subMenu_1.addItem("| 2. Search by Bus                                |");
        subMenu_1.addItem("| 3. Search by Brand                              |");
        subMenu_1.addItem("| 4. Return to Main Menu                          |");
        subMenu_1.addItem(" -------------------------------------------------");
        subMenu_1.showMenu();

        int subChoice = subMenu_1.getChoice();
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
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                searchMenu(subMenu, ramList);
        }
    }

    public static String TypeMenu(String welcome ) {
        System.out.println(welcome);
        I_Program subMenu_2 = new Program();
        subMenu_2.addItem("|               RAM Type Menu                      |");
        subMenu_2.addItem("| -------------------------------------------------|");
        subMenu_2.addItem("| 1. DDR4                                          |");
        subMenu_2.addItem("| 2. LPDDR4                                        |");
        subMenu_2.addItem("| 3. LPDDR5                                        |");
        subMenu_2.addItem("| 4. DDR3                                          |");
        subMenu_2.addItem("| 5. LPDDR3                                        |");
        subMenu_2.addItem("| 6. Others: please enter type which you want      |");
        subMenu_2.showMenu();

        int choice = subMenu_2.getChoice();
        Enum.Type type = Enum.Type.fromMenuChoice(choice);
        if (type == null) {
            return Util.getString("Enter new RAM Type: ");
        }
        return type.name();
    }

    public static String BusMenu(String welcome ) {
        System.out.println(welcome);
        I_Program subMenu_3 = new Program();
        subMenu_3.addItem("|               RAM Bus Menu                       |");
        subMenu_3.addItem("| -------------------------------------------------|");
        subMenu_3.addItem("| 1. 1600MHz                                       |");
        subMenu_3.addItem("| 2. 2333MHz                                       |");
        subMenu_3.addItem("| 3. 2666MHz                                       |");
        subMenu_3.addItem("| 4. 3200MHz                                       |");
        subMenu_3.addItem("| 5. 4800MHz                                       |");
        subMenu_3.addItem("| 6. 5600MHz                                       |");
        subMenu_3.addItem("| 7. N/A: please enter bus which you want          |");
        subMenu_3.showMenu();

        int choice = subMenu_3.getChoice();
        Enum.Bus bus = Enum.Bus.fromMenuChoice(choice);
        if (bus == null) {
            return Util.getString("Enter new RAM Bus Speed: ");
        }
        return bus.name().replace("MHz", "MHz");
    }
}
