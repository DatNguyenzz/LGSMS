<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<% String emailMessage =  (String)request.getAttribute("emailMessage"); 
    
%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-acount
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="Staff_LGSMS/css/lgin_reg_fgpw.css">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>
    <body class="img js-fullHeight" style="background-image: url(Staff_LGSMS/assets/image/bg4.webp); background-attachment: fixed;">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <a href="<%=request.getContextPath()%>/Home">
                            <img src="Staff_LGSMS/assets/image/logophuoc-01.PNG" width="150" height="180" style="padding-bottom: 5%;">
                        </a>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4" style="background-color: rgba(28, 100, 168, 0.521); border: 5px solid rgb(117, 105, 105);">
                        <div class="text-center">
                            <h3 class="mb-4 text-center">Quên mật khẩu?</h3>
                            <p class="mb-4">Bạn hãy nhập địa chỉ email đã đăng ký, chúng tôi sẽ gửi cho bạn một mã xác nhận qua email.</p>
                        </div>
                        <form action="<%=request.getContextPath()%>/ForgotPassword" method="post" id="form">
                            <div class="form-group">
                                <input type="text" class="form-control" name="email" id="email" placeholder="Nhập địa chỉ email của bạn" maxlength="50">
                                
                                <% if(emailMessage!=null){%>
                                <div class="fail"  style="color:#ff3860;" > &emsp;<%=request.getAttribute("emailMessage")%> </div>
                               <%}%>
                                <div class="fail"></div>
                            </div>
                            <button type="submit"  class="form-control btn btn-primary submit px-3">Gửi Email</button>
                        </form>
                        <br>
                    </div>

                </div>
            </div>

        </section>
        <!--js for toggle menu-->
        <!-- <script src="/js/header.js"></script> -->
        <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
        <script src="Customer_LGSMS/js/include-html.min.js"></script>
        <script src="Customer_LGSMS/js/fnon.min.js"></script>
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script>
            const form = document.getElementById('form');
            const email = document.getElementById('email');
            const validateInputs = () => {
                const emailValue = email.value.trim();

                //Thông báo nhập địa chỉ email
                if (emailValue === '') {
                    setError(email, 'Yêu cầu nhập địa chỉ email');
                } else if (!isValidEmail(emailValue)) {
                    setError(email, 'Nhập đúng định dạng email your@example.com');
                } else {
                    setSuccess(email);
                }
            }
            form.addEventListener('submit', e => {
                e.preventDefault();
                x = 0;
                validateInputs();
                if (x == 1) {
                    document.getElementById("form").submit();
                }

            });
        </script>

    </body>

</html>