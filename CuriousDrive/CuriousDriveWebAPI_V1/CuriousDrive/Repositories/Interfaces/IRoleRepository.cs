using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public interface IRoleRepository : IRepository<Role>
    {
        Role GetAdminRoles(int id);
    }
}