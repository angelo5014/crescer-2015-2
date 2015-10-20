function ordenaPorTitulo(titulo, arr){
  return (arr.sort(function(a,b){return (a.titulos[titulo].qtd < b.titulos[titulo].qtd)}));
};

function somarTitulos(titulo, arr){
	var soma = 0;
	arr.forEach(function(a){
		soma += a.titulos[titulo].qtd;
	});
	return soma;
};

function apenasOsMelhores(arr){
	return arr.filter(function(a){
		return a.titulos[0].qtd > 18;
	});
};

function ordenaPorNacionais(arr){
  return ordenaPorTitulo(0, arr);
};
function ordenaPorContinentais(arr){
  return ordenaPorTitulo(1, arr);
};
function ordenaPorMundiais(arr){
  return ordenaPorTitulo(2,arr);
};
function somarPorNacionais(arr){
	return somarTitulos(0, arr);
};

function somarPorContinentais(arr){
	return somarTitulos(1,arr);
};

function somarPorTodosTitulos(arr){
	var soma = 0;
	[0,1,2].forEach(function(i){
		soma += somarsomarTitulos(i,arr);
	});
	return soma;
};

function calcularIdadeMedia(arr){
  var soma = arr.reduce(function(acumulador, elem){
    var idade = new Date().getFullYear() - elem.fundacao.getFullYear();
    return acumulador + idade;
  }, 0);
  return soma / arr.length;
}

/*
var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];*/
