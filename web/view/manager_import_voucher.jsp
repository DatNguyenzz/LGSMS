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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">

    <!-- Custom styles for this template -->
    <link href="assets/styles/sb-admin-2.min.css" rel="stylesheet">
    <link href="assets/styles/icon_action.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="assets/styles/custom_box.css" rel="stylesheet">
    <link href="css/fnon.min.css" rel="stylesheet">
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <div include-html="components/sidebar.html" id="sidebar" style="display: contents;"></div>
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column" class="img js-fullheight"
            style="background-image: url(assets/image/fac2.jpg); background-size: cover;">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                    <!-- Topbar Navbar -->
                    <div include-html="components/topnavbar.html" id="topnavbar" class="ml-auto"></div>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-white">Qu?n lý ??n nh?p</h1>
                        <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" data-toggle="modal"
                            data-target="#exampleModal" data-whatever="@getbootstrap"><i
                                class="fas fa-plus fa-sm text-white-50"></i> T?o ??n nh?p hàng</button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Thông tin nh?p hàng</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="" id="form">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <div class="row">
                                                        <div class="col-8 col-sm-12 ">
                                                            <div class="form-group">
                                                                <label for="product-name">Tên s?n ph?m:</label>
                                                                <select name="product-name" id="product-name"
                                                                    class="border border-secondary w-100 label_box rounded">
                                                                    <option value="product-1">Bình gas 12kg van ngang
                                                                    </option>
                                                                    <option value="product-2">Bình gas 12kg van ch?p
                                                                    </option>
                                                                    <option value="product-3">Bình gas 45kg công nghi?p
                                                                    </option>
                                                                    <option value="product-4">Bình gas 13kg van ngang
                                                                    </option>
                                                                    <option value="product-5">Bình gas 13 van ch?p
                                                                    </option>
                                                                </select>
                                                            </div>
                                                            <br>
                                                            <div class="form-group">
                                                                <label for="provider-name" class="col-form-label">Tên
                                                                    nhà cung c?p:</label>
                                                                <select name="provider-name" id="provider-status"
                                                                    class="border border-secondary w-100 label_box rounded">
                                                                    <option value="provider-1">Petrolimex Gas</option>
                                                                </select>
                                                            </div>
                                                            <br>
                                                            <div class="form-group">
                                                                <label for="product-quantity">S? l??ng:</label>
                                                                <input type="number" id="product-quantity"
                                                                    name="product-quantity" class="form-control" />
                                                                <div class="fail"></div>
                                                            </div>
                                                            <div class="form-group" hidden>
                                                            <label for="import-status" class="col-form-label">Tr?ng
                                                                thái:</label><br>
                                                            <select name="import-status" id="import-status"
                                                                class="border border-secondary w-100 p-2 rounded"
                                                                style="margin-bottom: 8px;">
                                                                <option selected value="status-1">?ang x? lí</option>
                                                                <option disabled value="status-2">??n ?ã xác nh?n</option>
                                                                <option disabled value="status-3">??n b? h?y</option>
                                                            </select>
                                                            </div>
                                                            <!-- <br> -->
                                                            <div class="form-group">
                                                                <label for="product-price" class="col-form-label">Giá
                                                                    nh?p:</label>
                                                                <input type="number" class="form-control"
                                                                    id="product-price" />
                                                                <div class="fail"></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="product-note" class="col-form-label">Ghi
                                                                    chú:</label>
                                                                <textarea class="form-control"
                                                                    style="resize: none; overflow: auto;"
                                                                    id="product-note"></textarea>

                                                            </div>
                                                            <br>
                                                            <div class="row">
                                                                <div class="col-4"></div>
                                                                <div class="col-8">
                                                                    <div class="form-group">
                                                                        <label for="import-pay" style="float: right;"
                                                                            class="col-form-label">T?ng chi phí nh?p
                                                                            hàng (VN?):</label>
                                                                        <input type="number"
                                                                            style="text-align: right;font-size: 36px;"
                                                                            readonly
                                                                            class="form-control bg-white border-0"
                                                                            id="import-pay" value="" />
                                                                    </div>
                                                                    <div style="margin-top: 2%; float: right">
                                                                        <input type="submit" class="btn btn-primary"
                                                                            value="L?u"></input>
                                                                        <button type="button" class="btn btn-secondary"
                                                                            data-dismiss="modal">H?y</button>
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
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách ??n nh?p</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Tên s?n ph?m</th>
                                            <th>Nhà cung c?p</th>
                                            <th>S? l??ng</th>
                                            <th>Ngày nh?p</th>
                                            <th>T?ng chi phí nh?p</th>
                                            <th>Tr?ng thái</th>
                                            <th>Ng??i t?o ??n</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Bình gas 12kg van ngang</td>
                                            <td>Petrolimex Gas</td>
                                            <td>500</td>
                                            <td>2010/01/04</td>
                                            <td>599.000</td>
                                            <td>
                                                <p id="status_pending">?ang x? lý</p>
                                            </td>
                                            <td>MinhPQ</td>
                                            <td>
                                                <a href="#viewImportModal" class="view" data-toggle="modal"><i
                                                        class="bi bi-pencil-square" data-toggle="tooltip" title="View"></i></a>
                                            </td>
                                            <!-- <td>
                                                <a href="#viewImportModal" class="view" data-toggle="modal"><i class="fas fa-eye" data-toggle="tooltip" title="View"></i></a>
                                                <a href="#" class="accept" data-toggle="modal"><i class="fas fa-check-circle" data-toggle="tooltip" title="accept"></i></a>
                                                <a href="#" class="reject" data-toggle="modal"><i class="fas fa-times-circle" data-toggle="tooltip" title="reject"></i></a>
                                            </td> -->
                                        </tr>
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
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thông tin nh?p hàng</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="" id="form1">
                            <div class="row">
                                <div class="col-sm-12" style="margin: auto;">
                                    <div class="row">
                                        <div class="col-8 col-sm-12" style="margin: auto;">
                                            <div class="form-group">
                                                <label for="product-name">Tên s?n ph?m:</label>
                                                <input type="text" id="productNameInfo" name="productNameINfo" readonly
                                                    class="form-control" value="Bình gas 12kg van ch?p" />
                                                <!-- <select name="product-name" id="product-name" aria-readonly="true"
                                                    class="border border-secondary w-100 label_box rounded">
                                                    <option value="product-1">Bình gas 12kg van ngang
                                                    </option>
                                                    <option value="product-2">Bình gas 12kg van ch?p
                                                    </option>
                                                    <option value="product-3">Bình gas 45kg công nghi?p
                                                    </option>
                                                    <option value="product-4">Bình gas 13kg van ngang
                                                    </option>
                                                    <option value="product-5">Bình gas 13 van ch?p
                                                    </option>
                                                </select> -->
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="provider-name" class="col-form-label">Tên
                                                    nhà cung c?p:</label>
                                                <input type="text" id="providerNameInfo" name="providerNameInfo"
                                                    readonly class="form-control" value="Petrolimex Gas" />
                                                <!-- <select name="provider-name" id="provider-status" aria-readonly="true"
                                                    class="border border-secondary w-100 label_box rounded">
                                                    <option value="provider-1">Petrolimex Gas</option>
                                                </select> -->
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="product-quantity1">S? l??ng:</label>
                                                <input type="number" id="product-quantity1"
                                                    name="product-quantity1" class="form-control" value="20"/>
                                                <div class="fail"></div>
                                            </div>
                                            <!-- <div class="form-group" hidden>
                                            <label for="import-status" class="col-form-label">Tr?ng
                                                thái:</label><br>
                                            <select name="import-status" id="import-status"
                                                class="border border-secondary w-100 p-2 rounded"
                                                style="margin-bottom: 8px;">
                                                <option selected value="status-1">?ang x? lí</option>
                                                <option disabled value="status-2">??n ?ã xác nh?n</option>
                                                <option disabled value="status-3">??n b? h?y</option>
                                            </select>
                                            </div> -->
                                            <div class="form-group">
                                                <label for="product-price" class="col-form-label1">Giá
                                                    nh?p:</label>
                                                <input type="number" class="form-control"
                                                    id="product-price1" value="599000"/>
                                                <div class="fail"></div>
                                            </div>
                                            <div class="form-group">
                                                <label for="product-note" class="col-form-label">Ghi
                                                    chú:</label>
                                                <textarea class="form-control" id="product-note"></textarea>

                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-4"></div>
                                                <div class="col-8">
                                                    <div class="form-group">
                                                        <label for="import-pay1" style="float: right;"
                                                            class="col-form-label">T?ng chi phí nh?p
                                                            hàng (VN?):</label>
                                                        <input type="number"
                                                            style="text-align: right;font-size: 36px;"
                                                            readonly
                                                            class="form-control bg-white border-0"
                                                            id="import-pay1" value="" />
                                                    </div>
                                                    <div style="margin-top: 2%; float: right">
                                                        <input type="submit" class="btn btn-primary"
                                                            value="L?u"></input>
                                                        <button type="button" class="btn btn-secondary"
                                                            data-dismiss="modal">H?y</button>
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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/Noneed(maybe)/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/include-html.min.js"></script>
    <script src="js/valdation/import_validate.js"></script>
    <script src="js/valdation/alert.js"></script>
    <script src="js/fnon.min.js"></script>
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