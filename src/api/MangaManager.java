package api;

import dev.katsute.mal4j.MyAnimeList;
import dev.katsute.mal4j.manga.Manga;
import dev.katsute.mal4j.manga.MangaRecommendation;
import dev.katsute.mal4j.manga.RelatedManga;
import dev.katsute.mal4j.manga.property.Author;
import dev.katsute.mal4j.property.AlternativeTitles;
import dev.katsute.mal4j.property.Genre;
import dev.katsute.mal4j.query.MangaSearchQuery;
import java.util.ArrayList;
import java.util.List;
import model.MangaSeries;

import model.Series;

public class MangaManager implements Manager{
    private MyAnimeList mal;
    
    public MangaManager(MyAnimeList mal){
        this.mal = mal;
    }

    @Override
    //Factory Method
    public MangaSeries Search(String name) {
        List<Manga> mangas = mal.getManga().withQuery(name).withLimit(1).includeNSFW(true).search();
        MangaSeries mangaSeries = new MangaSeries();
        for (Manga manga: mangas){
            AlternativeTitles altNames = manga.getAlternativeTitles();
            if (altNames.getEnglish().equals(name)){
                mangaSeries.setName(altNames.getEnglish());
                mangaSeries.setAuthors(getAuthorsAsList(manga.getAuthors()));
                mangaSeries.setGenres(getGenresAsList(manga.getGenres()));
                mangaSeries.setChapters(manga.getChapters());
                mangaSeries.setRate(manga.getRank());
                mangaSeries.setRelease(manga.getStartDate().getDate());
                mangaSeries.setEnd(manga.getEndDate().getDate());
                mangaSeries.setRelated(getRelatedAsList(manga.getRelatedManga()));
                mangaSeries.setRecomendations(getRecomendedasList(manga.getRecommendations()));
                mangaSeries.setPopularity(manga.getPopularity());
                mangaSeries.setSynopsis(manga.getSynopsis());
                break;
            }
        }
        return mangaSeries;
    }
    
    private List<String> getAuthorsAsList(Author[] authors){
        List<String> lista = new ArrayList<String>();
        
        for(Author a: authors){
            lista.add(""+a.getFirstName()+" "+a.getLastName()+" Role: "+a.getRole());
        }
        
        return lista;
    }

    private List<String> getGenresAsList(Genre[] genres) {
        List<String> lista = new ArrayList<String>();
        
        for(Genre g: genres){
            lista.add(g.getName());
        }
        
        return lista;
    }

    private List<String> getRelatedAsList(RelatedManga[] relatedManga) {
        List<String> lista = new ArrayList<String>();
        for (RelatedManga rm: relatedManga) {
            lista.add(rm.getRawRelationType());
        }
        return lista;
    }

    private List<String> getRecomendedasList(MangaRecommendation[] recommendations) {
        List<String> lista = new ArrayList<String>();
        for (MangaRecommendation recommendation : recommendations) {
            lista.add(recommendation.toString());
        }
        return lista;
    }
}
