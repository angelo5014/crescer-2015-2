namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class NomeCompletoParaUsuario : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Usuario", "NomeCompleto", c => c.String(maxLength: 200));
            Sql("UPDATE Usuario SET NomeCompleto = 'SEM_NOME'");
            AlterColumn("dbo.Usuario", "NomeCompleto", c => c.String(nullable: false, maxLength: 200));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Usuario", "NomeCompleto");
        }
    }
}
