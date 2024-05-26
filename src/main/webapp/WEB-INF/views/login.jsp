<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<!--begin::Head-->
<head>
    <title>Đăng nhập</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta property="og:locale" content="en_US"/>
    <meta property="og:type" content="article"/>
    <meta property="og:title" content="Metronic - The World's #1 Selling Bootstrap Admin Template by KeenThemes"/>
    <meta property="og:url" content="https://keenthemes.com/metronic"/>
    <meta property="og:site_name" content="Metronic by Keenthemes"/>
    <link rel="canonical" href="https://preview.keenthemes.com/public/authentication/layouts/corporate/sign-in.html"/>
    <link rel="shortcut icon" href="/public/assets/media/logos/favicon.ico"/>

    <!--begin::Fonts(mandatory for all pages)-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300,400,500,600,700"/>
    <!--end::Fonts-->


    <!--begin::Global Stylesheets Bundle(mandatory for all pages)-->
    <link href="/public/assets/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css"/>
    <link href="/public/assets/css/style.bundle.css" rel="stylesheet" type="text/css"/>
    <!--end::Global Stylesheets Bundle-->

</head>
<!--end::Head-->

<!--begin::Body-->
<body id="kt_body" class="app-blank">
<!--begin::Theme mode setup on page load-->
<script>
    var defaultThemeMode = "light";
    var themeMode;

    if (document.documentElement) {
        if (document.documentElement.hasAttribute("data-bs-theme-mode")) {
            themeMode = document.documentElement.getAttribute("data-bs-theme-mode");
        } else {
            if (localStorage.getItem("data-bs-theme") !== null) {
                themeMode = localStorage.getItem("data-bs-theme");
            } else {
                themeMode = defaultThemeMode;
            }
        }

        if (themeMode === "system") {
            themeMode = window.matchMedia("(prefers-color-scheme: dark)").matches ? "dark" : "light";
        }

        document.documentElement.setAttribute("data-bs-theme", themeMode);
    }
</script>
<!--end::Theme mode setup on page load-->

