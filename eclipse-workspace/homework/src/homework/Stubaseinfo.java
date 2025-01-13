

package homework;

import java.sql.*;

public class Stubaseinfo {
    public static void main(String[] args) {
        SQLtools sqltools = new SQLtools();

        String head[];
        String data[][];

        sqltools.showStuBaseInfo("student");

        data = sqltools.data;
        head = sqltools.colname;

        for(int i = 0 ;i < head.length; i++)
        {
            System.out.print(head[i] + "      ");

        }

        System.out.println();

        for(int i = 0 ;i < data.length; i ++)
        {
            for(int j = 0; j < data[i].length; j++)
            {
                System.out.print(data[i][j] + "      ");
            }

            System.out.println();
        }
    }
}

class SQLtools
{
    private String databasename = "";
    private String sql;
    public String colname[];
    public String data[][];

    public SQLtools() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     public void showStuBaseInfo(String path)
     {
         try {
             sql = "select * from stuinfo";
             databasename = path;

             Connection con;
             Statement setsql;
             ResultSet rs;
             String user = "jdbc:mysql://localhost:3306/" + databasename + "?useSSL = false&severTimezone = CST&characterEncoding = utf-8";

             con = DriverManager.getConnection(user, "root", "password");
             setsql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);

             rs = setsql.executeQuery(sql);
             ResultSetMetaData metaData = rs.getMetaData();
             int colcnt = metaData.getColumnCount();
             colname = new String[colcnt];

             for(int i = 1 ;i <= colcnt; i++)
             {
                 colname[i - 1]  = metaData.getColumnName(i);
             }

             rs.last();
             int rowcnt = rs.getRow();
             rs.beforeFirst();

             data = new String[rowcnt][colcnt];

             int rowpos = 0;
             while(rs.next())
             {
                 for(int colpos = 1; colpos <= colcnt; colpos++)
                 {
                     data[rowpos][colpos - 1] = rs.getString(colpos);
                 }
                 rowpos ++;
             }

             con.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
