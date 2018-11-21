package lab.nice.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:sss.SSS";

    /**
     * Convert time string in format "yyyy-MM-dd HH:mm:sss.SSS" to epoch milliseconds
     *
     * @param time       the time string to convert
     * @param timezoneId the timezone of the time
     * @return {@link Long} epoch milliseconds
     */
    public static Long toEpochMilli(String time, String timezoneId) {
        return toEpochMilli(DEFAULT_FORMAT, time, timezoneId);
    }

    /**
     * Convert time string to epoch milliseconds
     *
     * @param format     the time format, such as "yyyy-MM-dd HH:mm:sss.SSS".
     * @param time       the time string to convert
     * @param timezoneId the timezone of the time
     * @return {@link Long} epoch milliseconds
     */
    public static Long toEpochMilli(String format, String time, String timezoneId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, formatter).atZone(ZoneId.of(timezoneId)).toInstant().toEpochMilli();
    }

    /**
     * Convert epoch milliseconds to ZonedDateTime
     *
     * @param epochMilli       the epoch milliseconds to convert
     * @param targetTimezoneId the target timezone
     * @return {@link ZonedDateTime} ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Long epochMilli, String targetTimezoneId) {
        return Instant.ofEpochMilli(epochMilli).atZone(ZoneId.of(targetTimezoneId));
    }
}
