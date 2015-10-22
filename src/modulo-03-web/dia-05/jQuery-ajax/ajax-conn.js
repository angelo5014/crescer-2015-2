function listarPessoas(){
  $(function() {
        $.get('http://localhost:3000/pessoas')
          .done(function(data) {
            console.log(data);
              )
            });
          });
      });
}
