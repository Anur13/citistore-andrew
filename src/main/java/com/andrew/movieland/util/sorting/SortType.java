package com.andrew.movieland.util.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SortType {
    private final SortDirections sortDirection;
    private final SortField sortField;
}
