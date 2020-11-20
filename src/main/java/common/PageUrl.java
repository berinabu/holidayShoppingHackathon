package common;

public enum PageUrl {
    V1("https://demo.applitools.com/tlcHackathonMasterV1.html"),
    DEV("https://demo.applitools.com/tlcHackathonDev.html"),
    PRODUCTION("https://demo.applitools.com/tlcHackathonMasterV2.html");

    private final String pageUrl;

    PageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }
}
