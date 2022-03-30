function InvalidMsg(textbox) {
    
    if (textbox.value == '') {
        textbox.setCustomValidity('Xin hãy nhập email của bạn.');
    }
    else if(textbox.validity.typeMismatch){
        textbox.setCustomValidity('Xin hãy nhập đúng định dạng email.');
    }
    else {
        textbox.setCustomValidity('');
    }
    return true;
}

function InvalidNum(textbox) {
    
    if (textbox.value == '') {
        textbox.setCustomValidity('Xin hãy nhập số sản phẩm.');
    }
    else if(textbox.value <= 0){
        textbox.setCustomValidity('Xin hãy nhập số dương.');
    }
    else {
        textbox.setCustomValidity('');
    }
    return true;
}

function InvalidPrice(textbox) {
    
    if (textbox.value == '') {
        textbox.setCustomValidity('Xin hãy nhập giá sản phẩm.');
    }
    else if(textbox.value <= 0){
        textbox.setCustomValidity('Xin hãy nhập đúng giá.');
    }
    else {
        textbox.setCustomValidity('');
    }
    return true;
}

const phone = document.getElementById('staff-phone');
const phone1 = document.getElementById('provider-phone');
const re = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;

//Điều kiện số điện thoại
const isValidPhone = phone => {
    const re = /(84|0[3|5|7|8|9])+([0-9]{8})\b/g;
    return re.test(String(phone).toLowerCase());
}
//Trim input và các thông báo
function InvalidPhone(textbox) {
    const phoneValue = phone.value.trim();
    // Thông báo nhập số điện thoại
    if (phoneValue === '') {
        textbox.setCustomValidity('Xin hãy nhập số điện thoại.');
    } else if (!isValidPhone(phoneValue)) {
        textbox.setCustomValidity('Xin hãy nhập đúng số điện thoại.');
    } else {
        textbox.setCustomValidity('');
    }
}
function InvalidPhone1(textbox) {
    const phoneValue1 = phone1.value.trim();
    console.log(phoneValue1);
    // Thông báo nhập số điện thoại
    if (phoneValue1 === '') {
        textbox.setCustomValidity('Xin hãy nhập số điện thoại.');
    } else if (!isValidPhone(phoneValue1)) {
        textbox.setCustomValidity('Xin hãy nhập đúng số điện thoại.');
    } else {
        textbox.setCustomValidity('');
    }
}
