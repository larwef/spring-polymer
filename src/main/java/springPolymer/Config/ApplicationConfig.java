package springPolymer.Config;

public class ApplicationConfig {
    public final static int SERVICE_PORT = Config.getInt("service.port");
    public final static String SERVICE_CONTEXT = Config.getString("service.context");
}
