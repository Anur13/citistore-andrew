package com.andrew.movieland.util.sorting;

import java.util.List;

public class AcceptedSortTypesList {
    public final static List<SortType> ACCEPTED_SORT_TYPES = List.of(new SortType(SortDirections.DESC, SortField.RATING),
            new SortType(SortDirections.ASC, SortField.PRICE),
            new SortType(SortDirections.DESC, SortField.PRICE));

}
