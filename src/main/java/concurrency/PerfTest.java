package concurrency;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import com.qb.ad.entity.DataTest;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.qb.ad.util.ApiUtilsTest.click;
import static com.qb.ad.util.ApiUtilsTest.exposure;

public class PerfTest {
    static String private_key ="MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQg0m/PkbvEdLbCnc/O/lMkSUa+I0TP0y43m5q7mGOKH2CgCgYIKoZIzj0DAQehRANCAAR8cDO9A9U3zgEJgXfScJGnHv42xjq+lHbAG6w96/2v842JhEkhFyrkYy7sRSJG2V/WIlOc2V2mtw37gQxvh2Yt";
    static String partnerId = "2011022896";
    static String parkId = "010202007177068";
    static String adPosId = "5";
    static String adId ="";
    static String mediumType = "1";//媒体类型：1:微信公众号 2:微信小程序 3:app 默认获取微信公众号
    static String url= DataTest.click_url;
    @Test
    public static void open_click_perf() throws Exception {

        try {
                adId = exposure(parkId , partnerId ,private_key,adPosId,mediumType);
                    click( url,adId ,parkId , partnerId ,private_key);
        }catch (NullPointerException e){
            System.out.println("曝光失败，空指针异常！" );
        }catch (UnknownHostException e){
            System.out.println("曝光失败，域名无法访问！" );
        }

    }

    @JunitPerfConfig(threads = 10, warmUp = 0_500, duration = 10_000
            , reporter = {HtmlReporter.class, ConsoleReporter.class})
    public void newStrTestStringBuilder() throws Exception {
        open_click_perf();
    }
}