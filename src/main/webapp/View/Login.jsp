<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../../css/lgin_reg_fgpw.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
</head>

<body class="img js-fullHeight" style="background-image: url(../../assets/image/bg4.webp); background-attachment: fixed;">
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <a href="home.jsp">
                        <span class="iconify" data-icon="ic:twotone-gas-meter" style="color: white;" data-width="80" data-height="80"></span>
                        <h2 class="heading-section">LGSMS</h2>
                    </a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4" style="background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);">
                    <div class="login-wrap p-0">
                        <h3 class="mb-4 text-center">Đăng Nhập</h3>
                        <!-- Form đăng nhập -->
                        <form id="form" action="/">
                            <!-- Nhập email -->
                            <div class="input-control">
                                <input id="email" name="email" type="text" class="form-control" placeholder="Email/Tên đăng nhập">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập mật khẩu -->
                            <div class="input-control">
                                <input id="password" name="password" type="password" class="form-control" placeholder="Mật khẩu">
                                <i class="fa fa-eye field-icon" id="togglePassword" style="margin-top: auto;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Đăng nhập btn -->
                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary submit px-3"><a href="view_profile.jsp">Đăng nhập</a></button>
                            </div>
                            <div class="form-group w-100 text-center">
                                <a href="forgot_password.jsp" style="color: #fff; text-decoration: underline;">Quên mật khẩu?</a>
                            </div>
                        </form>
                        <!-- URL tạo tài khoản -->
                        <div class="w-100 text-center">
                            <p>Bạn chưa có tài khoản? <a href="Register.jsps" style="color: #fff; text-decoration: underline;"><b>Đăng ký
								ngay!</b></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/popper.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/main.js"></script>
    <script>
        // Lấy input
        const form = document.getElementById('form');
        const email = document.getElementById('email');
        const password = document.getElementById('password');

        //Chạy hàm validate
        form.addEventListener('submit', e => {
            e.preventDefault();
            validateInputs();
        });
        //Xét điều kiện để hiện thông báo lỗi
        const setError = (element, message) => {
                const inputControl = element.parentElement;
                const errorDisplay = inputControl.querySelector('.error');

                errorDisplay.innerText = message;
                inputControl.classList.add('error');
                inputControl.classList.remove('success')
            }
            //Xét điều kiện để hiện thông báo thành công
        const setSuccess = element => {
            const inputControl = element.parentElement;
            const errorDisplay = inputControl.querySelector('.error');

            errorDisplay.innerText = '';
            inputControl.classList.add('success');
            inputControl.classList.remove('error');
        };
        //Điều kiện email
        const isValidEmail = email => {
            const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(String(email).toLowerCase());
        }


        //Trim input và các thông báo
        const validateInputs = () => {

            const emailValue = email.value.trim();
            const passwordValue = password.value.trim();

            if (emailValue === '') {
                setError(email, 'Yêu cầu nhập địa chỉ email');
            } else if (!isValidEmail(emailValue)) {
                setError(email, 'Nhập đúng định dạng email');
            } else {
                setSuccess(email);
            }

            if (passwordValue === '') {
                setError(password, 'Yêu cầu nhập mật khẩu');
            } else if (passwordValue.length < 8) {
                setError(password, 'Mật khẩu tối thiểu 8 kí tự.')
            } else {
                setSuccess(password);
            }

        };
    </script>
</body>

</html>