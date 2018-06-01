package webapp;

import appLayer.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user user = new user();

        if(user.isValidUserCredentials(request.getParameter("usuario"), request.getParameter("password"))){
            request.getRequestDispatcher("/principal.jsp").forward(request, response);
        }else{
            request.setAttribute("errorMessage", "Credenciales invalidas");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
