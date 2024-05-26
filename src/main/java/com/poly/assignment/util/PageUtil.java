package com.poly.assignment.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

public class PageUtil {
    public static <T> Page<T> createPage(List<T> list, int page, int pageSize) {
        int totalElements = list.size();
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalElements);

        if (startIndex >= endIndex) {
            return new PageImpl<>(Collections.emptyList(), Pageable.ofSize(pageSize), totalElements);
        }

        List<T> paginatedList = list.subList(startIndex, endIndex);

        return new PageImpl<>(paginatedList, Pageable.ofSize(pageSize), totalElements);
    }

}
