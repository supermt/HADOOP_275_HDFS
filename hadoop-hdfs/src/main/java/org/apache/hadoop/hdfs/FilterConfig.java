package org.apache.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DFSConfigKeys.FILTER_ENHANCER_RETURN;

public class FilterConfig
{
    private static String enhancer_host;
    private static String enhancer_port;
    private static boolean enhanced;
    private static FILTER_ENHANCER_RETURN filter_enhancer_return;

    public static void init(Configuration conf)
    {
        enhanced = conf.getBoolean(DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCED_OR_NOT,
                DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCED_OR_NOT_DEFAULT);
        if (enhanced) {
            String enhancerLocation = conf.get(DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCER_LOCATION,
                    DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCER_LOCATION_DEFAULT);
            enhancer_host = enhancerLocation.split(":")[0];
            enhancer_port = enhancerLocation.split(":")[1];
            filter_enhancer_return = conf.getEnum(DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCED_RETURN,
                    DFSConfigKeys.DFS_CLIENT_FILTER_ENHANCED_RETURN_DEFAULT);
        }
    }

    public static String getEnhancerHost()
    {
        return enhancer_host;
    }

    public static String getEnhancerPort()
    {
        return enhancer_port;
    }

    public static boolean isEnhanced()
    {
        return enhanced;
    }

    public static FILTER_ENHANCER_RETURN getFilter_enhancer_return()
    {
        return filter_enhancer_return;
    }
}
