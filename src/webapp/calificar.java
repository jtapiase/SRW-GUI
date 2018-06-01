package webapp;

import appLayer.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calificar")
public class calificar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user user = new user();
        user.calificar(Integer.parseInt(request.getParameter("calificacion")), request.getParameter("id"));
        request.setAttribute("usuario", request.getParameter("id"));
        request.getRequestDispatcher("/principal.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
