<!DOCTYPE html>
<!DOCTYPE html>
<html lang="vi">

    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Alert Modal</title>

    <!-- Custom styles for this template -->
    <link href="../assets/styles/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="../assets/styles/alert.css" rel="stylesheet">

</head>
<body>
    <h1>Confirm Modal window</h1>
    <!--N?u không comment script m? comment ph?n này là 1 modal alert-->
<!--     <div class="modal_overlay">
        <div class="modal_window">
            <div class="modal_titlebar">
                <span class="modal_title">Confirm title</span>
                <button class="modal_close material-icons" onclick="this.parentElement.parentElement.parentElement.style.display='none';">&times;</button>
                
            </div>
            <div class="modal_content">
                lul mao poop peepo
            </div>
        </div>
    </div> -->



<script src="../js/modal_alert.js"></script>
<!--Dùng script này ?? g?i 1 modal xu?t hi?n thay ??i title content theo ý mu?n-->
<script>
    ModalWindow.openModal({
    title:"Confirm",
    content:"Pôp"
})
</script>

</body>
</html>