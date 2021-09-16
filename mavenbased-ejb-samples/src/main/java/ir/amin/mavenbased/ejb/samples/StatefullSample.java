package ir.amin.mavenbased.ejb.samples;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import ir.amin.mavenbased.ejb.samples.interfaces.StatefullSampleLocal;

@Stateful
@LocalBean
public class StatefullSample extends ParentSample implements StatefullSampleLocal {

}
