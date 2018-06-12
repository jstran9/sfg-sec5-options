package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import guru.springframework.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javax.naming.ldap.Control;
import java.util.Iterator;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyController controller = (MyController) ctx.getBean("myController");
        controller.hello();

        // below demonstrates Inversion of Control (The Spring Framework is determining what dependencies to wire at run-time).
        // this is done because of how we used the annotations of @Autowired, @Controller, and @Service!
        System.out.println(((PropertyInjectedController) getController("propertyInjectedController", ctx)).sayHello());
        System.out.println(((SetterInjectedController) getController("setterInjectedController", ctx)).sayHello());
        System.out.println(((ConstructorInjectedController) getController("constructorInjectedController", ctx)).sayHello());
    }

    private static Object getController(String controllerName, ApplicationContext ctx) {
        return ctx.getBean(controllerName);
    }

}
