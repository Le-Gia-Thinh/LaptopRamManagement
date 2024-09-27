package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {

    public static String getString(String welcome) {
        boolean check = true;
        String str = "";
        do {
            System.out.println(welcome);
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("Please input data!!!");
            } else {
                check = false;
            }

        } while (check);
        return str;
    }

    public static String updateString(String welcome, String oldStr) {
        String newStr = oldStr;
        System.out.println(welcome);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!str.isEmpty()) {
            newStr = str;
        }
        return newStr;
    }

    public static int getInt(String welcome) {
        boolean check = true;
        int result = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(welcome);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input number!!!");
            }
        } while (check);
        return result;
    }

    public static int updateInt(String welcome, int oldInt) {
        boolean check = true;
        int newInt = oldInt;
        do {
            try {
                System.out.println(welcome);
                Scanner sc = new Scanner(System.in);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    newInt = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number!!!");
            }
        } while (check);
        return newInt;
    }

    public static double getDouble(String welcome) {
        boolean check = true;
        double result = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(welcome);
                result = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Please input number!!!");
            }
        } while (check);
        return result;
    }

    public static double updateDouble(String welcome, double oldDouble) {
        boolean check = true;
        double newInt = oldDouble;
        do {
            try {
                System.out.println(welcome);
                Scanner sc = new Scanner(System.in);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    newInt = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number!!!");
            }
        } while (check);
        return newInt;
    }

    public static Date getDate() {
        boolean check = true;
        Date date = null;
        do {
            String str = getString("Input expired date: ");
            SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = spf.parse(str);
                check = false;
            } catch (ParseException ex) {
                System.out.println("Incorrect format!!!");
            }
        } while (check);
        return date;
    }

    public static Date updateDate(String welcome, Date oldDate) {
        Date newDate = oldDate;
        System.out.println(welcome);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                newDate = spf.parse(tmp);
            } catch (ParseException e) {
                System.out.println("Incorrect format!!");
            }
        }
        return newDate;
    }

    public static boolean confirmYesNo(String message) {
        while (true) {
            String input = getString(message).trim().toUpperCase();
            if ("Y".equals(input)) {
                return true;
            } else if ("N".equals(input)) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }

    public static boolean checkExpiredDate(Date expireDate) {
        boolean check = true;
        Date currentDate = new Date();
        if (currentDate.after(expireDate)) {
            check = false;
        }
        return check;
    }

    public static String formatCode(String welcome) {
        System.out.println(welcome);
        Scanner sc = new Scanner(System.in);
        String code;

        while (true) {
            code = sc.nextLine();
            if (code.isEmpty()) {
                System.out.println("Cannot be empty!!");
            } else {
                // Kiểm tra định dạng mã
                if (code.matches("RAM\\d+_\\d+")) {
                    break;
                } else {
                    System.out.println("Incorrect format!!!");
                    System.out.println("Code should have format 'RAMx_y', where x and y are numbers!");
                }
            }
        }
        return code; // Trả về mã hợp lệ
    }
}