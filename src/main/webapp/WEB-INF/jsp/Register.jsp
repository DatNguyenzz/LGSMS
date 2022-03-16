<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/lgin_reg_fgpw.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
</head>

<body class="img js-fullHeight" style="background-image: url(assets/image/bg4.webp);background-attachment: fixed;">
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
                        <h3 class="mb-4 text-center">Đăng Ký</h3>
                        <form id="form" action="/">
                            <!-- Nhập email -->
                            <div class="input-control">
                                <input id="email" name="email" type="text" class="form-control" placeholder="Tài khoản email">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập sđt -->
                            <div class="input-control">
                                <input id="phone" name="phone" type="tel" class="form-control" placeholder="Số điện thoại">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập mật khẩu -->
                            <div class="input-control">
                                <input id="password" name="password" type="password" class="form-control" placeholder="Mật khẩu">
                                <i class="fa fa-eye field-icon" id="togglePassword" style="margin-top: 25px;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Xác nhận mật khẩu -->
                            <div class="input-control">
                                <input id="re_password" name="re_password" type="password" class="form-control" placeholder="Xác nhận mật khẩu">
                                <i class="fa fa-eye field-icon" id="re_togglePassword" style="margin-top: 100px;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Đăng nhập btn -->
                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary submit px-3">Đăng ký</button>
                            </div>
                        </form>
                        <!-- URL tạo tài khoản -->
                        <div class="w-100 text-center">
                            <p>Bạn đã có tài khoản? <a href="Login.jsp" style="color: #fff; text-decoration: underline;"><b>Đăng nhập ngay!</b></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

    <script>
        // Lấy input
        const form = document.getElementById('form');
        const email = document.getElementById('email');
        const phone = document.getElementById('phone');
        const password = document.getElementById('password');
        const re_password = document.getElementById('re_password');
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
            //Điều kiện số điện thoại
        const isValidPhone = phone => {
                const re = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;
                return re.test(String(phone).toLowerCase());
            }
            //Trim input và các thông báo
        const validateInputs = () => {
            const phoneValue = phone.value.trim();
            const emailValue = email.value.trim();
            const passwordValue = password.value.trim();
            const re_passwordValue = re_password.value.trim();
            // Thông báo nhập số điện thoại
            if (phoneValue === '') {
                setError(phone, 'Yêu cầu nhập số điện thoại');
            } else if (!isValidPhone(phoneValue)) {
                setError(phone, 'Nhập đúng định dạng số điện thoại');
            } else {
                setSuccess(phone);
            }
            //Thông báo nhập địa chỉ email
            if (emailValue === '') {
                setError(email, 'Yêu cầu nhập địa chỉ email');
            } else if (!isValidEmail(emailValue)) {
                setError(email, 'Nhập đúng định dạng email');
            } else {
                setSuccess(email);
            }
            //Thông báo nhập mật khẩu
            if (passwordValue === '') {
                setError(password, 'Yêu cầu nhập mật khẩu');
            } else if (passwordValue.length < 8) {
                setError(password, 'Mật khẩu tối thiểu 8 kí tự.')
            } else {
                setSuccess(password);
            }
            //Thông báo xác nhận mật khảu
            if (re_passwordValue === '') {
                setError(re_password, 'Yêu cần xác nhận mật khẩu');
            } else if (re_passwordValue !== passwordValue) {
                setError(re_password, "Không trùng với mật khẩu");
            } else {
                setSuccess(re_password);
            }

        };
    </script><body class="img js-fullHeight" style="background-image: url(assets/image/bg4.webp);background-attachment: fixed;">
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
                        <h3 class="mb-4 text-center">Đăng Ký</h3>
                        <form id="form" action="/">
                            <!-- Nhập email -->
                            <div class="input-control">
                                <input id="email" name="email" type="text" class="form-control" placeholder="Tài khoản email">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập sđt -->
                            <div class="input-control">
                                <input id="phone" name="phone" type="tel" class="form-control" placeholder="Số điện thoại">
                                <div class="error"></div>
                            </div>
                            <!-- Nhập mật khẩu -->
                            <div class="input-control">
                                <input id="password" name="password" type="password" class="form-control" placeholder="Mật khẩu">
                                <i class="fa fa-eye field-icon" id="togglePassword" style="margin-top: 25px;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Xác nhận mật khẩu -->
                            <div class="input-control">
                                <input id="re_password" name="re_password" type="password" class="form-control" placeholder="Xác nhận mật khẩu">
                                <i class="fa fa-eye field-icon" id="re_togglePassword" style="margin-top: 100px;"></i>
                                <div class="error"></div>
                            </div>
                            <!-- Đăng nhập btn -->
                            <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary submit px-3">Đăng ký</button>
                            </div>
                        </form>
                        <!-- URL tạo tài khoản -->
                        <div class="w-100 text-center">
                            <p>Bạn đã có tài khoản? <a href="Login.jsp" style="color: #fff; text-decoration: underline;"><b>Đăng nhập ngay!</b></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>

    <script>
        // Lấy input
        const form = document.getElementById('form');
        const email = document.getElementById('email');
        const phone = document.getElementById('phone');
        const password = document.getElementById('password');
        const re_password = document.getElementById('re_password');
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
            //Điều kiện số điện thoại
        const isValidPhone = phone => {
                const re = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;
                return re.test(String(phone).toLowerCase());
            }
            //Trim input và các thông báo
        const validateInputs = () => {
            const phoneValue = phone.value.trim();
            const emailValue = email.value.trim();
            const passwordValue = password.value.trim();
            const re_passwordValue = re_password.value.trim();
            // Thông báo nhập số điện thoại
            if (phoneValue === '') {
                setError(phone, 'Yêu cầu nhập số điện thoại');
            } else if (!isValidPhone(phoneValue)) {
                setError(phone, 'Nhập đúng định dạng số điện thoại');
            } else {
                setSuccess(phone);
            }
            //Thông báo nhập địa chỉ email
            if (emailValue === '') {
                setError(email, 'Yêu cầu nhập địa chỉ email');
            } else if (!isValidEmail(emailValue)) {
                setError(email, 'Nhập đúng định dạng email');
            } else {
                setSuccess(email);
            }
            //Thông báo nhập mật khẩu
            if (passwordValue === '') {
                setError(password, 'Yêu cầu nhập mật khẩu');
            } else if (passwordValue.length < 8) {
                setError(password, 'Mật khẩu tối thiểu 8 kí tự.')
            } else {
                setSuccess(password);
            }
            //Thông báo xác nhận mật khảu
            if (re_passwordValue === '') {
                setError(re_password, 'Yêu cần xác nhận mật khẩu');
            } else if (re_passwordValue !== passwordValue) {
                setError(re_password, "Không trùng với mật khẩu");
            } else {
                setSuccess(re_password);
            }

        };
    </script>
    </body>
</html>