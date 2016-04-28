package fruit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class FruitServer {
    private final Server server;

    public FruitServer(int port) {
        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        servletHolder.setInitParameter("com.sun.jersey.config.property.packages", "fruit");
        servletHolder.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addServlet(servletHolder, "/");
    }

    public void start() throws Exception{
        server.start();
        System.out.println("监听：" + server.getURI());
    }

    public void stop() throws Exception{
        server.stop();
        System.out.println("服务停止");
    }

    public static void main(String[] args) throws Exception{
        new FruitServer(9988).start();
    }
}
