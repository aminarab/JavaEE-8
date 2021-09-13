package ir.amin.mavenbased.ejb.samples;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * @version $Revision$ $Date$
 */
public interface HelloEjbLocalHome extends EJBLocalHome {

    HelloEjbLocal create() throws CreateException;
}