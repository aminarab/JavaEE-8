package ir.amin.mavenbased.ejb.samples;

import javax.ejb.EJBLocalObject;

/**
 * @version $Revision$ $Date$
 */
public interface HelloEjbLocal extends EJBLocalObject {

    String sayHello();

}