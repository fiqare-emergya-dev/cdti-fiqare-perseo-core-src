 
/**
 * Copyright 2015 Telefonica Investigación y Desarrollo, S.A.U
 *
 * This file is part of perseo-core project.
 *
 * perseo-core is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License version 2 as published by the Free Software Foundation.
 *
 * perseo-core is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with perseo-core. If not, see
 * http://www.gnu.org/licenses/.
 *
 * For those usages not covered by the GNU General Public License please contact with
 * iot_support at tid dot es
 */

package com.telefonica.iot.perseo.utils;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;

/**
 * The type Date time utils test.
 */
public class DateTimeUtilsTest extends TestCase {

    public final double LATITUDE = 40.4131699;

    public final double LONGITUDE = -3.6830699;

    public final long DAYTOMILIS = 86400000;

    public final long SECONDTOMILIS = 1000;

    /**
     * Test get next sunrise.
     * Calculates next sunrise and compares it to current date.
     * Is successful if current date is previous than next Sunrise
     */
    public void testGetNextSunrise() {
        System.out.println("getNextSunrise");
        Calendar calendar = Calendar.getInstance();
        Calendar nextSunrise = DateTimeUtils.getNextSunrise(calendar, LATITUDE, LONGITUDE);
        assertTrue(calendar.compareTo(nextSunrise) < 0);
    }

    /**
     * Test get next sunset.
     * Calculates next sunset and compares it to current date.
     * Is successful if current date is previous than next sunset
     */
    public void testGetNextSunset() {
        System.out.println("getNextSunset");
        Calendar calendar = Calendar.getInstance();
        Calendar nextSunset = DateTimeUtils.getNextSunset(calendar, LATITUDE, LONGITUDE);
        assertTrue(calendar.compareTo(nextSunset) < 0);
    }

    /**
     * Test get milis to next sunrise
     * Calculates milliseconds to next sunrise considering current date
     * Is successful if the resoult is less than 24 hrs (86400000 milliseconds)
     */
    public void testGetMilisToNextSunrise() {
        System.out.println("getMilisToNextSunrise");
        Calendar calendar = Calendar.getInstance();
        long nextSunrise = DateTimeUtils.getMilisToNextSunrise(calendar, LATITUDE, LONGITUDE);
        assertTrue(nextSunrise < DAYTOMILIS);
    }

    /**
     * Test get milis to next sunset.
     * Calculates milliseconds to next sunset considering current date
     * Is successful if the resoult is less than 24 hrs (86400000 milliseconds)
     */
    public void testGetMilisToNextSunset() {
        System.out.println("getMilisToNextSunset");
        Calendar calendar = Calendar.getInstance();
        long nextSunset = DateTimeUtils.getMilisToNextSunset(calendar, LATITUDE, LONGITUDE);
        assertTrue(nextSunset < DAYTOMILIS);
    }

    /**
     * Test get milis to next sunrise
     * Calculates milliseconds to next sunrise considering current date
     * Is successful if the resoult is less than 24 hrs (86400000 milliseconds)
     */
    public void testGetSecondsToNextSunrise() {
        System.out.println("getSecondsToNextSunrise");
        Calendar calendar = Calendar.getInstance();
        long nextSunrise = DateTimeUtils.getSecondsToNextSunrise(calendar, LATITUDE, LONGITUDE);
        assertTrue(nextSunrise < (DAYTOMILIS + SECONDTOMILIS));
    }

    /**
     * Test get milis to next sunset.
     * Calculates milliseconds to next sunset considering current date
     * Is successful if the resoult is less than 24 hrs (86400000 milliseconds)
     */
    public void testGetSecondsToNextSunset() {
        System.out.println("getSecondsToNextSunset");
        Calendar calendar = Calendar.getInstance();
        long nextSunset = DateTimeUtils.getSecondsToNextSunset(calendar, LATITUDE, LONGITUDE);
        assertTrue(nextSunset < (DAYTOMILIS + SECONDTOMILIS));
    }

    /**
     * Test date to utc.
     * Converts date 2019-11-11T11:43:01+04:00 into UTC
     * Is successful if the resoult time on UTC is 7
     */
    public void testDateToUTC() {
        System.out.println("dateToUTC");
        String isoDate = "2019-11-11T11:43:01+04:00";
        Calendar dateToUTC = DateTimeUtils.dateToUTC(isoDate);
        assertTrue(dateToUTC.get(Calendar.HOUR_OF_DAY) == 7);
    }

    /**
     * Test time to utc.
     * Converts hour 10 on CET zone time to UTC
     * Is successful if the resoult is 9
     */
    public void testTimeToUTC() {
        System.out.println("timeToUTC");
        int hour = 3;
        String timeZone = "CET";
        int hourUTC = DateTimeUtils.timeToUTC(hour, timeZone);
        assertTrue(hourUTC < hour);
    }
}
