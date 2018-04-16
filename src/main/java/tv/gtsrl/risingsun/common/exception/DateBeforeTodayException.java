package tv.gtsrl.risingsun.common.exception;

public class DateBeforeTodayException extends RuntimeException {

    public DateBeforeTodayException() {
        super("Please inform a date after today.");
    }
}
