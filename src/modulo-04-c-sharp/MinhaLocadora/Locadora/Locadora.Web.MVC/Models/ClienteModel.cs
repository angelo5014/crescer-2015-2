using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ClienteModel
    {
        private const string CAMPO_OBRIGATORIO = "Campo obrigatório";

        [Required(ErrorMessage = CAMPO_OBRIGATORIO)]
        [StringLength(255, MinimumLength = 5)]
        public string Nome { get; set; }

        [Required]
        [Range(typeof(int), "18", "120")]
        public int Idade { get; set; }

        [DisplayName("E-mail")]
        [Required]
        [RegularExpression(@"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}", ErrorMessage = "E-mail Inválido")]
        public string Email { get; set; }

        [DisplayName("E-mail Confirmação")]
        [Required]
        [Compare("Email", ErrorMessage = "Os campos não correspondem")]
        public string EmailConfimacao { get; set; }

    }
}