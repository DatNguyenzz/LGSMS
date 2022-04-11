// Lấy input
let x = 0;
const form = document.getElementById('form');
const aname = document.getElementById('user-name');
const email = document.getElementById('user-email');
const phone = document.getElementById('user-phone');
const address = document.getElementById('user-address');
const dob = document.getElementById('user-dob');

const form1 = document.getElementById('form1');
const oldpass = document.getElementById('old-password');
const newpass = document.getElementById('new-password');
const repass = document.getElementById('re-password');


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
        setError(aname, 'Yêu cầu nhập tên không có ký tự đặc biệt hoặc số');
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

form1.addEventListener('submit', e => {
    e.preventDefault();
    y = 0;
    validateInputs1();
    if (y == 3) {
        alertFunction();
    }
});

//Trim input và các thông báo form add
const validateInputs1 = () => {
    const oldValue = oldpass.value.trim();
    const newValue = newpass.value.trim();
    const reValue = repass.value.trim();

    //Thông báo nhập mật khẩu cũ
    if (oldValue === '') {
        setError1(oldpass, 'Yêu cầu nhập mật khẩu');
    } else {
        setOkay1(oldpass);
    }
    //Thông báo nhập mật khẩu
    if (newValue === '') {
        setError1(newpass, 'Yêu cầu nhập mật khẩu');
    } else if (!isValidPass(newValue)) {
        setError1(newpass, 'Mật khẩu tối thiểu 8 kí tự có ít nhất 1 số và 1 chữ hoa.')
    } else {
        setOkay1(newpass);
    }
    //Thông báo xác nhận mật khảu
    if (reValue === '') {
        setError1(repass, 'Yêu cầu xác nhận mật khẩu');
    } else if (reValue !== newValue) {
        setError1(repass, "Không trùng với mật khẩu");
    } else {
        setOkay1(repass);
    }

};