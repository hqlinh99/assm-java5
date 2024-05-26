<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${totalPages != null && totalPages > 0}">
    <ul class="pagination justify-content-end">
        <li class="page-item previous ${currentPage == 0 ? 'disabled' : ''}">
            <a href="/${param.e}/table?page=${currentPage - 1}&pageSize=${pageSize}&status=${status}"
               class="page-link"><i class="previous"></i></a>
        </li>
        <c:forEach begin="0" end="${totalPages != null ? totalPages - 1 : 0}"
                   var="pageNumber">
            <li class="page-item ${currentPage == pageNumber ? 'active' : ''}">
                <a href="/${param.e}/table?page=${pageNumber}&pageSize=${pageSize}&status=${status}"
                   class="page-link">${pageNumber + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item next">
            <a href="/${param.e}/table?page=${currentPage + 1}&pageSize=${pageSize}&status=${status}"
               class="page-link"><i class="next"></i></a>
        </li>
    </ul>
</c:if>
