// 获取DOM元素
const usernameInput = document.getElementById('username');
const companyInput = document.getElementById('company');
const editBtn_usrname = document.getElementById('editBtn_usrname');
const editBtn_usrcompany = document.getElementById('editBtn_usrcompany');

// 模拟从后端获取的数据
const userData = {
    username: 'JohnDoe',
    company: 'Example Company'
};

// 初始化页面内容
usernameInput.value = userData.username;
companyInput.value = userData.company;

// 编辑模式切换
function toggleEditMode(input, editBtn) {
    input.readOnly = !input.readOnly;

    if (input.readOnly) {
        editBtn.classList.remove('edit-mode');
    } else {
        editBtn.classList.add('edit-mode');
    }
}

// 监听按钮点击事件
editBtn_usrname.addEventListener('click', function() {
    toggleEditMode(usernameInput, editBtn_usrname);
});
editBtn_usrcompany.addEventListener('click', function() {
    toggleEditMode(companyInput, editBtn_usrcompany);
});