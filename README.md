### Setup

```
wget http://download.jboss.org/wildfly/8.0.0.Final/wildfly-8.0.0.Final.zip
unzip wildfly-8.0.0.Final.zip
wget https://github.com/boldt/wildfly8-helloworld-war/raw/master/hello-remote.war
wget https://github.com/boldt/wildfly8-helloworld-war/raw/master/hello.war
mv *.war wildfly-8.0.0.Final/standalone/deployments/
./wildfly-8.0.0.Final/bin/add-user.sh (Application User test with Password test)
```

### Run

```
./wildfly-8.0.0.Final/bin/standalone.sh
```

### Test

Open: 

  http://localhost:8080/hello/world 

Yields to the exception:

  `javax.servlet.ServletException: UT010013: Could not instantiate de.dennis_boldt.HelloServlet`

Redeploy: 

  `touch wildfly-8.0.0.Final/standalone/deployments/hello.war.dodeploy`

Open:

  http://localhost:8080/hello/world 

works well (with a warning).
