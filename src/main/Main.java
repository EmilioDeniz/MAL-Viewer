package main;

import api.AnimeManager;
import api.MangaManager;
import dev.katsute.mal4j.MyAnimeList;
import java.util.List;
import model.MangaSeries;
public class Main {
    
    public static void main(String[] args){
        MyAnimeList mal = MyAnimeList.withClientID("5c7d53f8bffa32bea8c1ed7cf6b559cd");
        MangaManager mangaManager = new MangaManager(mal);
        AnimeManager animeManager = new AnimeManager(mal);
    }
}
