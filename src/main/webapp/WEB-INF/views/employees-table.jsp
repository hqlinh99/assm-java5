<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <title>${nhanVien.id != null ? "Chỉnh sửa thông tin nhân viên " += nhanVien.id : "Nhân viên" }</title>
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
                        Nhân viên</h1>
                    <!--end::Title-->
                    <!--begin::Breadcrumb-->
                    <ul class="breadcrumb breadcrumb-separatorless fw-semibold fs-7 my-0 pt-1">
                        <!--begin::Item-->
                        <li class="breadcrumb-item text-muted">
                            <a href="index.html" class="text-muted text-hover-primary">Trang chủ</a>
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
                                    <h2>Thông tin nhân viên</h2>
                                </div>
                            </div>
                            <!--end::Card header-->
                            <!--begin::Form-->
                            <form:form id="kt_account_profile_details_form"
                                       class="form fv-plugins-bootstrap5 fv-plugins-framework"
                                       action="/employees/create?id=${nhanVien.id}" method="post"
                                       modelAttribute="nhanVien"
                                       enctype="multipart/form-data">
                                <!--begin::Card body-->
                                <div class="card-body pt-0">
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Input-->
                                        <div class="image-input image-input-empty image-input-outline image-input-placeholder mb-3"
                                             data-kt-image-input="true">
                                            <!--begin::Preview existing avatar-->
                                            <div class="image-input-wrapper w-150px h-150px"
                                                 style="background-image: url('${nhanVien.hinhAnh}')">
                                            </div>
                                            <!--end::Preview existing avatar-->
                                            <!--begin::Label-->
                                            <label class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                   data-kt-image-input-action="change" data-bs-toggle="tooltip"
                                                   aria-label="Change avatar" data-bs-original-title="Change avatar"
                                                   data-kt-initialized="1">
                                                <i class="ki-duotone ki-pencil fs-7">
                                                    <span class="path1"></span>
                                                    <span class="path2"></span>
                                                </i>
                                                <!--begin::Inputs-->
                                                <input type="file" name="file" accept=".png, .jpg, .jpeg">
                                                <input type="hidden" name="avatar_remove">
                                                <!--end::Inputs-->
                                            </label>
                                            <!--end::Label-->
                                            <!--begin::Cancel-->
                                            <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                  data-kt-image-input-action="cancel" data-bs-toggle="tooltip"
                                                  aria-label="Cancel avatar" data-bs-original-title="Cancel avatar"
                                                  data-kt-initialized="1">
															<i class="ki-duotone ki-cross fs-2">
																<span class="path1"></span>
																<span class="path2"></span>
															</i>
														</span>
                                            <!--end::Cancel-->
                                            <!--begin::Remove-->
                                            <span class="btn btn-icon btn-circle btn-active-color-primary w-25px h-25px bg-body shadow"
                                                  data-kt-image-input-action="remove" data-bs-toggle="tooltip"
                                                  aria-label="Remove avatar" data-bs-original-title="Remove avatar"
                                                  data-kt-initialized="1">
															<i class="ki-duotone ki-cross fs-2">
																<span class="path1"></span>
																<span class="path2"></span>
															</i>
														</span>
                                            <!--end::Remove-->
                                        </div>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Tải lên ảnh nhân viên dưới dạng *.png, *.jpg
                                            and *.jpeg.
                                        </div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Mã nhân viên</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="maNV" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="maNV" class="form-control mb-2"
                                                    placeholder="Mã nhân viên"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập mã nhân viên.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Tên nhân viên</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="ten" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="ten" class="form-control mb-2"
                                                    placeholder="Tên nhân viên"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập tên nhân viên.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Tên đăng nhập</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="tenDangNhap" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="tenDangNhap" class="form-control mb-2"
                                                    placeholder="Tên đăng nhập"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập tên đăng nhập.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Mật khẩu</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="matKhau" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <form:input path="matKhau" type="password" class="form-control mb-2"
                                                    placeholder="Mật khẩu"/>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Nhập mật khẩu.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="mb-10 fv-row">
                                        <!--begin::Label-->
                                        <label class="required form-label">Chức vụ</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="matKhau" class="badge badge-light-danger"/>
                                        <!--end::Error-->
                                        <!--begin::Input-->
                                        <div class="d-flex gap-2">
                                            <!--begin::Radio-->
                                            <div class="form-check form-check-custom form-check-solid">
                                                <input class="form-check-input" name="chucVu" type="radio"
                                                       value="true" id="ql" checked/>
                                                <label class="form-check-label" for="ql">
                                                    Quản lý
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                            <!--begin::Radio-->
                                            <div class="form-check form-check-danger form-check-solid">
                                                <input class="form-check-input" name="chucVu" type="radio"
                                                       value="false"
                                                       id="nv" ${nhanVien.chucVu == false ? "checked" : ""}/>
                                                <label class="form-check-label" for="nv">
                                                    Nhân viên
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                        </div>
                                        <!--end::Input-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Chọn chức vụ.</div>
                                        <!--end::Description-->
                                    </div>
                                    <!--end::Input group-->
                                    <!--begin::Input group-->
                                    <div class="fv-row">
                                        <!--begin::Label-->
                                        <label class="form-label">Trạng thái</label>
                                        <!--end::Label-->
                                        <!--begin::Error-->
                                        <form:errors path="trangThai" class="badge badge-light-danger"/>
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
                                                       id="inactive" ${nhanVien.trangThai == false ? "checked" : ""}/>
                                                <label class="form-check-label" for="inactive">
                                                    Bị khoá
                                                </label>
                                            </div>
                                            <!--end::Radio-->
                                        </div>
                                        <!--end::Status-->
                                        <!--begin::Description-->
                                        <div class="text-muted fs-7">Chọn trạng thái cho nhân viên.
                                        </div>
                                        <!--end::Description-->
                                        <!--begin::Actions-->
                                        <div class="card-footer d-flex justify-content-end py-6 px-9">
                                            <a href="/employees/table" type="reset"
                                               class="btn btn-light btn-active-light-primary me-2">
                                                Làm mới
                                            </a>
                                            <button type="submit" class="btn btn-primary"
                                                    id="kt_account_profile_details_submit">Lưu nhân viên
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
                        <!--begin::Employees-->
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
                                               data-kt-ecommerce-product-filter="search"
                                               class="form-control form-control-solid w-250px ps-12 me-2"
                                               placeholder="Tìm kiếm nhân viên..."/>

                                        <button onclick="location.href='/employees/table?key='+document.getElementById('search-input').value"
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
                                                data-kt-ecommerce-product-filter="status"
                                                name="status"
                                                onchange="location.href='/employees/table?page=0&pageSize=${pageSize}&status='+this.value">
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
                                       id="kt_ecommerce_employees_table">
                                    <thead>
                                    <tr class="text-start text-gray-500 fw-bold fs-7 text-uppercase gs-0">
                                        <th class="w-10px pe-2">
                                            <div class="form-check form-check-sm form-check-custom form-check-solid me-3">
                                                <input class="form-check-input" type="checkbox" data-kt-check="true"
                                                       data-kt-check-target="#kt_ecommerce_employees_table .form-check-input"
                                                       value="1"/>
                                            </div>
                                        </th>
                                        <th class="min-w-100px">Mã nhân viên</th>
                                        <th class="min-w-200px">Tên nhân viên</th>
                                        <th class="min-w-100px">Tên đăng nhập</th>
                                        <th class="text-end min-w-100px">Trạng thái</th>
                                        <th class="text-end min-w-70px">Hành động</th>
                                    </tr>
                                    </thead>
                                    <tbody class="fw-semibold text-gray-600">
                                    <c:forEach items="${ePage.getContent()}" var="employee" varStatus="i">
                                        <tr>
                                            <td>
                                                <div class="form-check form-check-sm form-check-custom form-check-solid">
                                                    <input class="form-check-input" type="checkbox" value="1"/>
                                                </div>
                                            </td>
                                            <td class="pe-0">
                                                <span class="fw-bold">${employee.maNV}</span>
                                            </td>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <!--begin::Thumbnail-->
                                                    <a href="apps/ecommerce/catalog/edit-product.html"
                                                       class="symbol symbol-50px">
                                                    <span class="symbol-label"
                                                          style="background-image:url('${employee.hinhAnh}');"></span>
                                                    </a>
                                                    <!--end::Thumbnail-->
                                                    <div class="ms-5">
                                                        <!--begin::Title-->
                                                        <a href="apps/ecommerce/catalog/edit-employee.html"
                                                           class="text-gray-800 text-hover-primary fs-5 fw-bold"
                                                           data-kt-ecommerce-employee-filter="employee_name">${employee.ten}</a>
                                                        <!--end::Title-->
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="pe-0" data-order="6">
                                                <span class="fw-bold ms-3">${employee.tenDangNhap}</span>
                                            </td>
                                            <td class="text-end pe-0" data-order="Scheduled">
                                                <!--begin::Badges-->
                                                <div class="badge ${employee.trangThai ? "badge-light-primary" : "badge-light-danger"}">${employee.trangThai ? "Hoạt động" : "Bị khoá"}</div>
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
                                                        <a href="/employees/update?id=${employee.id}"
                                                           class="menu-link px-3">Sửa thông tin</a>
                                                    </div>
                                                    <!--end::Menu item-->
                                                    <!--begin::Menu item-->
                                                    <div class="menu-item px-3">
                                                        <a href="/employeess/delete?id=${employee.id}"
                                                           class="menu-link px-3"
                                                           data-kt-ecommerce-employee-filter="delete_row">Xoá nhân viên</a>
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
                                    <jsp:param name="e" value="employees"/>
                                </jsp:include>
                                <!--end::Pagination-->
                            </div>
                            <!--end::Card body-->
                        </div>
                        <!--end::Employees-->
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