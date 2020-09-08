import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoLogin", urlPatterns = "/doLogin")
public class DoLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = User.login(username,password);
        String redirectTo = "";

        if(user != null) {

            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            redirectTo = "/postLogin.jsp";
        } else {
            request.setAttribute("errorMessage", "Username / email / password invalid.<br />Retry!");
            redirectTo = "/login.jsp";
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(redirectTo);
        dispatcher.forward(request, response);


    }


}
