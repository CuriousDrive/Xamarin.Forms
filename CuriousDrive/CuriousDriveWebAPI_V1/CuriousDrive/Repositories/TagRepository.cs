using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class TagRepository : Repository<Tag>, ITagRepository
    {
        public TagRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }
    }
}