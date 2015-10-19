/*======================
     Exercícios JS
=======================*/

//Ex-1
function daisyGame(petalas) {
  if(!isNaN(petalas)){
   var game = (petalas % 2 === 0)? 'Love me not' : 'Love me';
   return game;
  }
}

//Ex-2
function maiorTexto(arr){
  var maior = '';
  for(texto in arr){
    if(typeof arr[texto] === 'string'){
      if(arr[texto].length > maior.length){
        maior = arr[texto];
      }
    }
  }
  return maior;
}
//Ex-3
function imprime(arr, funcao) {
  if(typeof funcao === 'function'){
   for(valor in arr){
     funcao(arr[valor]);
   }
  }
}

//Ex-4
function fibSum(n){
  var soma = 0;
    for(i=0, j=1, k=0 ; k<n ; i=j, j=x, k++ ){
        x=i+j;
        soma += x;
    }
    return soma;
}
//Ex-5
function excelis(letra) {
    letra = letra.toUpperCase();
    var soma = 0;
    for (var i = 0; i < letra.length; i++) {
        soma = soma * 26 + letra.charCodeAt(i) - 64;
    }
    return soma;
}
