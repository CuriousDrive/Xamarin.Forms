using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class CodeRepository : Repository<Code>, ICodeRepository
    {
        public CodeRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }
    }
}