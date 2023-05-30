$(function() {
    var all = $('.all');
    var itme;
    itme = $('.itme');
    all.on('click', function() {
        if (this.checked == true) {
            itme.prop('checked', true);
            all.prop('checked', true);
        } else {
            itme.prop('checked', false);
            all.prop('checked', false);
        }
    })

    $.each(itme, function(index, value) {
        $(this).on('click', function() {
            if ($('.itme:checked').length == $('.itme').length) {
                all.prop('checked', true);
            } else {
                all.prop('checked', false);
            }
        })
    });

    var off = $('.off');
    off.on('click', function() {
        all.prop('checked', false);
        itme.prop('checked', false);
    });

    var del = $('.del');
    del.on('click', function() {
    $('.itme:checked').each(function() {
      var lastCell = $(this).closest('tr').find('td:last');
      lastCell.text('通过');
      $(this).prop('checked', false);
    });

    if ($('.itme:checked').length == 0) {
      all.prop('checked', false);
    }
  });

    var refuse = $('.refuse');
    refuse.on('click', function() {
    $('.itme:checked').each(function() {
      var lastCell = $(this).closest('tr').find('td:last');
      lastCell.text('未通过');
      $(this).prop('checked', false);
    });

    if ($('.itme:checked').length == 0) {
      all.prop('checked', false);
    }
  });

    
    

    $.each(itme, function(index, value) {
        $(this).on('click', function() {
            if ($('.itme:checked').length == $('.itme').length) {
                all.prop('checked', true);
            } else {
                all.prop('checked', false);
            }
        })
    });

})