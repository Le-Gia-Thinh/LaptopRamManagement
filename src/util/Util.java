    package util;


    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.Date;
    import java.util.Scanner;

    public class Util {

        public static String getString(String welcome) {
            boolean check = true;
            String str = "";
            do {
                System.out.println(welcome);
                Scanner sc = new Scanner(System.in);
                str = sc.nextLine().trim();
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
            String str = sc.nextLine().trim();
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

        public static String getDate() {
            LocalDate currentDate = LocalDate.now(); // Get the current date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define the format as day/month/year
            return currentDate.format(formatter); // Return the date formatted as a string
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

        public static String generateUniqueRAMCode(String type, int count) {
            // Generate a unique RAM code in the format: RAMx_y
            return String.format("RAM%s_%d", type, count + 1);
        }
    }