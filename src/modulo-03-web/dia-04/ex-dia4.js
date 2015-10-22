function isPalindrome(palavra){
  var palavraInvertida = palavra.split('').reverse().join('');
  return palavra === palavraInvertida ? true : false;
}
