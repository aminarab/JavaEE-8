package ir.amin.mavenbased.ejb.samples;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ir.amin.mavenbased.ejb.samples.interfaces.StatelessSampleLocal;

@Stateless
@LocalBean
public class StatelessSample extends ParentSample implements StatelessSampleLocal{
	
}
