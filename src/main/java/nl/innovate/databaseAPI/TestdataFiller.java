package nl.innovate.databaseAPI;
import java.sql.*;

public class TestdataFiller {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        try {
            // Load the JDBC driver, the cj.jdbc.Driver is newer
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Connect to a database
            // serverTimezone attribute is important, UTC seems to be standard
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://192.168.2.44:3306/myapi" + "?useTimezone=true&serverTimezone=UTC", "capcom", "iH4@65q4");
            System.out.println("Database connected");

            int[][] testdata = {
                    {0, 2020, 1, 8320, 8, 16},
                    {1, 2020, 2, 7435, 7, 14},
                    {2, 2020, 3, 6382, 6, 12},
                    {3, 2020, 4, 5342, 5, 10},
                    {4, 2020, 5, 9823, 9, 18},
                    {5, 2020, 6, 8320, 8, 16},
                    {6, 2020, 7, 7435, 7, 14},
                    {7, 2020, 8, 6382, 6, 12},
                    {8, 2020, 9, 5342, 5, 10},
                    {9, 2020, 10, 9823, 9, 18},
                    {10, 2020, 11, 5342, 5, 10},
                    {11, 2020, 12, 9823, 9, 18},
                    {12, 2021, 1, 8320, 8, 16},
                    {13, 2021, 2, 7435, 7, 14},
                    {14, 2021, 3, 6382, 6, 12},
                    {15, 2021, 4, 5342, 5, 10},
                    {16, 2021, 5, 9823, 9, 18},
                    {17, 2021, 6, 8320, 8, 16},
                    {18, 2021, 7, 7435, 7, 14},
                    {19, 2021, 8, 6382, 6, 12},
                    {20, 2021, 9, 5342, 5, 10},
                    {21, 2021, 10, 9823, 9, 18},
                    {22, 2021, 11, 5342, 5, 10},
                    {23, 2021, 12, 9823, 9, 18},
            };

            // Create a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT into statistics_all (id, year, month, value1, value2, value3) " + "values (?, ?, ?, ?, ?, ?)");

            for (int i = 0; i < testdata.length; i++) {
                preparedStatement.setInt(1, testdata[i][0]); 	// id
                preparedStatement.setInt(2, testdata[i][1]);	// year
                preparedStatement.setInt(3, testdata[i][2]);	// month
                preparedStatement.setInt(4, testdata[i][3]);	// amount_cups
                preparedStatement.setInt(5, testdata[i][4]);	// kg waste
                preparedStatement.setInt(6, testdata[i][5]);	// euros

                // Execute a statement
                preparedStatement.executeUpdate();
                System.out.println("Row " + i + " is imported into the database.");
            }
            System.out.println("Data import completed.");

            // Fill the prepared statement once
//			preparedStatement.setInt(1, 4); 	// id
//			preparedStatement.setInt(2, 2020);	// year
//			preparedStatement.setInt(3, 7);		// month
//			preparedStatement.setInt(4, 7221);	// amount_cups

            // Iterate through the result and print the amount of cups
//			while (resultSet.next())
//				System.out.println(resultSet.getString(1) + "\t " + resultSet.getString(2) + "\t " + resultSet.getString(3));

            // Close the connection, not necessary with try-with-resources
//			connection.close();
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}