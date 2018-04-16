package tv.gtsrl.risingsun.common.exception;

public class RaceQualifyingResultRegisteredException extends RuntimeException {

    public RaceQualifyingResultRegisteredException() {
        super("It's not possible to remove. There are either Races or Qualifying Results registered to this day.");
    }
}
