package com.corejava.annotations;

class Person implements BPListener{
    public void alertNotification(int bp) {
          System.out.println("ALERT! BP at "+bp);
    }	
}
