package ua.igorbendera.enumeration;

public enum Months {
    JANUARY(31, Seasons.WINTER),
    FEBRUARY(28, Seasons.WINTER),
    MARCH(31, Seasons.SPRING),
    APRIL(30, Seasons.SPRING),
    MAY(31, Seasons.SPRING),
    JUNE(30, Seasons.SUMMER),
    JULY(31, Seasons.SUMMER),
    AUGUST(31, Seasons.SUMMER),
    SEPTEMBER(30, Seasons.FALL),
    OCTOBER(31, Seasons.FALL),
    NOVEMBER(30, Seasons.FALL),
    DECEMBER(31, Seasons.WINTER);

    int day;
    Seasons seasons;

    Months(int day, Seasons seasons) {
        this.day = day;
        this.seasons = seasons;
    }

    public int getDay() {
        return day;
    }

    public Seasons getSeasons() {
        return seasons;
    }
}
