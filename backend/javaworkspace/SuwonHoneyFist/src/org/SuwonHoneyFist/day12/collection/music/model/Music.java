package org.SuwonHoneyFist.day12.collection.music.model;

public class Music {
    private String title;
    private String singer;

    public Music(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    @Override
    public String toString() {
    	return "Music [title=" + title + ", somger=" + singer + "]";
    }
    
    @Override
    public int compareTo(Music o ) {
    	return this.title.compareTo(o.getTitle());  // 1, 0, -1
    }
}
