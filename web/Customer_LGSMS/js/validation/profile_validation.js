// Lấy input
let x = 0;
let y = 0;
const form = document.getElementById('form');
const aname = document.getElementById('user-name');
const username = document.getElementById('username');
const email = document.getElementById('user-email');
const phone = document.getElementById('user-phone');
const address = document.getElementById('user-address');
const dob = document.getElementById('user-dob');

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 6) {
        alertFunction();
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
    } else if (!isValidName(nameValue)) {
        setError(aname, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess(aname);
    }
    //Thông báo tên nhân viên
    if (usernameValue === '') {
        setError(username, 'Yêu cầu nhập tên đăng nhập');
    }else if (isValidUsername(usernameValue)) {
        setError(username, 'Tên tài khoản không được có ký tự đặc biệt')
    } else {
        setSuccess(username);
    }
    //Thông báo ngày sinh 
    if (dobValue === '') {
        setError(dob, 'Yêu cầu chọn ngày sinh');
    } else {
        setSuccess(dob);
    }
};