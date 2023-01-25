package model;

import java.util.List;

public interface Series {
    public String getName();
    public Double getRate();
    public List<Series> getRelatedSeries();
    public List<String> getGenres();
    public List<String> getComments();
}
