<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>Chỉnh sửa hoá đơn</title>
</head>
<body>
<!--begin::Main-->
<div class="app-main flex-column flex-row-fluid" id="kt_app_main">
    <c:if test="${currentUser.chucVu}">
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
                            Hoá đơn</h1>
                        <!--end::Title-->
                        <!--begin::Breadcrumb-->
                        <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
                            <!--begin::Item-->
                            <li class="breadcrumb-item text-muted">
                                <a href="/" class="text-muted text-hover-primary">Trang chủ</a>
                            </li>
                            <!--end::Item-->
                            <!--begin::Item-->
                            <li class="breadcrumb-item">
                                <span class="bullet bg-gray-500 w-5px h-2px"></span>
                            </li>
                            <!--end::Item-->
                            <!--begin::Item-->
                            <li class="breadcrumb-item text-muted">
                                <a href="/invoices/table" class="text-muted text-hover-primary">Hoá đơn</a>
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
                                        <h2>Thông tin hoá đơn</h2>
                                    </div>
                                </div>
                                <!--end::Card header-->
                                <!--begin::Form-->
                                <form:form id="kt_account_profile_details_form"
                                           class="form fv-plugins-bootstrap5 fv-plugins-framework"
                                           action="/invoices/create?id=${hoaDon.id}" method="post"
                                           modelAttribute="hoaDon">
                                    <!--begin::Card body-->
                                    <div class="card-body pt-0">
                                        <!--begin::Input group-->
                                        <div class="mb-10 fv-row">
                                            <!--begin::Label-->
                                            <label class="required form-label">Nhân viên</label>
                                            <!--end::Label-->
                                            <!--begin::Error-->
                                            <form:errors path="id" class="badge badge-light-danger"/>
                                            <!--end::Error-->
                                            <!--begin::Input-->
                                            <select class="form-select" data-control="select1"
                                                    data-placeholder="Chọn nhân viên" name="nhanVien.id">
                                                <c:forEach items="${employees}" var="employee">
                                                    <option value="${employee.id}" ${hoaDon.nhanVien.id == employee.id ? "selected" : ""}>
                                                            ${employee.id} - ${employee.ten}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <!--end::Input-->
                                            <!--begin::Description-->
                                            <div class="text-muted fs-7">Chọn nhân viên.</div>
                                            <!--end::Description-->
                                        </div>
                                        <!--end::Input group-->
                                        <!--begin::Input group-->
                                        <div class="mb-10 fv-row">
                                            <!--begin::Label-->
                                            <label class="required form-label">Khách hàng</label>
                                            <!--end::Label-->
                                            <!--begin::Error-->
                                            <form:errors path="khachHang.id" class="badge badge-light-danger"/>
                                            <!--end::Error-->
                                            <!--begin::Input-->
                                            <select class="form-select" data-control="select2"
                                                    data-placeholder="Chọn khách hàng" name="khachHang.id">
                                                <c:forEach items="${customers}" var="customer">
                                                    <option value="${customer.id}"${hoaDon.khachHang.id == customer.id ? "selected" : ""}>
                                                            ${customer.id} - ${customer.ten}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <!--end::Input-->
                                            <!--begin::Description-->
                                            <div class="text-muted fs-7">Chọn khách hàng.</div>
                                            <!--end::Description-->
                                        </div>
                                        <!--end::Input group-->
                                        <!--begin::Input group-->
                                        <div class="mb-10 fv-row">
                                            <!--begin::Label-->
                                            <label class="required form-label">Ngày mua hàng</label>
                                            <!--end::Label-->
                                            <!--begin::Error-->
                                            <form:errors path="khachHang.id" class="badge badge-light-danger"/>
                                            <!--end::Error-->
                                            <!--begin::Input-->
                                            <div class="input-group" id="kt_td_picker_localization"
                                                 data-td-target-input="nearest" data-td-target-toggle="nearest">
                                                <input type="text" class="form-control" name="ngayMuaHang"
                                                       value="${hoaDon.ngayMuaHang}"
                                                       data-td-target="#kt_td_picker_localization"/>
                                                <span class="input-group-text"
                                                      data-td-target="#kt_td_picker_localization"
                                                      data-td-toggle="datetimepicker">
                                                <i class="ki-duotone ki-calendar fs-2">
                                                    <span class="path1"></span>
                                                    <span class="path2"></span>
                                                </i>
                                            </span>
                                            </div>
                                            <!--end::Input-->
                                            <!--begin::Description-->
                                            <div class="text-muted fs-7">Chọn ngày mua hàng.</div>
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
                                                        Thành công
                                                    </label>
                                                </div>
                                                <!--end::Radio-->
                                                <!--begin::Radio-->
                                                <div class="form-check form-check-danger form-check-solid">
                                                    <input class="form-check-input" name="trangThai" type="radio"
                                                           value="false"
                                                           id="inactive" ${hoaDon.trangThai == false ? "checked" : ""}/>
                                                    <label class="form-check-label" for="inactive">
                                                        Huỷ
                                                    </label>
                                                </div>
                                                <!--end::Radio-->
                                            </div>
                                            <!--end::Status-->
                                            <!--begin::Description-->
                                            <div class="text-muted fs-7">Chọn trạng thái cho hoá đơn.
                                            </div>
                                            <!--end::Description-->
                                            <!--begin::Actions-->
                                            <div class="card-footer d-flex justify-content-end py-6 px-9">
                                                <a href="/invoices/update?id=${hoaDon.id}" type="reset"
                                                   class="btn btn-light btn-active-light-primary me-2">
                                                    Làm mới
                                                </a>
                                                <button type="submit" class="btn btn-primary"
                                                        id="kt_account_profile_details_submit">Lưu hoá đơn
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
                                        <h2>Hoá đơn chi tiết</h2>
                                    </div>
                                    <!--end::Card title-->
                                </div>
                                <!--end::Card header-->
                                <!--begin::Card body-->
                                <div class="card-body pt-0">
                                    <!--begin::Table-->
                                    <table class="table align-middle table-row-dashed fs-6 gy-5"
                                           id="kt_ecommerce_product_table">
                                        <thead>
                                        <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                            <th class="min-w-200px">Sản phẩm</th>
                                            <th class="text-center min-w-100px">Số lượng</th>
                                            <th class="min-w-100px">Đơn giá</th>
                                            <th class="text-end min-w-100px">Thành tiền</th>
                                            <th class="text-end min-w-70px">Trạng thái</th>
                                        </tr>
                                        </thead>
                                        <tbody class="fw-semibold text-gray-600">
                                        <c:forEach items="${invoiceDetails}" var="invoiceDetail" varStatus="i">
                                            <tr>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <!--begin::Thumbnail-->
                                                        <a href="apps/ecommerce/catalog/edit-product.html"
                                                           class="symbol symbol-50px">
                                                            <span class="symbol-label"
                                                                  style="background-image:url('${invoiceDetail.sanPhamChiTiet.hinhAnh}');"></span>
                                                        </a>
                                                        <!--end::Thumbnail-->
                                                        <div class="ms-5">
                                                            <!--begin::Product detail-->
                                                            <select class="form-select" data-control="select2"
                                                                    data-placeholder="Chọn sản phẩm chi tiết"
                                                                    onchange="location.href='/update-product-detail-in-invoice-detail?iid=${hoaDon.id}&idid=${invoiceDetail.id}&pdid='+this.value">
                                                                <c:forEach items="${productDetails}"
                                                                           var="productDetail">
                                                                    <option value="${productDetail.id}"${invoiceDetail.sanPhamChiTiet.id == productDetail.id ? "selected" : ""}>
                                                                            ${productDetail.sanPham.ten}
                                                                        - ${productDetail.ten}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                            <!--end::Product detail-->
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="pe-0">
                                                    <div class="position-relative w-md-100px mx-auto">
                                                        <!--begin::Decrease control-->
                                                        <button onclick="location.href='/decrease-quantity-in-invoice-detail-${hoaDon.id}?idid=${invoiceDetail.id}'"
                                                                type="button"
                                                                class="btn btn-icon btn-active-color-gray-700 position-absolute translate-middle-y top-50 start-0"
                                                            ${invoiceDetail.soLuong < 2 ? "disabled" : ""}>
                                                            <i class="ki-outline ki-minus-square fs-1"></i>
                                                        </button>
                                                        <!--end::Decrease control-->

                                                        <!--begin::Input control-->
                                                        <input type="text"
                                                               class="form-control form-control-solid border-0 ps-12"
                                                               data-kt-dialer-control="input" placeholder="Amount"
                                                               name="manageBudget" readonly=""
                                                               value="${invoiceDetail.soLuong}">
                                                        <!--end::Input control-->

                                                        <!--begin::Increase control-->
                                                        <button onclick="location.href='/increase-quantity-in-invoice-detail-${hoaDon.id}?idid=${invoiceDetail.id}'"
                                                                type="button"
                                                                class="btn btn-icon btn-active-color-gray-700 position-absolute translate-middle-y top-50 end-0">
                                                            <i class="ki-outline ki-plus-square fs-1"></i>
                                                        </button>
                                                        <!--end::Increase control-->
                                                    </div>
                                                </td>
                                                <td class="pe-0">
                                                    <span class="fw-bold">${invoiceDetail.donGia}</span>
                                                </td>
                                                <td class="text-end pe-0">
                                                    <span class="fw-bold">${invoiceDetail.soLuong * invoiceDetail.donGia}đ</span>
                                                </td>
                                                <td class="text-end pe-0" data-order="Scheduled">
                                                    <!--begin::Badges-->
                                                    <div onclick="location.href='/update-status-invoice-detail?iid=${hoaDon.id}&idid=${invoiceDetail.id}'" class="badge cursor-pointer ${invoice.trangThai ? "badge-light-primary" : "badge-light-danger"}">
                                                            ${invoiceDetail.trangThai ? "Hoạt động" : "Bị khoá"}
                                                    </div>
                                                    <!--end::Badges-->
                                                </td>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <!--end::Table-->
<%--                                    <!--begin::Pagination-->--%>
<%--                                    <jsp:include page="/WEB-INF/components/pagination.jsp">--%>
<%--                                        <jsp:param name="e" value="products"/>--%>
<%--                                    </jsp:include>--%>
<%--                                    <!--end::Pagination-->--%>
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
    </c:if>
    <jsp:include page="403.jsp"/>
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