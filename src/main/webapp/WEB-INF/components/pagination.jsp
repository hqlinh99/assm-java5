<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ePage.totalPages > 1}">
    <ul class="pagination justify-content-end">
        <li class="page-item previous ${ePage.number == 0 ? 'disabled' : ''}">
            <a href="/${param.e}/table?page=${ePage.number - 1}&pageSize=${ePage.pageable.pageSize}&status=${status}"
               class="page-link"><i class="previous"></i></a>
        </li>
        <c:forEach begin="0" end="${ePage.totalPages - 1}"
                   var="pageNumber">
            <li class="page-item ${ePage.number == pageNumber ? 'active' : ''}">
                <a href="/${param.e}/table?page=${pageNumber}&pageSize=${ePage.pageable.pageSize}&status=${status}"
                   class="page-link">${pageNumber + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item next">
            <a href="/${param.e}/table?page=${number + 1}&pageSize=${ePage.pageable.pageSize}&status=${status}"
               class="page-link"><i class="next"></i></a>
        </li>
    </ul>
</c:if>
