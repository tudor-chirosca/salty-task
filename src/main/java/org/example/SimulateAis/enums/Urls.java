package org.example.SimulateAis.enums;

import org.apache.logging.log4j.LogManager;

public enum Urls {
    API_BASE_URL("api.base.url"),
    DEBUG_BASE_URL("debug.base.url"),
    UI_BASE_URL("ui.base.url");

    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        LogManager.getLogger().info("Retrieving the endpoint: {}", url);
        return url;
    }
}
