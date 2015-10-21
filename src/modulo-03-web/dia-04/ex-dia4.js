function isPalindrome(palavra){
  var palavraInvertida = palavra.split('').reverse().join('');
  return palavra === palavraInvertida ? true : false;
}

function isBissext(data){
  var ano = data.getFullYear();
  return ((ano % 4 === 0) && (ano % 100 !== 0) || (ano %400 === 0));
}
