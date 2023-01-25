package api;

import dev.katsute.mal4j.MyAnimeList;
import dev.katsute.mal4j.manga.Manga;
import dev.katsute.mal4j.property.AlternativeTitles;
import dev.katsute.mal4j.query.MangaSearchQuery;
import java.util.List;
import model.MangaSeries;

import model.Series;

public class MangaManager implements Manager{
    private MyAnimeList mal;
    
    public MangaManager(MyAnimeList mal){
        this.mal = mal;
    }

    @Override
    public MangaSeries Search(String name) {
        List<Manga> mangas = mal.getManga().withQuery(name).withLimit(1).includeNSFW(false).search();
        MangaSeries mangaSeries = new MangaSeries();
        for (Manga manga: mangas){
            AlternativeTitles altNames = manga.getAlternativeTitles();
            if (altNames.getEnglish().equals(name)){
                mangaSeries.setName(altNames.getEnglish());
                mangaSeries.setAuthor(manga.getAuthors());
            }
            break;
        }
        return mangaSeries;
    }
}
