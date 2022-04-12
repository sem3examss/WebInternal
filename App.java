import java.sql.*;
import java.util.*;
class App{
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(Exception exception){
                System.out.println("Driver Registration problem");
            }
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","root","1863");
                Statement stmt = con.createStatement();
                Scanner sc=new Scanner(System.in);
                int n;
                String table;
                
                while(true){
                    System.out.println("1.Create Table 2.Insert Values 3.Get value 4.Delete 5.Update 6.Exit");
                    n = sc.nextInt();
                    if(n==6){
                        System.exit(0);
                    }
                    System.out.print("Enter table name:");
                    table = sc.next();
                    switch(n){
                        case 1: Boolean out = stmt.execute("create table "+ table +"(id int primary key, name varchar(20) not null)");
                                if(!out){
                                    System.out.println("Table created");
                                }
                                else{
                                    System.out.println("Table not created");
                                }
                                break;
                        case 2: System.out.print("Id:");
                                String id = sc.next();
                                System.out.print("Name:");
                                String name = sc.next();
                                String ins = "insert into "+ table +" values("+ id + ","+ "'" +name + "'" + ")";
                                stmt.executeUpdate(ins);
                                break;
                        case 3: ResultSet  rs = stmt.executeQuery("select * from "+ table);
                                while(rs.next()){
                                    System.out.print("id :"+rs.getInt("id"));   
                                    System.out.println(" Name :"+rs.getString("name"));
                                }
                                System.out.println("End of data");
                                break;
                        case 4: System.out.print("Enter ID of the tuple to be deleted:");
                                String did = sc.next();
                                stmt.executeUpdate("delete from "+table+" where id = "+did);
                                break;
                                
                        case 5:System.out.println("Enter ID of the tuple to be updated:");
                                String uid = sc.next();
                                System.out.println("Enter name :");
                                String uname = sc.next();
                                stmt.executeUpdate("update "+table+" set name = \""+uname+"\" where id = "+uid);
                                break;                                
                    }
                }
               
            }
            catch(Exception exception){
                System.out.print(exception);
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}