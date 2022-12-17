package com.example.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Servlet ProductServlet started");
        Map<String, Integer> map = initMap();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++){
            Product p = new Product(i + 1, (String) map.keySet().toArray()[i], map.get((String) map.keySet().toArray()[i]));
            resp.getWriter().printf("<h3>" +String.format("%d. %s = %d", p.getId(), p.getTitle(), p.getCost()) + ".руб </h3>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
        logger.info("Servlet ProductServlet finished");
    }

    public Map<String, Integer> initMap(){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("Молоко", 70);
        map.put("Хлеб", 40);
        map.put("Яйцо", 70);
        map.put("Картофель", 40);
        map.put("Чай", 400);
        map.put("Рыба", 400);
        map.put("Мука", 50);
        map.put("Сыр", 550);
        map.put("Сахар", 60);
        map.put("Капуста", 40);
        return map;
    }
}
