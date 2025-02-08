package asm;
import static asm.Validate.checkInputLimited;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class MenuManager <E extends Comparable<E>>{
    private static final String customer_list ="/Sale-Management-System/Customers.txt";
    private static final String product_list ="/Sale-Management-System/product1.txt";
    private static final String ordering_list ="/Sale-Management-System/Orders.txt";
   
    //----- product -----
    public static void loadFromFileProducts(MyList<Product> p) throws Exception{
        try {    
            File f = new File(product_list);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line = br.readLine()) != null){
                String[] detailPro = line.split("//|");                
                p.addToTail(new Product(detailPro[0],
                                          detailPro[1],
                                          Integer.parseInt(detailPro[2]),
                                          Integer.parseInt(detailPro[3]), 
                                          Double.parseDouble(detailPro[4])));
            }
            System.out.println("Load successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void inputProductToEnd(MyList<Product> p){
        System.out.print("Enter code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity: ");
        int pQuan = Validate.checkInputInt();
        System.out.print("Enter sale: ");
        int pSale = Validate.checkInputSaled(pQuan);
        System.out.print("Enter price: ");
        double pPrice = Validate.checkInputDouble();
        p.addToTail(new Product(pCode, pName, pQuan, pSale, pPrice));        
        System.err.println("Add succcessfully!");
    }
        public static void displayProduct(MyList<Product> p){
        p.traverse();
    }
    public void saveProductToFile(MyList <Product> p) {
        
        try {
            File f = new File(customer_list);
            FileWriter writer = new FileWriter(f);
            Node <Product> current = (Node <Product>) head; 
            while (current != null) {
                writer.write(current.pcode + " | " + current.pro_name + " | " + current.quantity + " | " + current.saled + " | " + current.price + "\n");
                current = current.next;
            }
            writer.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
    public static void searchByPCode(MyList<Product> p){
        System.out.print("Input code: ");
        String pCode = Validate.checkInputString();
        Product pr;  
        if((pr = p.search(new Product(pCode, "", 0, 0, 0))) == null){
            System.err.println("Not found!");
            return;
        }
        System.out.println(pr.toString());
    }
    public static void deleteByPCode(MyList<Product> p) {
        System.out.print("Input code: ");
        String pCode = Validate.checkInputString();
        p.delete(new Product(pCode, "", 0, 0, 0));

    }
        
public static void sortBySaled(MyList <Product> p) {
        Product saled = null;
            p.sort(saled);
            p.traverse();
        
    }

public static void sortByPcode(MyList <Product> p) {
    Node <Product> head = null;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node <Product> tempHead = head;
        while (tempHead != null) {
            Node <Product> min = tempHead;
            Node <Product> current = tempHead.next;
            while (current != null) {
                if (current.pcode.compareTo(min.pcode) < 0) {
                    min = current;
                }
                current = current.next;
            }
            // Swap data
            String tempPcode = tempHead.pcode;
            String tempProName = tempHead.pro_name;
            String tempQuantity = tempHead.quantity;
            String tempSaled = tempHead.saled;
            String tempPrice = tempHead.price;
            double tempValue = tempHead.value;

            tempHead.pcode = min.pcode;
            tempHead.pro_name = min.pro_name;
            tempHead.quantity = min.quantity;
            tempHead.saled = min.saled;
            tempHead.price = min.price;
            tempHead.value = min.value;

            min.pcode = tempPcode;
            min.pro_name = tempProName;
            min.quantity = tempQuantity;
            min.saled = tempSaled;
            min.price = tempPrice;
            min.value = tempValue;

            tempHead = tempHead.next;
        }
    }
    public static void addProductAfter(MyList<Product> p){
        System.out.print("Input position k: ");
        int k = Validate.checkInputInt();
        System.out.print("Input code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Input name: ");
        String pName = Validate.checkInputString();
        System.out.print("Input quantity: ");
        int pQuantity = Validate.checkInputInt();
        System.out.print("Input sale: ");
        int pSale = Validate.checkInputSaled(pQuantity);
        System.out.print("Input price: ");
        double pPice = Validate.checkInputDouble();
        p.addAfterPosition(k, new Product(pCode, pName, pQuantity, pSale, pPice));   
        System.err.println("Add successfully!");
    }
    public static void deleteProductAfter(MyList<Product> p) {
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();
        p.deleteAfterNode(new Product(pCode, "", 0, 0, 0));
    }
    //----- customer -----
    public static void loadFromFileCustomers(MyList<Customer> c) throws Exception{
        try {    
            File f = new File(customer_list);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){  
                String[] detailCus = line.split("//|");                
                c.addToTail(new Customer(detailCus[0], detailCus[1], detailCus[2]));
            }
            System.err.println("Load successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public static void loadFromFileProducts(MyList<Product> p) {
        try {    
            File f = new File(product_list);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while((line = br.readLine()) != null){
                String[] detailPro = line.split("//|");                
                p.addToTail(new Product(detailPro[0],
                                          detailPro[1],
                                          Integer.parseInt(detailPro[2]),
                                          Integer.parseInt(detailPro[3]), 
                                          Double.parseDouble(detailPro[4])));
            }
            System.out.println("Load successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    public  static void inputCustomerToEnd(MyList<Customer> c){
        System.out.print("Input code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter name: ");
        String cName = Validate.checkInputString();
        System.out.print("Enter phone number: ");
        String cPhone =Validate.checkInputString();
        c.addToTail(new Customer(cCode, cName, cPhone)); 
        System.err.println("Add successfully!");
    }
    public static void displayCustomer(MyList<Customer> c){
        c.traverse();
    }
     public void saveCustomerToFile(MyList <Customer> c) {
        try {
            File f = new File(customer_list);
            FileWriter writer = new FileWriter(f);
            Node <Customer> current = (Node <Customer>) head; 
            while (current != null) {
                writer.write(current.ccode + " | " + current.name + " | " + current.phone + "\n");
                current = current.next;
            }
            writer.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
    public static void searchByCCode(MyList<Customer> c){
        System.out.print("Input Code: ");
        String cCode = Validate.checkInputString();         
                                    
        Customer cus;
        if((cus = c.search(new Customer(cCode, "", ""))) == null){
            System.err.println("Not found.");
            return;
        }
        System.out.println(cus.toString());
    }
    public static void deleteByCCode(MyList<Customer> c){
        System.out.print("Input code: ");
        String cCode = Validate.checkInputString();
        c.delete(new Customer(cCode, "", ""));
    }
    //----- order -----
    public static void addOrder(MyList<Ordering> o){
        System.out.print("Input customer's code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Input product's code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Input product's quantity: ");
        int pQuantity = Validate.checkInputInt();
        o.addToTail(new Ordering(pCode, cCode, pQuantity));
        System.err.println("Add successful!");
    }
    public static void displayOrder(MyList<Ordering> o){
        o.traverse();
    }
    /*
    public static void sortOrder(MyList<Ordering> o){
        o.sort();
    }  
*/
    private static class Node<E> {
        private E info;
        private Node<E> next;
        private String pcode;
        private String price;
        private String pro_name;
        private String quantity;
        private String saled;
        private double value;
        private String ccode;
        private String name;
        private String phone;
        public Node() {
        }
        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
        public Node(E info) {
            this.info = info;
            this.next = null;
        }
        public E getInfo() {
            return info;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setInfo(E info) {
            this.info = info;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    Node<E> head;
    public static int menu(){
        System.out.print("\nMain menu:");
        System.out.println("\n1. Product list");
        System.out.println("2. Customer list");
        System.out.println("3. Order list");
        System.out.println("0. Exit program");
        
        int choice = checkInputLimited(0, 3);
        return choice;
    }

}

