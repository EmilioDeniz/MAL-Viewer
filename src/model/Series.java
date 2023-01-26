package model;

import java.util.Date;
import java.util.List;

public interface Series {
    public String getName();
    public int getPopularity();
    public List<String> getRelated();
    public int getRate();
    public List<String> getRelatedSeries();
    public List<String> getGenres();
    public List<String> getRecomendations();
    public Integer getChapters();
    public Date getRelease();
    public Date getEnd();
    public void setRate(int rate);
    public void setRelated(List<String> related);
    public void setGenres(List<String> genres);
    public void setRecomendations(List<String> recomendations);
    public void setChapters(Integer chapters);
    public void setRelease(Date release);
    public void setEnd(Date end);
    public void setPopularity(int popularity);
    public void setSynopsis(String synopsis);
    
}
