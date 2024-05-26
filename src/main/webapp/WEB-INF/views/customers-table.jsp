<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>${khachHang.id != null ? "Chỉnh sửa thông tin khách hàng " += khachHang.id : "Khách hàng" }</title>
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
                        Khách hàng</h1>
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
                                    <h2>Thông tin khách hàng</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Form-->
                            <form:form id="kt_account_profile_details_form"
                                  class="form fv-plugins-bootstrap5 fv-plugins-framework"
                                  action="/customer/create?id=${khachHang.id}" method="post" modelAttribute="khachHang">
                                <!--begin::Card body-->
                                <div class="card-body pt-0">
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Mã khách hàng</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="maKH" class="text-danger fs-7" />
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="maKH" class="form-control mb-2"
                                               placeholder="Mã khách hàng" />
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập mã khách hàng.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Tên khách hàng</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="ten" class="text-danger fs-7" />
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="ten" class="form-control mb-2"
                                               placeholder="Tên khách hàng" />
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập tên khách hàng.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Số điện thoại</label>
                                        <!--end::Label-->
                                        <!--begin::Input-->
                                        <form:input path="sdt" class="form-control mb-2"
                                               placeholder="Số điện thoại" />
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập số điện thoại khách hàng.</div>
                                        <!--end::Description-->
                                        <!--begin::Error-->
                                        <form:errors path="sdt" class="text-danger fs-7" />
                                        <!--end::Error-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="form-label">Trạng thái</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="trangThai" class="text-danger fs-7" />
                                        <!--end::Error-->
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
                                                       id="inactive" ${khachHang.trangThai == false ? "checked" : ""}/>
                                                <label class="form-check-label" for="inactive">
                                                    Bị khoá
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                        </div>
                                        <!--end::Status-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Chọn trạng thái cho khách hàng.
                                        </div>
                                        <!--end::Description-->
                                        <!--begin::Actions-->
                                        <div class="card-footer d-flex justify-content-end py-6 px-9">
                                            <button type="reset" class="btn btn-light btn-active-light-primary me-2">
                                                Discard
                                            </button>
                                            <button type="submit" class="btn btn-primary"
                                                    id="kt_account_profile_details_submit">Lưu khách hàng
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
                        <!--begin::Customers-->
                        <div class="card card-flush">
                            <!--begin::Card header-->
                            <div class="card-header align-items-center py-5 gap-2 gap-md-5">
                                <!--begin::Card title-->
                                <div class="card-title">
                                    <i class="ki-duotone ki-magnifier fs-3 position-absolute ms-4">
                                        <span class="path1"></span>
                                        <span class="path2"></span>
                                    </i>

                                    <input id="search-input"
                                           type="text"
                                           name="key"
                                           value="${key}"
                                           data-kt-ecommerce-product-filter="search"
                                           class="form-control form-control-solid w-250px ps-12 me-2"
                                           placeholder="Tìm kiếm khách hàng..."/>

                                    <button onclick="location.href='/products/table?key='+document.getElementById('search-input').value"
                                            class="btn btn-primary">
                                        Tìm kiếm
                                    </button>
                                </div>
                                <!--end::Card title-->
                                <!--begin::Card toolbar-->
                                <div class="card-toolbar flex-row-fluid justify-content-end gap-5">
                                    <div class="w-100 mw-150px">
                                        <!--begin::Select2-->
                                        <select class="form-select form-select-solid" data-control="select2"
                                                data-hide-search="true" data-placeholder="Status"
                                                data-kt-ecommerce-customer-filter="status">
                                            <option></option>
                                            <option value="all">Tất cả</option>
                                            <option value="published">Hoạt động</option>
                                            <option value="scheduled">Bị khoá</option>
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
                                       id="kt_ecommerce_customers_table">
                                    <thead>
                                    <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                        <th class="w-10px pe-2">
                                            <div class="form-check form-check-sm form-check-custom form-check-solid me-3">
                                                <input class="form-check-input" type="checkbox" data-kt-check="true"
                                                       data-kt-check-target="#kt_ecommerce_customers_table .form-check-input"
                                                       value="1"/>
                                            </div>
                                        </th>
                                        <th class="min-w-100px">Mã khách hàng</th>
                                        <th class="min-w-200px">Tên khách hàng</th>
                                        <th class="text-end min-w-100px">Số điện thoại</th>
                                        <th class="text-end min-w-100px">Trạng thái</th>
                                        <th class="text-end min-w-70px">Hành động</th>
                                    </tr>
                                    </thead>
                                    <tbody class="fw-semibold text-gray-600">
                                    <c:forEach items="${customers}" var="customer" varStatus="i">
                                        <tr>
                                            <td>
                                                <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                    <input class="form-check-input" type="checkbox" value="1"/>
                                                </div>
                                            </td>
                                            <td class="pe-0">
                                                <span class="fw-bold">${customer.maKH}</span>
                                            </td>
                                            <td class="pe-0">
                                                <span class="fw-bold">${customer.ten}</span>
                                            </td>
                                            <td class="text-end pe-0" data-order="6">
                                                <span class="fw-bold ms-3">${customer.sdt}</span>
                                            </td>
                                            <td class="text-end pe-0" data-order="Scheduled">
                                                <!--begin::Badges-->
                                                <div class="badge ${customer.trangThai ? "badge-light-primary" : "badge-light-danger"}">${customer.trangThai ? "Hoạt động" : "Bị khoá"}</div>
                                                <!--end::Badges-->
                                            </td>
                                            <td class="text-end">
                                                <a href="#"
                                                   class="btn btn-sm btn-light btn-flex btn-center btn-active-light-primary"
                                                   data-kt-menu-trigger="click" data-kt-menu-placement="bottom-end">Hành động
                                                    <i class="ki-duotone ki-down fs-5 ms-1"></i>
                                                </a>
                                                <!--begin::Menu-->
                                                <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-600 menu-state-bg-light-primary fw-semibold fs-7 w-125px py-4"
                                                     data-kt-menu="true">
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/customer/update?id=${customer.id}"
                                                           class="menu-link px-3">Sửa thông tin</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/customers/delete?id=${customer.id}"
                                                           class="menu-link px-3"
                                                           data-kt-ecommerce-customer-filter="delete_row">Xoá khách hàng</a>
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
                                    <jsp:param name="e" value="customers"/>
                                </jsp:include>
                                <!--end::Pagination-->
                            </div>
                            <!--end::Card body-->
                        </div>
                        <!--end::Customers-->
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