package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory that reuses TextStyle instances.
 */
public class TextStyleFactory {
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    public TextStyle get(String font, int size, boolean bold) {
        String key = font + "|" + size + (bold ? "|B" : "|N");
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
    public int cachedCount() {
        return cache.size();
    }
}