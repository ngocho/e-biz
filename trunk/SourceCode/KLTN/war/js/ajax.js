
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

function  updateNumberProduct(idUpdate,numberUpdate){
    $.ajax({
        type: "POST",
        url: "/updateShoppingCart.vn",
        data: "id="+idUpdate+"&number="+numberUpdate,
        dataType: "json",
        cache: false,
        async: false,
        success: function(data){
            try
            {
              //  alert(data);
             //get value of data
              //  alert(data.id);
               // alert(data.value);
                
                if(data.id == "1"){
                    alert("Vui lòng chọn nhỏ hơn "+ data.value + " san phẩm");
                }
            }
            catch(e)
            { 
                alert(e);
            }
            
        }
        });
    
}




