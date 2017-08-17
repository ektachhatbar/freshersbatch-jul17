package com.corejava.annotations;

import java.util.concurrent.ThreadLocalRandom; 

public class HospitalTest {
	public static void main(String[] args) throws InterruptedException {
	     
        Hospital h = new Hospital();
        
        
        
        for( ; ; ) {
             int bp = ThreadLocalRandom.current().nextInt(100,150);
             h.updateBloodPressure(bp);
             System.out.println(bp);
             Thread.sleep(3000);
        }

  }

}
