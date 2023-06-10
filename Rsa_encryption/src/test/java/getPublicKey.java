import org.yeonfish.Util.Stopwatch;
import org.yeonfish.Util.logger;
import org.yeonfish.engin.Keygenerator;

public class getPublicKey {
    public static void main(String[] args) {
        final logger log = new logger();

        Keygenerator keygenerator = new Keygenerator();

        Stopwatch stopwatch = new Stopwatch();

        stopwatch.Flag();
        log.info(keygenerator.getPubkey());
        stopwatch.Flag();

        log.info(stopwatch.getDuration(0, 1));
    }
}
