package ir.amin.mavenbased.ejb.samples;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;

/**
 * @version $Revision$ $Date$
 */
public class HelloTest extends TestCase {

    public void test() throws Exception {
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.core.LocalInitialContextFactory");
        InitialContext initialContext = new InitialContext(properties);

        HelloEjbLocalHome localHome = (HelloEjbLocalHome) initialContext.lookup("MyHello");
        HelloEjbLocal helloEjb = localHome.create();

        String message = helloEjb.sayHello();

        assertEquals(message, " to Maven base JavaEE");
    }
}