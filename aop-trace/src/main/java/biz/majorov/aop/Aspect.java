package biz.majorov.aop;

import org.jboss.aop.joinpoint.ConstructorInvocation;
import org.jboss.aop.joinpoint.FieldInvocation;
import org.jboss.aop.joinpoint.FieldReadInvocation;
import org.jboss.aop.joinpoint.FieldWriteInvocation;
import org.jboss.aop.joinpoint.MethodInvocation;

public class Aspect {

    public Object trace(MethodInvocation invocation) throws Throwable {
        try {
           System.out.println("############### Entering method: " + invocation.getMethod());
           return invocation.invokeNext(); // proceed to next advice or actual call
        } finally {
           System.out.println("############# Leaving method: " + invocation.getMethod());
        }
     }
    public Object trace(FieldWriteInvocation invocation) throws Throwable {
        
           System.out.println("############### write to  field: " +  invocation.getField().getName()
                 + "  generic str: " +  invocation.getField().toGenericString()           
                 );
           return invocation.invokeNext(); // proceed to next advice or actual call
        
     }
    
    public Object trace(FieldReadInvocation invocation) throws Throwable {
        
        System.out.println("############### read field: " +  invocation.getField().getName());
        return invocation.invokeNext(); // proceed to next advice or actual call
     
  }
    
     public Object trace(ConstructorInvocation invocation) throws Throwable {
        try {
           System.out.println("############## Entering constructor: " + invocation.getConstructor());
           return invocation.invokeNext(); // proceed to next advice or actual call
        } finally {
           System.out.println("##############Leaving constructor: " + invocation.getConstructor());
        }
     }
}
