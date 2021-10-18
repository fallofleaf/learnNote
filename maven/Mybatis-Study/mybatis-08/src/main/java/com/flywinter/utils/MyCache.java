package com.flywinter.utils;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 20:17
 * Description: 可以自定义cache
 */
public class MyCache implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return Cache.super.getReadWriteLock();
    }
}
