package hyc.upload.dataupload.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceContextHolder {
    private static Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    public static void read() {
        logger.debug("切换至[读]数据源");
        local.set(DataSourceType.READ.getType());
    }

    public static void write() {
        logger.debug("切换至[写]数据源");
        local.set(DataSourceType.WRITE.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }

}
