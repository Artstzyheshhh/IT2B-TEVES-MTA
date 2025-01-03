package tevesmovieapp;
import java.util.Scanner;
public class movies {
        config conf = new config();
        String resp;
        Scanner sc = new Scanner(System.in);
      public void options(){
        try{
        
              
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
                      System.out.println("\t--------------------");
                      System.out.println("\t|     ADD MOVIE    |");
                      System.out.println("\t--------------------"); 
                      mapp.viewmovie();
                     mapp.addmovie();
                     break;
                 case 2:
                      System.out.println("\t-----------------------");
                      System.out.println("\t|     MOVIE REPORT    |");
                      System.out.println("\t-----------------------"); 
                     mapp.viewmovie();
                     break;
                 case 3:
                      System.out.println("\t-----------------------");
                      System.out.println("\t|     UPDATE MOVIE    |");
                      System.out.println("\t-----------------------"); 
                      mapp.viewmovie();
                     mapp.Updatemovie();
                     mapp.viewmovie();
                     break;
                     
                 case 4:
                      System.out.println("\t-----------------------");
                      System.out.println("\t|     DELETE MOVIE    |");
                      System.out.println("\t-----------------------"); 
                      mapp.viewmovie();
                      mapp.deletemovie();
                       mapp.viewmovie();
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
              System.out.print("enter a valid character");
          }
           
          
    
      }
      
      //add
      public void addmovie(){
         
        try{
        System.out.print("Movie name: ");
        String name = sc.next();
        System.out.print("price: ");
        int price = sc.nextInt();
        System.out.print("category: ");
        String category = sc.next();
        System.out.print("seats available: ");
        int seats = sc.nextInt();
        if(seats> 0){ 
            String status = ("Available") ;
            System.out.println("Movie status: "+status);
        }
        else if (seats < 0){
           String status = ("Unavailable");        
            System.out.println("Movie status: "+status);
        } 
        
        String sql = "INSERT INTO tbl_movie (m_name, m_price, m_category, m_seats) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, name, price, category, seats);
        
        }catch(Exception e){
            System.out.println("enter valid character:");       
        }
          
    }
      // view
      
     public void viewmovie() {
        String sqlQuery = "SELECT * FROM tbl_movie";
        String[] columnHeaders = {"ID", "Name", "price", "category", "Seats", "status"};
        String[] columnNames = {"m_id", "m_name", "m_price", "m_category", "m_seats", "m_status"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
       
        // update 
    public void Updatemovie(){
     try{
     
      System.out.print("Enter movie ID to edit: ");
        int id = sc.nextInt();
        
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        while(conf.getSingleValue(movid, id) == 0){
              System.out.print("\nMovie not found, try again: ");
              id = sc.nextInt(); }
         
        System.out.print("New movie name: ");
        String name = sc.next();
        System.out.print("New price: ");
        int price = sc.nextInt();      
        System.out.print("New category: ");
        String category = sc.next();
        System.out.print("seats available: ");
        int seats = sc.nextInt();
       
        if(seats> 0){ 
            String status = ("Available") ;
            String sql = "UPDATE tbl_movie SET m_status = ? WHERE m_id = ?";  
            conf.updateRecord(sql, status, id);
            System.out.println("movie status: "+status);
        }
        else if (seats < 0){
           String status = ("Unavailable");
           String sql = "UPDATE tbl_movie SET m_status = ? WHERE m_id = ?";  
           conf.updateRecord(sql, status, id);
           System.out.println("movie status: "+status);
        } 
         
    String sql = "UPDATE tbl_movie SET m_name = ?, m_price = ?, m_category = ?, m_seats = ? WHERE m_id = ?";
    
    conf.updateRecord(sql, name, price, category, seats, id);
     }catch(Exception e){
              System.out.print("enter a valid character");
          }
       
    }
    
    public void deletemovie(){
        
     try{
     
     String delmore;
        do{
        System.out.print("Enter movie ID to delete: ");
        int id = sc.nextInt();
         
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        while(conf.getSingleValue(movid, id) == 0){
              System.out.print("\n movie not found, try again: ");
              id = sc.nextInt(); }        
        System.out.print("delete more(yes/no):");
        delmore = sc.next();                
        
        String sql = "DELETE FROM tbl_movie WHERE m_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
        }while(delmore.equalsIgnoreCase("yes"));
     
     }catch(Exception e){
              System.out.print("enter a valid character");
          }    
        
        
}
  
}

