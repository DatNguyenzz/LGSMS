// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const aname = document.getElementById('staff-name');
const email = document.getElementById('staff-email');
const phone = document.getElementById('staff-phone');
const address = document.getElementById('staff-address');
const dob = document.getElementById('staff-dob');
const username = document.getElementById('username');
const pass = document.getElementById('staff-password');

const form1 = document.getElementById('form1');
const aname1 = document.getElementById('staff-name1');
const email1 = document.getElementById('staff-email1');
const phone1 = document.getElementById('staff-phone1');
const address1 = document.getElementById('staff-address1');
const dob1 = document.getElementById('staff-dob1');
const username1 = document.getElementById('username1');

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
//Xét điều kiện để hiện thông báo lỗi form add
const setError = (element, message) => {
    const inputControl = element.parentNode;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = message;
    inputControl.classList.add('failed');
    inputControl.classList.remove('success')
}
//Xét điều kiện để hiện thông báo thành công form add
const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('failed');
    x = x + 1;   
};

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 7) {
        Fnon.Ask.Danger({
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
                    x = 0;
                }
            }
        });
    }
});

//Trim input và các thông báo form add
const validateInputs = () => {
    const phoneValue = phone.value.trim();
    const emailValue = email.value.trim();
    const nameValue = aname.value.trim();
    const addressValue = address.value.trim();
    const dobValue = dob.value.trim();
    const usernameValue = username.value.trim();
    const passValue = pass.value.trim();

    // Thông báo nhập số điện thoại

    if (phoneValue === '') {
        setError(phone, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue)) {
        setError(phone, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess(phone);
    }

    //Thông báo nhập địa chỉ email
    if (emailValue === '') {
        setError(email, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess(email);
    }
    //Thông báo nhập địa chỉ
    if (addressValue === '') {
        setError(address, 'Yêu cầu nhập địa chỉ nhân viên');
    } else {
        setSuccess(address);
    }
    //Thông báo tên nhân viên
    if (nameValue === '') {
        setError(aname, 'Yêu cần nhập tên nhân viên');
    } else {
        setSuccess(aname);
    }
    //Thông báo ngày sinh 
    if (dobValue === '') {
        setError(dob, 'Yêu cần chọn ngày sinh');
    } else {
        setSuccess(dob);
    }
    //Thông báo tên đăng nhập
    if (usernameValue === '') {
        setError(username, 'Yêu cần nhập tên đăng nhập của nhân viên');
    } else {
        setSuccess(username);
    }
    //Thông báo mật khẩu
    if (passValue === '') {
        setError(pass, 'Yêu cần nhập mật khẩu cho nhân viên');
    } else {
        setSuccess(pass);
    }
};



//Xét điều kiện để hiện thông báo lỗi form edit
const setError1 = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = message;
    inputControl.classList.add('failed');
    inputControl.classList.remove('success')
}
//Xét điều kiện để hiện thông báo thành công form edit
const setSuccess1 = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.fail');
    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('failed');
    y = y + 1;
    
};
//Chạy hàm validate form edit
form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 6) {
        Fnon.Ask.Danger({
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
                    y = 0;
                }
            }
        });
    }
});
//Trim input và các thông báo form edit
const validateInputs1 = () => {
    const phoneValue1 = phone1.value.trim();
    const emailValue1 = email1.value.trim();
    const nameValue1 = aname1.value.trim();
    const addressValue1 = address1.value.trim();
    const dobValue1 = dob1.value.trim();
    const usernameValue1 = username1.value.trim();
    // Thông báo nhập số điện thoại
    if (phoneValue1 === '') {
        setError1(phone1, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue1)) {
        setError1(phone1, 'Nhập đúng định dạng số điện thoại');
    } else {
        setSuccess1(phone1);
    }
    //Thông báo nhập địa chỉ email
    if (emailValue1 === '') {
        setError1(email1, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue1)) {
        setError1(email1, 'Nhập đúng định dạng email');
    } else {
        setSuccess1(email1);
    }
    //Thông báo nhập địa chỉ
    if (addressValue1 === '') {
        setError1(address1, 'Yêu cầu nhập địa chỉ nhà cung cấp');
    } else {
        setSuccess1(address1);
    }

    //Thông báo tên nhân viên
    if (nameValue1 === '') {
        setError1(aname1, 'Yêu cần nhập tên nhân viên');
    } else {
        setSuccess1(aname1);
    }
    //Thông báo ngày sinh 
    if (dobValue1 === '') {
        setError1(dob1, 'Yêu cần chọn ngày sinh');
    } else {
        setSuccess1(dob1);
    }
    //Thông báo tên đăng nhập
    if (usernameValue1 === '') {
        setError1(username1, 'Yêu cần nhập tên đăng nhập của nhân viên');
    } else {
        setSuccess1(username1);
    }

};


