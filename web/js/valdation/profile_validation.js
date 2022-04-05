// Lấy input
let x = 0;
const form = document.getElementById('form');
const aname = document.getElementById('user-name');
const email = document.getElementById('user-email');
const phone = document.getElementById('user-phone');
const address = document.getElementById('user-address');
const dob = document.getElementById('user-dob');

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
    if (x == 5) {
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
        setError(address, 'Yêu cầu nhập địa chỉ');
    } else {
        setSuccess(address);
    }
    //Thông báo tên nhân viên
    if (nameValue === '') {
        setError(aname, 'Yêu cần nhập họ và tên');
    }else if (!isValidName(nameValue)) {
        setError(anameS, 'Yêu cầu nhập tên không dấu');
    } else {
        setSuccess(aname);
    }
    //Thông báo ngày sinh 
    if (dobValue === '') {
        setError(dob, 'Yêu cần chọn ngày sinh');
    } else {
        setSuccess(dob);
    }
};
