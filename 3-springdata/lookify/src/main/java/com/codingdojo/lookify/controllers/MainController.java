package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class MainController {

	private SongService songService;
	public MainController(SongService songService){
	    this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
    public String getSongs(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
        return "dash";
    }

    @RequestMapping("/songs/new")
    public String addSong(
    		@ModelAttribute("song") Song song) {
    		return "new";
    }
	
	@PostMapping("/songs/new")
	public String addSongPost(
		@Valid @ModelAttribute("song") Song song,
		BindingResult result) {
		
		if (result.hasErrors()) {
			return "new";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String getSong(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", songService.getSong(id));
		return "song";
	}
    
    @RequestMapping("/songs/{id}/delete")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    
	@RequestMapping("/search/top10")
    public String getTopTen(Model model) {
		List<Song> topten = songService.topTen();
		model.addAttribute("topten", topten);
        return "topTen";
    }
	
    @PostMapping("/search")
    public String search(@RequestParam("artist") String artist) {
    	return "redirect:/search/".concat(artist)	;
    }
	
	@RequestMapping("/search/{artist}")
	public String searchResults(Model model,
		@PathVariable("artist") String artist, RedirectAttributes flash) {
		
		model.addAttribute("artist", artist);
		List<Song> result = songService.searchByArtist(artist);
		
		if (result.isEmpty()) {
			flash.addFlashAttribute("flash", "No artists were found!");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songService.searchByArtist(artist));
			return "search";
		}
	}
	
}