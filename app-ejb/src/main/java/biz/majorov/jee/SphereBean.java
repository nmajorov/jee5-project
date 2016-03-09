package biz.majorov.jee;

import javax.ejb.Local;

@Local
public interface SphereBean {

  public String getUnit() ;

  public void setUnit(String unit) ;

  public int getCount() ;

  public void setCount(int count) ;

  public double computeVolume(double radius) ;

}
