package de.uni_luebeck.itm.sva;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.dennis_boldt.Hello;

public class Main {
	public static void main(String[] args) throws NamingException {
		final Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		InitialContext context = new InitialContext(jndiProperties);
		Hello hello = (Hello) context.lookup("hello-remote/HelloImplRemote!de.dennis_boldt.Hello");
		System.out.println(hello.helloWorld());
	}

}
