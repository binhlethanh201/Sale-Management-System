package asm;
public class Asm {
    public static void main(String[] args) throws Exception {
        MyList<Product> p = new MyList <Product> ();
        MyList<Customer> c = new MyList <Customer> ();
        MyList<Ordering> o = new MyList <Ordering> ();
        MenuManager m = new MenuManager();
        MainMenu(c, o, p, m);
    }
    public static void MainMenu(MyList<Customer> c, MyList<Ordering> o, MyList<Product> p, MenuManager m) throws Exception{
        while (true) {
            int choice;
            choice = MenuManager.menu();
            if (choice == 0) {
                break;
            }
             switch (choice) {
                case 1:
                    while (true) {
                        int choiceP = Menu.menuP();

                        if (choiceP == 0) {
                            break;
                        }
                        switch (choiceP) {
                            case 1:
                                MenuManager.loadFromFileProducts(p);
                                break;

                            case 2:
                                MenuManager.inputProductToEnd(p);   
                                break;
                            case 3:
                                MenuManager.displayProduct(p);
                                break;
                                
                            case 4:
                                m.saveProductToFile(p);
                                break;
                            case 6:
                                MenuManager.deleteByPCode(p);
                                break;
                            case 5:
                                MenuManager.searchByPCode(p);    
                                break;
                            case 7:
                                MenuManager.sortByPcode(p);
                                break;
                            case 8:
                                MenuManager.addProductAfter(p);
                                break;
                            case 9:
                                MenuManager.deleteProductAfter(p);
                                break;
                            
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        int choiceC = Menu.menuC();

                        if (choiceC == 0) {
                            break;
                        }
                        switch (choiceC) {
                            case 1:
                                MenuManager.loadFromFileCustomers(c);
                                break;
                            case 2:
                                MenuManager.inputCustomerToEnd(c); 
                                break;
                            case 3:
                                MenuManager.displayCustomer(c);
                                break;
                            case 4:
                                m.saveCustomerToFile(c); 
                            case 5:
                                MenuManager.searchByCCode(c);    
                                break;
                            case 6: 
                                MenuManager.deleteByCCode(c);
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        int choiceO = Menu.menuO();

                        if (choiceO == 0) {
                            break;
                        }
                        switch (choiceO) {
                            case 1:
                                MenuManager.addOrder(o);
                                break;
                            case 2:
                                MenuManager.displayOrder(o);
                                break;
                                /*
                            case 3:
                                MenuManager.sortOrder(o);
                                break;
                                */
                        }
                                
                    }
                    break;
            }
        }
    }
    /*
     public static void demoProduct() {
      MyList<Product> listProduct = new MyList<>();
      listProduct.addToHead(new Product("1","A","6","2",1));
      listProduct.addToHead(new Product("3","B","2","1",1));
      listProduct.addToHead(new Product("2","C","5","4",1));
      listProduct.addToHead(new Product("4","D","4","3",1));
      Product result = listProduct.search(new Product("1","A","6","2",1));
      Product result1 = listProduct.search(new Product("3","B","2","1",1));
      Product result2 = listProduct.search(new Product("2","C","5","4",1));
      Product result3 = listProduct.search(new Product("4","D","4","3",1));
       System.out.println(result );
       System.out.println(result1);
       System.out.println(result2);
       System.out.println(result3);
    }
*/

}
