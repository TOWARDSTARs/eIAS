// 获取DOM元素
const usernameInput = document.getElementById('username');
const companyInput = document.getElementById('company');
const editBtn = document.getElementById('editBtn');
const changeEmailBtn = document.getElementById('changeEmailBtn');
const changePasswordBtn = document.getElementById('changePasswordBtn');

// 模拟从后端获取的数据
const userData = {
  username: 'JohnDoe',
  company: 'Example Company'
};

// 初始化页面内容
usernameInput.value = userData.username;
companyInput.value = userData.company;

// 编辑模式切换
function toggleEditMode() {
  usernameInput.readOnly = !usernameInput.readOnly;
  companyInput.readOnly = !companyInput.readOnly;

  if (usernameInput.readOnly) {
    editBtn.textContent = 'Edit';
    usernameInput.classList.remove('edit-mode');
    companyInput.classList.remove('edit-mode');
  } else {
    editBtn.textContent = 'Save';
    usernameInput.classList.add('edit-mode');
    companyInput.classList.add('edit-mode');
  }
}

// 更改邮箱
function changeEmail() {
  // 处理更改邮箱的逻辑
  console.log('Changing email...');
}

// 更改密码
function changePassword() {
  // 处理更改密码的逻辑
  console.log('Changing password...');
}

// 监听按钮点击事件
editBtn.addEventListener('click', toggleEditMode);
changeEmailBtn.addEventListener('click', changeEmail);
changePasswordBtn.addEventListener('click', changePassword);
