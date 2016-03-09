package biz.majorov.j2ee;


import java.io.Serializable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import biz.majorov.jee.SphereBean;


@Name("CalculateAction")
@Scope(ScopeType.CONVERSATION)
public class CalculateAction implements Serializable {


 private static final long serialVersionUID = 4230398381571469339L;

  @Logger
  private Log log;

  private int radius = 10;

  private Double volume;

  private SphereBean sphereBean;

  public void setRadius(int r){
    this.radius = r;
  }

  public int getRadius(){
    return this.radius;
  }


  public CalculateAction(){};

  @Create
  public void create() {
      try {
        Context context = new InitialContext();
        sphereBean = (SphereBean) context.lookup("app-ear-1.0-SNAPSHOT/SphereBeanImpl/local");

    } catch (NamingException e) {
        throw new RuntimeException("error at  action initializing ",e);
    }

  }

  public void calculate(){
    log.info("calculate with radius: " + radius);
    this.volume = sphereBean.computeVolume(this.radius);
  }

  public String getResult(){
    if (this.volume == null){
      return "";
    }

    return "Calculated volume is: " +  this.volume;
  }
}
