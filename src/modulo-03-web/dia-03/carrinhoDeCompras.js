function CarrinhoDeCompras(){
  this.produtos = [];
}

CarrinhoDeCompras.prototype.adicionarItem = function(item){
  this.produtos.push(item);
}

CarrinhoDeCompras.prototype.removerItem = function(sku){
    this.produtos.slice(indexOfProduto(sku),1);
}

CarrinhoDeCompras.prototype.atualizarItem = function(sku, novaQtd){
  this.produtos[indexOfProduto(sku)].quantidade = novaQtd;
}

CarrinhoDeCompras.prototype.calcularValorTotal = function(){
  var soma = 0;
  this.produtos.forEach(function(a){soma += a.calcularSubTotal(a);});
  if(Math.random() > 0.6){
    soma = (soma * 10) / 100;
  }
  return soma;
}

CarrinhoDeCompras.prototype.indexOfProduto = function(sku){
 this.produtos.map(function(a){
   return a.sku;
 }).indexOf(sku);
}
