import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DoRegister", urlPatterns = "/doRegister")
public class DoRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userID = null;
        String redirectTo = "";

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");

        ArrayList errors = User.validate(username,email, password, firstname, lastname, dob);
        if(errors.size() == 0) {
            userID = User.register(username,email, password, firstname, lastname, dob);
        }

        if(userID != null) {
            request.setAttribute("userID",userID);
            redirectTo = "login.jsp";
        } else {
            String  errorList = String.join("<br /><br />",  errors);
            request.setAttribute("errorMessage", errorList);
            redirectTo = "register.jsp";
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(redirectTo);
        dispatcher.forward(request, response);


    }


}
