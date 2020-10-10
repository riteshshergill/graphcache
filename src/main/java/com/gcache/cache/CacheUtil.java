package com.gcache.cache;

import com.gcache.graph.GraphInstance;
import com.gcache.graph.model.DataWeighedEdge;
import com.gcache.graph.model.Node;
import com.github.benmanes.caffeine.cache.Cache;
import org.checkerframework.checker.nullness.qual.NonNull;

public class CacheUtil {

    @NonNull private static Cache<String, Object> cacheInstance;

    public void initCacheDefault(Long maxRecords, Integer expireAfterWriteInMinutes, Integer expireAfterAccessInMinutes) {
        cacheInstance = CacheInitializer.defaultInitialize(maxRecords, expireAfterWriteInMinutes, expireAfterAccessInMinutes);
    }

    public synchronized void clearCache() {
        cacheInstance.cleanUp();
    }

    public synchronized void removeKey(String key) {
        cacheInstance.invalidate(key);
    }

    public synchronized void cacheGraph(String key, GraphInstance graph) {
        cacheInstance.put(key, graph);
    }

    public synchronized void cacheNode(String key, Node node) {
        cacheInstance.put(key, node);
    }

    public synchronized void cacheEdge(String key, DataWeighedEdge edge) {
        cacheInstance.put(key, edge);
    }

    public Object getObject(String key) {
        return cacheInstance.getIfPresent(key);
    }
}
