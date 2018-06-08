package de.bithackaton.model;

/**
 * bITHackaton2018
 * Author: tsteidle
 * Created: 08.06.18
 */
public class Navigation {
    private final long id;
    private final String content;

    public Navigation(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
