using Locadora.Dominio;
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
        public int? Id { get; set; }

        [Required(ErrorMessage = "CAMPO OBRIGATORIO CARA!!")]
        [StringLength(250, MinimumLength = 5, ErrorMessage = "O nome deve ter entre 5 e 250 caracteres")]
        public string Nome { get; set; }

        [Required]
        [Range(typeof(int), "18", "120")]
        public int Idade { get; set; }

        [DisplayName("E-mail")]
        [Required]
        [RegularExpression(@"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}", ErrorMessage = "O email deve corresponder -Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z] sacou?")]
        public string Email { get; set; }

        [DisplayName("E-mail Confirmação")]
        [Required]
        [Compare("Email")]
        public string EmailConfimacao { get; set; }

        public Categoria Categoria { get; set; }

        public int IdJogo { get; set; }
    }
}