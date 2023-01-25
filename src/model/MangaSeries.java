package model;

import api.MangaManager;
import dev.katsute.mal4j.manga.property.Author;
import dev.katsute.mal4j.query.MangaSearchQuery;
import java.util.List;

public class MangaSeries implements Series{
    private String name;
    private Double rate;
    private List<Series> related;
    private List<String> genres;
    private List<String> comments;
    private Author[] authors;
    private List<String> recomendations;
    
    public MangaSeries() {
        
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRate() {
        return this.rate;
    }

    @Override
    public List<Series> getRelatedSeries() {
        return this.related;
    }

    @Override
    public List<String> getGenres() {
        return this.genres;
    }

    @Override
    public List<String> getComments() {
        return this.comments;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setAuthor(Author[] authors) {
        this.authors = authors;
    }
}
