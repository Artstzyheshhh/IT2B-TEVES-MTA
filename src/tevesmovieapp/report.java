package tevesmovieapp;
import java.util.Scanner;

public class report {
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    public void report() {
        String resp;
        try{
         do{      
          System.out.println("-------------");
          System.out.println("| REPORTS |");
          System.out.println("-------------");
          System.out.println("1. VIEW GENERAL REPORT");
          System.out.println("2. VIEW SPECIFIC REPORT");
          System.out.println("3. MAIN MENU");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("try again : ");
        choices = sc.nextInt();
    }
              report rp = new report();
             switch(choices){
                 case 1:
                       System.out.println("\t-------------------------");
                       System.out.println("\t|    GENERAL REPORT     |");
                       System.out.println("\t-------------------------");
                     rp.viewgenreport();
                     break;
                 case 2:
                      
                      customer cst = new customer();
                      cst.viewcustomer();
                      rp.viewSpecific();
                     break;                
                  case 3:
                       TEVESmovieapp map = new TEVESmovieapp();
                       map.menu(); 
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes")); 
        
        }catch(Exception e){
              System.out.print("enter a valid character");
          }
    
    
    }
    
        public void viewgenreport(){
         
    String sqlQuery  = "SELECT t_id, c_name, m_name , t_ticket FROM tbl_transact "
               + "LEFT JOIN tbl_customer ON tbl_customer.c_id = tbl_transact.c_id "
               + "LEFT JOIN tbl_movie ON tbl_movie.m_id = tbl_transact.m_id";
        String[] columnHeaders = {"transact_ID", "customerName", "movieName", "ticket bought"};
        String[] columnNames  = {"t_id", "c_name", "m_name", "t_ticket"};
         conf.viewRecords(sqlQuery, columnHeaders, columnNames);  
        }
        
  
        
        public void viewSpecific() {
        
        
        try { 
             System.out.println("\t---------------------------");
             System.out.println("\t|    INDIVIUAL REPORT     |");
             System.out.println("\t---------------------------");
            
       
    System.out.print("Enter customer id: ");
        int id = sc.nextInt();
         
        String cusid = "SELECT c_id FROM tbl_customer WHERE c_id = ?"; 
        int cid = conf.getSingleIntValue(cusid, id); 
        while(conf.getSingleValue(cusid, id) == 0){
              System.out.print("\n customer not found, try again: ");
              id = sc.nextInt(); }    
        String cusname = "SELECT c_name FROM tbl_customer WHERE c_id =?"; 
        String cname = conf.getString(cusname, cid);
            System.out.println("customer name: "+cname);

    String sqlQuery = "SELECT tbl_transact.t_id AS Transact_id, tbl_movie.m_name AS Movie_name, tbl_movie.m_price AS Movie_price,"
               + "tbl_transact.t_ticket AS tickets_paid, tbl_transact.t_total AS total, tbl_transact.t_cash AS cash, "
               + "tbl_transact.t_change AS change FROM tbl_transact "          
               + "LEFT JOIN tbl_movie ON tbl_movie.m_id = tbl_transact.m_id WHERE tbl_transact.c_id = ?";

    String[] columnHeaders = {"Transact id", "Movie name", "Movie price", "Tickets paid", "Total", "Cash", "Change"};
    String[] columnNames = {"Transact_id", "Movie_name", "Movie_price", "Tickets_paid", "Total", "Cash", "Change"};

    conf.viewIndivRecords(sqlQuery, columnHeaders, columnNames, cid);
             
             
           
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer for transaction ID.");
        }
    }
}

   
