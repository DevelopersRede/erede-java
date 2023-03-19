package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

public class Device {
    @SerializedName("ColorDepth")
    private int colorDepth;

    @SerializedName("DeviceType3ds")
    private String deviceType3ds;

    @SerializedName("JavaEnabled")
    private Boolean javaEnabled;

    @SerializedName("Language")
    private String language;

    @SerializedName("ScreenHeight")
    private int screenHeight;

    @SerializedName("ScreenWidth")
    private int screenWidth;

    @SerializedName("TimeZoneOffset")
    private int timeZoneOffset;

    public Device(
            int colorDepth,
            String deviceType3ds,
            Boolean javaEnabled,
            int screenHeight,
            int screenWidth
    ) {
        this(colorDepth, deviceType3ds, javaEnabled, "BR", screenHeight, screenWidth, 3);
    }

    public Device(
            int colorDepth,
            String deviceType3ds,
            Boolean javaEnabled,
            String language,
            int screenHeight,
            int screenWidth,
            int timeZoneOffset
    ) {
        this.colorDepth = colorDepth;
        this.deviceType3ds = deviceType3ds;
        this.javaEnabled = javaEnabled;
        this.language = language;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.timeZoneOffset = timeZoneOffset;
    }

    public int getColorDepth() {
        return colorDepth;
    }

    public Device setColorDepth(int colorDepth) {
        this.colorDepth = colorDepth;
        return this;
    }

    public String getDeviceType3ds() {
        return deviceType3ds;
    }

    public Device setDeviceType3ds(String deviceType3ds) {
        this.deviceType3ds = deviceType3ds;
        return this;
    }

    public Boolean getJavaEnabled() {
        return javaEnabled;
    }

    public Device setJavaEnabled(Boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Device setLanguage(String language) {
        this.language = language;
        return this;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public Device setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public Device setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }

    public int getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public Device setTimeZoneOffset(int timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }
}
