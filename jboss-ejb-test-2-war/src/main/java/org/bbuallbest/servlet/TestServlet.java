package org.bbuallbest.servlet;

import org.bbuallbest.TestLocal;
import org.bbuallbest.TestLocalHome;
import org.bbuallbest.entity.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer requestUserId;
        String answer = null;
        Student student = null;

        try {
            requestUserId = Integer.valueOf(req.getParameter("userId"));

        } catch (NumberFormatException e) {
            requestUserId = 2;
        }

        try {
            Context context = new InitialContext();
            TestLocalHome testLocalHome = (TestLocalHome)context.lookup("java:app/jboss-ejb-test-2-ejb-1.0-SNAPSHOT/TestBean!org.bbuallbest.TestLocalHome");
//            TestLocalHome testLocalHome = (TestLocalHome)context.lookup("java:comp/env/ejb/TestBean");
            TestLocal testLocal = testLocalHome.create();
            answer = testLocal.sayHello();
            student = testLocal.getStudent(requestUserId);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html");
        
        PrintWriter writer = resp.getWriter();
        writer.append("<html>");
        writer.append("<head></head>");
        writer.append("<body>");
        writer.append("<h1>Text: " + answer + "</h1><br/>");
        writer.append("<h1>Student: " + student + "</h1>");
        writer.append("</body>");
        writer.append("</html>");
    }
}
