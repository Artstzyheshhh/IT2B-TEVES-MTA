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
                     rp.viewgenreport();
                     break;
                 case 2:
                     rp.viewgenreport();
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
              System.out.print("rnter a valid character");
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
            System.out.print("Enter specific transaction ID: ");
            int id = sc.nextInt();
           
             String trnid = "SELECT t_id FROM tbl_transact WHERE t_id =?"; 
           while(conf.getSingleValue(trnid, id) == 0){
              System.out.print("\n Customer not found, try again: ");
              id = sc.nextInt(); }
           
            String cusid = "SELECT c_id FROM tbl_transact WHERE t_id =?";
            String cid = conf.getString(cusid, id);
            String movid = "SELECT m_id FROM tbl_transact WHERE t_id =?";
            String mid = conf.getString(movid, id);
            
            String cusname = "SELECT c_name FROM tbl_customer WHERE c_id =?";
            String cname = conf.getString(cusname,cid);
            String movname = "SELECT m_name FROM tbl_movie WHERE m_id =?";
            String mname = conf.getString(movname,mid);
            String tickets = "SELECT t_ticket FROM tbl_transact WHERE t_id =?";
            String tick = conf.getString(tickets,id);
            String cashs = "SELECT t_cash FROM tbl_transact WHERE t_id =?";
            double cash = conf.getSingleValue(cashs, id);
            String total = "SELECT t_total FROM tbl_transact WHERE t_id =?";
            double ttl = conf.getSingleValue(total, id);
            String change = "SELECT t_change FROM tbl_transact WHERE t_id =?";
            double chng = conf.getSingleValue(change, id);
            System.out.println("\n-----------------------------------------------");
            System.out.println("customer name:      "+cname);
            System.out.println("movie name:         "+mname);
            System.out.println("tickets bought:     "+tick);
            System.out.println("total:              "+ttl);
            System.out.println("customers cash:     "+cash);
            System.out.println("change:             "+chng);
            System.out.println("-----------------------------------------------");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer for transaction ID.");
        }
    }
}

   
