package com.gcache.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Utility class to initialize a default instance of a Caffeine cache with max size, expire after write or
 * expire after access params or create your own instance
 */
public class CacheInitializer {

    private static Logger log = LoggerFactory.getLogger(CacheInitializer.class);

    /**
     * Create a default instance with max size, expireAfterWrite or expireAfterAccess properties
     * @param maxRecords Maximum records the cache will store before eviction
     * @param expireAfterWriteInMinutes Max time in minutes after a write before a record is invalidated
     * @param expireAfterAccessInMinutes Max time in minutes after a record is accessed before it is invalidated
     * @return Default instance of Caffeine cache
     */
    public static Cache defaultInitialize(Long maxRecords, Integer expireAfterWriteInMinutes, Integer expireAfterAccessInMinutes) {

        Caffeine cafInst = Caffeine.newBuilder();

        cafInst = maxRecords != null ? cafInst.maximumSize(maxRecords) : expireAfterWriteInMinutes != null ?
                cafInst.expireAfterWrite(expireAfterWriteInMinutes, TimeUnit.MINUTES) : expireAfterAccessInMinutes != null ?
                cafInst.expireAfterAccess(expireAfterAccessInMinutes, TimeUnit.MINUTES) : cafInst;

        log.info("Cache instance created with default params");

        return cafInst.build();
    }

    /**
     * Get a customizable Caffeine instance
     * @return Caffeine instance that is customizable
     */
    public static Caffeine createSelfCustomizableInstance() {
        return Caffeine.newBuilder();
    }
}
