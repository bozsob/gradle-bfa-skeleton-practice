package dao;

import model.Garage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseGarageDao implements GarageDao {

    private final Connection conn;

    public DatabaseGarageDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Garage> getAllGarages() throws SQLException {

        Statement st = conn.createStatement();

        String query = String.format("SELECT * FROM `garage`");
        ResultSet rs = st.executeQuery(query);
        List<Garage> garages = new ArrayList<>();

        if(rs.next()) {
            garages.add(new Garage(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4)));
        }
        return garages;
    }
}
