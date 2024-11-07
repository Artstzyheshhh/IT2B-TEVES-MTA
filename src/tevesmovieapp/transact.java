
package tevesmovieapp;

import java.util.Scanner;

public class transact {
    
        config conf = new config();
        String resp;
        Scanner sc = new Scanner(System.in);
      public void options(){
      do{ 
          System.out.println("-------------------------------");
          System.out.println("| MOVIE TICKETING APPLICATION |");
          System.out.println("-------------------------------");
          System.out.println("1. ADD MOVIE");
          System.out.println("2. VIEW MOVIE LIST");
          System.out.println("3. EDIT MOVIE");
          System.out.println("4. DELETE MOVIE");
          System.out.println("5. MAIN MENU");
          System.out.print("Enter choice: ");
              int choices = sc.nextInt();
    while(choices> 5){ 
        System.out.print("try again : ");
        choices = sc.nextInt();
    }
              movies mapp = new movies();
             switch(choices){
                 case 1:
                     
                     break;
                 case 2:
                  
                     break;
                 case 3:
                     ;
                     break;
                     
                 case 4:
                 
                     break;
                  case 5:
                       
                     break;
                                              
             } 
        System.out.print("do another transaction(yes/no): ");
        resp = sc.next();
        }while(resp.equalsIgnoreCase("yes"));
      }
      
      //add
      public void addmovie(){
       System.out.print("Customer name: ");
            String name = sc.next(); 
            movies mapp = new movies();
            mapp.viewmovie();
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
      
     public void viewmovie() {
        
         
    }
     //view transact
      public void view() {
        
          
    }
        // update 
    public void Updatemovie(){
    
        System.out.print("Enter customer id: ");
            int cid = sc.nextInt();
            
        System.out.print("New customer name: ");
            String name = sc.next();      
         movies mapp = new movies();
            mapp.viewmovie();           
        System.out.print("Enter movie id to buy: ") ;
            int mid = sc.nextInt();
            
        String cust = "SELECT c_id FROM tbl_customer WHERE c_id =?";
        String ctckt = "SELECT c_ticket FROM tbl_customer WHERE c_id =?";
        String mticket = "SELECT m_seats FROM tbl_movie WHERE m_id =?";
        String ccash = "SELECT c_cash FROM tbl_customer WHERE c_id =?";
        String mprice = "SELECT m_price FROM tbl_movie WHERE m_id =?";
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        String ctotal = "SELECT c_total FROM tbl_customer WHERE c_id =?";
        
        double custicket = conf.getSingleValue(ctckt, cid);                  
        double tickets = conf.getSingleValue(mticket, mid);  
        double cuscash = conf.getSingleValue(ccash, cid);
        double price = conf.getSingleValue(mprice, mid);
        double custotal = conf.getSingleValue(ctotal, cid);
        
        while(conf.getSingleValue(movid, mid) == 0){
        System.out.print("\n movie not found, try again: ");
            mid = sc.nextInt(); }
    
        System.out.print("tickets to buy: ");
            int ticket = sc.nextInt();
        
        while(ticket>tickets){
        System.out.print("input limited tickets only: ");
            ticket =sc.nextInt(); }
        double total = ticket * price;
        double rseat = tickets - ticket; 
        System.out.println("seats available :"+rseat);
        System.out.println("total payment: "+total);
        
        double ntotal = total + custotal; 
        double ntickets = ticket + custicket;
        System.out.print("cash: ");
            int cash = sc.nextInt();
                
        while(cash < price){ 
            System.out.println("not enough ammount, enter larger ammount: ");
           cash = sc.nextInt();   }  
         
        double ncash = cash + cuscash;
         double change = cash - total; 
         System.out.println("change :"+change);
         
       String msql = "UPDATE tbl_movie SET m_seats = ? WHERE m_id = ?";
       conf.updateRecord(msql,rseat ,mid);  
       String sql = "UPDATE tbl_customer SET c_name = ?, c_ticket = ?, c_cash = ? , c_total = ? WHERE c_id = ?";
       config conf = new config();
       conf.updateRecord(sql, name, ntickets, ncash, ntotal,  cid);  
      
        
    }
    
    public void deletemovie(){
       
        
    }
}
