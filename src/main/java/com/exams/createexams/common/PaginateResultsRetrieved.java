package com.exams.createexams.common;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PaginateResultsRetrieved {

  public void addLinkHeaderOnPagedResourceRetrieval(final UriComponentsBuilder uriBuilder, final
  HttpServletResponse response, final String path, final int page, final int totalPages,
      final int pageSize) {

    uriBuilder.path(path);

    final StringBuilder linkHeader = new StringBuilder();

    if (hasNextPage(page, totalPages)) {
      final String uriForNextPage = buildNextPageUri(uriBuilder, page, pageSize);
      linkHeader.append(createLinkHeader(uriForNextPage, "next"));
    }
    if (hasPreviousPage(page)) {
      final String uriForPrePage = buildPrePageUri(uriBuilder, page, pageSize);
      appendCommaIfNecessary(linkHeader);
      linkHeader.append(createLinkHeader(uriForPrePage, "prev"));
    }
    response.addHeader("Link", linkHeader.toString());
  }

  private boolean hasNextPage(final int page, final int totalPages) {
    return page < totalPages - 1;
  }

  private boolean hasPreviousPage(final int page) {
    return page > 0;
  }

  private String buildNextPageUri(
      final UriComponentsBuilder uriBuilder,
      final int page,
      final int pageSize) {
    return uriBuilder
        .replaceQueryParam("page", page + 1)
        .replaceQueryParam("size", pageSize)
        .build()
        .encode()
        .toUriString();
  }

  private String buildPrePageUri(
      final UriComponentsBuilder uriBuilder,
      final int page,
      final int pageSize
  ) {
    return uriBuilder.replaceQueryParam("page", page - 1)
        .replaceQueryParam("size", pageSize)
        .build()
        .encode()
        .toUriString();
  }

  private static String createLinkHeader(final String uri, final String rel) {
    return "<" + uri + ">; rel=\"" + rel + "\"";
  }

  private void appendCommaIfNecessary(final StringBuilder linkHeader) {
    if (linkHeader.length() > 0) {
      linkHeader.append((","));
    }
  }
}
