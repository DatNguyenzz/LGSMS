// Lấy input
let x = 0;
const form = document.getElementById('form');
const account = document.getElementById('account');
const email = document.getElementById('email');
// const phone = document.getElementById('phone');
const password = document.getElementById('password');
const re_password = document.getElementById('re_password');
//Chạy hàm validate
form.addEventListener('submit', e => {
    e.preventDefault();
    validateInputs();
    if (x == 4) {
        document.getElementById("form").submit();
    }
});
};
//Trim input và các thông báo
const validateInputs = () => {
    // const phoneValue = phone.value.trim();
    const emailValue = email.value.trim();
    const accountValue = account.value.trim();
    const passwordValue = password.value.trim();
    const re_passwordValue = re_password.value.trim();
    // Thông báo nhập số điện thoại
    // if (phoneValue === '') {
    //     setError(phone, 'Yêu cầu nhập số điện thoại');
    // } else if (!isValidPhone(phoneValue)) {
    //     setError(phone, 'Nhập đúng định dạng số điện thoại');
    // } else {
    //     setSuccess(phone);
    // }
    //Thông báo nhập địa chỉ email
    if (emailValue === '') {
        setError(email, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue)) {
        setError(email, 'Nhập đúng định dạng email');
    } else {
        setSuccess(email);
    }
    //Thông báo nhập mật khẩu
    if (passwordValue === '') {
        setError(password, 'Yêu cầu nhập mật khẩu');
    } else if (!isValidPass(passwordValue)) {
        setError(password, 'Mật khẩu tối thiểu 8 kí tự có ít nhất 1 số và 1 chữ hoa.')
    } else {
        setSuccess(password);
    }
    //Thông báo xác nhận mật khảu
    if (re_passwordValue === '') {
        setError(re_password, 'Yêu cần xác nhận mật khẩu');
    } else if (re_passwordValue !== passwordValue) {
        setError(re_password, "Không trùng với mật khẩu");
    } else {
        setSuccess(re_password);
    }

    //Thông báo tài khoản
    if (accountValue === '') {
        setError(account, 'Yêu cần nhập tên tài khoản');
    }   else if (isValidUsername(accountValue)) {
        setError(account, 'Không được có ký tự đặc biệt')
    } else {
        setSuccess(account);
    }
};