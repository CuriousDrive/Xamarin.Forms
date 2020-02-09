using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class CommentRepository : Repository<Comment>, ICommentRepository
    {
        public CommentRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }
    }
}