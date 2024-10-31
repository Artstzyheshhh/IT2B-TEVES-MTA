package tevesmovieapp;
import java.util.Scanner;

public class customer {
       config conf = new config();
        String resp;
        Scanner sc = new Scanner(System.in);
      public void options(){
      do{ 
          System.out.println("-------------");
          System.out.println("| CUSTOMERS |");
          System.out.println("-------------");
          System.out.println("1. ADD CUSTOMERS");
          System.out.println("2. VIEW CUSTOMER'S LIST");
          System.out.println("3. EDIT CUSTOMER");
          System.out.println("4. DELETE CUSTOMERS");
          System.out.println("5. MAIN MENU");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("try again : ");
        choices = sc.nextInt();
    }
              movies mapp = new movies();
              customer cst = new customer();
             switch(choices){
                 case 1:
                     mapp.viewmovie();
                     cst.addcustomers();
                     break;
                 case 2:
                    cst.viewcustomer();
                     break;
                 case 3:
                      cst.viewcustomer();
                     cst.Updatecustomer();
                      cst.viewcustomer();
                     break;
                     
                 case 4:
                      cst.viewcustomer();
                      cst.deletecustomer();
                       cst.viewcustomer();
                     break;
                  case 5:
                       TEVESmovieapp map = new TEVESmovieapp();
                       map.menu(); 
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes"));
      }
      
      //add
 public void addcustomers() {
    System.out.print("Customer name: ");
    String name = sc.next();
    System.out.print("Enter movie ID to buy: ");
    int id = sc.nextInt();
   
    String movieName = conf.fetchMovieName(id);
    int moviePrice = conf.fetchMoviePrice(id); 
    int availableSeats = conf.fetchAvailableSeats(id);
    if (availableSeats == -1 || movieName == null || moviePrice == -1) {
        System.out.println("Movie ID not found or invalid details.");
        return;
    }
    System.out.println("\nAvailable seats for " + movieName + ": " + availableSeats);
    System.out.println("Price per ticket for " + movieName + ": " + moviePrice);

    System.out.print("Number of tickets to buy: ");
    int ticket = sc.nextInt();

    if (ticket > availableSeats) {
        System.out.println("Not enough seats available! Only " + availableSeats + " seats left.");
        return;
    }
  
    int totalPrice = ticket * moviePrice;

    System.out.println("Total price: " + totalPrice);
    System.out.print("Cash: ");
    int cash = sc.nextInt();
    if (cash < totalPrice) {
        System.out.println("Insufficient cash. Total price is " + totalPrice + " and you entered " + cash);
        return;
    }
    boolean updateSuccess = conf.updateSeats(id, availableSeats - ticket);
    if (!updateSuccess) {
        System.out.println("Failed to update seats.");
        return;
    }
    String sqlAddCustomer = "INSERT INTO tbl_customer (c_name, c_ticket, c_cash, c_movie, c_total) VALUES (?, ?, ?, ?, ?)";
    conf.addRecord(sqlAddCustomer, name, ticket, cash, movieName, totalPrice);
    System.out.println("Customer added successfully! Movie purchased: " + movieName + ", Total cost: " + totalPrice);
}



      // view
      
     public void viewcustomer() {
        String sqlQuery = "SELECT * FROM tbl_customer";
        String[] columnHeaders = {"ID", "Name", "tickets", "cash", "movie", "total"};
        String[] columnNames = {"c_id", "c_name", "c_ticket", "c_cash","c_movie", "c_total" };

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
     
        // update 
    public void Updatecustomer(){
      
        System.out.print("Enter customer ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();
         
        System.out.print("New customer name: ");
        String name = sc.nextLine();
        System.out.print("New ticket: ");
        int ticket = sc.nextInt();
       
        System.out.print("New cash: ");
        String cash = sc.next();
       
    
    String sql = "UPDATE tbl_customer SET c_name = ?, c_ticket = ?, c_cash = ? WHERE c_id = ?";
    config conf = new config();
    conf.updateRecord(sql, name, ticket, cash, id);
    }
    
    public void deletecustomer(){
          System.out.print("Enter customer ID to delete: ");
        int id = sc.nextInt();
        
        String sql = "DELETE FROM tbl_customer WHERE c_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
    }
    
    
    
}
