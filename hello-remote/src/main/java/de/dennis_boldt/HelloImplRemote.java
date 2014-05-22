package de.dennis_boldt;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import de.dennis_boldt.Hello;

@Stateful
@Remote
public class HelloImplRemote implements Hello {

	private static final long serialVersionUID = 1L;

	@Override
	public String helloWorld() {
		return "Hello World from Remote!";
	}
	
}