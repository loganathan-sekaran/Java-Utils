package org.vishag.javautils.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import org.vishag.javautils.log.Logger;
import org.vishag.javautils.optional.RunnableWithThrowable;
import org.vishag.javautils.optional.SupplierWithThrowable;
import org.vishag.javautils.tuples.Tuple;
import org.vishag.javautils.tuples.Tuple2;

public final class DateTimeUtil {
	
    public static Logger logger = Logger.defaultSysOutErrLogger();

    public static final String ISO_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final  DateFormat ISO_DATE_TIME_FORMAT = new SimpleDateFormat(ISO_DATE_TIME_FORMAT_PATTERN);
    public static final String DATE_TIME_PATTERN_FOR_FILE_NAME = "yyyyMMdd_HHmmss";
    private static final SimpleDateFormat DATE_FORMAT_FOR_FILE_NAME = new SimpleDateFormat(DATE_TIME_PATTERN_FOR_FILE_NAME);

    private DateTimeUtil(){}

    public static <R, E extends Exception> Tuple2<R, Long> timed(SupplierWithThrowable<R, E> supplier) throws E {
        long startTime = System.currentTimeMillis();
        R result = supplier.get();
        return Tuple.of(result, (System.currentTimeMillis() - startTime));
    }

    public static <E extends  Exception> Long timed(RunnableWithThrowable<E> runnable) throws E{
        long startTime = System.currentTimeMillis();
        runnable.run();
        return (System.currentTimeMillis() - startTime);
    }

    public static <R, E extends Exception> R timeLogged(Function<Long, String> durationBasedMessage, SupplierWithThrowable<R, E> supplier) throws E {
        Tuple2<R, Long> timed = timed(supplier);
        logger.debug(durationBasedMessage.apply(timed.get2()));
        return timed.get1();
    }

    public static <E extends  Exception> void timeLogged(Function<Long, String> durationBasedMessage, RunnableWithThrowable<E> runnable) throws E {
        Long duration = timed(runnable);
        logger.debug( durationBasedMessage.apply(duration));
    }

    public static String getCurrentDateTimeString() {
        return getDateTimeString(new Date());
    }

    public static String getDateTimeString(Date dateTime) {
        return ISO_DATE_TIME_FORMAT.format(dateTime);
    }

    public static Date parseIsoDateTimeString(String isoDateTimeString) throws ParseException {
        return ISO_DATE_TIME_FORMAT.parse(isoDateTimeString);
    }

    public static String getCurrentDateTimeStrForFileName() {
        Date now = new Date();
        // Format the date-time as a string
        return DATE_FORMAT_FOR_FILE_NAME.format(now);
    }

}
