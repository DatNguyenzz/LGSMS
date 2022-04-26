// Lấy input
let x = 0;
const form = document.getElementById('form');
const aname = document.getElementById('fname');
const phone = document.getElementById('phone');
const address = document.getElementById('adr');


//Chạy hàm validate form add
form.addEventListener('submit', e => {
    e.preventDefault();
    x = 0;
    validateInputs();
    if (x == 3) {
        alertFunction();
    }
});

//Trim input và các thông báo form add
const validateInputs = () => {
    const phoneValue = phone.value.trim();
    const nameValue = aname.value.trim();
    const addressValue = address.value.trim();

    // Thông báo nhập số điện thoại

    if (phoneValue === '') {
        setError(phone, 'Yêu cầu nhập số điện thoại');
    } else if (!isValidPhone(phoneValue)) {
        setError(phone, 'Nhập đúng định dạng số điện thoại có 10 chữ số');
    } else {
        setSuccess(phone);
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
        setError(aname, 'Nhập đúng tên Nguyễn Văn A');
    } else {
        setSuccess(aname);
    }
};
