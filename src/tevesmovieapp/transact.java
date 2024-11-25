
package tevesmovieapp;

import java.util.Scanner;

public class transact {
        
        movies mapp = new movies();
        customer cst = new customer();
        config conf = new config();
        String resp;
        Scanner sc = new Scanner(System.in);
      public void options(){
           try{
           
             do{ 
          System.out.println("-------------------------------");
          System.out.println("| MOVIE TICKETING APPLICATION |");
          System.out.println("-------------------------------");
          System.out.println("1. ADD TRANSACT");
          System.out.println("2. EDIT TRANSACT");
          System.out.println("3. VIEW TRANSACT");
          System.out.println("4. DELETE TRANSACT");
          System.out.println("5. MAIN MENU");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("try again : ");
        choices = sc.nextInt();
    }      
           transact trn = new transact();   
             switch(choices){
                 case 1:
                      System.out.println("\t--------------------------");
                      System.out.println("\t|     ADD TRANSACTION    |");
                      System.out.println("\t--------------------------"); 
                     trn.addtransact();
                     break;
                 case 2:
                      System.out.println("\t-----------------------------");
                      System.out.println("\t|     UPDATE TRANSACTION    |");
                      System.out.println("\t-----------------------------"); 
                     trn.Updatetransact();
                     trn.viewtransact();
                     break;
                 case 3:
                     System.out.println("\t-----------------------------");
                     System.out.println("\t|    TRANSACTION REPORT     |");
                     System.out.println("\t-----------------------------");
                     trn.viewtransact();
                     break;
                     
                 case 4:
                      System.out.println("\t-----------------------------");
                      System.out.println("\t|     DELETE TRANSACTION    |");
                      System.out.println("\t-----------------------------"); 
                     trn.viewtransact();
                     trn.deletetransact();
                     break;
                  case 5:
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
      
      //add
      public void addtransact(){
           try{         
        cst.viewcustomer();
        System.out.print("Enter customer id: ");
        int cid = sc.nextInt(); 
        String cusid = "SELECT c_id FROM tbl_customer WHERE c_id =?"; 
        while(conf.getSingleValue(cusid, cid) == 0){
              System.out.print("\n Customer not found, try again: ");
              cid = sc.nextInt(); }
        
        mapp.viewmovie();
        System.out.print("Enter movie id: ");
        int mid = sc.nextInt();         
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        while(conf.getSingleValue(movid, mid) == 0){
              System.out.print("\n Customer not found, try again: ");
              mid = sc.nextInt(); }
        
        System.out.print("tickets to buy: ");
        int ticket = sc.nextInt();
        String mticket = "SELECT m_seats FROM tbl_movie WHERE m_id =?";  
        double tickets = conf.getSingleValue(mticket, mid);  
        while(ticket>tickets){
            System.out.print("input limited tickets only: ");
            ticket =sc.nextInt(); }
        
        String mprice = "SELECT m_price FROM tbl_movie WHERE m_id =?";
        double price = conf.getSingleValue(mprice, mid);
        
        double total = ticket * price;
        double rseat = tickets - ticket; 
        System.out.println("seats available :"+rseat);
        System.out.println("total payment: "+total);
        
        System.out.print("cash: ");
        int cash = sc.nextInt();
        while(cash < price){ 
            System.out.println("not enough ammount, enter larger ammount: ");
            cash = sc.nextInt();   }        
        double change = cash - total; 
        System.out.println("change :"+change);
        
        String usql = "UPDATE tbl_movie SET m_seats = ? WHERE m_id = ?";
        conf.updateRecord(usql, rseat, mid);        
        String sql = "INSERT INTO tbl_transact (c_id, m_id, t_ticket, t_cash, t_total, t_change) VALUES (?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, cid, mid, ticket, cash, total, change);
               
           }catch(Exception e){
              System.out.print("rnter a valid character");
          }
       
    }
      // view
      
     public void viewtransact() {
        String sqlQuery = "SELECT * FROM tbl_transact";
         
        String[] columnHeaders = {"transact id", "customer id", "movie id", "tickets", "cash", "total", "change"};
        String[] columnNames = {"t_id", "c_id", "m_id", "t_ticket", "t_cash", "t_total", "t_change"};
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);  
         
    }
   
 
        // update 
    public void Updatetransact(){
         try{
         
         transact trn = new transact(); 
        trn.viewtransact();
        System.out.print("Enter transact id: ");
        int tid = sc.nextInt(); 
        
        String trnid = "SELECT t_id FROM tbl_transact WHERE t_id =?"; 
        while(conf.getSingleValue(trnid, tid) == 0){
              System.out.print("\n transaction not found, try again: ");
              tid = sc.nextInt(); }
        
        cst.viewcustomer();
        System.out.print("Enter customer id: ");
        int cid = sc.nextInt(); 
        String cusid = "SELECT c_id FROM tbl_customer WHERE c_id =?"; 
        while(conf.getSingleValue(cusid, cid) == 0){
              System.out.print("\n Customer not found, try again: ");
              cid = sc.nextInt(); }
        
        mapp.viewmovie();
        System.out.print("Enter movie id: ");
        int mid = sc.nextInt();         
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        while(conf.getSingleValue(movid, mid) == 0){
              System.out.print("\n Customer not found, try again: ");
              mid = sc.nextInt(); }
        
        System.out.print("new tickets to buy: ");
        int ticket = sc.nextInt();
        String mticket = "SELECT m_seats FROM tbl_movie WHERE m_id =?";  
        double tickets = conf.getSingleValue(mticket, mid);  
        while(ticket>tickets){
            System.out.print("input limited tickets only: ");
            ticket =sc.nextInt(); }
        
        String mprice = "SELECT m_price FROM tbl_movie WHERE m_id =?";
        double price = conf.getSingleValue(mprice, mid);
        
        double total = ticket * price;
        double rseat = tickets - ticket; 
        System.out.println("seats available :"+rseat);
        System.out.println("total payment: "+total);
        
        System.out.print("cash: ");
        int cash = sc.nextInt();
        while(cash < price){ 
            System.out.println("not enough ammount, enter larger ammount: ");
            cash = sc.nextInt();   }        
        double change = cash - total; 
        System.out.println("change :"+change);
        
        String usql = "UPDATE tbl_movie SET m_seats = ? WHERE m_id = ?";
        conf.updateRecord(usql, rseat, mid);        
        
       String sql = "UPDATE tbl_transact SET c_id = ?, m_id = ?, t_ticket = ?, t_cash = ?, t_total = ?, t_change = ?   WHERE t_id = ?";    
       conf.updateRecord(sql, cid, mid, ticket, cash, total, change, tid); 
         }catch(Exception e){
              System.out.print("rnter a valid character");
              
          }
          
     
      
        
    }
    
    public void deletetransact(){
         try{
            String delmore;
        do{
        System.out.print("Enter transact ID to delete: ");
        int id = sc.nextInt();
         
        String trnid = "SELECT t_id FROM tbl_transact WHERE t_id =?"; 
        while(conf.getSingleValue(trnid, id) == 0){
              System.out.print("\n movie not found, try again: ");
              id = sc.nextInt(); }        
        System.out.print("delete more:");
        delmore = sc.next();                
        
        String sql = "DELETE FROM tbl_transact WHERE t_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
        }while(delmore.equalsIgnoreCase("yes"));

         
         }catch(Exception e){
              System.out.print("rnter a valid character");
          }
       
    }
}
