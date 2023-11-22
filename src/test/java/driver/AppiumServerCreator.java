package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

public class AppiumServerCreator {
    private static AppiumDriverLocalService server;
    private static final int port = 4723;

    public static void init() {
        server = new AppiumServiceBuilder().
                usingPort(port).
                withIPAddress("127.0.0.1").
                withArgument(() -> "-pa", "/wd/hub").
                build();
        server.start();
    }

    public static AppiumDriverLocalService get() {
        return server;
    }

    public static void stop() {
        server.stop();
    }
}
