package dto;

public class Enum {

    public enum Type {
        DDR4, LPDDR4, LPDDR5, DDR3, LPDDR3;

        public static Type fromMenuChoice(int choice) {
            switch (choice) {
                case 1: return DDR4;
                case 2: return LPDDR4;
                case 3: return LPDDR5;
                case 4: return DDR3;
                case 5: return LPDDR3;
                default: return null;  // Nếu chọn "Others", trả về null
            }
        }
    }


    public enum Bus {
        MHz1600, MHz2333, MHz2666, MHz3200, MHz4800, MHz5600;

        public static Bus fromMenuChoice(int choice) {
            switch (choice) {
                case 1: return MHz1600;
                case 2: return MHz2333;
                case 3: return MHz2666;
                case 4: return MHz3200;
                case 5: return MHz4800;
                case 6: return MHz5600;
                default: return null;
            }
        }
    }
}
