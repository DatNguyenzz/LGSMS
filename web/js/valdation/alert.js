function alertFunction() {
    Fnon.Ask.Dark({
        width: 'nl',
        animation: 'slide-top',
        closeButton: false,
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
            if (result === true) {
                document.getElementById("form").submit();
//                document.getElementById("form1").submit();
//                sessionStorage.setItem('alert', true);
            } else {
                Fnon.Hint.Dark('Đã hủy thao tác', {
                    fontFamily:'"Quicksand", sans-serif',
                    position: 'center-top', // 'right-top', 'right-center', 'right-bottom', 'left-top', 'left-center', 'left-bottom', 'center-top', 'center-center', 'center-bottom'
                    spacing: '16px',
                    svgSize: { w: '160px', h: '160px' },
                    textColor: '#fff',
                    fontSize: '16px',
                    backgroundColor: '#4e73df',
                    shadowColor: 'rgba(2, 158, 255, 0.3)',
                    width: '300px',
                    zindex: 4000,
                    animation: 'slide-top', //'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    animationDuration: 500,
                    displayDuration: 3000,
                    progressColor: 'rgba(255,255,255,0.9)',
                    callback:undefined,
                  });
                x = 0;
                y = 0;
            }

        }
    });
}

function alertFunction1() {
    Fnon.Ask.Danger({
        width: 'nl',
        animation: 'slide-top',
        closeButton: false,
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
            if (result === true) {
//                document.getElementById("form").submit();
                document.getElementById("form1").submit();
//                sessionStorage.setItem('alert', true);
            } else {
                Fnon.Hint.Dark('Đã hủy thao tác', {
                    fontFamily:'"Quicksand", sans-serif',
                    position: 'center-top', // 'right-top', 'right-center', 'right-bottom', 'left-top', 'left-center', 'left-bottom', 'center-top', 'center-center', 'center-bottom'
                    spacing: '16px',
                    svgSize: { w: '160px', h: '160px' },
                    textColor: '#fff',
                    fontSize: '16px',
                    backgroundColor: '#4e73df',
                    shadowColor: 'rgba(2, 158, 255, 0.3)',
                    width: '300px',
                    zindex: 4000,
                    animation: 'slide-top', //'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    animationDuration: 500,
                    displayDuration: 3000,
                    progressColor: 'rgba(255,255,255,0.9)',
                    callback:undefined,
                  });
                x = 0;
                y = 0;
            }

        }
    });
}
//$(function () {
//    if (sessionStorage.getItem('alert') !== "false") {
//        Fnon.Alert.Dark({
//            message: 'Đã lưu thành công',
//            title: 'Xác nhận',
//            titleBackground: '#4e73df',
//            btnOkColor: '#fff',
//            btnOkBackground: '#4e73df',
//            color: '#2b2b2b',
//            background: 'rgba(0, 0, 0, 0.1)',
//            width: 'nl',
//            animation: 'slide-top',
//
//            btnOkText: 'Ok',
//            btnOkColor: '#fff',
//            btnOkBackground: '#4e73df',
//            btnOkShadow: 'rgba(0, 0, 0, 0.5)',
//            btnOkBorderColor: '#d4d4d4',
//            callback: () => {
//            }
//        });
//        sessionStorage.setItem('alert', false);
//    }
//}
//);

function confirmFunction() {
    alertFunction();
}

