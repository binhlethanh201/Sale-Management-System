package asm;
public class Menu {

    public static int menuP() {
        System.out.println("Product menu:");
        System.out.println("""
                           1. Load data from file
                           2. Input & add to the end
                           3. Display data
                           4. Save product list to file
                           5. Search by pcode
                           6. Delete by pcode
                           7. Sort by pcode
                           8. Add after position\u00a0 k
                           9. Delete the node after the node having code = xCode
                           11. Load data and display
                           12. Delete pcode = 1 and display
                           13. Find pcode =4 , fix quantity = 77 and display
                           14. Add (5,F,3,2,1) and display
                           15. Sort ascending order in saled and displays
                           0. Exit to main menu
                           """);

        int choice = Validate.checkInputLimited(0, 15);
        return choice;
    }

    public static int menuO() {
        System.out.println("Order menu:");
        System.out.println("""
                           1. Input data
                           2. Display data with total value
                           3. Sort by pcode + ccode
                           0. Exit to main menu
                           """);

        int choice = Validate.checkInputLimited(0, 3);
        return choice;
    }

    public static int menuC() {
        System.out.println("Customer menu:");
        System.out.println("""
                           1. Load data from file
                           2. Input & add to the end
                           3. Display data
                           4. Save customer list to file
                           5. Search by ccode
                           6. Delete by ccode
                           0. Exit to main menu
                           """);
        
        int choice = Validate.checkInputLimited(0, 6);
        return choice;
    }

}

