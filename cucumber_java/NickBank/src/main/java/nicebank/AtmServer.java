package nicebank;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.javalite.activejdbc.Base;


public class AtmServer {
    private final Server _server;

    public AtmServer(int port, CashSlot cashSlot, Account account) {
        this._server = new Server(port);

        ContextHandler resourceContext = new ContextHandler();
        resourceContext.setContextPath("/js");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("src/main/webapp/js");
        resourceContext.setHandler(resourceHandler);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath("/");
        servletContext.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot, account)), "/withdraw");
        servletContext.addServlet(new ServletHolder(new ValidationServlet(cashSlot)), "/validate");
        servletContext.addServlet(new ServletHolder(new AtmServlet()), "/");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[]{resourceContext, servletContext});

        _server.setHandler(servletContext);
    }

    public void start() throws Exception{
        _server.start();
        System.out.println("监听："+_server.getURI());
    }

    public void stop() throws Exception{
        _server.stop();
        System.out.println("服务器关闭");
    }

    public static void main(String[] args) throws Exception {
        Base.open("com.mysql.jdbc.Driver","jdbc:mysql://localhost/bank", "teller", "password");
        new AtmServer(9988, new CashSlot(), new Account()).start();
    }
}
