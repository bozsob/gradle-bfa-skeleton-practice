package dao;

import model.Garage;

import java.sql.SQLException;
import java.util.List;

public interface GarageDao {

    List<Garage> getAllGarages() throws SQLException;

}
