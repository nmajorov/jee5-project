JEE5 example project
====================

Simple JEE5 application web application which call EJB3 components.

this EAR contains AOP trace aspects as example.

tested with jdk1.7 and jboss-5.1.0.GA

JBOSS aop uses load-time weaving and it hast to be enabled on the server.

## How-to enable aop load-time weaver in JBOSS 5 server 

set javaagent property with instrumentation from server:


                  export JAVA_OPTS="-javaagent:$HOME/tools/jboss-5.1.0.GA/server/default/deployers/jboss-aop-jboss5.deployer/pluggable-instrumentor.jar"

edit file:




              server/default/conf/bootstrap/aop.xml


and set  property enableLoadtimeWeaving to true:

                    <property name="enableLoadtimeWeaving">true</property>



restart server then build app with command :



                      mvn clean package



and deploy application by coping it to the deploy directory of the server.


**IMPORTANT:** the application is compiled with jdk1.7 so run the server with same jdk !

