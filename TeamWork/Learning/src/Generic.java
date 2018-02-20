import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 * Created by cchandragiri on 5/5/2017.
 */
public class Generic {

    static Logger log = Logger.getLogger(Generic.class);

    public String user_input() throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String symbols = br.readLine();
        log.info("User Entered as :- " + symbols);
        return symbols;
    }




}
