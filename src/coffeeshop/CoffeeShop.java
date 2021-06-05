package coffeeshop;
import java.util.*;
import javax.swing.JOptionPane;
//Basic/general cup class
class cup{
//    Attributes
    String size;
    int amount;
    double price;
    cup(String size,int amount,double price){
        this.size = size;
        this.amount = amount;
        this.price = price;
    }
//Setters and Getters
    public String getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
//Class to handle small cup data
class smallCup extends cup{
    smallCup(){
//        Small cup values given in the case studey
        super("small",9,1.75);
    }
}
//Class to handle medium cup data
class mediumCup extends cup{
    mediumCup(){
//        Medium cup constant values given in the case study
        super("medium",12,1.99);
    }
}
//Class to handle large cup data
class largeCup extends cup{
    largeCup(){
//        Large cup constant data according to the case study
        super("Large",15,2.15);
    }
}
//Main Class
public class CoffeeShop {
//    Attributes, with the functionalites as name suggests
    smallCup sc;
    mediumCup mc;
    largeCup lc;
    int totalAmountSold;
    int totalMoneyMade;
    int totalSmallSold;
    int totalMediumSold;
    int totalLargeSold;
    Scanner input;
    CoffeeShop(){
        sc = new smallCup();
        mc = new mediumCup();
        lc = new largeCup();
        totalAmountSold =0;
        totalMoneyMade =0;
        totalSmallSold =0;
        totalMediumSold =0;
        totalLargeSold =0;
        input = new Scanner(System.in);
    }
    void buyCoffee(){
//        System.out.println("Enter the size of cup you want to buy:(small,medium,large) ");
//        Asking for size input
        String size = JOptionPane.showInputDialog(null,"Enter Cup Size: ");
        int c=0;
//        System.out.println("How Many Cups?");
//        Using try catch to validate user input
        String  n2= JOptionPane.showInputDialog(null,"Enter Number of cups you want t buy: ");
        int n=0;
        try{
//            Asking for number input
            n = Integer.parseInt(n2);
        }catch(Exception e){
            System.out.println("Please enter a valid number!");
            c++;
            input.next();
            
        }
//        If c!= 0, it means there was some error. If c==0, means there were no errors so its safe to proceed!
        if(c==0){
            if(size.equalsIgnoreCase("small")){
//                Final Price = cup price * number of cups
                double finalPrice = sc.getPrice() * n;
                JOptionPane.showMessageDialog(null,"\n...\n" + n + " Small Cup Sold.\n...\nPrice: " + finalPrice+"$\n");
                this.totalAmountSold += sc.getAmount();
                this.totalMoneyMade += finalPrice;
                this.totalSmallSold += 1;
            }
//            Same as above
            else if(size.equalsIgnoreCase("medium")){
                double finalPrice = mc.getPrice() * n;
                JOptionPane.showMessageDialog(null,"\n...\n" + n + " Medium Cup Sold.\n...\nPrice: " + finalPrice +"$\n");
                this.totalAmountSold += mc.getAmount();
                this.totalMoneyMade += finalPrice;
                this.totalMediumSold += 1;
            }
//            Same as above
            else if(size.equalsIgnoreCase("large")){
                double finalPrice = lc.getPrice() * n;
                JOptionPane.showMessageDialog(null,"\n...\nLarge Cup Sold.\n...\nPrice: " + finalPrice+"$\n");
                this.totalAmountSold += lc.getAmount();
                this.totalMoneyMade += finalPrice;
                this.totalLargeSold += 1;
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Cup Size!");
            }
        }
    }
//Getters and setters
    public int getTotalAmountSold() {
        return totalAmountSold;
    }

    public int getTotalMoneyMade() {
        return totalMoneyMade;
    }

    public int getTotalSmallSold() {
        return totalSmallSold;
    }

    public int getTotalMediumSold() {
        return totalMediumSold;
    }

    public int getTotalLargeSold() {
        return totalLargeSold;
    }
//    Performs functions as the name suggests
    void showAllCupsSold(){
        JOptionPane.showMessageDialog(null,"\n..\nAll Cups Records\n...\n");
        JOptionPane.showMessageDialog(null,"Total Small Cups Sold: " + this.getTotalSmallSold() + 
        "\nTotal Medium Cups Sold: " + this.getTotalMediumSold()
        + "\nTotal Large Sold: " + this.getTotalLargeSold() +"\n...\n");
    }
//    Show total number of small cups sold
    void showSmallCupsSold(){
        JOptionPane.showMessageDialog(null,"\n...\nTotal Small Cups Sold: " + this.getTotalSmallSold() + "\n...\n");
    }
    //    Show total number of medium cups sold
    void showMediumCupsSold(){
        JOptionPane.showMessageDialog(null,"\n...\nTotal Medium Cups Sold: " + this.getTotalMediumSold()+ "\n...\n");
    }
    //    Show total number of large cups sold
    void showLargeCupsSold(){
        JOptionPane.showMessageDialog(null,"\n...\nTotal Large Sold: " + this.getTotalLargeSold()+ "\n...\n");
    }
//    Display total amount of coffee sold
    void showTotalAmount(){
        JOptionPane.showMessageDialog(null,"\n...\nTotal Amount of Coffee Sold: " + this.getTotalAmountSold() + " oz"+ "\n...\n");
    }
//    Display total money made
    void showTotalMoneyMade(){
        JOptionPane.showMessageDialog(null,"\n...\nTotal Money Made: " + this.getTotalMoneyMade() + "$"+ "\n...\n");
    }
//    Display all data
    void displayAllData(){
        this.showTotalMoneyMade();
        this.showTotalAmount();
        this.showAllCupsSold();
    }
    
//    Main Menu
    public static void main(String[] args) {
        CoffeeShop EffahCoffee = new CoffeeShop();
        Scanner input = new Scanner(System.in);
        while(true){
//            Menu option
            System.out.println("Press 1 to buy coffee\nPress 2 to show total money made\nPress 3 to show total amount sold"
                    + "\nPress 4 to show total Small Cups Sold\nPress 5 to show total medium cups sold"
                    + "\nPress 6 to show total large cups sold"
                    + "\nPress 7 to show all data\nPress 8 to Open GUI\nPress 9 to exit");
            System.out.print("Please enter your choice: ");
            int choice =0;
//            Using try catch to validate user input
            try{
//                Taking user choice input
                choice = input.nextInt();
            }catch(Exception e){
                System.out.println("\n...\nEnter a valid integer!\n...\n");
                input.next();
                continue;
            }
            if(choice == 1){
                EffahCoffee.buyCoffee();
            }
            else if(choice == 2){
                EffahCoffee.showTotalMoneyMade();
            }
            else if(choice == 3){
                EffahCoffee.showTotalAmount();
            }
            else if(choice == 4){
                EffahCoffee.showSmallCupsSold();
            }
            else if(choice == 5){
                EffahCoffee.showMediumCupsSold();
            }
            else if(choice == 6){
                EffahCoffee.showLargeCupsSold();
            }
            else if(choice == 7){
                EffahCoffee.displayAllData();
            }
            else if(choice == 8){
                CoffeeShopGUI cs = new CoffeeShopGUI();
                cs.setVisible(true);
            }
            else if(choice == 9){
                System.out.println("\n...\nProgram is Exiting\n...\n");
                break;
            }
            else{
                System.out.println("\n...\nPlease enter a valid input!\n...\n");
            }
        }
    }
    
}
