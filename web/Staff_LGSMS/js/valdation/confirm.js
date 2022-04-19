function confirmFunction() {
    // if (InvalidMsg == true) {
    Fnon.Ask.Dark({
        width: 'nl', // sm//lg//nl//xl
        // closeButton: true,
        animation: 'slide-top',//'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
        closeButton: false,
        // callback: undefined,
        // icon: undefined,
        // iconColor: '#4e73df',
        // showIcon: true,
        message: 'Bạn có chắc chắn lưu thay đổi này?',

        title: 'Thông báo xác nhận',
        titleColor: '#fff',
        titleBackground: '#4e73df',

        btnOkText: 'Lưu',
        btnOkColor: '#fff',
        btnOkBackground: '#4e73df',
        btnOkShadow: 'rgba(0, 0, 0, 0.5)',
        btnOkBorderColor: '#d4d4d4',

        btnCancelText: 'Hủy',
        btnCancelColor: '#fff',
        btnCancelBackground: '#4e73df',
        btnCancelShadow: 'rgba(0, 0, 0, 0.5)',
        btnCancelBorderColor: '#d4d4d4',

        color: '#2b2b2b',
        background: 'rgba(0, 0, 0, 0.1)',
        callback: (result) => {
            if (result == true) {
                Fnon.Alert.Dark({
                    message: 'Đã lưu thành công',
                    title: 'Xác nhận',
                    titleBackground: '#4e73df',
                    btnOkColor: '#fff',
                    btnOkBackground: '#4e73df',
                    color: '#2b2b2b',
                    background: 'rgba(0, 0, 0, 0.1)',
                    width: 'nl', // sm, lg, nl, xl
                    // closeButton: true,
                    animation: 'slide-top', // 'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    // closeButton: false,
                    // icon: undefined,
                    // iconColor: '#000',
                    // showIcon: false,
                    btnOkText: 'Ok',
                    btnOkColor: '#fff',
                    btnOkBackground: '#4e73df',
                    btnOkShadow: 'rgba(0, 0, 0, 0.5)',
                    btnOkBorderColor: '#d4d4d4',
                    callback: () => {
                        document.getElementById("form").submit();
                    }
                });
            } else {
            }
        }
    });
}

function confirmChangePass() {
    Fnon.Ask.Dark({
        width: 'nl', // sm//lg//nl//xl
        // closeButton: true,
        animation: 'slide-top',//'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
        closeButton: false,
        // callback: undefined,
        // icon: undefined,
        // iconColor: '#4e73df',
        // showIcon: true,
        message: 'Bạn có chắc chắn với việc thay đổi mật khẩu này?',

        title: 'Thông báo xác nhận',
        titleColor: '#fff',
        titleBackground: '#4e73df',

        btnOkText: 'Lưu',
        btnOkColor: '#fff',
        btnOkBackground: '#4e73df',
        btnOkShadow: 'rgba(0, 0, 0, 0.5)',
        btnOkBorderColor: '#d4d4d4',

        btnCancelText: 'Hủy',
        btnCancelColor: '#fff',
        btnCancelBackground: '#4e73df',
        btnCancelShadow: 'rgba(0, 0, 0, 0.5)',
        btnCancelBorderColor: '#d4d4d4',

        color: '#2b2b2b',
        background: 'rgba(0, 0, 0, 0.1)',
        callback: (result) => {
            if (result == true) {
                Fnon.Alert.Dark({
                    message: 'Đã thay đổi thành công',
                    title: 'Xác nhận',
                    titleBackground: '#4e73df',
                    btnOkColor: '#fff',
                    btnOkBackground: '#4e73df',
                    color: '#2b2b2b',
                    background: 'rgba(0, 0, 0, 0.1)',
                    width: 'nl', // sm, lg, nl, xl
                    // closeButton: true,
                    animation: 'slide-top', // 'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    // closeButton: false,
                    // icon: undefined,
                    // iconColor: '#000',
                    // showIcon: false,
                    btnOkText: 'Ok',
                    btnOkColor: '#fff',
                    btnOkBackground: '#4e73df',
                    btnOkShadow: 'rgba(0, 0, 0, 0.5)',
                    btnOkBorderColor: '#d4d4d4',
                    callback: () => {
                        location.reload();
                    }
                });
            } else {
            }
        }
    });
}


// Fnon.Ask.Init({
//     fontFamily: defaultFont,
//     width: 'nl', // sm//lg//nl//xl
//     closeButton: true,
//     animation: 'slide-top',//'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
//     closeButton: false,
//     callback: undefined,
//     icon: undefined,
//     iconColor: '#fff',
//     showIcon: false,
//     message: 'Are you sure?',

//     title: 'Confirmation',
//     titleColor: '#fff',
//     titleBackground: '#fff',

//     btnOkText: 'Ok',
//     btnOkColor: '#fff',
//     btnOkBackground: '#fff',
//     btnOkShadow: 'rgba(0, 0, 0, 0.2)',
//     btnOkBorderColor: '#d4d4d4',

//     btnCancelText: 'Cancel',
//     btnCancelColor: '#fff',
//     btnCancelBackground: '#fff',
//     btnCancelShadow: 'rgba(0, 0, 0, 0.1)',
//     btnCancelBorderColor: '#d4d4d4',

//     color: '#2b2b2b',
//     background: 'rgba(0, 0, 0, 0.1)',

//     zIndex:4000,

// Functions
//     beforeShow: undefined,
//     afterShow: undefined,

// });


// $('.example1').on('click', function(){
//     $.alert({
//         title: 'Alert!',
//         content: 'Simple alert!',
//     });
// });

// $('#notify').on('click', function () {
//     Fnon.Hint.Dark('CSSScript Toast', {
//         position: 'right-top',
//         fontSize: '14px',
//         width: '300px'
//     });
// })

// $('#loading').on('click', function () {
//     Fnon.Wait.Liquid('Please Wait', {
//         textSize: '14px',
//         clickToClose: true,
//     });
// })

// $('#alert').on('sumbit', function () {
//     Fnon.Alert.Dark({
//         title: 'Alert Title',
//         message: 'Alert Dialog',
//         callback: () => {
//             // do some thing
//         }
//     });
// })

// $('#confirm').on('click', function () {
//     Fnon.Ask.Danger({
//         title: 'Confirmation',
//         message: 'Are you sure?',
//         callback: (result) => {
//             // do some thing
//         }
//     });

// })

// $('#dialog').on('click', function () {
//     Fnon.Dialogue.Success('Message', 'Title', 'Sure', 'Naah', (closer, html) => {
//         return false; // this will avoid closing the model.
//         closer();// will force the closing.
//         // html is simply the body container where you can use it to do some validation, querying,...etc.
//     });

// })
