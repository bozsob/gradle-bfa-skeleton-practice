package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseGarageDao;
import model.Garage;
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
 * Created by trixi on 2017.05.21..
 */
@WebServlet("/garage")
public class GarageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        DatabaseGarageDao garageDao = new DatabaseGarageDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.BFA));
        List<Garage> garages = new ArrayList<>();

        try {
            garages = garageDao.getAllGarages();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        objectMapper.writeValue(response.getOutputStream(), garages);

    }
}
