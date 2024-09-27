package dto;

public interface I_List {
    int checkExist(String code);

    void addItem();

    void update();

    void delete();

    void displayAll();


    void loadFromFile();

    void saveToFile();
}
