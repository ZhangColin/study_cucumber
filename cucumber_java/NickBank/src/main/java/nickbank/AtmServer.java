package nickbank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Administrator on 2016/3/19.
 */
public class AtmServer {
    private final Server _server;

    public AtmServer(int port) {
        this._server = new Server(9988);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        _server.setHandler(context);

        context.addServlet(new ServletHolder(new AtmServlet()), "/*");
    }

    public void start() throws Exception{
        _server.start();
        System.out.println("监听："+_server.getURI());
    }

    public void stop() throws Exception{
        _server.stop();
    }

    public static void main(String[] args) throws Exception {
        new AtmServer(9988).start();
    }
}
