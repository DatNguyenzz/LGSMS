
<%@page import="Utility.FormatNumber"%>
<%@page import="Model.Provider"%>
<%@page import="Model.Product"%>
<%@page import="Model.Importation"%>
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

        <title>LGS - Manager</title>

        <!-- Custom fonts for this template -->
        <link href="Staff_LGSMS/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">

        <!-- Custom styles for this template -->
        <link href="Staff_LGSMS/assets/styles/sb-admin-2.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/icon_action.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="Staff_LGSMS/assets/styles/custom_box.css" rel="stylesheet">
        <link href="Staff_LGSMS/css/fnon.min.css" rel="stylesheet">
    </head>

    <body id="page-top">
        <%
            ArrayList<Importation> listImport = (ArrayList<Importation>) request.getAttribute("listImportation");
            ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
            ArrayList<Provider> listProvider = (ArrayList<Provider>) request.getAttribute("listProvider");
            FormatNumber formatNumber = new FormatNumber();
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
                            <h1 class="h3 mb-0 text-white">Qu???n l?? ????n nh???p</h1>
                            <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal"
                                    data-target="#exampleModal" data-whatever="@getbootstrap"><i
                                    class="fas fa-plus fa-sm text-white-50"></i> T???o ????n nh???p h??ng</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Th??ng tin nh???p h??ng</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="<%=request.getContextPath()%>/CreateNewImport" method="POST" id="form">
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="row">
                                                            <div class="col-8 col-sm-12 ">
                                                                <div class="form-group">
                                                                    <label for="product-name">T??n s???n ph???m:</label>
                                                                    <select name="product-id" id="product-name"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for (Product pro : listProduct) {%>
                                                                        <option value="<%=pro.getProductID()%>"><%=pro.getProductName()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <br>
                                                                <div class="form-group">
                                                                    <label for="provider-name" class="col-form-label">T??n nh?? cung c???p:</label>
                                                                    <select name="provider-id" id="product-status"
                                                                            class="border border-secondary w-100 label_box rounded">
                                                                        <%for (Provider provider : listProvider) {%>
                                                                        <option value="<%=provider.getProviderID()%>"><%=provider.getProviderName()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <br>
                                                                <div class="form-group">
                                                                    <label for="product-quantity">S??? l?????ng:</label>
                                                                    <input type="number" id="product-quantity"
                                                                           name="product-quantity"
                                                                           class="form-control" maxlength="4"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-price" class="col-form-label">Gi??
                                                                        nh???p:</label>
                                                                    <input type="number" class="form-control" name="product-import-price"
                                                                           id="product-price" maxlength="25"/>
                                                                    <div class="fail"></div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="product-note" class="col-form-label">Ghi
                                                                        ch??:</label>
                                                                    <textarea class="form-control"
                                                                              style="resize: none; overflow: auto;"
                                                                              id="product-note1" name="import-note"
                                                                              maxlength="500"></textarea>

                                                                </div>
                                                                <br>
                                                                <div class="row">
                                                                    <div class="col-4"></div>
                                                                    <div class="col-8">
                                                                        <div class="form-group">
                                                                            <label for="import-pay" style="float: right;"
                                                                                   class="col-form-label">T???ng chi ph?? nh???p
                                                                                h??ng (VN??):</label>
                                                                            <input type="number"
                                                                                   style="text-align: right;font-size: 36px;"
                                                                                   readonly
                                                                                   class="form-control bg-white border-0"
                                                                                   id="import-pay" value="" />
                                                                        </div>
                                                                        <div style="margin-top: 2%; float: right">
                                                                            <input type="submit" class="btn btn-primary"
                                                                                   value="L??u"></input>
                                                                            <button type="button" class="btn btn-secondary"
                                                                                    data-dismiss="modal">H???y</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
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
                                <h6 class="m-0 font-weight-bold text-primary">Danh s??ch ????n nh???p</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>T??n s???n ph???m</th>
                                                <th>Ngu???n</th>
                                                <th>S??? l?????ng</th>
                                                <th>Ng??y nh???p</th>
                                                <th>T???ng chi ph?? nh???p</th>
                                                <th>Ng?????i t???o ????n</th>
                                                <th>Tr???ng th??i</th>
                                                <th>Thao t??c</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (Importation importation : listImport) {%>
                                            <tr>
                                                <td><%=importation.getProductName()%></td>
                                                <td><%=(importation.getProviderName() == null) ? "Kh??ch h??ng" : importation.getProviderName()%></td>
                                                <td><%=importation.getProductImportQuantity()%></td>
                                                <td><%=importation.getCreatedAt()%></td>
                                                <td><%=formatNumber.formatDoubleToVND(importation.getImportAmount())%></td>
                                                <td><%=(importation.getManagerName() == null) ? importation.getStaffName() : importation.getManagerName()%></td>
                                                <td>
                                                    <%switch (importation.getImportStatus()) {
                                                        case 0: {%>
                                                    <p id="status_pending">??ang x??? l??</p>
                                                    <%break;
                                                        }
                                                        case 1: {%>
                                                    <p id="status_complete">Ho??n th??nh</p>
                                                    <%break;
                                                        }
                                                        case 2: {%>
                                                    <p id="status_reject">???? h???y</p>
                                                    <%break;
                                                            }
                                                        }%>
                                                </td>

                                                <td>
                                                    <a href="#viewImportModal" 
                                                       onclick="handleClick('<%=importation.getImportID()%>',
                                                                   '<%=(importation.getManagerName()==null) ? "" : importation.getManagerName()%>',
                                                                   '<%=importation.getProductName()%>',
                                                                   '<%=(importation.getProviderName() == null) ? "Kh??ch h??ng" : importation.getProviderName()%>',
                                                                   '<%=importation.getProductImportQuantity()%>',
                                                                   '<%=importation.getCreatedAt()%>',
                                                                   '<%=importation.getImportStatus()%>',
                                                                   '<%=formatNumber.formatDoubleToNumber(importation.getImportAmount())%>',
                                                                   '<%=(importation.getUpdatedAt() == null) ? "" : importation.getUpdatedAt()%>',
                                                                   '<%=(importation.getStaffName() == null) ? "" : importation.getStaffName()%>',
                                                                   '<%=importation.getNote()%>')"
                                                       class="view" data-toggle="modal"><i
                                                            class="fas fa-eye" data-toggle="tooltip"
                                                            title="View"></i></a>
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
            <div class="modal fade" id="viewImportModal" role="dialog" aria-labelledby="viewImportModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Th??ng tin nh???p h??ng</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form id="form1">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="row">
                                            <div class="col-8 col-sm-6">
                                                <div class="form-group">
                                                    <label for="product-name" class="col-form-label">T??n s???n ph???m:</label>
                                                    <input type="text" id="productNameInfo" name="productNameINfo" readonly
                                                           class="border border-secondary w-100 p-2 rounded"
                                                           />

                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="create-staff" class="col-form-label">Qu???n l??:</label>
                                                    <input type="text" id="create-staff" name="create-staff"
                                                           class="border border-secondary w-100 p-2 rounded" readonly />
                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="product-quantity1" class="col-form-label">S??? l?????ng:</label>
                                                    <input type="number" id="product-quantity1" name="product-quantity1"
                                                           class="border border-secondary w-100 p-2 rounded" readonly  />
                                                    <div class="fail"></div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="product-price" class="col-form-label">Gi??
                                                        nh???p:</label>
                                                    <input type="number" class="border border-secondary w-100 p-2 rounded"
                                                           id="product-price1" readonly  />
                                                    <div class="fail"></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col">
                                                        <label for="order-create" class="col-form-label">Ng??y
                                                            t???o:</label>
                                                        <input type="text"
                                                               class="border border-secondary w-100 rounded label_box"
                                                               readonly class=" form-control-plaintext"
                                                               id="order-create"/>
                                                    </div>
                                                    <div class="col">
                                                        <label for="order-update" class="col-form-label"
                                                               style="text-align: right;">Ng??y c???p nh???t:</label>
                                                        <input type="text"
                                                               class="border border-secondary w-100 rounded label_box" readonly
                                                               class="form-control-plaintext"
                                                               id="order-update"/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-8 col-sm-6">
                                                <div class="form-group">
                                                    <label for="provider-name" class="col-form-label">Ngu???n nh???p</label>
                                                    <input type="text" id="providerNameInfo" name="providerNameInfo"
                                                           readonly class="border border-secondary w-100 p-2 rounded"/>

                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="confirm-staff" class="col-form-label">Nh??n vi??n:</label>
                                                    <input type="text" id="confirm-staff" name="confirm-staff"
                                                           class="border border-secondary w-100 p-2 rounded" readonly  />
                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="import-status" class="col-form-label">Tr???ng
                                                        th??i:</label>
                                                    <select name="import-status" id="import-status"
                                                            class="border border-secondary w-100 p-2 rounded">
                                                        <option  value="0">??ang x??? l??</option>
                                                        <option  value="1">????n ???? ho??n th??nh</option>
                                                        <option  value="2">????n b??? h???y</option>
                                                    </select>
                                                </div>
                                                <br>
                                                <div class="form-group">
                                                    <label for="product-note" class="col-form-label">Ghi
                                                        ch??:</label>
                                                    <input type="text" id="product-note" name="product-note"
                                                           class="border border-secondary w-100 p-2 rounded" readonly  />


                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-4"></div>
                                                    <div class="col-8">
                                                        <div class="form-group">
                                                            <label for="import-pay1" style="float: right;"
                                                                   class="col-form-label">T???ng chi ph?? nh???p
                                                                h??ng (VN??):</label>
                                                            <input type="number" style="text-align: right;font-size: 36px;"
                                                                   readonly class="form-control bg-white border-0"
                                                                   id="import-pay1" value="" />
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Bootstrap core JavaScript-->
        <script type="text/javascript">

            const productName = document.getElementById("productNameInfo");
            const providerName = document.getElementById("providerNameInfo");
            const manageName = document.getElementById("create-staff");
            const quantity2 = document.getElementById("product-quantity1");
            const price2 = document.getElementById("import-pay1");
            const dateCreate = document.getElementById("order-create");
            const dateUpdate = document.getElementById("order-update");
            const staffName = document.getElementById("confirm-staff");
            const status = document.getElementById("import-status");
            const note = document.getElementById("product-note");
            const productImportPrice = document.getElementById("product-price1");

            const handleClick = (idInput, manageNameIn, productNameInput,
                    providerNameIn, productImportQuantity, importDateIn,
                    importStatusIn, priceIn, updateDateIn,
                    staffNameIn, noteIn) => {
                productName.value = productNameInput;
                providerName.value = providerNameIn;
                manageName.value = manageNameIn;
                quantity2.value = productImportQuantity;
                price2.value = priceIn;
                dateCreate.value = importDateIn;
                dateUpdate.value = updateDateIn;
                staffName.value = staffNameIn;
                note.value = noteIn;
                status.value = importStatusIn;
                if (priceIn == 0) {
                    productImportPrice.value = 0;
                } else {
                    productImportPrice.value = priceIn / productImportQuantity;
                }
            };
        </script>
        <script src="Staff_LGSMS/vendor/jquery/jquery.min.js"></script>
        <script src="Staff_LGSMS/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="Staff_LGSMS/vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="Staff_LGSMS/js/sb-admin-2.min.js"></script>
        <!-- Page level plugins -->
        <script src="Staff_LGSMS/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="Staff_LGSMS/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="Staff_LGSMS/js/demo/datatables-demo.js"></script>
        <script src="Staff_LGSMS/js/include-html.min.js"></script>
        <script src="Staff_LGSMS/js/valdation/import_validate.js"></script>
        <script src="Staff_LGSMS/js/valdation/alert.js"></script>
        <script src="Staff_LGSMS/js/fnon.min.js"></script>
        <script>
             var imprice = document.getElementById('product-price'),
                     imquantity = document.getElementById('product-quantity'),
                     payment = document.getElementById('import-pay');
             imquantity.onchange = function () {
                 var result = parseFloat(imquantity.value) * parseFloat(imprice.value);
                 payment.value = !isNaN(result) ? result : '';
             }

             imprice.onchange = function () {
                 var result = parseFloat(imquantity.value) * parseFloat(imprice.value);
                 payment.value = !isNaN(result) ? result : '';
             }
        </script>
        <script>
            var imprice1 = document.getElementById('product-price1'),
                    imquantity1 = document.getElementById('product-quantity1'),
                    payment1 = document.getElementById('import-pay1');
            payment1.value = imprice1.value * imquantity1.value;
            imquantity1.onchange = function () {
                var result1 = parseFloat(imquantity1.value) * parseFloat(imprice1.value);
                payment1.value = !isNaN(result1) ? result1 : '';
            }

            imprice1.onchange = function () {
                var result1 = parseFloat(imquantity1.value) * parseFloat(imprice1.value);
                payment1.value = !isNaN(result1) ? result1 : '';
            }
        </script>
    </body>

</html>