package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class DB {
	
	Connection con;
	 
	public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            System.out.println("DB connection successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public static void createDatabase() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            System.out.println("DB connection successful");
            Statement statement = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS patients";
            statement.executeUpdate(sql);
            con.close();
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void createTable() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients", "root", "");
            System.out.println("DB connection successful");
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `patients`.`asset` ( `uuid` INT NOT NULL AUTO_INCREMENT , "
            		+ "`name` VARCHAR(50) NOT NULL , `age` INT NOT NULL , `gender` VARCHAR(7) NOT NULL ,"
            		+ " `blood_type` VARCHAR(3) NOT NULL , `weight` DOUBLE NOT NULL , `height` VARCHAR(6) NOT NULL ,"
            		+ " PRIMARY KEY (`uuid`)) ENGINE = InnoDB";
            if (statement.executeUpdate(sql) == 1) {
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Jordan Sancho', '23', 'Male', 'A+', '78', '5\\'10\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Valentina Sanders', '42', 'Female', 'O+', '93', '5\\'7\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Carolina Murray', '32', 'Female', 'B-', '82', '5\\'5\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Carlos Flores', '18', 'Male', 'A-', '55', '5\\'9\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Kingston Watkins', '36', 'Male', 'A+', '66', '6\\'1\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Rose Hughes', '25', 'Female', 'B+', '49', '5\\'9\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Paul Tucker', '28', 'Male', 'O-', '105', '5\\'8\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Gemma Bailey', '58', 'Female', 'AB+', '67', '5\\'7\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Kathy Peterson', '12', 'Female', 'AB-', '24', '4\\'3\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		sql = "INSERT INTO `asset` (`uuid`, `name`, `age`, `gender`, `blood_type`, `weight`, `height`) VALUES (NULL, 'Dave Martinez', '8', 'Male', 'B+', '18', '3\\'2\\'\\'')";
	    		statement.executeUpdate(sql);
	    		
	    		System.out.println("Data added in database.");
	    		con.close();
            }
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public static List<Patient> getPatients() {
		try {
			List<Patient> list = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients", "root", "");
	        System.out.println("DB connection successful");
	        Statement statement = con.createStatement();
	        String sql = "SELECT * FROM `asset` WHERE 1";
	        
	        ResultSet rs = statement.executeQuery(sql);
	        
	        while(rs.next()) {
                Patient patient = new Patient(rs.getInt("uuid"), rs.getString("name"), rs.getInt("age"), 
                			rs.getString("gender"), rs.getString("blood_type"), rs.getDouble("weight"), rs.getString("height"));
                list.add(patient);
            }
	        
	        return list;
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
		
	}
}
