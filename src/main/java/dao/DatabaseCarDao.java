package dao;

import model.Car;
import model.Garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCarDao implements CarDao {

    private final Connection conn;

    public DatabaseCarDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {


        Statement st = conn.createStatement();

        String query = String.format("SELECT * FROM `car`");
        ResultSet rs = st.executeQuery(query);
        List<Car> cars = new ArrayList<>();

        while(rs.next()) {
            cars.add(new Car(rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getInt(5)));
        }
        return cars;
    }

    @Override
    public List<Car> getCarsByGarage(int id) throws SQLException {

        String query = "SELECT * FROM `car` WHERE garageId = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        List<Car> cars = new ArrayList<>();

        while(rs.next()) {
            cars.add(new Car(rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getInt(5)));
        }
        return cars;
    }

    @Override
    public Car addCar(String color, int year, String brand, int garageId) throws SQLException {


        String query = "INSERT INTO `car` VALUES(NULL,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, color);
        ps.setInt(2, year);
        ps.setString(3, brand);
        ps.setInt(4, garageId);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        Car car = null;
        if(rs.next()) {
            car = new Car(rs.getInt(1),
                color,
                year,
                brand,
                garageId);

        }
        return car;
    }
}
