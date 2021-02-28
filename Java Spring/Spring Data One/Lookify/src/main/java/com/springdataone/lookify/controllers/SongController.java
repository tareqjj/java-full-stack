package com.springdataone.lookify.controllers;

import com.springdataone.lookify.models.Song;
import com.springdataone.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/")
    public String index() {
        return "/songs/index.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Song> allSongs = songService.allSongs();
        model.addAttribute("songs", allSongs);
        return "/songs/dashboard.jsp";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("artist") String artist){
        if (artist == "")
            return "redirect:/dashboard";
        else
            return "redirect:/search/"+ artist;
    }

    @RequestMapping("/search/{artist}")
    public String showSearch(@PathVariable("artist") String artist, Model model){
        List<Song> songList = songService.findSongList(artist);
        if (songList == null)
            model.addAttribute("artist", "Artist not found!");
        else {
            model.addAttribute("songList", songList);
            model.addAttribute("artist", artist);
        }
        return "/songs/search.jsp";
    }

    @RequestMapping("/songs/new")
    public String showNewSong(@ModelAttribute("song") Song song) {
        return "/songs/new.jsp";
    }

    @RequestMapping(value = "/songs/new", method = RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors())
            return "/songs/new.jsp";
        else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping("/songs/{id}")
    public String displaySong(@PathVariable("id") Long id, Model model){
        Song songToDisplay = songService.findSong(id);
        model.addAttribute("song", songToDisplay);
        return "/songs/show.jsp";
    }

    @RequestMapping("/search/topTen")
    public String topTen(Model model){
        List<Song> topTenList = songService.findTopten();
        model.addAttribute("topTen", topTenList);
        return "/songs/topTen.jsp";
    }

    @RequestMapping(value ="/songs/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
