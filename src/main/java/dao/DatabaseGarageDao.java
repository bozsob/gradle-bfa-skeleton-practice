package dao;

import model.Garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseGarageDao implements GarageDao {

    private final Connection conn;

    public DatabaseGarageDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Garage> getAllGarages() throws SQLException {


        String query = "SELECT * FROM `garage`";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);

        List<Garage> garages = new ArrayList<>();

        while(rs.next()) {
            garages.add(new Garage(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4)));
        }
        return garages;
    }
}
