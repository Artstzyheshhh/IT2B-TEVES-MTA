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
                      rp.viewspecific();
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
        
        public void viewspecific (){
            
            int id;
            try{
                report rp = new report();
                rp.viewgenreport();
                System.out.print("Enter specific transaction id: ");
                id = sc.nextInt();
                
               String trnid = "SELECT t_id FROM tbl_transact WHERE t_id =?"; 
           while(conf.getSingleValue(trnid, id) == 0){
               System.out.print("\n transaction not found, try again: ");
               id = sc.nextInt(); }
               String cusname = " SELECT c_name FROM tbl_transact WHRERE t_id =? ";
               String cname =  conf.getString(cusname, id);
                System.out.println("transact info: ");
                System.out.print("customer name: "+cname);
               
            }catch(Exception e){
                System.out.println("Enter an integer");
            }
           
            
              
            
            
        }
}

   
