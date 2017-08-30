package com.yexj.yougo.jdbc.datasource;

/**
 * 数据源上下文
 * Created by xinjian.ye on 2017/8/29.
 */
public class DataSourceContextHolder {
    private static final String MASTER = "master";
    private static final String SLAVE = "slave";
    private static final ThreadLocal<String> dataSources = new ThreadLocal();

    public DataSourceContextHolder() {
    }

    private static void setDataSource(String dataSourceKey) {
        dataSources.set(dataSourceKey);
    }

    private static String getDataSource() {
        return (String)dataSources.get();
    }

    protected static void setMaster() {
        setDataSource("master");
    }

    protected static void setSlave() {
        setDataSource("slave");
    }

    protected static boolean isMaster() {
        return "master".equals(getDataSource());
    }

    protected static boolean isSlave() {
        return "slave".equals(getDataSource());
    }

    protected static boolean haveValue() {
        return dataSources.get() != null;
    }

    protected static void clearDataSource() {
        dataSources.remove();
    }
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
//
//    public static void setDbType(String dbType) {
//        contextHolder.set(dbType);
//    }
//
//    public static String getDbType() {
//        return ((String) contextHolder.get());
//    }
//
//    public static void clearDbType() {
//        contextHolder.remove();
//    }
}