<!--begin::Root-->
<div class="d-flex flex-column flex-root" id="kt_app_root">

    <!--begin::Authentication - Sign-in -->
    <div class="d-flex flex-column flex-lg-row flex-column-fluid">
        <!--begin::Body-->
        <div class="d-flex flex-column flex-lg-row-fluid w-lg-50 p-10 order-2 order-lg-1">
            <!--begin::Form-->
            <div class="d-flex flex-center flex-column flex-lg-row-fluid">
                <!--begin::Wrapper-->
                <div class="w-lg-500px p-10">

                    <!--begin::Form-->
                    <form:form class="form w-100" novalidate="novalidate" id="kt_sign_in_form" method="post"
                               action="/login" modelAttribute="auth">
                        <!--begin::Heading-->
                        <div class="text-center mb-11">
                            <!--begin::Title-->
                            <h1 class="text-gray-900 fw-bolder mb-3">
                                Đăng Nhập
                            </h1>
                            <!--end::Title-->

                            <!--begin::Subtitle-->
                            <div class="text-gray-500 fw-semibold fs-6">
                                Đăng nhập để mua hàng
                            </div>
                            <!--end::Subtitle--->
                        </div>
                        <!--begin::Heading-->

                        <!--begin::Login options-->
                        <div class="row g-3 mb-9">
                            <!--begin::Col-->
                            <div class="col-md-6">
                                <!--begin::Google link--->
                                <a href="#"
                                   class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                    <img alt="Logo" src="/public/assets/media/svg/brand-logos/google-icon.svg"
                                         class="h-15px me-3"/>
                                    Đăng nhập với Google
                                </a>
                                <!--end::Google link--->
                            </div>
                            <!--end::Col-->

                            <!--begin::Col-->
                            <div class="col-md-6">
                                <!--begin::Google link--->
                                <a href="#"
                                   class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                    <img alt="Logo" src="/public/assets/media/svg/brand-logos/apple-black.svg"
                                         class="theme-light-show h-15px me-3"/>
                                    <img alt="Logo" src="/public/assets/media/svg/brand-logos/apple-black-dark.svg"
                                         class="theme-dark-show h-15px me-3"/>
                                    Đăng nhập với Apple
                                </a>
                                <!--end::Google link--->
                            </div>
                            <!--end::Col-->
                        </div>
                        <!--end::Login options-->

                        <!--begin::Separator-->
                        <div class="separator separator-content my-14">
                            <span class="w-125px text-gray-500 fw-semibold fs-7">Hoặc với tên đăng nhập</span>
                        </div>
                        <!--end::Separator-->

                        <!--begin::Error-->
                        <div class="text-center mb-2">
                            <span class="badge badge-light-danger mb-2">${message}</span>
                        </div>
                        <!--end::Error-->

                        <!--begin::Input group--->
                        <div class="fv-row mb-8 position-relative">
                            <!--begin::Email-->
                            <input type="text" placeholder="Tên đăng nhập" name="username" autocomplete="off"
                                   value="${auth.username}"
                                   class="form-control bg-transparent"/>
                            <!--end::Email-->
                            <!--begin::Error-->
                            <form:errors path="username" style="top: 0px; right: 0px"
                                         class="position-absolute badge badge-light-danger"/>
                            <!--end::Error-->
                        </div>

                        <!--end::Input group--->
                        <div class="fv-row mb-3 position-relative">
                            <!--begin::Password-->
                            <input type="password" placeholder="Mật khẩu" name="password" autocomplete="off"
                                   value="${auth.password}"
                                   class="form-control bg-transparent"/>
                            <!--end::Password-->

                            <!--begin::Error-->
                            <form:errors path="password" style="top: 0px; right: 0px"
                                         class="position-absolute badge badge-light-danger"/>
                            <!--end::Error-->
                        </div>
                        <!--end::Input group--->

                        <!--begin::Wrapper-->
                        <div class="d-flex flex-stack flex-wrap gap-3 fs-base fw-semibold mb-8">
                            <div></div>

                            <!--begin::Link-->
                            <a href="/public/authentication/layouts/corporate/reset-password.html" class="link-primary">
                                Quên mật khẩu ?
                            </a>
                            <!--end::Link-->
                        </div>
                        <!--end::Wrapper-->

                        <!--begin::Submit button-->
                        <div class="d-grid mb-10">
                            <button type="submit" id="kt_sign_in_submit" class="btn btn-primary">

                                <!--begin::Indicator label-->
                                <span class="indicator-label">Đăng nhập</span>
                                <!--end::Indicator label-->

                            </button>
                        </div>
                        <!--end::Submit button-->

                        <!--begin::Sign up-->
                        <div class="text-gray-500 text-center fw-semibold fs-6">
                            Bạn chưa có tài khoản?

                            <a href="/public/authentication/layouts/corporate/sign-up.html" class="link-primary">
                                Đăng ký
                            </a>
                        </div>
                        <!--end::Sign up-->
                    </form:form>
                    <!--end::Form-->
                </div>
                <!--end::Wrapper-->
            </div>
            <!--end::Form-->

            <!--begin::Footer-->
            <div class="w-lg-500px d-flex flex-stack px-10 mx-auto">
                <!--begin::Languages-->
                <div class="me-10">
                    <!--begin::Toggle-->
                    <button class="btn btn-flex btn-link btn-color-gray-700 btn-active-color-primary rotate fs-base"
                            data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start"
                            data-kt-menu-offset="0px, 0px">
                        <img data-kt-element="current-lang-flag" class="w-20px h-20px rounded me-3"
                             src="/public/assets/media/flags/united-states.svg" alt=""/>

                        <span data-kt-element="current-lang-name" class="me-1">Tiếng Việt</span>

                        <span class="d-flex flex-center rotate-180">
                            <i class="ki-outline ki-down fs-5 text-muted m-0"></i>
                        </span>
                    </button>
                    <!--end::Toggle-->

                    <!--begin::Menu-->
                    <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg-light-primary fw-semibold w-200px py-4 fs-7"
                         data-kt-menu="true" id="kt_auth_lang_menu">
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="#" class="menu-link d-flex px-5" data-kt-lang="English">
                                <span class="symbol symbol-20px me-4">
                                    <img data-kt-element="lang-flag" class="rounded-1"
                                         src="/public/assets/media/flags/united-states.svg" alt=""/>
                                </span>
                                <span data-kt-element="lang-name">English</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="#" class="menu-link d-flex px-5" data-kt-lang="Spanish">
                                <span class="symbol symbol-20px me-4">
                                    <img data-kt-element="lang-flag" class="rounded-1"
                                         src="/public/assets/media/flags/spain.svg" alt=""/>
                                </span>
                                <span data-kt-element="lang-name">Spanish</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="#" class="menu-link d-flex px-5" data-kt-lang="German">
                                <span class="symbol symbol-20px me-4">
                                    <img data-kt-element="lang-flag" class="rounded-1"
                                         src="/public/assets/media/flags/germany.svg" alt=""/>
                                </span>
                                <span data-kt-element="lang-name">German</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="#" class="menu-link d-flex px-5" data-kt-lang="Japanese">
                                <span class="symbol symbol-20px me-4">
                                    <img data-kt-element="lang-flag" class="rounded-1"
                                         src="/public/assets/media/flags/japan.svg" alt=""/>
                                </span>
                                <span data-kt-element="lang-name">Japanese</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                        <!--begin::Menu item-->
                        <div class="menu-item px-3">
                            <a href="#" class="menu-link d-flex px-5" data-kt-lang="French">
                                <span class="symbol symbol-20px me-4">
                                    <img data-kt-element="lang-flag" class="rounded-1"
                                         src="/public/assets/media/flags/france.svg" alt=""/>
                                </span>
                                <span data-kt-element="lang-name">French</span>
                            </a>
                        </div>
                        <!--end::Menu item-->
                    </div>
                    <!--end::Menu-->
                </div>
                <!--end::Languages-->

                <!--begin::Links-->
                <div class="d-flex fw-semibold text-primary fs-base gap-5">
                    <a href="/public/pages/team.html" target="_blank">Điều khoản</a>

                    <a href="/public/pages/pricing/column.html" target="_blank">Kế hoạch</a>

                    <a href="/public/pages/contact.html" target="_blank">Liên hệ</a>
                </div>
                <!--end::Links-->
            </div>
            <!--end::Footer-->
        </div>
        <!--end::Body-->

        <!--begin::Aside-->
        <div class="d-flex flex-lg-row-fluid w-lg-50 bgi-size-cover bgi-position-center order-1 order-lg-2"
             style="background-image: url('https://elements-cover-images-0.imgix.net/18e4fb9e-0035-4ed3-a504-4751d3b62e06?auto=compress%2Cformat&w=900&fit=max&s=04d4ffe418b1c65a7af45b16b5da9b91')">
        </div>
        <!--end::Aside-->
    </div>
    <!--end::Authentication - Sign-in-->

</div>
<!--end::Root-->

<!--begin::Javascript-->
<script>
    var hostUrl = "/public/assets/";
</script>

<!--begin::Global Javascript Bundle(mandatory for all pages)-->
<script src="/public/assets/plugins/global/plugins.bundle.js"></script>
<script src="/public/assets/js/scripts.bundle.js"></script>
<!--end::Global Javascript Bundle-->
<!--end::Javascript-->
</body>
<!--end::Body-->
</html>