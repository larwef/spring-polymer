package springPolymer.Config;

import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import org.constretto.model.Resource;

public class Config {
    private static final ConstrettoConfiguration configuration = new ConstrettoBuilder().
            createPropertiesStore().
            addResource(Resource.create("classpath:application.properties")).
            done().
            getConfiguration();

    private Config() {}

    public static String getString(String key) {
        return configuration.evaluateToString(key);
    }

    public static Integer getInt(String key) {
        return configuration.evaluateToInt(key);
    }

    public static boolean getBoolean(String key) {
        return configuration.evaluateToBoolean(key);
    }
}
