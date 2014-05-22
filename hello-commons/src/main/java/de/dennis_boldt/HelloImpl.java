package de.dennis_boldt;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.enterprise.context.Dependent;
import javax.naming.NamingException;

@Dependent
@Stateful
@Local
public class HelloImpl implements Hello {

	private static final long serialVersionUID = 1L;
	private Hello hello = null;
	
	public HelloImpl() {
		try {
			this.hello = HelloJndi.getHello();
		} catch (NamingException e) {
			System.out.println("JNDI Error");
			e.printStackTrace();
		}
	}
	
	@Override
	public String helloWorld() {
		return this.hello.helloWorld();
	}

}