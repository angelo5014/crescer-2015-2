CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras);

function CarrinhoDeComprasChantagista(){
  CarrinhoDeCompras.apply();
}

CarrinhoDeCompras.prototype.forcarCompra = function() {
  if (!this.intervalo) {
    this.intervalo = setInterval(function() {
      this.itens.forEach(function(elem) {
        elem.valorUnitario += elem.valorUnitario * .1;
      });
    }.bind(this), 5000);
  }
};

CarrinhoDeCompras.prototype.concluirPedido = function() {
  clearInterval(this.intervalo);
  delete this.intervalo;
};
