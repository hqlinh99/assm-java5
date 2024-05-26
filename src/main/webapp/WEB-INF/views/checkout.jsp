<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>Chỉnh sửa thông tin thanh toán</title>
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
                        Thông tin thanh toán</h1>
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
                <!--begin::Form-->
                <form:form id="kt_ecommerce_edit_order_form" class="form d-flex flex-column flex-lg-row"
                      action="/invoices/create" modelAttribute="hoaDon">

                    <!--begin::Main column-->
                    <div class="d-flex flex-column flex-lg-row-fluid gap-7 gap-lg-10 mb-7 me-7">
                        <!--begin::Order details-->
                        <div class="card card-flush py-4">
                            <!--begin::Card body-->
                            <div class="card-body py-0">
                                <div class="d-flex flex-column gap-10">
                                    <!--begin::Table-->
                                    <table class="table align-middle table-row-dashed fs-6 gy-5"
                                           id="kt_ecommerce_edit_order_product_table">
                                        <thead>
                                        <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                            <th class="w-25px pe-2"></th>
                                            <th class="min-w-200px">Product</th>
                                            <th class="min-w-100px text-center pe-5">Qty</th>
                                            <th class="min-w-100px text-end pe-5">Total</th>
                                            <th class="w-25px pe-2"></th>
                                        </tr>
                                        </thead>
                                        <tbody class="fw-semibold text-gray-600">
                                        <c:forEach items="${cart}" var="cartItem">
                                            <tr>
                                                <td>
                                                    <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                        <input class="form-check-input" type="checkbox" value="1" checked disabled/>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="d-flex align-items-center"
                                                         data-kt-ecommerce-edit-order-filter="product"
                                                         data-kt-ecommerce-edit-order-id="product_${cartItem.sanPhamChiTiet.id}">
                                                        <!--begin::Thumbnail-->
                                                        <a href="apps/ecommerce/catalog/edit-product.html"
                                                           class="symbol symbol-50px">
                                                            <span class="symbol-label"
                                                                  style="background-image:url(${cartItem.sanPhamChiTiet.hinhAnh});"></span>
                                                        </a>
                                                        <!--end::Thumbnail-->
                                                        <div class="ms-5">
                                                            <!--begin::Title-->
                                                            <a href="apps/ecommerce/catalog/edit-product.html"
                                                               class="text-gray-800 text-hover-primary fs-5 fw-bold">${cartItem.sanPhamChiTiet.sanPham.ten} - ${cartItem.sanPhamChiTiet.ten}</a>
                                                            <!--end::Title-->
                                                            <!--begin::Price-->
                                                            <div class="fw-semibold fs-7">Price: $
                                                                <span data-kt-ecommerce-edit-order-filter="price">${cartItem.sanPhamChiTiet.donGia}</span>
                                                            </div>
                                                            <!--end::Price-->
                                                            <!--begin::SKU-->
                                                            <div class="text-muted fs-7">SKU: ${sanPham.maSP}</div>
                                                            <!--end::SKU-->
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end pe-5" data-order="5">
                                                    <div class="position-relative w-md-100px mx-auto">
                                                        <!--begin::Decrease control-->
                                                        <button onclick="location.href='/decrease-quantity-in-cart-item?cid=${cartItem.id}'" type="button"
                                                                class="btn btn-icon btn-active-color-gray-700 position-absolute translate-middle-y top-50 start-0"
                                                            ${cartItem.quantity < 2 ? "disabled" : ""}>
                                                            <i class="ki-outline ki-minus-square fs-1"></i>
                                                        </button>
                                                        <!--end::Decrease control-->

                                                        <!--begin::Input control-->
                                                        <input type="text" class="form-control form-control-solid border-0 ps-12" data-kt-dialer-control="input" placeholder="Amount" name="manageBudget" readonly="" value="${cartItem.quantity}">
                                                        <!--end::Input control-->

                                                        <!--begin::Increase control-->
                                                        <button onclick="location.href='/increase-quantity-in-cart-item?cid=${cartItem.id}'" type="button" class="btn btn-icon btn-active-color-gray-700 position-absolute translate-middle-y top-50 end-0">
                                                            <i class="ki-outline ki-plus-square fs-1"></i>
                                                        </button>
                                                        <!--end::Increase control-->
                                                    </div>
                                                </td>
                                                <td class="text-end pe-5" data-order="5">
                                                    <span class="fw-bold text-primary ms-3">${cartItem.quantity * cartItem.sanPhamChiTiet.donGia}</span>
                                                </td>
                                                <td>
                                                    <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                        <div><a href="/delete-item-in-cart?pdid=${cartItem.sanPhamChiTiet.id}"><i class="ki-duotone ki-trash fs-2">
                                                            <span class="path1"></span>
                                                            <span class="path2"></span>
                                                            <span class="path3"></span>
                                                            <span class="path4"></span>
                                                            <span class="path5"></span>
                                                        </i> </a></div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <!--end::Table-->
                                </div>
                            </div>
                            <!--end::Card header-->
                        </div>
                        <!--end::Order details-->

                        <div class="d-flex justify-content-end">
                            <!--begin::Button-->
                            <a href="/" id="kt_ecommerce_edit_order_cancel"
                               class="btn btn-light me-5">Huỷ</a>
                            <!--end::Button-->
                            <!--begin::Button-->
                            <button type="submit" id="kt_ecommerce_edit_order_submit" class="btn btn-primary" ${cart.size() == 0 ? "disabled" : ""}>
                                <span class="indicator-label">Mua hàng</span>
                                <span class="indicator-progress">Vui lòng đợi...
                                    <span class="spinner-border spinner-border-sm align-middle ms-2"></span>
                                </span>
                            </button>
                            <!--end::Button-->
                        </div>
                    </div>
                    <!--end::Main column-->
                    <!--begin::Aside column-->
                    <div class="w-100 flex-lg-row-auto w-lg-350px me-lg-10">
                        <!--begin::Order details-->
                        <div class="card card-flush py-4">
                            <!--begin::Card header-->
                            <div class="card-header">
                                <div class="card-title">
                                    <h2>Hoá đơn</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Card body-->
                            <div class="card-body pt-0">
                                <div class="d-flex flex-column gap-10">
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="form-label">Order ID</label>
                                        <!--end::Label-->
                                        <!--begin::Auto-generated ID-->
                                        <div class="fw-bold fs-3">#12594</div>
                                        <!--end::Input-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
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
                                </div>
                            </div>
                            <!--end::Card header-->
                        </div>
                        <!--end::Order details-->
                    </div>
                    <!--end::Aside column-->
                </form:form>
                <!--end::Form-->
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