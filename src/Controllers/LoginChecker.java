package Controllers;

import Models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginChecker")
public class LoginChecker implements Filter {
    private User initUser;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        User loginUser = new User("", "", "");
        System.out.println("here was");
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String user, pass;

        user = request.getParameter("username");
        pass = request.getParameter("password");

        if (session.getAttribute("username") != null) {
            response.sendRedirect("/HomePage.jsp");
            //request.redi("/game.do").forward(request, response);
        } else {


            ///Merge-olni a ket ifet, szolni neki hogy balfasz s nem irt semmit
            if(user == null || pass == null)
            {
                user = "";
                pass = "";
            }

            if(!user.isEmpty() && !pass.isEmpty()) {

                if(user.equals(initUser.getUsername()) && pass.equals(initUser.getPassword()))
                {
                    session.setAttribute("username", user);
                    response.sendRedirect("/HomePage.jsp");
                    //request.getRequestDispatcher("/game.do").forward(request, response);
                }
                else {
                    loginUser.setUsername(user);
                    loginUser.setPassword(pass);
                    loginUser.setError("Wrong password or username");
                    request.setAttribute("user", loginUser);
                    chain.doFilter(req, resp);
                    //////visszatolti azzal amit rosszul irtal, de ki is lehet torolni #swagYolo
                }
            }
            else
            {
                loginUser.setUsername(user);
                loginUser.setPassword(pass);
                loginUser.setError("Smthg is empty");
                request.setAttribute("user", loginUser);
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
        initUser = new User(config.getInitParameter("username"), config.getInitParameter("password"), "buu");
    }

}
