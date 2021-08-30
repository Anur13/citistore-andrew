package com.andrew.citystore.Web.Controller;

import com.andrew.citystore.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/movie")
public class MovieController {

    MovieService movieService;
}
