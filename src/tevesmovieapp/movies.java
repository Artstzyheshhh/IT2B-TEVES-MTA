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
                     mapp.addmovie();
                     break;
                 case 2:
                     mapp.viewmovie();
                     break;
                 case 3:
                     mapp.editmovie();
                     break;
                 case 4:
                     mapp.deletemovie();
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
      
     public void viewmovie() {
        String sqlQuery = "SELECT * FROM tbl_movie";
        String[] columnHeaders = {"ID", "Name", "price", "category", "Seats"};
        String[] columnNames = {"m_id", "m_name", "m_price", "m_category", "m_seats"};

        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }
     
    public void deletemovie() {
        System.out.print("Enter movie ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tbl_movie WHERE m_id = ?";
        conf.deleteRecord(sql, id);
    }
    
    public void editmovie() {
    System.out.print("Enter movie ID to edit: ");
    int id = sc.nextInt();
    sc.nextLine(); 
    System.out.print("New movie name: ");
    String name = sc.nextLine();
    System.out.print("New price: ");
    int price = sc.nextInt();
    sc.nextLine();  
    System.out.print("New category: ");
    String category = sc.nextLine();
    System.out.print("seats available: ");
    int seats = sc.nextInt();
    
    String sql = "UPDATE tbl_movie SET m_name = ?, m_price = ?, m_category = ?, m_seats = ? WHERE m_id = ?";

    conf.editRecord(sql, name, price, category, seats, id);
    }   
    
    public void buytickets() {
        String buymore;
        do{
            System.out.print("Enter movie ID to buy tickets for: ");
        int movieId = sc.nextInt();
        System.out.print("Number of tickets to buy: ");
        int numTickets = sc.nextInt();

        String checkSeatsSql = "SELECT m_seats FROM tbl_movie WHERE m_id = ?";
        String updateSeatsSql = "UPDATE tbl_movie SET m_seats = ? WHERE m_id = ?";

        try {
            
            int availableSeats = conf.checkAvailableSeats(checkSeatsSql, movieId);
            if (availableSeats >= numTickets) {
                int remainingSeats = availableSeats - numTickets;

                
                conf.editRecord(updateSeatsSql, remainingSeats, movieId);

                System.out.println("Tickets purchased successfully!");
                System.out.println("Remaining seats: " + remainingSeats);
            } else {
                System.out.println("Not enough seats available.");
            }
        } catch (Exception e) {
            System.out.println("Error buying tickets: " + e.getMessage());
        }
            
            System.out.println("buy more tickets (yes/no): ");
            buymore = sc.next();
        }while(buymore.equalsIgnoreCase("yes"));
    
        
    }
}
