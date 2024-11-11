package tevesmovieapp;
import java.util.Scanner;

public class report {
    Scanner sc = new Scanner(System.in);
    public void report() {
        String resp;
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
              movies mapp = new movies();
              customer cst = new customer();
             switch(choices){
                 case 1:
                     cst.viewcustomer();
                     cst.addcustomers();
                     break;
                 case 2:
                    cst.viewcustomer();
                     break;                
                  case 3:
                       TEVESmovieapp map = new TEVESmovieapp();
                       map.menu(); 
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes")); 
    
    }
    
        public void viewgenreport(){
         
    String sqlQuery  = "SELECT t_id, c_name, m_name, _type , b_cin,b_cout,b_total, b_cash, b_change FROM tbl_bookings "
               + "LEFT JOIN tbl_customer ON tbl_guest.c_id = tbl_transact.c_id "
               + "LEFT JOIN tbl_room ON tbl_room.r_id = tbl_bookings.r_id";
        String[] columnHeaders = {"B_ID", "Guest Name", "Guest Status", "Room Type", "Check-In", "Check-Out", "Total", "Cash", "Change"};
        String[] columnNames  = {"b_id", "g_name", "g_status", "r_type", "b_cin", "b_cout", "b_total", "b_cash", "b_change"};
        
        }
}


