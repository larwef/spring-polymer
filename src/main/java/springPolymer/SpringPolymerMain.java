package springPolymer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import springPolymer.Config.ApplicationConfig;
import springPolymer.Config.WebConfig;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import static java.util.EnumSet.allOf;
import static org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME;

public class SpringPolymerMain {
    public static void main(String[] args) throws Exception {

        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);

        Server server = new Server(ApplicationConfig.SERVICE_PORT);
        ServletContextHandler context = new ServletContextHandler(server, ApplicationConfig.SERVICE_CONTEXT);

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletHolder servletHolder = new ServletHolder(dispatcherServlet);
        context.addServlet(servletHolder, "/*");

        FilterRegistration.Dynamic securityFilter = context.getServletContext()
                .addFilter(DEFAULT_FILTER_NAME, DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(allOf(DispatcherType.class), false, "/*");

        server.start();
        server.join();
    }
}
