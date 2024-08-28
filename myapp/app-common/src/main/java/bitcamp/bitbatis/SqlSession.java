package bitcamp.bitbatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

;

public class SqlSession{
    Connection con;

    public SqlSession(Connection con){
        this.con = con;
    }

    public int insert(String sql, Object... values) throws SQLException {
        try(PreparedStatement stmt = con.prepareStatement(sql)){

            int inparameterIndex = 1;
            for(Object value : values) {
                stmt.setString(inparameterIndex++, value.toString());
            }
            return stmt.executeUpdate();
        }
    }

}