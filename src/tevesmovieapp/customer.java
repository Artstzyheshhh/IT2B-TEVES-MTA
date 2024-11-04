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
            int mid = sc.nextInt();
            
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?";
        String mticket = "SELECT m_seats FROM tbl_movie WHERE m_id =?";     
        String mprice = "SELECT m_price FROM tbl_movie WHERE m_id =?";
        
        double tickets = conf.getSingleValue(mticket, mid);
        double price = conf.getSingleValue(mprice, mid);
        
        while(conf.getSingleValue(movid, mid) == 0){
        System.out.print("\n movie does not existed try again: ");
            mid = sc.nextInt();     } 
        System.out.print("\ntickets available: "+tickets);
        System.out.print("\nNumber of tickets to buy: ");
            int ticket = sc.nextInt();
            
        while(ticket>tickets){
        System.out.print("input limited tickets only: ");
            ticket =sc.nextInt();     }
            
            double rseat = tickets - ticket; 
            config conf = new config(); 
            double total = ticket * price;
        System.out.println("seats available :"+rseat);
        System.out.println("total payment: "+total);
        System.out.print("Cash: ");
            int cash = sc.nextInt();
         while(cash < price){ 
        System.out.println("not enough ammount, enter larger ammount: ");
           cash = sc.nextInt();   }    
        double change = cash - total; 
         System.out.println("change :"+change);
        
        String msql = "UPDATE tbl_movie SET m_seats = ? WHERE m_id = ?";
        conf.updateRecord(msql,rseat ,mid); 
        String csql = "INSERT INTO tbl_customer (c_name, c_cash, c_ticket, c_total) VALUES (?, ?, ?, ?)";
        conf.addRecord(csql, name, cash, ticket, total);
        }



      // view
      
     public void viewcustomer() {
        String sqlQuery = "SELECT * FROM tbl_customer";

        String[] columnHeaders = {"ID", "Name", "tickets", "cash","total"};
        String[] columnNames = {"c_id", "c_name", "c_ticket", "c_cash", "c_total"};


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
         String delmore;
        do{
         System.out.print("Enter customer ID to delete: ");
        int id = sc.nextInt();
        
         System.out.print("delete more:");
         delmore = sc.next();
         
         String sql = "DELETE FROM tbl_customer WHERE c_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
        }while(delmore.equalsIgnoreCase("yes"));
        
       
    }
    
    
    
}
