package com.yexj.yougo.jdbc.datasource;


import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Created by xinjian.ye on 2017/8/29.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    private AtomicInteger counter = new AtomicInteger();
    private DataSource master;
    private List<DataSource> slaves;
    @Override
    public Logger getParentLogger() {
        return null;
    }

//    @Override
//    protected Object determineCurrentLookupKey() {
//        return DataSourceContextHolder. getDbType();
//    }
public DynamicDataSource() {
}

    protected Object determineCurrentLookupKey() {
        return null;
    }

    public void afterPropertiesSet() {
    }

    protected DataSource determineTargetDataSource() {
        DataSource returnDataSource = null;
        if(DataSourceContextHolder.isMaster()) {
            returnDataSource = this.master;
        } else if(DataSourceContextHolder.isSlave()) {
            int count = this.counter.incrementAndGet();
            if(count > 1000000) {
                this.counter.set(0);
            }

            int n = this.slaves.size();
            int index = count % n;
            returnDataSource = (DataSource)this.slaves.get(index);
            this.log.info("No.{} slave datasource have been chose", Integer.valueOf(index));
        } else {
            returnDataSource = this.master;
            this.log.info("Master datasource have been chose by default");
        }

        if(returnDataSource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
            org.apache.tomcat.jdbc.pool.DataSource source = (org.apache.tomcat.jdbc.pool.DataSource)returnDataSource;
            String jdbcUrl = source.getUrl();
            this.log.info("JdbcUrl:{}", jdbcUrl);
        }

        return returnDataSource;
    }

    public DataSource getMaster() {
        return this.master;
    }

    public void setMaster(DataSource master) {
        this.master = master;
    }

    public List<DataSource> getSlaves() {
        return this.slaves;
    }

    public void setSlaves(List<DataSource> slaves) {
        this.slaves = slaves;
    }
}
