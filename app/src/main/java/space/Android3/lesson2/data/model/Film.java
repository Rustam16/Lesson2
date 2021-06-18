package space.Android3.lesson2.data.model;

import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("running_time")
    private String runningTime;
    @SerializedName("rt_score")
    private String rtScore;

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runningTime='" + runningTime + '\'' +
                ", rtScore='" + rtScore + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }
}
