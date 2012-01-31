
function  addToCart(quantity,idProduct){
    $.ajax({
        type: "GET",
        url: "/addShoppingCart.vn",
        data: "id="+idProduct+"&number="+quantity,
        dataType: "html",
        async: false,
        success: function(data){
            if(data == 0){
                alert("Sản phẩm không đủ")
            }
            else{
            $("#countShop").html(data) ;
            $("#current_cart_items_count").html(data) ;
            }
        }
        });
    
}

function  resetForm(path){
    $.ajax({
        type: "GET",
        url: path,
        dataType: "html",
        async: false,
        success: function(data){
        }
        });
    
}

/*function  addToCart(quantity,idProduct){
    $.ajax({
        type: "GET",
        url: "/addShoppingCart.vn",
        data: "id="+idProduct+"&number="+quantity,
        dataType: "html",
        async: false,
        success: function(data){
            if(data == 0){
                alert("Sản phẩm không đủ")
            }
            else{
            $("#countShop").html(data) ;
            $("#current_cart_items_count").html(data) ;
            }
        }
        });
    
}*/
function  uploadImage(url){
    $.ajax({
        type: "GET",
        url: "/addShoppingCart.vn",
        data: "id="+idProduct+"&number="+quantity,
        dataType: "html",
        async: false,
        success: function(data){
            if(data == 0){
                alert("Sản phẩm không đủ");
            }
            else{
            $("#countShop").html(data) ;
            $("#current_cart_items_count").html(data) ;
            }
        }
        });
    
}


function  updateNumberProduct(idUpdate,numberUpdate, index){
    alert("ajax");
    $.ajax({
        type: "GET",
        url: "/updateShoppingCart.vn",
        data: "id="+idUpdate+"&number="+numberUpdate,
        dataType: "html",
//        cache: false,
        async: false,
        success: function(data){
            var temp = new Array();
            alert(data);
            if(data != 0){
            temp = data.split(' ');
                if(temp[0] == 0){
                $("#"+index).val(temp[1]);
                }
                else{
                $("#Sub"+ index).html(temp[2]);
                $("#total").html(temp[3]);
//                $("#"+index).val() = temp[1];
                }
            }
             /* //  alert(data);
             //get value of data
              //  alert(data.id);
               // alert(data.value);
                
                if(data.id == "1"){
                    alert("Vui lòng chọn nhỏ hơn "+ data.value + " san phẩm");
                }*/
        }
            
        });
    
}




