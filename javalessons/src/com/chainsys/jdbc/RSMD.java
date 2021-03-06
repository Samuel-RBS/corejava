package com.chainsys.jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.*;

	public class RSMD{
	    public static void main(String args[]) {
	        //resultSetMetaData();
	        //DatabaseMetaData();
	        //printsTotalNumberOfTables();
	      //storeImageInTheDatabase();
	      //storeImageInTheDatabase1();
	    	RetrieveImage();
	    }
	    //find total column,individual name and column data type 
	    public static void resultSetMetaData()
	    {
	        try {
	          //  Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
	            PreparedStatement ps = con.prepareStatement("select * from filetable");
	            ResultSet rs = ps.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            System.out.println("Total columns: " + rsmd.getColumnCount());
	            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(2));
	            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(2));
	            con.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
       //Find the JDBC driver details
	    public static void DatabaseMetaData()
	    {
	    try{  
	     //   Class.forName("oracle.jdbc.driver.OracleDriver");  	          
	        Connection con=DriverManager.getConnection(  
	        "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
	        DatabaseMetaData dbmd=con.getMetaData();  	          
	        System.out.println("Driver Name: "+dbmd.getDriverName());  
	        System.out.println("Driver Version: "+dbmd.getDriverVersion());  
	        System.out.println("UserName: "+dbmd.getUserName());  
	        System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
	        System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  	          
	        con.close();  
	        }catch(Exception e){ System.out.println(e);}  
	}	
	    // Print total no of tables...by using view or Table
	    public static void printsTotalNumberOfTables()
	    {
	try{  
	  //  Class.forName("oracle.jdbc.driver.OracleDriver");  	      
	    Connection con=DriverManager.getConnection(  
	    "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  	      
	    DatabaseMetaData dbmd=con.getMetaData();  
	    String table[]={"VIEW"};  
	    ResultSet rs=dbmd.getTables(null,null,null,table);  	      
	    while(rs.next()){  
	    System.out.println(rs.getString(3));  
	    }  	      
	    con.close();  	      
	    }catch(Exception e){ System.out.println(e);  
	    }
	    }  
	    //To get images by using the fileInputStream format
	    public static void storeImageInTheDatabase()
	    {
	    try{  
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	        Connection con=DriverManager.getConnection(
	        		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  	                      
	        PreparedStatement ps=con.prepareStatement("insert into ImageJDBC  values(?,?)");  
	        ps.setString(1,"Samuel");  	          
	        FileInputStream fin=new FileInputStream("D:\\temp\\flower.jpg");  
	        ps.setBinaryStream(2,fin,fin.available());  
	        int i=ps.executeUpdate();  
	        System.out.println(i+" records affected");  	                  
	        con.close();  
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }  
	    }
	public static void storeImageInTheDatabase1() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				 PreparedStatement ps=con.prepareStatement("insert into ImageJDBC  values(?,?)");
				 ps.setString(1,"Samuel");  	          
			        FileInputStream fin=new FileInputStream("D:\\temp\\Minions.png");  
			        ps.setBinaryStream(2,fin,fin.available());  
			        int i=ps.executeUpdate();  
			        System.out.println(i+" records affected");  	                  
			        con.close();  
			        }catch (Exception e) {
			        	e.printStackTrace();
			        } 
		}
		public static void RetrieveImage() {  			
			try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  			      
			PreparedStatement ps=con.prepareStatement("select * from ImageJDBC");  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){//now on 1st row  			              
			Blob b=rs.getBlob(2);//2 means 2nd column data  
			byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  			              
			FileOutputStream fout=new FileOutputStream("D:\\Minions.png");  
			fout.write(barr);  			              
			fout.close();  
			}//end of if  
			System.out.println("ok");  		              
			con.close();  
			}catch (Exception e) {
				e.printStackTrace();  
			}  
		}  
	}