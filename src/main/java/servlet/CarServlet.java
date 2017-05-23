package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.DatabaseCarDao;
import model.Car;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trixi on 2017.05.19..
 */
@WebServlet("/car")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String brand = request.getParameter("brand");
        Integer year = Integer.valueOf(request.getParameter("year"));
        String color = request.getParameter("color");
        Integer garageId = Integer.parseInt(request.getParameter("garageId"));

        Car car = new Car(color, year, brand, garageId);

        DatabaseCarDao carDao = new DatabaseCarDao(ConnectionUtil
        .getConnection(ConnectionUtil.DatabaseName.BFA));

        try {
            Car resultCar = carDao.addCar(color, year, brand, garageId);
            response.setContentType("application/json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), resultCar);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        System.out.println("id: " + id);

        List<Car> cars = new ArrayList<>();
        DatabaseCarDao carDao = new DatabaseCarDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.BFA));

        try {
            if(id == 0) {
                cars = carDao.getAllCars();
            }
            else {
                cars = carDao.getCarsByGarage(id);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), cars);

        /*
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(cars));
         */
    }
}
