using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterJogoModel
    {
        public int? Id { get; set; }

        [Required(ErrorMessage = "Campo nome é obrigatório.")]
        [StringLength(250, ErrorMessage = "O nome não pode ter mais de 250 caracteres.")]
        public string Nome { get; set; }

        [Required]
        [EnumDataType(typeof(Categoria), ErrorMessage = "Selecione uma categoria.")]
        public Categoria Categoria { get; set; }

        [DisplayName("Descrição")]
        [Required(ErrorMessage = "Campo descrição é obrigatório.")]
        [StringLength(500, ErrorMessage = "A descrição não pode ter mais de 500 caracteres.")]
        public string Descricao { get; set; }

        [Required]
        [EnumDataType(typeof(Selo), ErrorMessage = "Selecione um selo.")]
        public Selo Selo { get; set; }

        [StringLength(500, ErrorMessage = "A url não pode ter mais de 500 caracteres.")]
        public string Imagem { get; set; }

        [StringLength(500, ErrorMessage = "O código não pode ter mais de 500 caracteres.")]
        public string Video { get; set; }
    }
}