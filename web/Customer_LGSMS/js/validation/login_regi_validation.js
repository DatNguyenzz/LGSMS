let x = 0;
const form = document.getElementById('loginForm');
const account = document.getElementById('username');
const password = document.getElementById('password');

const form1 = document.getElementById('registerForm');
const regiacc = document.getElementById('refiUsername');
const reemail = document.getElementById('regiEmail');
const regipass = document.getElementById('regiPass');
const repass = document.getElementById('regiRepass');
//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 2) {
        document.getElementById("loginForm").submit();
        //form đã được submit tôi chưa biết so sánh form với database tn nên bạn thử sau đây noti trong if hoạt động oke

    }
});


//Trim input và các thông báo form add
const validateInputs = () => {
    const accValue = account.value.trim();
    const passValue = password.value.trim();
    //Thông báo tên tài khoản
    if (accValue === '') {
        setError(account, 'Yêu cầu tên tài khoản');
    } else {
        setOkay(account);
    }
    //Thông báo mặt khẩu
    if (passValue === '') {
        setError(password, 'Yêu cầu nhập mật khẩu');
    } else {
        setOkay(password);
    }
};

form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 2) {
        document.getElementById("registerForm").submit();
        //form đã được submit tôi chưa biết so sánh form với database tn nên bạn thử sau đây noti trong if hoạt động oke

    }
});

const validateInputs1 = () => {
    const regiaccValue = regiacc.value.trim();
    const regimailValue = reemail.value.trim();
    //Thông báo tên tài khoản
    if (regiaccValue === '') {
        setError1(regiacc, 'Yêu cầu tên tài khoản');
    }else if (isValidUsername(regiaccValue)) {
        setError1(regiacc, 'Không được có ký tự đặc biệt')
    } else {
        setOkay1(regiacc);
    }
    //Thông báo nhập địa chỉ email
    if (regimailValue === '') {
        setError1(reemail, 'Yêu cầu nhập địa chỉ email');
    } else if (!isValidEmail(regimailValue)) {
        setError1(reemail, 'Nhập đúng định dạng email your@example.com');
    } else {
        setSuccess1(reemail);
    }
};
