package com.handsonpractice.generateJSON;
import java.sql.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "kanak_410";
        String password = "0410_kana";
        String query = "SELECT * FROM your_table";

        List<Map<String, Object>> dataList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(metaData.getColumnName(i), rs.getObject(i));
                }
                dataList.add(rowData);
            }

            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

            // Save JSON to a file
            objectMapper.writeValue(new File("database_report.json"), dataList);

            System.out.println("JSON Report Generated Successfully!");
            System.out.println(jsonReport);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
