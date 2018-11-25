import beans.Client;
import beans.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private ConsoleEventLogger eventLogger;

    public void logEvent(String msg){
        String message = msg.replaceAll(
               client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public App(Client client, ConsoleEventLogger logger){
        this.client = client;
        this.eventLogger = logger;
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");


        app.logEvent("Some event for user 1");
    }
}
