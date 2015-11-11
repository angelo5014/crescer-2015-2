<<<<<<< HEAD
﻿using System;
=======
﻿using Locadora.Dominio;
using System;
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ClienteModel
    {
<<<<<<< HEAD
        private const string CAMPO_OBRIGATORIO = "Campo obrigatório";

        [Required(ErrorMessage = CAMPO_OBRIGATORIO)]
        [StringLength(255, MinimumLength = 5)]
=======
        public int? Id { get; set; }

        [Required(ErrorMessage = "CAMPO OBRIGATORIO CARA!!")]
        [StringLength(250, MinimumLength = 5, ErrorMessage = "O nome deve ter entre 5 e 250 caracteres")]
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
        public string Nome { get; set; }

        [Required]
        [Range(typeof(int), "18", "120")]
        public int Idade { get; set; }

        [DisplayName("E-mail")]
        [Required]
<<<<<<< HEAD
        [RegularExpression(@"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}", ErrorMessage = "E-mail Inválido")]
=======
        [RegularExpression(@"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}", ErrorMessage = "O email deve corresponder -Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z] sacou?")]
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
        public string Email { get; set; }

        [DisplayName("E-mail Confirmação")]
        [Required]
<<<<<<< HEAD
        [Compare("Email", ErrorMessage = "Os campos não correspondem")]
        public string EmailConfimacao { get; set; }

=======
        [Compare("Email")]
        public string EmailConfimacao { get; set; }

        public Categoria Categoria { get; set; }

        public int IdJogo { get; set; }
>>>>>>> 196bc442c1d9dea6c1835e05199b10a9db08b196
    }
}