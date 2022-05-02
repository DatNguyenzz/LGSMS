let x = 0;
const form = document.getElementById('form');
//const oldpass = document.getElementById('old-pass');
const newpass = document.getElementById('new-pass');
const repass = document.getElementById('re-pass');

//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 2) {
        // document.getElementById("form").submit();
        alertFunction();
        //form đã được submit tôi chưa biết so sánh form với database tn nên bạn thử sau đây noti trong if hoạt động oke
        
    }
});

//Trim input và các thông báo
const validateInputs = () => {
//    const old_passValue = oldpass.value.trim();
    const new_passValue = newpass.value.trim();
    const re_passValue = repass.value.trim();

    //Thông báo nhập mật khẩu
    if (new_passValue === '') {
        setError(newpass, 'Yêu cầu nhập mật khẩu');
    } else if (!isValidPass(new_passValue)) {
        setError(newpass, 'Tối thiểu 8 kí tự, có 1 số và 1 chữ hoa.')
    } else {
        setSuccess(newpass);
    }
    //Thông báo xác nhận mật khảu
    if (re_passValue === '') {
        setError(repass, 'Yêu cầu xác nhận mật khẩu');
    } else if (re_passValue !== new_passValue) {
        setError(repass, "Không trùng với mật khẩu");
    } else {
        setSuccess(repass);
    }

    //Thông báo mật khẩu
//    if (old_passValue === '') {
//        setError(oldpass, 'Yêu cầu nhập mật khẩu cũ');
//    }else if (!isValidPass(old_passValue)) {
//        setError(oldpass, 'Tối thiểu 8 kí tự, có 1 số và 1 chữ hoa.')
//    }  else {
//        setSuccess(oldpass);
//    }
};