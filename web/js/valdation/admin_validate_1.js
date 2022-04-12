//// Lấy input
//let x = 0;
//let y = 0;
//const form = document.getElementById('form');
//const aname = document.getElementById('staff-name');
//const email = document.getElementById('staff-email');
//const phone = document.getElementById('staff-phone');
//const address = document.getElementById('staff-address');
//const dob = document.getElementById('staff-dob');
//const username = document.getElementById('username');
//const pass = document.getElementById('staff-password');
//
//const form1 = document.getElementById('form1');
//const aname1 = document.getElementById('staff-name1');
//const email1 = document.getElementById('staff-email1');
//const phone1 = document.getElementById('staff-phone1');
//const address1 = document.getElementById('staff-address1');
//const dob1 = document.getElementById('staff-dob1');
//const username1 = document.getElementById('username1');

// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const aname1 = document.getElementById('user-name');
const email1 = document.getElementById('staff-email');
const address1 = document.getElementById('user-address');
const phone1 = document.getElementById('staff-phone1');
const dob1 = document.getElementById('user-dob');
const username1 = document.getElementById('username');
//const pass1 = document.getElementById('user-password');

const form1 = document.getElementById('form1');
const aname2 = document.getElementById('fullnameEditInput');
const email2 = document.getElementById('emailEditInput');
const phone2 = document.getElementById('staff-phone');
const address2 = document.getElementById('addressEditInput');
const dob2 = document.getElementById('dobEditInput');
const username2 = document.getElementById('usernameEditInput');


//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 5) {
        alertFunction();
    }
});
//Trim input và các thông báo form add
const validateInputs = () => {
    const phoneValue = phone1.value.trim();
    const emailValue = email1.value.trim();
    const nameValue = aname1.value.trim();
    const addressValue = address1.value.trim();
    const dobValue = dob1.value.trim();
//    const passValue = pass1.value.trim();

    // Thông báo nhập số điện thoại

    if (phoneValue === '') {
        setError(phone1, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue)) {
        setError(phone1, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess(phone1);
    }

    //Thông báo nhập địa chỉ email
    if (emailValue === '') {
        setError(email1, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue)) {
        setError(email1, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess(email1);
    }
    //Thông báo nhập địa chỉ
    if (addressValue === '') {
        setError(address1, 'Yêu cầu nhập địa chỉ nhân viên');
    } else {
        setSuccess(address1);
    }
    //Thông báo tên nhân viên
    if (nameValue === '') {
        setError(aname1, 'Yêu cầu nhập tên nhân viên');
    }else if (!isValidName(nameValue)) {
        setError(aname1, 'Yêu cầu nhập tên không có ký tự đặc biệt hoặc số');
    }else {
        setSuccess(aname1);
    }
    //Thông báo ngày sinh 
    if (dobValue === '') {
        setError(dob1, 'Yêu cầu chọn ngày sinh');
    } else {
        setSuccess(dob1);
    }
    //Thông báo tên đăng nhập
//    if (usernameValue === '') {
//        setError(username1, 'Yêu cầu nhập tên đăng nhập của nhân viên');
//    } else {
//        setSuccess(username1);
//    }
    //Thông báo mật khẩu
//    if (passValue === '') {
//        setError(pass1, 'Yêu cầu nhập mật khẩu cho nhân viên');
//    } else {
//        setSuccess(pass1);
//    }
};



//Chạy hàm validate form edit
form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 5) {
        alertFunction1();
    }
});
//Trim input và các thông báo form edit
const validateInputs1 = () => {
    const phoneValue1 = phone2.value.trim();
    const emailValue1 = email2.value.trim();
    const nameValue1 = aname2.value.trim();
    const addressValue1 = address2.value.trim();
    const dobValue1 = dob2.value.trim();
    const usernameValue1 = username2.value.trim();
    // Thông báo nhập số điện thoại
    if (phoneValue1 === '') {
        setError1(phone2, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue1)) {
        setError1(phone2, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess1(phone2);
    }
    //Thông báo nhập địa chỉ email
    if (emailValue1 === '') {
        setError1(email2, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue1)) {
        setError1(email2, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess1(email2);
    }
    //Thông báo nhập địa chỉ
    if (addressValue1 === '') {
        setError1(address2, 'Yêu cầu nhập địa chỉ nhà cung cấp');
    } else {
        setSuccess1(address2);
    }

    //Thông báo tên nhân viên
    if (nameValue1 === '') {
        setError1(aname2, 'Yêu cầu nhập tên nhân viên');
    }else if (!isValidName(nameValue1)) {
        setError1(aname2, 'Yêu cầu nhập tên không có ký tự đặc biệt hoặc số');
    } else {
        setSuccess1(aname2);
    }
    //Thông báo ngày sinh 
    if (dobValue1 === '') {
        setError1(dob2, 'Yêu cầu chọn ngày sinh');
    } else {
        setSuccess1(dob2);
    }
    //Thông báo tên đăng nhập
//    if (usernameValue1 === '') {
//        setError1(username2, 'Yêu cầu nhập tên đăng nhập của nhân viên');
//    } else {
//        setSuccess1(username2);
//    }

};


