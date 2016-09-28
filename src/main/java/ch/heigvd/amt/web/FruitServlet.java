package ch.heigvd.amt.web;

import ch.heigvd.amt.model.Fruit;
import ch.heigvd.amt.services.FruitManager;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//Servlet -> Controller
@WebServlet(name="FruitServlet", urlPatterns={"/FruitServlet"})
public class FruitServlet extends javax.servlet.http.HttpServlet {

    FruitManager fruitManager = new FruitManager();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Object counter = request.getSession().getAttribute("counter");
        if(counter == null) {
            request.getSession().setAttribute("counter", new Integer(1));
        } else {
            Integer oldValue = (Integer) counter;
            request.getSession().setAttribute("counter", oldValue + 1);
        }
        Fruit fruit = fruitManager.getRandomFruit();
        request.setAttribute("theFruit", fruit);
        request.getRequestDispatcher("/WEB-INF/pages/Fruit.jsp").forward(request, response);
    }
}