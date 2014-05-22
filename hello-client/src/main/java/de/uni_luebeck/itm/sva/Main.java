package de.uni_luebeck.itm.sva;

import javax.naming.NamingException;

import de.dennis_boldt.Hello;
import de.dennis_boldt.HelloJndi;

public class Main {
	public static void main(String[] args) throws NamingException {
		Hello hello = HelloJndi.getHello();
		System.out.println(hello.helloWorld());
	}

}
