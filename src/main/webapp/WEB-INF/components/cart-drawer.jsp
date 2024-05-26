<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>Í
<div id="kt_drawer_chat" class="bg-body drawer drawer-end" data-kt-drawer="true" data-kt-drawer-name="chat"
     data-kt-drawer-activate="true" data-kt-drawer-overlay="true"
     data-kt-drawer-width="{default:'300px', 'md': '500px'}" data-kt-drawer-direction="end"
     data-kt-drawer-toggle="#kt_drawer_chat_toggle" data-kt-drawer-close="#kt_drawer_chat_close"
     style="width: 500px !important;">
    <!--begin::Messenger-->
    <div class="card w-100 border-0 rounded-0" id="kt_drawer_chat_messenger">
        <!--begin::Card header-->
        <div class="card-header pe-5" id="kt_drawer_chat_messenger_header">
            <!--begin::Title-->
            <div class="card-title">
                <!--begin::User-->
                <div class="d-flex justify-content-center flex-column me-3">
                    <a href="/cart" class="fs-4 fw-bold text-gray-900 text-hover-primary me-1 mb-2 lh-1">Giỏ hàng</a>
                </div>
                <!--end::User-->
            </div>
            <!--end::Title-->

            <!--begin::Card toolbar-->
            <div class="card-toolbar">
                <!--begin::Close-->
                <div class="btn btn-sm btn-icon btn-active-color-primary" id="kt_drawer_chat_close">
                    <i class="ki-outline ki-cross-square fs-2"></i></div>
                <!--end::Close-->
            </div>
            <!--end::Card toolbar-->
        </div>
        <!--end::Card header-->

        <!--begin::Card body-->
        <div class="card-body" id="kt_drawer_chat_messenger_body">
            <!--begin::Table-->
            <table class="table align-middle table-row-dashed fs-6 gy-5"
                   id="kt_ecommerce_edit_order_product_table">
                <thead>
                <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                    <th class="min-w-200px">Sản phẩm</th>
                    <th class="min-w-100px text-center pe-5">Số lượng</th>
                    <th class="min-w-100px text-end pe-5">Thành tiền</th>
                </tr>
                </thead>
                <tbody class="fw-semibold text-gray-600">
                <c:forEach items="${cart}" var="cartItem">
                    <tr>
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
                            <span class="fw-bold text-primary ms-3">${cartItem.quantity}</span>
                        </td>
                        <td class="text-end pe-5" data-order="5">
                            <span class="fw-bold text-primary ms-3">${cartItem.quantity * cartItem.sanPhamChiTiet.donGia}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--end::Table-->
            <!--begin::Total price-->
            <div class="fw-bold fs-4 text-end">Tổng tiền: $
                <span id="kt_ecommerce_edit_order_total_price">0.00</span></div>
            <!--end::Total price-->
        </div>
        <!--end::Card body-->

        <!--begin::Card footer-->
        <div class="card-footer pt-4" id="kt_drawer_chat_messenger_footer">
            <!--begin:Toolbar-->
            <div class="d-flex flex-end gap-2">
                <!--begin::Button checkout-->
                <button onclick="location.href='/checkout'" class="btn btn-primary" type="button" data-kt-element="send" ${cart.size() == 0 ? "disabled" : ""}>Chỉnh sửa thông tin</button>
                <!--end::Button checkout-->
            </div>
            <!--end::Toolbar-->
        </div>
        <!--end::Card footer-->
    </div>
    <!--end::Messenger-->
</div>