package com.andrew.movieLand.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private LocalDateTime releasedDate;
    private String description;
    private double rating;
    private double price;
    private String picturePath;
    private int votes;
}
