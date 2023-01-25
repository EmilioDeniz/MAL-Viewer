package main;

import api.MangaManager;
import dev.katsute.mal4j.MyAnimeList;
import model.MangaSeries;
public class Main {
    
    public static void main(String[] args){
        MyAnimeList mal = MyAnimeList.withClientID("5c7d53f8bffa32bea8c1ed7cf6b559cd");
        MangaManager manager = new MangaManager(mal);
        MangaSeries manga = manager.Search("Fairy Tail");
        System.out.print(manga.getName());
    }
}
