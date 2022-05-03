// Lấy input
let x = 0;
const form = document.getElementById('form');
const account1 = document.getElementById('account');
const email1 = document.getElementById('email');

//Chạy hàm validate
form.addEventListener('submit', e => {
    e.preventDefault();
    x=0;
    validateInputs();
    if (x == 2) {
        document.getElementById("form").submit();
    }
});
//Trim input và các thông báo
const validateInputs = () => {
    // const phoneValue = phone.value.trim();
    const emailValue = email1.value.trim();
    const accountValue = account1.value.trim();
    //Thông báo nhập địa chỉ email
    if (emailValue === '') {
        setError(email1, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(emailValue)) {
        setError(email1, 'Nhập đúng định dạng email');
    } else {
        setSuccess(email1);
    }

    //Thông báo tài khoản
    if (accountValue === '') {
        setError(account1, 'Yêu cần nhập tên tài khoản');
    }   else if (isValidUsername(accountValue)) {
        setError(account1, 'Không được có ký tự đặc biệt')
    } else {
        setSuccess(account1);
    }
};