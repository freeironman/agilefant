package fi.hut.soberit.agilefant.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExactEstimateUtilsTest {

    @Test
    public void testValidHours() {
        assertEquals(60, ExactEstimateUtils.convertFromString("1h")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidHoursWithWhitespace() {
        assertEquals(60, ExactEstimateUtils.convertFromString("  1h   ")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidHoursWithDecimalsAsComma() {
        assertEquals(90, ExactEstimateUtils.convertFromString("1,5h")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidHoursWithDecimalsAsPeriod() {
        assertEquals(90, ExactEstimateUtils.convertFromString("1.5h")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidMinutes() {
        assertEquals(15, ExactEstimateUtils.convertFromString("15min")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidHoursAndMinutes() {
        assertEquals(105, ExactEstimateUtils.convertFromString("1.5h15min")
                .getMinorUnits().longValue());
    }

    @Test
    public void testValidHoursAndMinutesWithWhitespace() {
        assertEquals(105, ExactEstimateUtils.convertFromString(
                "   1.5h   15min        ").getMinorUnits().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithoutUnit() {
        ExactEstimateUtils.convertFromString("1").getMinorUnits();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithoutMinuteUnit() {
        ExactEstimateUtils.convertFromString("1h 15").getMinorUnits();
    }

}
