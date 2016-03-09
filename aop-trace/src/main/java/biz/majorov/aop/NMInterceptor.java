package biz.majorov.aop;

import org.jboss.aop.advice.Interceptor;
import org.jboss.aop.joinpoint.Invocation;


public class NMInterceptor implements Interceptor {


   public Object invoke(Invocation invocation) throws Throwable{

     System.out.println("%%%%%%%%%%%%%%%% invoked : " + invocation.getTargetObject());

      return invocation.invokeNext();
   }

   public String  getName(){
         return NMInterceptor.class.getName();
   }

}
