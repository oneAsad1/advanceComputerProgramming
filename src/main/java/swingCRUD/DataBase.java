package swingCRUD;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class DataBase {
    Connection conn;
    Statement st;
    ResultSet resultSet;

    DataBase(String dbName) {
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String user = "root";
        String pass = "ItisHard@1234";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            st = conn.createStatement();
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }
    }
    Boolean createData(int regNumber, String Name) throws SQLException {
        PreparedStatement pStat = conn.prepareStatement("INSERT INTO student VALUES (?, ?)");
        pStat.setInt(1, regNumber);
        pStat.setString(2, Name);
        pStat.executeUpdate();
        return true;
    }

    DefaultTableModel readData() throws SQLException {
        resultSet = st.executeQuery("SELECT * FROM student");
        ResultSetMetaData rsmd = resultSet.getMetaData();

        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];
        DefaultTableModel model = new DefaultTableModel();

        for (int i = 0; i < columnCount; i++)
            columnNames[i] = rsmd.getColumnName(i + 1);

        model.setColumnIdentifiers(columnNames);
        Object[] rowData = new Object[columnCount];
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            model.addRow(rowData);
        }
        return model;
    }

    Boolean updateData(int regNumber, String Name) throws SQLException {
        PreparedStatement pStat = conn.prepareStatement("UPDATE student SET Name = ? WHERE Reg = ?");
        pStat.setString(1, Name);
        pStat.setInt(2, regNumber);
        pStat.executeUpdate();
        return true;
    }

    Boolean deleteData(int regNumber) throws SQLException {
        PreparedStatement pStat = conn.prepareStatement("DELETE FROM student WHERE Reg = ?");
        pStat.setInt(1, regNumber);
        pStat.executeUpdate();
        return true;
    }
}
