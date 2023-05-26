window.addEventListener('load', function() {
    var agreementDiv = document.getElementById('agreement');
    var editButton = document.getElementById('editButton');
    var editorDiv = document.getElementById('editor');
    var saveButton = document.getElementById('saveButton');
  
    // 初始化用户协议内容
    var agreementText = document.getElementById('agreement').innerText;
    agreementDiv.innerText = agreementText;
  
    // 监听编辑按钮的点击事件
    editButton.addEventListener('click', function() {
      // 切换到编辑模式
      agreementDiv.style.display = 'none';
      editorDiv.style.display = 'block';
      saveButton.style.display = 'block';
  
      // 将用户协议内容加载到编辑器中
      editorDiv.innerText = agreementText;
    });
  
    // 监听保存按钮的点击事件
    saveButton.addEventListener('click', function() {
      // 获取编辑器中的内容
      var newAgreementText = editorDiv.innerText;
  
      // 更新用户协议内容
      agreementText = newAgreementText;
      agreementDiv.innerText = agreementText;
  
      // 切换回显示模式
      agreementDiv.style.display = 'block';
      editorDiv.style.display = 'none';
      saveButton.style.display = 'none';
    });
  });
  