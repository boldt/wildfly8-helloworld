package de.dennis_boldt;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloJndi {
	
	public static InitialContext context = null;
	public static Hello hello = null;
	
	public static void getJndi() throws NamingException {
		final Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "test");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		context = new InitialContext(jndiProperties);
	}
	
	public static Hello getHello() throws NamingException {
		if(context == null) getJndi();
		if(hello != null) return hello;
		return (Hello) context.lookup("hello-remote/HelloImplRemote!de.dennis_boldt.Hello");
	}
	
}
