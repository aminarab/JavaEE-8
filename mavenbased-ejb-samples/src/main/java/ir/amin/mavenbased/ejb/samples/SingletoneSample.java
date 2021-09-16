package ir.amin.mavenbased.ejb.samples;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import ir.amin.mavenbased.ejb.samples.interfaces.SingletoneSampleLocal;

@Singleton
@LocalBean
public class SingletoneSample extends ParentSample implements SingletoneSampleLocal {

}
