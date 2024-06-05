<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>Hoang Linh - The World's #1 Selling Bootstrap Admin Template by KeenThemes</title>
</head>
<body>
<!--begin::Main-->
<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <!--begin::Content wrapper-->
    <div class="d-flex flex-column flex-column-fluid">
        <!--begin::Toolbar-->
        <div id="kt_app_toolbar" class="app-toolbar py-3 py-lg-6">
            <!--begin::Toolbar container-->
            <div id="kt_app_toolbar_container" class="app-container container-fluid d-flex flex-stack">
                <!--begin::Page title-->
                <div class="page-title d-flex flex-column justify-content-center flex-wrap me-3">
                    <!--begin::Title-->
                    <h1 class="page-heading d-flex text-gray-900 fw-bold fs-3 flex-column justify-content-center my-0">
                        Cửa hàng</h1>
                    <!--end::Title-->
                </div>
                <!--end::Page title-->
            </div>
            <!--end::Toolbar container-->
        </div>
        <!--end::Toolbar-->
        <!--begin::Content-->
        <div id="kt_app_content" class="app-content flex-column-fluid">
            <!--begin::Content container-->
            <div id="kt_app_content_container" class="app-container container-fluid">
                <!--begin::Row-->
                <div class="row g-5 gx-xl-10 mb-5 mb-xl-10">
                    <!--begin::Col-->
                    <div class="col-md-6 col-lg-6 col-xl-6 col-xxl-12 mb-md-5 mb-xl-10">
                        <!--begin::Row-->
                        <div class="row g-5 gx-xl-10 mb-5 mb-xl-10">
                            <c:forEach items="${ePage.getContent()}" var="product">
                                <!--begin::Col-->
                                <div class="col-md-6 col-lg-6 col-xl-6 col-xxl-4 mb-md-5 mb-xl-10">
                                    <!--begin::Product card-->
                                    <div class="card-xl-stretch me-md-6">
                                        <div class="row">
                                            <div class="col-5">
                                                <!--begin::Overlay-->
                                                <a class="d-block overlay mb-4"
                                                   data-fslightbox="lightbox-hot-sales"
                                                   href="/product-${product.id}/details">
                                                    <!--begin::Image-->
                                                    <div class="overlay-wrapper bgi-no-repeat bgi-position-center bgi-size-cover card-rounded min-h-175px"
                                                         style="background-image:url('${product.hinhAnh}')"></div>
                                                    <!--end::Image-->
                                                    <!--begin::Action-->
                                                    <div class="overlay-layer bg-dark card-rounded bg-opacity-25">
                                                        <i class="ki-duotone ki-eye fs-2x text-white"></i>
                                                    </div>
                                                    <!--end::Action-->
                                                </a>
                                                <!--end::Overlay-->
                                            </div>

                                            <div class="col-7">
                                                <!--begin::Body-->
                                                <div class="m-0">
                                                    <!--begin::Title-->
                                                    <a href="/product-${product.id}/details"
                                                       class="fs-4 text-gray-900 fw-bold text-hover-primary text-gray-900 lh-base">${product.ten}</a>
                                                    <!--end::Title-->
                                                    <!--begin::Author-->
                                                    <div class="base text-gray-600 mt-2 mb-2">
                                                        Horizon Tech
                                                    </div>
                                                    <!--end::Author-->
                                                    <!--begin::Rating-->
                                                    <div class="d-flex gap-2 mt-2 mb-2">
                                                        <!--begin::Average-->
                                                        <div class="fw-bold base text-gray-900">
                                                            5.0
                                                        </div>
                                                        <!--end::Average-->
                                                        <!--begin::Star-->
                                                        <div class="rating">
                                                            <div class="rating-label checked">
                                                                <i class="ki-duotone ki-star base"></i>
                                                            </div>
                                                            <div class="rating-label checked">
                                                                <i class="ki-duotone ki-star base"></i>
                                                            </div>
                                                            <div class="rating-label checked">
                                                                <i class="ki-duotone ki-star base"></i>
                                                            </div>
                                                            <div class="rating-label checked">
                                                                <i class="ki-duotone ki-star base"></i>
                                                            </div>
                                                            <div class="rating-label checked">
                                                                <i class="ki-duotone ki-star base"></i>
                                                            </div>
                                                        </div>
                                                        <!--end::Star-->
                                                        <!--begin::Count-->
                                                        <div class="base text-gray-600">
                                                            (998)
                                                        </div>
                                                        <!--end::Count-->
                                                    </div>
                                                    <!--end::Rating-->
                                                </div>
                                                <!--end::Body-->
                                            </div>
                                        </div>
                                    </div>
                                    <!--end::Product card-->
                                </div>
                                <!--end::Col-->
                            </c:forEach>
                        </div>
                        <!--end::Row-->
                        <!--begin::Pagination-->
<%--                        <ul class="pagination justify-content-end">--%>
<%--                            <li class="page-item previous ${ePage.number == 0 ? 'disabled' : ''}">--%>
<%--                                <a href="?page=${ePage.number - 1}&pageSize=${ePage.pageable.pageSize}&status=${status}"--%>
<%--                                   class="page-link"><i class="previous"></i></a>--%>
<%--                            </li>--%>
<%--                            <c:forEach begin="0" end="${ePage.totalPages - 1}"--%>
<%--                                       var="pageNumber">--%>
<%--                                <li class="page-item ${ePage.number == pageNumber ? 'active' : ''}">--%>
<%--                                    <a href="?page=${pageNumber}&pageSize=${ePage.pageable.pageSize}&status=${status}"--%>
<%--                                       class="page-link">${pageNumber + 1}</a>--%>
<%--                                </li>--%>
<%--                            </c:forEach>--%>
<%--                            <li class="page-item next">--%>
<%--                                <a href="?page=${number + 1}&pageSize=${ePage.pageable.pageSize}&status=${status}"--%>
<%--                                   class="page-link"><i class="next"></i></a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
                        <!--end::Pagination-->
                    </div>
                    <!--end::Col-->
                </div>
                <!--end::Row-->
            </div>
            <!--end::Content container-->
        </div>
        <!--end::Content-->
    </div>
    <!--end::Content wrapper-->
</div>
<!--end::Main-->
</body>
</html>