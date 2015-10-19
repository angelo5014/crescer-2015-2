<<<<<<< HEAD
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
=======
/*
* CWI Software
*/
// Exercício 01

function isNumber(number) {
  return typeof number === 'number';
  // return !isNaN(number);
};

function isFunction(fn) {
  return typeof fn === 'function';
};

function daisyGame(petals) { console.log('inline'); };

var daisyGame = function(petals) { 
  if (isNumber(petals)) {
    return 'Love me' + ( petals % 2 === 0 ? ' not' : '' );
  } else {
    throw new Error('Petals not a number!');
  }
};

var arr = ['t1', 'maior t3xt0', 't2a', 'u', '123'];
arr['nome'] = 'Array querido';

for (var prop in arr) {
  console.log(arr[prop]);
}

(function maiorTexto(textos) {

  for (var i = 0, maiorTxt = '', len = textos.length; i < len; i++) {
    (function() {
      var dentro = 'fora';
      if (textos[i].length > maiorTxt.length) {
        maiorTxt = textos[i];
      }
      //console.log(textos[i]);
    })();
  }

  //console.log('fora: %o', dentro);

  return maiorTxt;
})(arr);

function imprime(instrutores, fn) {
  // debugger;
  if (isFunction(fn)) {
    instrutores.forEach(fn);  
  }
};

var imprimeInstrutor = function(instrutor) {
  console.log(instrutor);
};

var alerta = function(instrutor) {
  alert(instrutor);
};

imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor);
imprime(['bernardo', 'nunes', 'benhur'], 'oi');
// ERRADO:
// imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor());

>>>>>>> 8281e44498eb3822e9bb6e7445853e6837dad4e1
var fibonacci = function(n) {
  if (n === 1) return 1;
  if (n === 2) return 1;

  return fibonacci(n-1)+fibonacci(n-2);
};
<<<<<<< HEAD
var fiboSum = function(n) {
  return fibonacci(n+2)-1;
};

//Ex-5
function excelis(letra) {
    var soma = 0;
    for (var i = 0; i < letra.length; i++) {
        soma = soma * 26 + letra.charCodeAt(i) - 64;
    }
    return soma;
}
//Ex-6
function queroCafe(mascada, precos){
var resposta = '';
precos.sort(function(a,b) {return a - b;});
  for(i=0;i<precos.length;i++){
    if(precos[i] <= mascada){
      i < (precos.length - 2) ? (resposta += precos[i]+',') : (resposta += precos[i]);
    }
  }
  return resposta;
}
=======

// fiboSum(7) => 13+8+5+3+2+1+1

var fiboSum = function(n) {
  //if (n === 1) return 1;
  //return fibonacci(n) + fiboSum(n-1);
  return fibonacci(n+2)-1;
};

function queroCafe(mascada, precos) {
  return precos
    .filter(function(elem) {
      return elem <= mascada;
    })
    .sort(function(elem1, elem2) {
      return elem1 > elem2;
    })
    .join(',');
    // alternativas:
    // join()
    // toString()
};

[
  // caso de teste 1
  { mascada: 3.14, precos: [ 5.16, 2.12, 1.15, 3.11, 17.5 ], esperado: '1.15,2.12,3.11' },
  // caso de teste 2
  { mascada: 99, precos: [ 101, 105 ], esperado: 'shimbalaie' },
].forEach(function(elem) {
  console.assert(
    queroCafe(elem.mascada, elem.precos) === elem.esperado
    , 'Falhou! ' + elem.mascada + ' ' + elem.precos
  )
});
>>>>>>> 8281e44498eb3822e9bb6e7445853e6837dad4e1
