package com.principal.group.benefits.clock;

import org.junit.Assert;
import org.junit.Test;

public class ClockTest {

    @Test
    public void canPrintTimeWithMinutes() {
        Assert.assertEquals("11:19", new Clock(11, 19).toString());
    }

    @Test
    public void canPrintTimeOnTheHour() {
        Assert.assertEquals("08:00", new Clock(8, 0).toString());
    }

    @Test
    public void clocksWithFullClockAndZeroedClockAreEqual() {
        Assert.assertEquals("00:00", new Clock(24, 0).toString());
    }

    @Test
    public void minutesRollOver() {
        Assert.assertEquals("02:40", new Clock(0, 160).toString());
    }

    @Test
    public void hourRollsOver() {
        Assert.assertEquals("01:00", new Clock(25, 0).toString());
    }

    @Test
    public void sixtyMinutesIsNextHour() {
        Assert.assertEquals("02:00", new Clock(1, 60).toString());
    }

    @Test
    public void clocksWithSameTimeAreEqual() {
        Assert.assertEquals(new Clock(15, 37), new Clock(15, 37));
    }

    @Test
    public void clocksAnHourApartAreNotEqual() {
        Assert.assertNotEquals(new Clock(14, 37), new Clock(15, 37));
    }

    @Test
    public void clocksWithMinuteOverflow() {
        Assert.assertEquals(new Clock(0, 1), new Clock(0, 1441));
    }
    
    @Test
    public void clocksWithMinuteOverflowBySeveralDays() {
        Assert.assertEquals(new Clock(2, 4322), new Clock(2, 2));
    }
    
    @Test
    public void addNoMinutes() {
        Clock clock = new Clock(6, 41);
        clock.add(0);
        Assert.assertEquals("06:41", clock.toString());
    }

    @Test
    public void addMinutes() {
        Clock clock = new Clock(10, 0);
        clock.add(3);
        Assert.assertEquals("10:03", clock.toString());
    }

    @Test
    public void negativeMinutes() {
        Assert.assertEquals("00:20", new Clock(1, -40).toString());
    }
    
    @Test
    public void subtractMinutes() {
        Clock clock = new Clock(7, 30);
        clock.add(-10);
        Assert.assertEquals("07:20", clock.toString());
    }

    @Test
    public void subtractMinutesLastHour() {
        Clock clock = new Clock(7, 30);
        clock.add(-40);
        Assert.assertEquals("06:50", clock.toString());
    }

    @Test
    public void subtractMoreThanTwoDays() {
        Clock clock = new Clock(2, 20);
        clock.add(-3000);
        Assert.assertEquals("00:20", clock.toString());
    }

    @Test
    public void clocksWithNegativeHourThatWrapsMultipleTimes() {
        Assert.assertEquals(new Clock(-83, 49), new Clock(13, 49));
    }

    @Test
    public void clocksWithNegativeHoursAndMinutesThatWrap() {
        Assert.assertEquals(new Clock(-54, -11513), new Clock(18, 7));
    }
}