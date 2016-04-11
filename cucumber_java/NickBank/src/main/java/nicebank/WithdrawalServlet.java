package nicebank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {
    private CashSlot _cashSlot;
    private Account _account;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {

        _cashSlot = cashSlot;
        _account = account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int amount = Integer.parseInt(request.getParameter("amount"));
        try {
            AutomatedTeller.withdrawFrom(_cashSlot, _account, amount);

            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<html><head><title>Nice Bank ATM</title><head>" +
                    "<body>Please take your $"+amount+"</body></html>");
        }
        catch (RuntimeException e){
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<html><head><title>Nice Bank ATM</title><head>" +
                    "<body>"+e.getMessage()+"</body></html>");
        }

    }
}

