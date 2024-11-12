package tevesmovieapp;
import java.util.Scanner;
public class movies {
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
                      mapp.viewmovie();
                     mapp.addmovie();
                     break;
                 case 2:
                     mapp.viewmovie();
                     break;
                 case 3:
                      mapp.viewmovie();
                     mapp.Updatemovie();
                     mapp.viewmovie();
                     break;
                     
                 case 4:
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
      }
      
      //add
      public void addmovie(){
        
        System.out.print("Movie name: ");
        String name = sc.next();
        System.out.print("price: ");
        int price = sc.nextInt();
        System.out.print("category: ");
        String category = sc.next();
        System.out.print("seats available: ");
        int seats = sc.nextInt();
       
        
        
        String sql = "INSERT INTO tbl_movie (m_name, m_price, m_category, m_seats) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, name, price, category, seats);
    }
      // view
      
     public void viewmovie() {
        String sqlQuery = "SELECT * FROM tbl_movie";
        String[] columnHeaders = {"ID", "Name", "price", "category", "Seats"};
        String[] columnNames = {"m_id", "m_name", "m_price", "m_category", "m_seats"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
     //view transact
      public void view() {
        String sqlQuery = "SELECT * FROM tbl_transact";
        String[] columnHeaders = {"ID", "Name", "price"};
        String[] columnNames = {"t_id", "m_name", "m_price"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
        // update 
    public void Updatemovie(){
      
        System.out.print("Enter movie ID to edit: ");
        int id = sc.nextInt();
        
        String cusid = "SELECT c_id FROM tbl_customer WHERE c_id =?"; 
        while(conf.getSingleValue(cusid, id) == 0){
              System.out.print("\n Customer not found, try again: ");
              id = sc.nextInt(); }
         
        System.out.print("New movie name: ");
        String name = sc.nextLine();
        System.out.print("New price: ");
        int price = sc.nextInt();
       
        System.out.print("New category: ");
        String category = sc.next();
        System.out.print("seats available: ");
        int seats = sc.nextInt();
        
   
    String sql = "UPDATE tbl_movie SET m_name = ?, m_price = ?, m_category = ?, m_seats = ? WHERE m_id = ?";
    config conf = new config();
    conf.updateRecord(sql, name, price, category, seats, id);
    }
    
    public void deletemovie(){
        String delmore;
        do{
        System.out.print("Enter movie ID to delete: ");
        int id = sc.nextInt();
         
        String movid = "SELECT m_id FROM tbl_movie WHERE m_id =?"; 
        while(conf.getSingleValue(movid, id) == 0){
              System.out.print("\n movie not found, try again: ");
              id = sc.nextInt(); }        
        System.out.print("delete more:");
        delmore = sc.next();                
        
        String sql = "DELETE FROM tbl_movie WHERE m_id = ?";
        config conf = new config();
        conf.deleteRecord(sql, id);
        }while(delmore.equalsIgnoreCase("yes"));
}
  
}

