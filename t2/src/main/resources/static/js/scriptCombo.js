(function(){
    var listaBotonesEditar = document.querySelectorAll('.editarCombo');
    listaBotonesEditar.forEach(item =>{
        item.addEventListener("click", e =>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboMenu').value = item.dataset.menu;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtPrecio').value = item.dataset.precio;
            document.getElementById('txtStock').value = item.dataset.stock;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
            //$('#modalEditar').modal('show');
        });
    });
})();