package tv.gtsrl.risingsun.common.exception;

public class RaceResultsFastestLapRegisteredException extends RuntimeException {

    public RaceResultsFastestLapRegisteredException() {
        super("It's not possible to remove. There are either Race Results or a Fastest Lap registered to this race.");
    }
}
