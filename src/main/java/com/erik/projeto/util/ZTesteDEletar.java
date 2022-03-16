package com.erik.projeto.util;
import java.util.Date;

import org.joda.time.Duration;


public class ZTesteDEletar {

    public static void main(String[] args) {
        Duration duration = new Duration(60000); // 60000 milliseconds = 60 seconds = 1 minute

        System.out.println( duration.getMillis() );
        
        Duration novaDuracao = duration.plus(60000);
        
        System.out.println( novaDuracao.getMillis() );
        
        
        System.out.println( new Date() );
    }
}
