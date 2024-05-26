<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="kt_app_sidebar" class="app-sidebar flex-column" data-kt-drawer="true" data-kt-drawer-name="app-sidebar"
     data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true" data-kt-drawer-width="275px"
     data-kt-drawer-direction="start" data-kt-drawer-toggle="#kt_app_sidebar_toggle">

    <!--begin::Logo-->
    <div class="d-flex flex-stack px-4 px-lg-6 py-3 py-lg-8" id="kt_app_sidebar_logo">
        <!--begin::Logo image-->
        <a href="/">
            <img alt="Logo" src="/public/assets/media/logos/demo23.svg" class="h-20px h-lg-25px theme-light-show">
            <img alt="Logo" src="/public/assets/media/logos/demo23-dark.svg" class="h-20px h-lg-25px theme-dark-show">
        </a>
        <!--end::Logo image-->

        <!--begin::User menu-->
        <div class="ms-3">
            <!--begin::Menu wrapper-->
            <div class="cursor-pointer position-relative symbol symbol-circle symbol-40px"
                 data-kt-menu-trigger="{default: 'click', lg: 'hover'}" data-kt-menu-attach="parent"
                 data-kt-menu-placement="bottom-end">
                <img src="${currentUser.hinhAnh}" alt="user">

                <div class="position-absolute rounded-circle bg-success start-100 top-100 h-8px w-8px ms-n3 mt-n3"></div>
            </div>

            <!--begin::User account menu-->
            <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg menu-state-color fw-semibold py-4 fs-6 w-275px"
                 data-kt-menu="true">
                <!--begin::Menu item-->
                <div class="menu-item px-3">
                    <div class="menu-content d-flex align-items-center px-3">
                        <!--begin::Avatar-->
                        <div class="symbol symbol-50px me-5">
                            <img alt="Logo" src="${currentUser.hinhAnh}">
                        </div>
                        <!--end::Avatar-->

                        <!--begin::Username-->
                        <div class="d-flex flex-column">
                            <div class="fw-bold d-flex align-items-center fs-5">
                                ${currentUser.ten} <span class="badge badge-light-success fw-bold fs-8 px-2 py-1 ms-2">Pro</span>
                            </div>

                            <a href="#" class="fw-semibold text-muted text-hover-primary fs-7">
                                ${currentUser.maNV} - ${currentUser.tenDangNhap} </a>
                        </div>
                        <!--end::Username-->
                    </div>
                </div>
                <!--end::Menu item-->

                <!--begin::Menu separator-->
                <div class="separator my-2"></div>
                <!--end::Menu separator-->

                <!--begin::Menu item-->
                <div class="menu-item px-5">
                    <a href="/public/account/overview.html" class="menu-link px-5">
                        Thông tin cá nhân
                    </a>
                </div>
                <!--end::Menu item-->

                <!--begin::Menu item-->
                <div class="menu-item px-5" data-kt-menu-trigger="{default: 'click', lg: 'hover'}"
                     data-kt-menu-placement="left-start" data-kt-menu-offset="-15px, 0">
                    <a href="#" class="menu-link px-5">
                        <span class="menu-title position-relative">
                            Chế độ
                            <span class="ms-5 position-absolute translate-middle-y top-50 end-0">
                                <i class="ki-outline ki-night-day theme-light-show fs-2"></i>
                                <i class="ki-outline ki-moon theme-dark-show fs-2"></i>
                            </span>
                        </span>
                    </a>

                    <!--begin::Menu-->
                    <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-title-gray-700 menu-icon-gray-500 menu-active-bg menu-state-color fw-semibold py-4 fs-base w-150px"
                         data-kt-menu="true" data-kt-element="theme-mode-menu">
                        <!--begin::Menu item-->
                        <div class="menu-item px-3 my-0">
                            <a href="#" class="menu-link px-3 py-2 active" data-kt-element="mode" data-kt-value="light">
                                <span class="menu-icon" data-kt-element="icon">
                                    <i class="ki-outline ki-night-day fs-2"></i>
                                </span>
                                <span class="menu-title">Sáng</span>
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3 my-0">
                            <a href="#" class="menu-link px-3 py-2" data-kt-element="mode" data-kt-value="dark">
                                <span class="menu-icon" data-kt-element="icon">
                                    <i class="ki-outline ki-moon fs-2"></i>
                                </span>
                                <span class="menu-title">Tối</span>
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3 my-0">
                            <a href="#" class="menu-link px-3 py-2" data-kt-element="mode" data-kt-value="system">
                                <span class="menu-icon" data-kt-element="icon">
                                    <i class="ki-outline ki-screen fs-2"></i>
                                </span>
                                <span class="menu-title">Hệ thống</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                    </div>
                    <!--end::Menu-->

                </div>
                <!--end::Menu item-->

                <!--begin::Menu item-->
                <div class="menu-item px-5" data-kt-menu-trigger="{default: 'click', lg: 'hover'}"
                     data-kt-menu-placement="left-start" data-kt-menu-offset="-15px, 0">
                    <a href="#" class="menu-link px-5">
                        <span class="menu-title position-relative">
                            Ngôn ngữ
                            <span class="fs-8 rounded bg-light px-3 py-2 position-absolute translate-middle-y top-50 end-0">
                                Tiếng việt
                                <img class="w-15px h-15px rounded-1 ms-2" src="/public/assets/media/flags/united-states.svg"
                                     alt="">
                            </span>
                        </span>
                    </a>

                    <!--begin::Menu sub-->
                    <div class="menu-sub menu-sub-dropdown w-175px py-4">
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="/public/account/settings.html" class="menu-link d-flex px-5 active">
                                <span class="symbol symbol-20px me-4">
                                    <img class="rounded-1" src="/public/assets/media/flags/united-states.svg" alt="">
                                </span>
                                English
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="/public/account/settings.html" class="menu-link d-flex px-5">
                                <span class="symbol symbol-20px me-4">
                                    <img class="rounded-1" src="/public/assets/media/flags/spain.svg" alt="">
                                </span>
                                Española
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="/public/account/settings.html" class="menu-link d-flex px-5">
                                <span class="symbol symbol-20px me-4">
                                    <img class="rounded-1" src="/public/assets/media/flags/germany.svg" alt="">
                                </span>
                                Deutsch
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="/public/account/settings.html" class="menu-link d-flex px-5">
                                <span class="symbol symbol-20px me-4">
                                    <img class="rounded-1" src="/public/assets/media/flags/japan.svg" alt="">
                                </span>
                                日本語
                            </a>
                        </div>
                        <!--end::Menu item-->

                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="/public/account/settings.html" class="menu-link d-flex px-5">
                                <span class="symbol symbol-20px me-4">
                                    <img class="rounded-1" src="/public/assets/media/flags/france.svg" alt="">
                                </span>
                                Française
                            </a>
                        </div>
                        <!--end::Menu item-->
                    </div>
                    <!--end::Menu sub-->
                </div>
                <!--end::Menu item-->

                <!--begin::Separator-->
                <div class="separator my-2"></div>
                <!--end::Separator-->

                <!--begin::Menu item-->
                <div class="menu-item px-5 my-1">
                    <a href="/public/account/settings.html" class="menu-link px-5">
                        Thiết lập
                    </a>
                </div>
                <!--end::Menu item-->

                <!--begin::Menu item-->
                <div class="menu-item px-5">
                    <a href="/logout" class="menu-link px-5">
                        Đăng xuất
                    </a>
                </div>
                <!--end::Menu item-->
            </div>
            <!--end::User account menu-->
            <!--end::Menu wrapper-->
        </div>
        <!--end::User menu-->
    </div>
    <!--end::Logo-->

    <!--begin::Sidebar nav-->
    <div class="flex-column-fluid px-4 px-lg-8 py-4" id="kt_app_sidebar_nav">
        <!--begin::Nav wrapper-->
        <div id="kt_app_sidebar_nav_wrapper" class="d-flex flex-column hover-scroll-y pe-4 me-n4" data-kt-scroll="true"
             data-kt-scroll-activate="true" data-kt-scroll-height="auto"
             data-kt-scroll-dependencies="#kt_app_sidebar_logo, #kt_app_sidebar_footer"
             data-kt-scroll-wrappers="#kt_app_sidebar, #kt_app_sidebar_nav" data-kt-scroll-offset="5px"
             style="height: 248px;">
            <!--begin::Progress-->
            <div class="d-flex align-items-center flex-column w-100 mb-6">
                <div class="d-flex justify-content-between fw-bolder fs-6 text-gray-800  w-100 mt-auto mb-3">
                    <span>Mục tiêu của bạn</span>
                </div>

                <div class="w-100 bg-light-primary rounded mb-2" style="height: 24px">
                    <div class="bg-primary rounded" role="progressbar" style="height: 24px; width: 37%;"
                         aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                </div>

                <div class="fw-semibold fs-7 text-primary w-100 mt-auto">
                    <span>đã đạt được 37%</span>
                </div>
            </div>
            <!--end::Progress-->

            <!--begin::Stats-->
            <div class="d-flex mb-3 mb-lg-6">
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 me-6">
                    <!--begin::Date-->
                    <span class="fs-6 text-gray-500 fw-bold">Hiện tại</span>
                    <!--end::Date-->

                    <!--begin::Label-->
                    <div class="fs-2 fw-bold text-success">$300</div>
                    <!--end::Label-->
                </div>
                <!--end::Stat-->
                <!--begin::Stat-->
                <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 ">
                    <!--begin::Date-->
                    <span class="fs-6 text-gray-500 fw-bold">Mục tiêu</span>
                    <!--end::Date-->

                    <!--begin::Label-->
                    <div class="fs-2 fw-bold text-danger">$1,000</div>
                    <!--end::Label-->
                </div>
                <!--end::Stat-->

            </div>
            <!--end::Stats-->

            <!--begin::Links-->
            <div class="mb-6">
                <!--begin::Title-->
                <h3 class="text-gray-800 fw-bold mb-8">Quản lý</h3>
                <!--end::Title-->
                <!--begin::Row-->
                <div class="row row-cols-3" data-kt-buttons="true" data-kt-buttons-target="[data-kt-button]"
                     data-kt-initialized="1">
                    <!--begin::Col-->
                    <div class="col mb-4">
                        <!--begin::Link-->
                        <a href="/invoices/table"
                           class="btn btn-icon btn-outline btn-bg-light btn-active-light-primary btn-flex flex-column flex-center w-lg-90px h-lg-90px w-70px h-70px border-gray-200"
                           data-kt-button="true">
                            <!--begin::Icon-->
                            <span class="mb-2">
                                <i class="ki-outline ki-bill fs-1"></i>
                            </span>
                            <!--end::Icon-->

                            <!--begin::Label-->
                            <span class="fs-7 fw-bold">Hoá đơn</span>
                            <!--end::Label-->
                        </a>
                        <!--end::Link-->
                    </div>
                    <!--end::Col-->
                    <!--begin::Col-->
                    <div class="col mb-4">
                        <!--begin::Link-->
                        <a href="/products/table"
                           class="btn btn-icon btn-outline btn-bg-light btn-active-light-primary btn-flex flex-column flex-center w-lg-90px h-lg-90px w-70px h-70px border-gray-200"
                           data-kt-button="true">
                            <!--begin::Icon-->
                            <span class="mb-2">
                                <i class="ki-outline ki-element-2 fs-1"></i>
                            </span>
                            <!--end::Icon-->

                            <!--begin::Label-->
                            <span class="fs-7 fw-bold">Sản phẩm</span>
                            <!--end::Label-->
                        </a>
                        <!--end::Link-->
                    </div>
                    <!--end::Col-->
                    <!--begin::Col-->
                    <div class="col mb-4">
                        <!--begin::Link-->
                        <a href="/customers/table"
                           class="btn btn-icon btn-outline btn-bg-light btn-active-light-primary btn-flex flex-column flex-center w-lg-90px h-lg-90px w-70px h-70px border-gray-200"
                           data-kt-button="true">
                            <!--begin::Icon-->
                            <span class="mb-2">
                                <i class="ki-outline ki-user-square fs-1"></i>
                            </span>
                            <!--end::Icon-->

                            <!--begin::Label-->
                            <span class="fs-7 fw-bold">Khách hàng</span>
                            <!--end::Label-->
                        </a>
                        <!--end::Link-->
                    </div>
                    <!--end::Col-->
                    <!--begin::Col-->
                    <div class="col mb-4">
                        <!--begin::Link-->
                        <a href="/employees/table"
                           class="btn btn-icon btn-outline btn-bg-light btn-active-light-primary btn-flex flex-column flex-center w-lg-90px h-lg-90px w-70px h-70px border-gray-200"
                           data-kt-button="true">
                            <!--begin::Icon-->
                            <span class="mb-2">
                                <i class="ki-outline ki-user-edit fs-1"></i>
                            </span>
                            <!--end::Icon-->

                            <!--begin::Label-->
                            <span class="fs-7 fw-bold">Nhân viên</span>
                            <!--end::Label-->
                        </a>
                        <!--end::Link-->
                    </div>
                    <!--end::Col-->
                </div>
                <!--end::Row-->
            </div>
            <!--end::Links-->


        </div>
        <!--end::Nav wrapper-->
    </div>
    <!--end::Sidebar nav-->

</div>