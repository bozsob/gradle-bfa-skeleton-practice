package dao;

import model.Car;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by trixi on 2017.05.19..
 */
public interface CarDao {

    List<Car> getAllCars() throws SQLException;
    List<Car> getCarsByGarage(int id) throws SQLException;
    Car addCar(String color, int year, String brand, int garageId) throws SQLException;
}
