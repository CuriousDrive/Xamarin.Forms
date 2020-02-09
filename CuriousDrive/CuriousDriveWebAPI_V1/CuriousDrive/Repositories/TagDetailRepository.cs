using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class TagDetailRepository : Repository<TagDetail>, ITagDetailRepository
    {
        public TagDetailRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }
    }
}