function confirmChangePass() {
    Fnon.Ask.Dark({
        width: 'nl',
        animation: 'slide-top',
        closeButton: false,
        message: 'Bạn có chắc chắn với việc thay đổi mật khẩu này?',

        title: 'Thông báo xác nhận',
        titleColor: '#fff',
        titleBackground: '#4e73df',

        btnOkText: 'Có',
        btnOkColor: '#fff',
        btnOkBackground: '#4e73df',
        btnOkShadow: 'rgba(0, 0, 0, 0.5)',
        btnOkBorderColor: '#d4d4d4',

        btnCancelText: 'Không',
        btnCancelColor: '#fff',
        btnCancelBackground: '#4e73df',
        btnCancelShadow: 'rgba(0, 0, 0, 0.5)',
        btnCancelBorderColor: '#d4d4d4',

        color: '#2b2b2b',
        background: 'rgba(0, 0, 0, 0.1)',
        callback: (result) => {
            if (result === true) {
                location.reload;
                 Fnon.Hint.Dark('Đã gửi mật khẩu mới', {
                    fontFamily:'"Quicksand", sans-serif',
                    position: 'center-top', // 'right-top', 'right-center', 'right-bottom', 'left-top', 'left-center', 'left-bottom', 'center-top', 'center-center', 'center-bottom'
                    spacing: '16px',
                    svgSize: { w: '16px', h: '16px' },
                    textColor: '#fff',
                    fontSize: '16px',
                    backgroundColor: '#4e73df',
                    shadowColor: 'rgba(2, 158, 255, 0.3)',
                    width: '300px',
                    zindex: 4000,
                    animation: 'slide-top', //'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    animationDuration: 500,
                    displayDuration: 3000,
                    progressColor: 'rgba(255,255,255,0.9)',
                    callback:undefined,
                  });
            }else{
                Fnon.Hint.Dark('Đã hủy thao tác', {
                    fontFamily:'"Quicksand", sans-serif',
                    position: 'center-top', // 'right-top', 'right-center', 'right-bottom', 'left-top', 'left-center', 'left-bottom', 'center-top', 'center-center', 'center-bottom'
                    spacing: '16px',
                    svgSize: { w: '16px', h: '16px' },
                    textColor: '#fff',
                    fontSize: '16px',
                    backgroundColor: '#4e73df',
                    shadowColor: 'rgba(2, 158, 255, 0.3)',
                    width: '300px',
                    zindex: 4000,
                    animation: 'slide-top', //'fade', 'slide-top', 'slide-bottom', 'slide-right' and 'slide-left'
                    animationDuration: 500,
                    displayDuration: 3000,
                    progressColor: 'rgba(255,255,255,0.9)',
                    callback:undefined,
                  });
            }
        }
    });
}
//$(function () {
//    if (sessionStorage.getItem('change') !== "false") {
//        Fnon.Alert.Dark({
//            message: 'Đã gửi mã thay đổi thành công',
//            title: 'Xác nhận',
//            titleBackground: '#4e73df',
//            btnOkColor: '#fff',
//            btnOkBackground: '#4e73df',
//            color: '#2b2b2b',
//            background: 'rgba(0, 0, 0, 0.1)',
//            width: 'nl',
//            animation: 'slide-top',
//
//            btnOkText: 'Ok',
//            btnOkColor: '#fff',
//            btnOkBackground: '#4e73df',
//            btnOkShadow: 'rgba(0, 0, 0, 0.5)',
//            btnOkBorderColor: '#d4d4d4',
//            callback: () => {
//            }
//        });
//        sessionStorage.setItem('change', false);
//    }
//}
//);

////Điều kiện tên
const isValidName = name => {
    const re = /^[^\-\!\[\]\{\}\"\'\>\<\%\^\*\?\/\\\|\,\;\:\+\=\(\)\@\$\&\!\.\#\_0-9]*$/g  ;
    return re.test(String(name).toLowerCase());
};

////Điều kiện email
const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};
//Điều kiện số điện thoại
const isValidPhone = phone => {
    const re = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;
    return re.test(String(phone).toLowerCase());
};
//Điều kiện mật khẩu
const isValidPass = password => {
    const re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm;
    return re.test(String(password));
};
//Điều kiện tên đăng nhập
const isValidUsername = username => {
    const re = /['\/~`\!@#\$%\^&\*\(\)_\-\+=\{\}\[\]\|;:"\<\>,\.\?\\]/g;
    return re.test(String(username));
};

//Điều kiện pick date
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
    $('#user-dob').attr('max', maxDate);
//    $('#user-dob').attr('max', maxDate);
    $('#dobEditInput').attr('max', maxDate);
});

//Xét điều kiện để hiện thông báo lỗi form add
const setError = (element, message) => {
    const inputControl = element.parentNode;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = message;
    inputControl.classList.add('failed');
    inputControl.classList.remove('success');
};
//Xét điều kiện để hiện thông báo thành công form add
const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('failed');
    x = x + 1;
};

//Xét điều kiện để hiện thông báo lỗi form edit
const setError1 = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = message;
    inputControl.classList.add('failed');
    inputControl.classList.remove('success');
};
//Xét điều kiện để hiện thông báo thành công form edit
const setSuccess1 = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('failed');
    y = y + 1;

};
const setOkay = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.remove('failed');
    x = x + 1;
};
const setOkay1 = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.remove('failed');
    y = y + 1;
};