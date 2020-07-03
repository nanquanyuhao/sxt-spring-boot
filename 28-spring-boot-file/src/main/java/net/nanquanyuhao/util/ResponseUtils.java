package net.nanquanyuhao.util;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author liyh1928
 * @date 2018/4/18
 */
public class ResponseUtils {

    private static String IE = "MSIE";
    private static String TRIDENT = "Trident";
    private static String EDGE = "Edge";
    private static String MOZILLA = "Mozilla";

    /**
     * 导出文件名处理
     *
     * @param fileName 原文件名
     * @param agent    request.getHeader("USER-AGENT");
     * @return 处理后的的文件名
     */
    public static String responseFileName(String fileName, String agent) {
        try {
            if (null != agent) {
                if (-1 != agent.indexOf(IE) || -1 != agent.indexOf(TRIDENT) || -1 != agent.indexOf(EDGE)) {
                    // ie
                    fileName = URLEncoder.encode(fileName, "UTF-8");
                } else if (-1 != agent.indexOf(MOZILLA)) {
                    // 火狐,chrome等
                    fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
                }
            }
        } catch (IOException e) {

        }
        return fileName;
    }

}
