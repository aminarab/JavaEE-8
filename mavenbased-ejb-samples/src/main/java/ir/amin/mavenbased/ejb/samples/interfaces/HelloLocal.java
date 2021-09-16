package ir.amin.mavenbased.ejb.samples.interfaces;

import javax.ejb.Local;


@Local
public interface HelloLocal {

    String sayHello();

}