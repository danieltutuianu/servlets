import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/sendData")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer number1 = Integer.parseInt(request.getParameter("number1"));
        Integer number2 = Integer.parseInt(request.getParameter("number2"));

        Integer sum = number1 + number2;
        request.setAttribute("sum", sum);

        HttpSession session = request.getSession(false);
        User user = null;

        if (session != null) {
            user = (User) session.getAttribute("user");
        }

        request.setAttribute("user", user);


        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }


}
