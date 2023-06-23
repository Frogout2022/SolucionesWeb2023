//funcion autoejecutable en la vista
(function(){
    console.log("funcion autojecutable recibida");
    var listaBotonesEditar = document.querySelectorAll('a.editarCombo');
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e =>{
            console.log("Has hecho clic en un botón de editar producto.");
            document.getElementById('id').value = item.dataset.id;
            
            if(item.dataset.menu != null) document.getElementById('cboMenu').value = item.dataset.menu;
            else document.getElementById('cboMenu').selectedIndex= 0;

           

            if(item.dataset.piqueo != null) document.getElementById('cboPiqueo').value = item.dataset.piqueo;
            else document.getElementById('cboPiqueo').selectedIndex= 0;
            
            
            
            if(item.dataset.pollo != null) document.getElementById('cboPollo').value = item.dataset.pollo;
            else document.getElementById('cboPollo').selectedIndex= 0;

            if(item.dataset.bebida != null) document.getElementById('cboBebida').value = item.dataset.bebida;
            else document.getElementById('cboBebida').selectedIndex= 0;


            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtPrecio').value = item.dataset.precio;
            document.getElementById('txtStock').value = item.dataset.stock;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        });
    });
})();


