package api;

import dev.katsute.mal4j.MyAnimeList;
import dev.katsute.mal4j.anime.Anime;
import dev.katsute.mal4j.anime.AnimeRecommendation;
import dev.katsute.mal4j.anime.RelatedAnime;
import dev.katsute.mal4j.anime.property.Studio;
import dev.katsute.mal4j.manga.MangaRecommendation;
import dev.katsute.mal4j.manga.RelatedManga;
import dev.katsute.mal4j.manga.property.Author;
import dev.katsute.mal4j.property.AlternativeTitles;
import dev.katsute.mal4j.property.Genre;
import java.util.ArrayList;
import java.util.List;
import model.AnimeSeries;
import model.Series;

public class AnimeManager implements Manager {

    private MyAnimeList mal;

    public AnimeManager(MyAnimeList mal) {
        this.mal = mal;
    }

    @Override
    public Series Search(String name) {
        List<Anime> animes = mal.getAnime().withQuery(name).withLimit(1).includeNSFW(true).search();
        AnimeSeries animeSeries = new AnimeSeries();
        for (Anime anime : animes) {
            AlternativeTitles aNames = anime.getAlternativeTitles();
            if (name.equals(aNames.getEnglish())) {
                animeSeries.setName(aNames.getEnglish());
                animeSeries.setStudio(getStudiosAsList(anime.getStudios()));
                animeSeries.setChapters(anime.getEpisodes());
                animeSeries.setGenres(getGenresAsList(anime.getGenres()));
                animeSeries.setRate(anime.getRank());
                animeSeries.setPopularity(anime.getPopularity());
                animeSeries.setRelease(anime.getStartDate().getDate());
                animeSeries.setEnd(anime.getEndDate().getDate());
                animeSeries.setSynopsis(anime.getSynopsis());
                animeSeries.setRecomendations(getRecomendedasList(anime.getRecommendations()));
                animeSeries.setRelated(getRelatedAsList(anime.getRelatedAnime()));
            }
        }
        return animeSeries;
    }

    private List<String> getStudiosAsList(Studio[] studios) {
        List<String> lista = new ArrayList<String>();

        for (Studio studio : studios) {
            lista.add(studio.getName());
        }

        return lista;
    }

    private List<String> getGenresAsList(Genre[] genres) {
        List<String> lista = new ArrayList<String>();

        for (Genre g : genres) {
            lista.add(g.getName());
        }

        return lista;
    }

    private List<String> getRelatedAsList(RelatedAnime[] relatedAnime) {
        List<String> lista = new ArrayList<String>();
        for (RelatedAnime ra : relatedAnime) {
            lista.add(ra.getRawRelationType());
        }
        return lista;
    }

    private List<String> getRecomendedasList(AnimeRecommendation[] recommendations) {
        List<String> lista = new ArrayList<String>();
        for (AnimeRecommendation recommendation : recommendations) {
            lista.add(recommendation.toString());
        }
        return lista;
    }
}
