package com.example.springboot_3_06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // First lets create a album
        Album album = new Album();
        album.setName("Lil Kim");
        album.setGenre("Hip Hop");

        // Now let`s create a song
        Song song = new Song();
        song.setTitle("HardCore");
        song.setYear(1997);
        song.setDescription("Best album ever");

        // Add the song to an empty list
        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song = new Song();
        song.setTitle("Big Momma Thang");
        song.setYear(1997);
        song.setDescription("best song");
        songs.add(song);

        // Add the list of songs to the album songs list
        album.setSongs(songs);

        // Save the album to the database
        albumRepository.save(album);

        //Grab all the albums from the database and send them to
        // the template
        model.addAttribute("albums", albumRepository.findAll());
        return "index";

    }
}
