package ir.amin.mavenbased.ejb.samples;


import javax.ejb.LocalBean;
import javax.ejb.LocalHome;
import javax.ejb.Stateless;

import ir.amin.mavenbased.ejb.samples.interfaces.HelloLocal;


@Stateless
@LocalBean
@LocalHome(HelloEjbLocalHome.class)
public class Hello implements HelloLocal {

    public String sayHello() {
        return " to Maven base JavaEE";
    }

}