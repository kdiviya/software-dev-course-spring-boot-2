package com.example.mycollections.controllers;
import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("Inception", 2010, "Christopher Nolan", 148));
        add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 175));
        add(new Movie("Parasite", 2019,"Bong Joon-ho", 132));
    }};

    @GetMapping("/json")
    public List<Movie> getAlbumsJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }

}
