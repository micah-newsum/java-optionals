package com.newsum;

import com.newsum.model.Computer;
import com.newsum.model.OptionalComputer;
import com.newsum.model.OptionalSoundcard;
import com.newsum.model.Soundcard;
import com.newsum.model.USB;

import java.util.Optional;

public class App {
  public static void main(String[] args) {

    // Without optionals
    Computer c = new Computer();
    String version = getUSBVersion(c);
    System.out.println(version);

    // With optionals
    Optional<OptionalComputer> maybeComputer = Optional.empty();
    version = getUSBVersionUsingOptionals(maybeComputer);
    System.out.println(version);
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

  // Approach for handling null pointer exceptions without java.util.Optional
  public static String getUSBVersionUsingOptionals(Optional<OptionalComputer> computer){
    return computer.flatMap(OptionalComputer::getSoundcard)
        .flatMap(OptionalSoundcard::getUSB)
        .map(USB::getVersion)
        .orElse("UNKNOWN");
  }
}

