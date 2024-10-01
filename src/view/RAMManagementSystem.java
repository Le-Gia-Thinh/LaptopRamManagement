package view;

import controllers.Program;
import controllers.RAMList;
import controllers.SubMenu;
import util.Util;
import util.Service;

public class RAMManagementSystem {

    public static void main(String[] args) {
        Program menu = new Program();
        RAMList ramList = new RAMList();
        SubMenu subMenu = new SubMenu();
        menu.addItem("-------------------------------------------------");
        menu.addItem("|             RAM Management System               |");
        menu.addItem("-------------------------------------------------");
        menu.addItem("| 1. Add an Item                                   |");
        menu.addItem("| 2. Search SubMenu                                |");
        menu.addItem("| 3. Update Item                                   |");
        menu.addItem("| 4. Delete Item                                   |");
        menu.addItem("| 5. Show All Items                                |");
        menu.addItem("| 6. Save Data to File                             |");
        menu.addItem("| 7. Exit                                          |");
        menu.addItem("-------------------------------------------------");
        ramList.loadFromFile();
        int choice;
        do {
            menu.showMenu();
            choice = menu.getChoice();

            switch (choice) {
                case 1:
                    ramList.addItem();
                    break;
                case 2:
                    Service.searchMenu(subMenu, ramList);
                    break;
                case 3:
                    ramList.update();
                    break;
                case 4:
                    ramList.delete();
                    break;
                case 5:
                    ramList.displayAll();
                    break;
                case 6:
                    ramList.saveToFile();
                    System.out.println("Data saved successfully!");
                    break;
                case 7:
                    boolean confirm = Util.confirmYesNo("Do you want to exit? ");
                    if (confirm) {
                        ramList.saveToFile();
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }
}
