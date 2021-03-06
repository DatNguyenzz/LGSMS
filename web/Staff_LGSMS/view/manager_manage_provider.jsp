<%@page import="Model.Provider"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>LGS - Admin</title>

        <!-- Custom fonts for this template -->
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/slider_status.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
         <link href="Staff_LGSMS/css/alert.css" rel="stylesheet">
    </head>

    <body id="page-top">
        <%
            ArrayList<Provider> listProvider = (ArrayList<Provider>) request.getAttribute("listProvider");
        %>
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
                <div include-html="Staff_LGSMS/components/sidebar.jsp" id="sidebar" style="display: contents;"></div>
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
            </ul>
            <!-- End of Sidebar -->
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column" class="img js-fullheight" 
                 style="background-image: url(Staff_LGSMS/assets/image/fac2.jpg); background-size: cover;">
                <!-- Main Content -->
                <div id="content">
                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                        <!-- Topbar Navbar -->
                        <div include-html="Staff_LGSMS/components/topnavbar.jsp" id="topnavbar" class="ml-auto"></div>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-white">Qu???n l?? nh?? cung c???p</h1>
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap"><i class="fas fa-plus fa-sm text-white-50"></i> Th??m nh?? cung c???p</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered " role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Th??m nh?? cung c???p</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">

                                            <form action="AddProvider" method="POST" id="form">
                                                <div class="row">
                                                    <div class="col-8 col-sm-12">
                                                        <div class="form-group">
                                                            <label for="provider-name" class="col-form-label">T??n nh?? cung c???p:</label>
                                                            <input type="text" class="form-control" name="provider-name" id="provider-name" maxlength="50"/>
                                                            <p class="fail"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="provider-address" class="col-form-label">?????a ch???:</label>
                                                            <input type="text" class="form-control" name="provider-address" id="provider-address" maxlength="500"/>
                                                            <p class="fail"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="provider-email" class="col-form-label">Email:</label>
                                                            <input type="text" class="form-control" name="provider-email" id="provider-email" name="email" maxlength="80"/>
                                                            <p class="fail"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="provider-phone" class="col-form-label">??i???n tho???i:</label>
                                                            <input type="text" class="form-control" name="provider-phone" id="provider-phone" maxlength="15"/>
                                                            <p class="fail"></p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="submit" class="btn btn-primary"  value="Th??m"></input>
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">H???y</button>

                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Page Heading -->
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Danh s??ch nh?? cung c???p</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>T??n nh?? cung c???p</th>
                                                <th>Email</th>
                                                <th>??i???n tho???i</th>
                                                <th>Ng??y t???o</th>
                                                <th>Tr???ng th??i</th>
                                                <th>Thao t??c</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Provider provider : listProvider) {%>
                                            <tr>
                                                <td><%=provider.getProviderID()%></td>
                                                <td><%=provider.getProviderName()%></td>
                                                <td><%=provider.getProviderEmail()%></td>
                                                <td><%=provider.getProviderPhone()%></td>
                                                <td><%=provider.getCreatedAt()%></td>
                                                <td>
                                                    <%if (provider.isIsActive()) {%>
                                                    <p id="status_complete">??ang ho???t ?????ng</p>
                                                    <%} else {%>
                                                    <p id="status_reject">Ng???ng ho???t ?????ng</p>
                                                    <%}%>
                                                </td>
                                                <td>
                                                    <a href="#editAccountModal" class="edit" 
                                                       onclick="handleClick('<%=provider.getProviderID()%>', 
                                                                            '<%=provider.getProviderName()%>',  
                                                                            '<%=provider.getProviderEmail()%>', 
                                                                            '<%=provider.getProviderPhone()%>', 
                                                                            '<%=provider.getProviderAddress()%>',
                                                                            '<%=provider.isIsActive()%>');"
                                                       data-toggle="modal"><i class="bi bi-pencil-square" data-toggle="tooltip" title="Edit"></i></a>
                                                </td>

                                            </tr>

                                            <%}%>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
                <!-- End of Main Content -->
            </div>
            <!-- End of Content Wrapper -->
        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <!-- Edit Modal HTML -->
        <div id="editAccountModal" class="modal fade">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content ">

                    <form id="form1" action="EditProvider" method="post">

                        <div class="modal-header">
                            <h4 class="modal-title">Ch???nh s???a th??ng tin nh?? cung c???p</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>M?? nh?? cung c???p</label>

                                <input name="providerID" id="providerID" type="text" class="border border-secondary w-100 rounded label_box" 
                                       readonly class="form-control-plaintext"></input>

                            </div>
                            <br>
                            <div class="form-group">
                                <label>T??n nh?? cung c???p</label>
                                <input name="providerName" id="providerName"  type="text" class="form-control" maxlength="50"/>
                                <p class="fail"></p>
                            </div>
                            <div class="form-group">
                                <label>?????a ch???</label>
                                <input name="address" id="address" type="text" class="form-control" maxlength="500"/>
                                <p class="fail"></p>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input name="email" id="email" type="email" class="form-control"name="email" maxlength="80"/>
                                <p class="fail"></p>
                            </div>
                            <div class="form-group">
                                <label>??i???n tho???i</label>
                                <input name="providerPhone" id="providerPhone" type="text" class="form-control" maxlength="15"/>
                                <p class="fail"></p>
                            </div>
                            <div class="form-group">
                                <label for="staff-status" class="col-form-label">Tr???ng th??i:</label>
                                <select class="form-control" name="provider-status" id="status">
                                    <option value="true">Ho???t ?????ng</option>
                                    <option value="false">Ng???ng ho???t ?????ng</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="H???y">
                            <input type="submit" class="btn btn-primary"  value="L??u">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript-->


        <script type="text/javascript">


            const providerID = document.getElementById("providerID");
            const providerName = document.getElementById("providerName");
            const email = document.getElementById("email");
            const address = document.getElementById("address");
            const providerPhone = document.getElementById("providerPhone");
            const providerStatus = document.getElementById("status");


            const handleClick = (idInput, nameInput, emailInput, phoneInput, addressInput, statusInput) => {
                providerName.value = nameInput;
                email.value = emailInput;
                providerPhone.value = phoneInput;
                providerID.value = idInput;
                address.value = addressInput;
                providerStatus.value = statusInput;

            }

        </script>


        <script src="Staff_LGSMS/vendor/jquery/jquery.min.js"></script>
        <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


        <!-- Core plugin JavaScript-->
        <script src="Staff_LGSMS/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="Staff_LGSMS/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="Staff_LGSMS/js/demo/datatables-demo.js"></script>
        <script src="Staff_LGSMS/js/include-html.min.js"></script>
        <script src="Staff_LGSMS/js/valdation/provider_validate.js"></script>
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script src="Staff_LGSMS/js/fnon.min.js"></script>
        
         <% 
            String message = (String) request.getSession().getAttribute("SucMessage") ;
            if(message != null){
        %>
        <script>
            ModalWindow.openModal(
                {
                    title: "Confirm",
                    content: "<%=message%>"
                }
            );
        </script>
        <%}%>
    </body>

</html>