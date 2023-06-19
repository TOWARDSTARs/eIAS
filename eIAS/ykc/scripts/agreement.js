  function showLi(obj) {
          $(obj).addClass('on').siblings().removeClass('on');
          var index = $(obj).index();
          //console.log($(obj).parent().parent())
          $(obj).parent().parent().find('.content li').hide();
          $(obj).parent().parent().find('.content li:eq(' + index + ')').show();
      }
      
  function showPanal1(obj) {
          $(obj).addClass('bag').siblings().removeClass('bag');
          var _index = $(obj).index();
          $('.panal').eq(_index).show('fast').siblings().hide('fast');
      }

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
      

      var pText = document.getElementsByClassName('qa'),
      btn = document.getElementsByClassName('change');

      for (var i = 0; i < btn.length; i++) {
          btn[i].index = i;
          btn[i].flag = false; // 不可修改
          btn[i].onclick = function() {
              if (this.flag) {
                  this.style.cssText = 'background:#51cbfc;color:#fff;';
                  this.value = '修改';
                  pText[this.index].setAttribute('contenteditable', false) // 当前p标签可编辑属性为假
              } else { // 不可修改 变为可修改
                  this.style.cssText = 'background:#f60;color:#fff;';
                  this.value = '确定';
                  pText[this.index].setAttribute('contenteditable', true)
                  pText[this.index].focus(); //  聚焦
              }
              this.flag = !this.flag;
          }
      }