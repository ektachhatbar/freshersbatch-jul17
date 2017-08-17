package com.corejava.annotations;
import java.util.ArrayList;


public class Notifier {
    private ArrayList<BPListener> listeners = new ArrayList<BPListener>();

  public void addListener(BPListener toAdd) {
      listeners.add(toAdd);
  }
    
  public void bpEvent(int bp) {
  for(BPListener listener : listeners) 
         listener.alertNotification(bp);
  
  }
  
}
