using CuriousDriveWebAPI.CuriousDrive.Models;
using System.Collections.Generic;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public interface IUserRepository : IRepository<User>
    {
        string GetSaltValueByEmailAddress(string emailAddress);
        User GetUserByEmailAddressAndPassword(string emailAddress, string password);
        List<User> GetUsersByRole(string role);
        List<User> GetTop10UsersByPrefix(string prefix);
        List<User> GetUsersByPrefix(string prefix);
        User GetSocialNetworkUserByEmailAddress(string emailAddress);
    }
}