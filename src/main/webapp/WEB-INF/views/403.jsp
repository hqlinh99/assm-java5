<c:if test="${!nhanVien.chucVu}">
    <!--begin::Alert-->
    <div class="alert alert-dismissible bg-light-danger d-flex flex-center flex-column py-10 px-10 px-lg-20 mb-10">
        <!--begin::Close-->
        <button type="button" class="position-absolute top-0 end-0 m-2 btn btn-icon btn-icon-danger"
                data-bs-dismiss="alert">
            <i class="ki-duotone ki-cross fs-1"><span class="path1"></span><span class="path2"></span></i>
        </button>
        <!--end::Close-->

        <!--begin::Icon-->
        <i class="ki-duotone ki-information-5 fs-5tx text-danger mb-5"><span class="path1"></span><span
                class="path2"></span><span class="path3"></span></i>
        <!--end::Icon-->

        <!--begin::Wrapper-->
        <div class="text-center">
            <!--begin::Title-->
            <h1 class="fw-bold mb-5">This is an alert</h1>
            <!--end::Title-->

            <!--begin::Separator-->
            <div class="separator separator-dashed border-danger opacity-25 mb-5"></div>
            <!--end::Separator-->

            <!--begin::Content-->
            <div class="mb-9 text-gray-900">
                The alert component can be used to highlight certain parts of your page for <strong>higher content
                visibility</strong>.<br/>
                Please read our <a href="#" class="fw-bold me-1">Terms and Conditions</a> for more info.
            </div>
            <!--end::Content-->

            <!--begin::Buttons-->
            <div class="d-flex flex-center flex-wrap">
                <a href="#" class="btn btn-outline btn-outline-danger btn-active-danger m-2">Cancel</a>
                <a href="#" class="btn btn-danger m-2">Ok, I got it</a>
            </div>
            <!--end::Buttons-->
        </div>
        <!--end::Wrapper-->
    </div>
    <!--end::Alert-->
</c:if>