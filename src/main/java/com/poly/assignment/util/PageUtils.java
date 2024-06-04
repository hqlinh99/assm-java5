package com.poly.assignment.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

public class PageUtils {
    public static Pageable getPageable(String page, String pageSize) {
        if (page != null && pageSize != null) {
            try {
                int pageInt = Integer.parseInt(page);
                int pageSizeInt = Integer.parseInt(pageSize);

                return PageRequest.of(pageInt, pageSizeInt);

            } catch (Exception ex) {
                return Pageable.unpaged();
            }
        }
        return Pageable.unpaged();
    }

}
