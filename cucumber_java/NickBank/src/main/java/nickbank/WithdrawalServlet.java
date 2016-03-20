package nickbank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/3/19.
 */
public class WithdrawalServlet extends HttpServlet {
    private CashSlot _cashSlot;
    private Account _account;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {

        _cashSlot = cashSlot;
        _account = account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teller teller = new AutomatedTeller(_cashSlot);
        int amount = Integer.parseInt(request.getParameter("amount"));
        teller.withdrawFrom(_account, amount);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<html><head><title>Nice Bank ATM</title><head>" +
                "<body>Please take your $"+amount+"</body></html>");
    }
}

