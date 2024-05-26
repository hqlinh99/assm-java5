<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!currentUser.chucVu}">
    <!--begin::Alert-->
    <div class="alert alert-dismissible bg-light d-flex flex-center flex-column py-10 px-10 px-lg-20 mb-10">

        <!--begin::Icon-->
        <i class="ki-duotone ki-information-5 fs-5tx text-danger mb-5"><span class="path1"></span><span
                class="path2"></span><span class="path3"></span></i>
        <!--end::Icon-->

        <!--begin::Wrapper-->
        <div class="text-center">
            <!--begin::Title-->
            <h1 class="fw-bold mb-5">Cảnh báo</h1>
            <!--end::Title-->

            <!--begin::Separator-->
            <div class="separator separator-dashed border-danger opacity-25 mb-5"></div>
            <!--end::Separator-->

            <!--begin::Content-->
            <div class="mb-9 text-gray-900">
                Bạn không có quyền thực hiện chức năng này!
            </div>
            <!--end::Content-->

            <!--begin::Buttons-->
            <div class="d-flex flex-center flex-wrap">
                <a href="/" class="btn btn-outline btn-outline-danger btn-active-danger m-2">Trang chủ</a>
                <a href="/logout" class="btn btn-danger m-2">Đăng xuất</a>
            </div>
            <!--end::Buttons-->
        </div>
        <!--end::Wrapper-->
    </div>
    <!--end::Alert-->
</c:if>