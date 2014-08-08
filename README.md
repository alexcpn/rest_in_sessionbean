rest_in_sessionbean
===================

Session Bean in ejb jar exposing a REST interface; tested with JBOSS 7

This is a simple test project showing how to expose a Stateless Session Bean  through REST interface; 
This is tested only with JBOSS 7 (jboss-as-7.1.1.Final)

Note that for this along with the Session Bean a War file is needed with a web.xml (no other source or servlet necessarry) which does the 
mapping for REST easy;

Here is the output

-----------------------------------

http://localhost:8080/Mroservlet/rest/sessionbean/getciofordn?dn=werwerwe
10000
http://localhost:8080/Mroservlet/rest/sessionbean/test
Hello from Mro SessionBean Jar
----------------------------------
http://localhost:8080/Mroservlet/rest/servlet/getciofordn?dn=%22dsd%22
10000 "dsd"

http://localhost:8080/Mroservlet/rest/servlet/service1
Hello Form Mro War Packaged Session Bean
--------------------------------------


The REstFacade.java  class is not needed; Basically the web.xml is only needed

<context-param>
		<param-name>resteasy.scan</param-name>
		<param-value>true</param-value>
	</context-param>

		<listener>
		<listener-class>org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap</listener-class>
	</listener>
	<servlet>
		<servlet-name>RESTEasy</servlet-name>
		<servlet-class>org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher</servlet-class>
	</servlet>
	
	<context-param>
		<param-name>resteasy.servlet.mapping.prefix</param-name>
		<param-value>/rest</param-value>
	</context-param>
	
	<servlet-mapping>
		<servlet-name>RESTEasy</servlet-name>
		<url-pattern>/rest/*</url-pattern>
	</servlet-mapping>

