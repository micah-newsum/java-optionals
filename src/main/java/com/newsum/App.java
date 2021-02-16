package com.newsum;

import com.newsum.model.Computer;
import com.newsum.model.Soundcard;
import com.newsum.model.USB;

public class App {
  public static void main(String[] args) {
    Computer c = new Computer();
    String version = getUSBVersion(c);
  }

  // Approach for handling null pointer exceptions without java.util.Optional
  public static String getUSBVersion(Computer computer){
    String version = "UNKNOWN";
    if(computer != null){
      Soundcard soundcard = computer.getSoundcard();
      if(soundcard != null){
        USB usb = soundcard.getUSB();
        if(usb != null){
          version = usb.getVersion();
        }
      }
    }
    return version;
  }
}

