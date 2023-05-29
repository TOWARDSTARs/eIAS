function changeText() {
    var text= document.getElementsByTagName("p")[0];
    text.innerHTML="This is a new text";
}

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






//购买推广部分
function selectPackage(packageId) {
  // 根据选择的套餐执行相应操作
  console.log("选择套餐：" + packageId);
  // 可以将选择的套餐信息发送到后端进行处理
}

     function addPackageToHistory(packageName, packageDescription, packagePrice) {
var historyList = document.getElementById("historyList");

var listItem = document.createElement("li");
listItem.innerHTML = "<strong>套餐名称:</strong> " + packageName + "<br>" +
                     "<strong>套餐描述:</strong> " + packageDescription + "<br>" +
                     "<strong>套餐价格:</strong> " + packagePrice;

// 点击历史套餐时显示详细信息弹窗
listItem.addEventListener("click", function() {
  showPackageDetails(packageName, packageDescription, packagePrice);
});

historyList.appendChild(listItem);
}






//我的服务部分
function showPackageDetails(packageName, packageDescription, packagePrice) {
  var modal = document.getElementById("packageDetailsModal");
  var modalPackageName = document.getElementById("modalPackageName");
  var modalPackageDescription = document.getElementById("modalPackageDescription");
  var modalPackagePrice = document.getElementById("modalPackagePrice");

  modalPackageName.textContent = "套餐名称: " + packageName;
  modalPackageDescription.textContent = "套餐描述: " + packageDescription;
  modalPackagePrice.textContent = "套餐价格: " + packagePrice;

  modal.style.display = "block";
}

function closeModal() {
  var modal = document.getElementById("packageDetailsModal");
  modal.style.display = "none";
}

// 示例调用
addPackageToHistory("套餐 1", "套餐 1 的描述信息", "$10");
addPackageToHistory("套餐 2", "套餐 2 的描述信息", "$20");

  






//账户充值部分
  // 假设从后端获取的余额值为balanceValue
  var balanceValue = 100; // 假设当前余额为100元

  // 更新当前余额显示和表单字段的值
  var currentBalanceElement = document.getElementById("currentBalance");
  currentBalanceElement.value = balanceValue.toFixed(2); // 格式化余额值为小数点后两位
  
  //         // 获取当前充值余额
  // function getCurrentBalance() {
  //   // 发送请求获取余额
  //   // 这里使用示例的 AJAX 请求方法
  //   var xhr = new XMLHttpRequest();
  //   xhr.open("GET", "/balance", true);
  
  //   // 响应处理
  //   xhr.onreadystatechange = function() {
  //     if (xhr.readyState === XMLHttpRequest.DONE) {
  //       if (xhr.status === 200) {
  //         var balance = JSON.parse(xhr.responseText).balance;
  //         // 更新余额显示
  //         document.getElementById("balanceAmount").textContent = balance;
  //       } else {
  //         console.error("获取余额失败");
  //       }
  //     }
  //   };
  
  //   // 发送请求
  //   xhr.send();
  // }
  
  // // 页面加载完成时获取当前余额
  // document.addEventListener("DOMContentLoaded", function() {
  //   getCurrentBalance();
  // });

  document.getElementById("rechargeForm").addEventListener("submit", function(event) {
    event.preventDefault(); // 阻止表单默认提交行为
  
    var amount = document.getElementById("amount").value;
  
    // 发送充值请求
    // 这里使用示例的 AJAX 请求方法
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/recharge", true);
    xhr.setRequestHeader("Content-Type", "application/json");
  
    // 响应处理
    xhr.onreadystatechange = function() {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          // 充值成功处理逻辑
          alert("充值成功！");
          // 其他操作，如刷新账户余额等
        } else {
          // 充值失败处理逻辑
          alert("充值失败，请稍后再试。");
        }
      }
    };
  
    // 发送充值请求
    xhr.send(JSON.stringify({ amount: amount }));
  });






//账户流水部分  
 // 假设从后端获取的账户流水数据为transactionData
 var transactionData = [
    { detail: "购物", amount: -100, date: "2023-05-01" },
    { detail: "工资", amount: 200, date: "2023-05-02" },
    { detail: "转账", amount: -50, date: "2023-05-03" }
  ];
  
  // 生成账户流水表格行
  var transactionTableBody = document.querySelector("#transactionTable tbody");
  transactionData.forEach(function(transaction, index) {
    var row = document.createElement("tr");
    row.innerHTML = `
      <td>${index + 1}</td>
      <td>${transaction.detail}</td>
      <td>${transaction.amount}</td>
      <td>${transaction.date}</td>
    `;
    transactionTableBody.appendChild(row);
  });
  


