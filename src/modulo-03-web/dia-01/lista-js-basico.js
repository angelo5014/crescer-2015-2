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
