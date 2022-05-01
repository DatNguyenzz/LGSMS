<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Account"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            LGSMS-Profile
        </title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <link href="Customer_LGSMS/css/profile.css" rel="stylesheet" type="text/css">
        <link href="Customer_LGSMS/css/custom_box.css" rel="stylesheet" type="text/css">
        <link href="Customer_LGSMS/css/fnon.min.css" rel="stylesheet" type="text/css">
    </head>
    <%
        Account account = (Account) request.getSession().getAttribute("account");
    %>
    <body>
        <div class="header">
            <div include-html="Customer_LGSMS/view/header.jsp" id="header">
            </div>
        </div>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">

                <div class="col-md-3">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center">
                            <h4 class="far fa-user"> Tài Khoản Của Tôi</h4>
                        </div>
                        <div class="col-md-12 ml-3"><a href="<%=request.getContextPath()%>/MyProfile" class="d-flex justify-content-between align-items-center">Hồ Sơ</a></div>
                        <div class="col-md-12 ml-3"><a href="<%=request.getContextPath()%>/ChangePassword" class="d-flex justify-content-between align-items-center">Đổi Mật Khẩu</a></div><br>

                    </div>
                </div>

                <div class="col-md-5 border-left">
                    <form aciton="<%=request.getContextPath()%>/MyProfile" method="POST" id="form">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Hồ Sơ Của Tôi</h4>
                            </div>
                            <div class="row mt-2">
                               
                                <div class="form-group">
                                    <label class="labels">Họ và Tên</label>
                                    <input type="text" class="form-control" name="fullname"
                                           placeholder="<%=account.getFullname()%>" 
                                           value="<%=account.getFullname()%>"
                                           id="user-name" maxlength="50"/>
                                    <div class="fail"></div>
                                </div>

                                <div class="form-group">
                                    <label for="gender" class="col-form-label">Giới tính:</label>
                                        <select class="form-control" name="gender" id="gender">
                                            <option value="true" >Nam</option>
                                            <option value="false" <% if(!account.isGender()){ %> selected <%}%>>Nữ</option>
                                        </select><br>
                                    
                                </div>

                                <div class="form-group">
                                    <label class="labels">Ngày Sinh</label>
                                    <input type="date" class="form-control" name="dob"
                                           placeholder="<%=account.getDOB()%>" 
                                           value="<%=account.getDOB()%>" id="user-dob" />
                                    <div class="fail"></div>
                                </div>

                            </div>
                            <div class="row mt-3">
                                
                                <div class="form-group">
                                    <label class="labels">Email</label>
                                    <input type="text" class="form-control" name="email"
                                           placeholder="<%=account.getEmail()%>" 
                                           value="<%=account.getEmail()%>" id="user-email"  
                                           maxlength="255"/>
                                    <div class="fail"></div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="labels">Điện Thoại</label>
                                    <input type="number" class="form-control" name="phone"
                                           placeholder="<%=account.getPhone()%>" 
                                           value="<%=account.getPhone()%>"
                                        id="user-phone"  maxlength="15"/>
                                    <div class="fail"></div>
                                </div>
                                <div class="form-group">
                                    <label class="labels">Địa Chỉ</label>
                                    <input type="text" class="form-control" name="address"
                                           placeholder="<%=account.getAddress()%>" 
                                           value="<%=account.getAddress()%>"
                                        id="user-address" maxlength="500" />
                                    <div class="fail"></div>
                                </div>
                                
                            </div>
                            <div class="mt-3 float-right text-center">
                                <input class="btn btn-primary profile-button" type="submit" value="Lưu">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4 border-right border-left">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5" width="150px" src="<%=account.getImagePath()%>">
                        <span class="font-weight-bold"><%=account.getUsername()%></span>
                        <input class="text-black-50" type="file" accept="image/*">
                    </div>
                    </span>
                </div>

            </div>
        </div>
    </div>


    <!-- footer-->
    <!-- <div include-html="footer.html" id="footer"></div> -->
    <!-- footer-->



    <script src="Customer_LGSMS/js/jquery-3.6.0.min.js"></script>
    <script src="Customer_LGSMS/js/include-html.min.js"></script>
    <script src="Customer_LGSMS/js/fnon.min.js"></script>
    <script src="Customer_LGSMS/js/validation/profile_validation.js"></script>
    <script src="Customer_LGSMS/js/validation/alert.js"></script>

</body>

</html>