package fruit;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class FruitServer {
    private HttpServer server;
    private int port;

    public FruitServer(int port) {
        /*ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        servletHolder.setInitParameter("com.sun.jersey.config.property.packages", "fruit");
        servletHolder.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addServlet(servletHolder, "/");*/
        this.port = port;
    }

    public void start() throws Exception{
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        final ResourceConfig resourceConfig = new ResourceConfig(FruitService.class);
        server = GrizzlyHttpServerFactory.createHttpServer(baseUri, resourceConfig);
        System.out.println("监听：" + baseUri);
    }

    public void stop() throws Exception{
        server.stop();
        System.out.println("服务停止");
    }

    public static void main(String[] args) throws Exception{
        new FruitServer(9988).start();
    }
}
