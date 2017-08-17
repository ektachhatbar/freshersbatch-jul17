package com.corejava.annotations;

public class Hospital {
	private int bloodPressure;
    
    public void updateBloodPressure(int bp) 
    {
          this.bloodPressure = bp;
          Notifier notifier = new Notifier();
          notifier.addListener(new Person());
          notifier.addListener(new Person());
          notifier.addListener(new Person());
          
          if(bloodPressure >= 140) {
                          
               notifier.bpEvent(bloodPressure);

          }

}
}