package ir.amin.mavenbased.ejb.samples;


import javax.ejb.LocalHome;
import javax.ejb.Stateless;

/**
 * @version $Revision$ $Date$
 */
@Stateless
@LocalHome(HelloEjbLocalHome.class)
public class HelloImpl implements Hello{

    public String sayHello() {
        return " to Maven base JavaEE";
    }

}