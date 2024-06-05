<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>${kichThuoc.id != null ? "Chỉnh sửa thông tin kích thước " += kichThuoc.id : "Sản phẩm" }</title>
</head>
<body>
<!--begin::Main-->
<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <!--begin::Content wrapper-->
    <div class="d-flex flex-column flex-column-fluid">
        <!--begin::Toolbar-->
        <div id="kt_app_toolbar" class="app-toolbar py-3 py-lg-6">
            <!--begin::Toolbar container-->
            <div id="kt_app_toolbar_container" class="app-container container-xxl d-flex flex-stack">
                <!--begin::Page title-->
                <div class="page-title d-flex flex-column justify-content-center flex-wrap me-3">
                    <!--begin::Title-->
                    <h1 class="page-heading d-flex text-gray-900 fw-bold fs-3 flex-column justify-content-center my-0">
                        Sản phẩm</h1>
                    <!--end::Title-->
                    <!--begin::Breadcrumb-->
                    <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">
                            <a href="/" class="text-muted text-hover-primary">Trang chủ</a>
                        </li>
                        <!--end::Item-->
                    </ul>
                    <!--end::Breadcrumb-->
                </div>
                <!--end::Page title-->

            </div>
            <!--end::Toolbar container-->
        </div>
        <!--end::Toolbar-->
        <!--begin::Content-->
        <div id="kt_app_content" class="app-content flex-column-fluid">
            <!--begin::Content container-->
            <div id="kt_app_content_container" class="app-container container-xxl">
                <!--begin::Col-->
                <div class="row gy-5 g-xl-10">
                    <!--begin::Col-->
                    <div class="col-xl-4">
                        <!--begin::Info-->
                        <div class="card card-flush py-4">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <div class="card-title">
                                    <h2>Thông tin kích thước</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Form-->
                            <form:form id="kt_account_profile_details_form"
                                       class="form fv-plugins-bootstrap5 fv-plugins-framework"
                                       action="/sizes/create?pid=${kichThuoc.id}" method="post" modelAttribute="kichThuoc"
                                       enctype="multipart/form-data">
                                <!--begin::Card body-->
                                <div class="card-body pt-0">
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Mã kích thước</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="maKT" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="maKT" class="form-control mb-2"
                                                    placeholder="Mã kích thước"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập mã kích thước.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Tên kích thước</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="ten" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="ten" class="form-control mb-2"
                                                    placeholder="Tên kích thước"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập tên kích thước.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Trạng thái</label>
                                        <!--end::Label-->
                                        <!--begin::Status-->
                                        <div class="d-flex gap-2">
                                            <!--begin::Radio-->
                                            <div class="form-check form-check-custom form-check-solid">
                                                <input class="form-check-input" name="trangThai" type="radio"
                                                       value="true" id="active" checked/>
                                                <label class="form-check-label" for="active">
                                                    Hoạt động
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                            <!--begin::Radio-->
                                            <div class="form-check form-check-danger form-check-solid">
                                                <input class="form-check-input" name="trangThai" type="radio"
                                                       value="false"
                                                       id="inactive" ${kichThuoc.trangThai == false ? "checked" : ""}/>
                                                <label class="form-check-label" for="inactive">
                                                    Bị khoá
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                        </div>
                                        <!--end::Status-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Chọn trạng thái cho kích thước.
                                        </div>
                                        <!--end::Description-->
                                        <!--begin::Actions-->
                                        <div class="card-footer d-flex justify-content-end py-6 px-9">
                                            <a href="/sizes/table" type="reset"
                                               class="btn btn-light btn-active-light-primary me-2">
                                                Làm mới
                                            </a>
                                            <button type="submit" class="btn btn-primary"
                                                    id="kt_account_profile_details_submit">Lưu kích thước
                                            </button>
                                        </div>
                                        <!--end::Actions-->
                                    </div>
                                    <!--end::Input group-->
                                </div>
                                <!--end::Card header-->
                            </form:form>
                            <!--end::Form-->
                        </div>
                        <!--end::Info-->
                    </div>
                    <!--end::Col-->
                    <!--begin::Col-->
                    <div class="col-xl-8">
                        <!--begin::Products-->
                        <div class="card card-flush">
                            <!--begin::Card header-->
                            <div class="card-header align-items-center py-5 gap-2 gap-md-5">
                                <!--begin::Card title-->
                                <div class="card-title">
                                    <!--begin::Search-->
                                    <div class="d-flex align-items-center position-relative my-1">
                                        <i class="ki-duotone ki-magnifier fs-3 position-absolute ms-4">
                                            <span class="path1"></span>
                                            <span class="path2"></span>
                                        </i>

                                        <input id="search-input"
                                               type="text"
                                               name="key"
                                               value="${key}"
                                               data-kt-ecommerce-kichThuoc-filter="search"
                                               class="form-control form-control-solid w-250px ps-12 me-2"
                                               placeholder="Tìm kiếm kích thước..."/>

                                        <button onclick="location.href='/sizes/table?key='+document.getElementById('search-input').value"
                                                class="btn btn-primary">
                                            Tìm kiếm
                                        </button>
                                    </div>
                                    <!--end::Search-->
                                </div>
                                <!--end::Card title-->
                                <!--begin::Card toolbar-->
                                <div class="card-toolbar flex-row-fluid justify-content-end gap-5">
                                    <div class="w-100 mw-150px">
                                        <!--begin::Select2-->
                                        <select class="form-select form-select-solid" data-control="select2"
                                                data-hide-search="true" data-placeholder="Status"
                                                data-kt-ecommerce-kichThuoc-filter="status"
                                                name="status"
                                                onchange="location.href='/sizes/table?page=0&pageSize=${pageSize}&status='+this.value">
                                            <option value="all">Tất cả</option>
                                            <option value="true" ${status == 'true' ? "selected" : ""}>Hoạt động
                                            </option>
                                            <option value="false" ${status == 'false' ? "selected" : ""}>Bị khoá
                                            </option>
                                        </select>
                                        <!--end::Select2-->
                                    </div>
                                </div>
                                <!--end::Card toolbar-->
                            </div>
                            <!--end::Card header-->
                            <!--begin::Card body-->
                            <div class="card-body pt-0">
                                <!--begin::Table-->
                                <table class="table align-middle table-row-dashed fs-6 gy-5"
                                       id="kt_ecommerce_kichThuoc_table">
                                    <thead>
                                    <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                        <th class="w-10px pe-2">
                                            <div class="form-check form-check-sm form-check-custom form-check-solid me-3">
                                                <input class="form-check-input" type="checkbox" data-kt-check="true"
                                                       data-kt-check-target="#kt_ecommerce_kichThuoc_table .form-check-input"
                                                       value="1"/>
                                            </div>
                                        </th>
                                        <th class="min-w-100px">Mã kích thước</th>
                                        <th class="min-w-200px">Tên kích thước</th>
                                        <th class="text-end min-w-100px">Trạng thái</th>
                                        <th class="text-end min-w-70px">Hành động</th>
                                    </tr>
                                    </thead>
                                    <tbody class="fw-semibold text-gray-600">
                                    <c:forEach items="${ePage.getContent()}" var="kichThuoc" varStatus="i">
                                        <tr>
                                            <td>
                                                <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                    <input class="form-check-input" type="checkbox" value="1"/>
                                                </div>
                                            </td>
                                            <td class="pe-0">
                                                <span class="fw-bold">${kichThuoc.maKT}</span>
                                            </td>
                                            <td class="pe-0">
                                                <span class="fw-bold">${kichThuoc.ten}</span>
                                            </td>
                                            <td class="text-end pe-0" data-order="Scheduled">
                                                <!--begin::Badges-->
                                                <div class="badge ${kichThuoc.trangThai ? "badge-light-primary" : "badge-light-danger"}">
                                                        ${kichThuoc.trangThai ? "Hoạt động" : "Bị khoá"}
                                                </div>
                                                <!--end::Badges-->
                                            </td>
                                            <td class="text-end">
                                                <a href="#"
                                                   class="btn btn-sm btn-light btn-flex btn-center btn-active-light-primary"
                                                   data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end">Hành
                                                    động
                                                    <i class="ki-duotone ki-down fs-5 ms-1"></i>
                                                </a>
                                                <!--begin::Menu-->
                                                <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-semibold fs-7 w-125px py-4"
                                                     data-kt-menu="true">
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/kichThuoc-${kichThuoc.id}/details-table"
                                                           class="menu-link px-3">Biến thể</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/sizes/update?pid=${kichThuoc.id}"
                                                           class="menu-link px-3">Sửa thông tin</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/sizes/delete?pid=${kichThuoc.id}"
                                                           class="menu-link px-3"
                                                           data-kt-ecommerce-kichThuoc-filter="delete_row">Xoá kích thước
                                                        </a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                </div>
                                                <!--end::Menu-->
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <!--end::Table-->
                                <!--begin::Pagination-->
                                <jsp:include page="/WEB-INF/components/pagination.jsp">
                                    <jsp:param name="e" value="sizes"/>
                                </jsp:include>
                                <!--end::Pagination-->
                            </div>
                            <!--end::Card body-->
                        </div>
                        <!--end::Products-->
                    </div>
                    <!--end::Col-->
                </div>
                <!--end::Col-->
            </div>
            <!--end::Content container-->
        </div>
        <!--end::Content-->
    </div>
    <!--end::Content wrapper-->
    <!--begin::Footer-->
    <div id="kt_app_footer" class="app-footer">
        <!--begin::Footer container-->
        <div class="app-container container-fluid d-flex flex-column flex-md-row flex-center flex-md-stack py-3">
            <!--begin::Copyright-->
            <div class="text-gray-900 order-2 order-md-1">
                <span class="text-muted fw-semibold me-1">2024&copy;</span>
                <a href="https://keenthemes.com" target="_blank" class="text-gray-800 text-hover-primary">Keenthemes</a>
            </div>
            <!--end::Copyright-->
            <!--begin::Menu-->
            <ul class="menu menu-gray-600 menu-hover-primary fw-semibold order-1">
                <li class="menu-item">
                    <a href="https://keenthemes.com" target="_blank" class="menu-link px-2">About</a>
                </li>
                <li class="menu-item">
                    <a href="https://devs.keenthemes.com" target="_blank" class="menu-link px-2">Support</a>
                </li>
                <li class="menu-item">
                    <a href="https://1.envato.market/EA4JP" target="_blank" class="menu-link px-2">Purchase</a>
                </li>
            </ul>
            <!--end::Menu-->
        </div>
        <!--end::Footer container-->
    </div>
    <!--end::Footer-->
</div>
<!--end:::Main-->

</body>
</html>