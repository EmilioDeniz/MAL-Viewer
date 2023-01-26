package model;

import api.MangaManager;
import dev.katsute.mal4j.query.MangaSearchQuery;
import java.util.Date;
import java.util.List;

public class MangaSeries implements Series{
    private String name;
    private int rate,popularity;
    private List<String> related;
    private List<String> genres;
    private List<String> authors;
    private List<String> recomendations;
    private Integer chapters;
    private Date release,end;
    private String synopsis;

    public int getPopularity() {
        return popularity;
    }

    public List<String> getRelated() {
        return related;
    }
    @Override
    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public List<String> getRelatedSeries() {
        return related;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getRecomendations() {
        return recomendations;
    }

    public Integer getChapters() {
        return chapters;
    }

    public Date getRelease() {
        return release;
    }

    public Date getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setRelated(List<String> related) {
        this.related = related;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setRecomendations(List<String> recomendations) {
        this.recomendations = recomendations;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
