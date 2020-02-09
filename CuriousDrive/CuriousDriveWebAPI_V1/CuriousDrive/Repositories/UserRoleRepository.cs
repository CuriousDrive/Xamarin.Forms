using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class UserRoleRepository : Repository<UserRole>, IUserRoleRepository
    {
        public UserRoleRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }
    }
}