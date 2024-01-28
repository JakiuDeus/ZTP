package me.ztpteam.planning;

public enum DayNumberMap {

    MONDAY(1, "PON"),
    TUESDAY(2, "WT"),
    WEDNESDAY(3, "ŚR"),
    THURSDAY(4, "CZW"),
    FRIDAY(5, "PT"),
    SATURDAY(6, "SOB"),
    SUNDAY(7, "ND");

    final int value;
    final String shortForm;
    DayNumberMap(int value, String shortForm) {
        this.value = value;
        this.shortForm = shortForm;
    }

    public String getShortForm(int index) {
        for (DayNumberMap day : values()) {
            if (value == index) {
                return day.shortForm;
            }
        }
        return null;
    }
}
