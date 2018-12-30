/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonehandler;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nSense
 */
public class ZoneHandler {

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
     
    public static void main(String[] args) {
        
        String dateInString = "12-12-2018 08:11:10 PM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId sourceZoneId = ZoneId.of("Asia/Kolkata");

        ZonedDateTime asiaZonedDateTime = ldt.atZone(sourceZoneId);

        ZoneId destinationZoneId = ZoneId.of("America/New_York");
        ZonedDateTime nyDateTime = asiaZonedDateTime.withZoneSameInstant(destinationZoneId);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        System.out.println("Source Time Zone : " + format.format(asiaZonedDateTime));
        System.out.println("Destination Time Zone " + format.format(nyDateTime));

    }   
}
