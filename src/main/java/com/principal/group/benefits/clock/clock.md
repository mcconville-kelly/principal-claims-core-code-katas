# Clock Code Kata

## Objective

create a clock that can be instantiated with a given number of hours and minutes that will:
1. display the given time
2. allow for the addition of minutes
3. can be reset
4. can be compared to other clocks

## Stub

```java
package com.principal.group.benefits;

public class Clock {
    
    public void add(int minutes);
    public void reset();
    
}
```

## Test cases

```java
package com.principal.group.benefits;

import com.principal.group.benefits.clock.Clock;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {

    @Test
    public void canPrintTimeWithMinutes() {
        assertThat(new Clock(11, 9).toString()).isEqualTo("11:09");
    }

    @Test
    public void canPrintTimeOnTheHour() {
        assertThat(new Clock(8, 0).toString()).isEqualTo("08:00");
    }

    @Test
    public void clocksWithFullClockAndZeroedClockAreEqual() {
        assertThat(new Clock(24, 0)).isEqualTo(new Clock(0, 0));
    }

    @Test
    public void minutesRollOver() {
        assertThat(new Clock(0, 160).toString()).isEqualTo("02:40");
    }

    @Test
    public void hourRollsOver() {
        assertThat(new Clock(25, 0).toString()).isEqualTo("01:00");
    }

    @Test
    public void sixtyMinutesIsNextHour() {
        assertThat(new Clock(1, 60).toString()).isEqualTo("02:00");
    }

    @Test
    public void clocksWithMinuteOverflow() {
        assertThat(new Clock(0, 1441)).isEqualTo(new Clock(0, 1));
    }

    @Test
    public void clocksWithSameTimeAreEqual() {
        assertThat(new Clock(15, 37)).isEqualTo(new Clock(15, 37));
    }

    @Test
    public void clocksAnHourApartAreNotEqual() {
        assertThat(new Clock(14, 37)).isNotEqualTo(new Clock(15, 37));
    }

    @Test
    public void addNoMinutes() {
        Clock clock = new Clock(6, 41);
        clock.add(0);
        assertThat(clock.toString()).isEqualTo("06:41");
    }

    @Test
    public void addMinutes() {
        Clock clock = new Clock(10, 0);
        clock.add(3);
        assertThat(clock.toString()).isEqualTo("10:03");
    }

    @Test
    public void clocksWithMinuteOverflowBySeveralDays() {
        assertThat(new Clock(2, 4322)).isEqualTo(new Clock(2, 2));
    }

    @Test
    public void negativeMinutes() {
        assertThat(new Clock(1, -40).toString()).isEqualTo("00:20");
    }

    @Test
    public void subtractMoreThanTwoDays() {
        Clock clock = new Clock(2, 20);
        clock.add(-3000);
        assertThat(clock.toString()).isEqualTo("00:20");
    }

    @Test
    public void clocksWithNegativeHourThatWrapsMultipleTimes() {
        assertThat(new Clock(-83, 49)).isEqualTo(new Clock(13, 49));
    }

    @Test
    public void clocksWithNegativeHoursAndMinutesThatWrap() {
        assertThat(new Clock(-54, -11513)).isEqualTo(new Clock(18, 7));
    }
}

```