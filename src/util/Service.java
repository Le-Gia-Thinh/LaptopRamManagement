// The Service class manages search menus and submenus for RAM Type and RAM Bus input.
// It also handles calling the respective search methods based on user input.
package util;

import controllers.Program;
import controllers.RAMList;
import controllers.SubMenu;
import dto.Enum;
import dto.I_Program;

public class Service {

    // The searchMenu method displays the main search menu for RAM.
    // It allows users to search RAM by type, bus, or brand.
    public static void searchMenu(SubMenu subMenu, RAMList ramList) {
        // Create a menu using I_Program (interface) to add menu items.
        I_Program subMenu_1 = new Program();
        subMenu_1.addItem("|               RAM Search Menu                  |");
        subMenu_1.addItem(" -------------------------------------------------");
        subMenu_1.addItem("| 1. Search by Type                               |");
        subMenu_1.addItem("| 2. Search by Bus                                |");
        subMenu_1.addItem("| 3. Search by Brand                              |");
        subMenu_1.addItem("| 4. Return to Main Menu                          |");
        subMenu_1.addItem(" -------------------------------------------------");
        subMenu_1.showMenu();

        // Get the user's choice and call the appropriate search method.
        int subChoice = subMenu_1.getChoice();
        switch(subChoice) {
            case 1:
                subMenu.searchByType(ramList);  // Calls search by type method.
                break;
            case 2:
                subMenu.searchByBus(ramList);   // Calls search by bus method.
                break;
            case 3:
                subMenu.searchByBrand(ramList); // Calls search by brand method.
                break;
            case 4:
                break;  // Exits the search menu and returns to the main menu.
            default:
                System.out.println("Invalid choice! Please try again.");  // Error handling for invalid input.
                searchMenu(subMenu, ramList);  // Recursively calls the method again for a valid input.
        }
    }

    // The TypeMenu method displays the RAM Type selection menu and returns the selected type.
    // If the user selects "Others", they can manually enter a new RAM type.
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

        // Get the user's choice.
        int choice = subMenu_2.getChoice();
        Enum.Type type = Enum.Type.fromMenuChoice(choice);  // Maps the user's choice to a Type enum.
        if (type == null) {
            // If the user selects "Others", prompt them to enter a custom RAM type.
            return Util.getString("Enter new RAM Type: ");
        }
        return type.name();  // Returns the name of the selected RAM type.
    }

    // The BusMenu method displays the RAM Bus selection menu and returns the selected bus speed.
    // If the user selects "N/A", they can manually enter a custom bus speed.
    public static String BusMenu(String welcome) {
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

        // Get the user's choice.
        int choice = subMenu_3.getChoice();
        Enum.Bus bus = Enum.Bus.fromMenuChoice(choice);  // Maps the user's choice to a Bus enum.
        if (bus == null) {
            // If the user selects "N/A", prompt them to enter a custom bus speed.
            return Util.getString("Enter new RAM Bus Speed: ");
        }
        return bus.toString();  // Returns the string representation of the selected bus speed.
    }

    // SORT Menu for show all RAM product
    public static int displaySortMenu() {
        I_Program sortMenu = new Program();
        sortMenu.addItem("|               Sort Menu                          |");
        sortMenu.addItem(" -------------------------------------------------");
        sortMenu.addItem("| 1. Sort by Type                                  |");
        sortMenu.addItem("| 2. Sort by Bus                                   |");
        sortMenu.addItem("| 3. Sort by Brand                                 |");
        sortMenu.addItem("| 4. Return to Previous Menu                       |");
        sortMenu.addItem(" -------------------------------------------------");
        sortMenu.showMenu();

        // Get the user's choice.
        return sortMenu.getChoice();
    }
}

