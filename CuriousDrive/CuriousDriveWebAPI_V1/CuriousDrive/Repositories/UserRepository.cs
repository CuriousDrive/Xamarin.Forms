using CuriousDriveWebAPI.CuriousDrive.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace CuriousDriveWebAPI.CuriousDrive.Repositories
{
    public class UserRepository : Repository<User>, IUserRepository
    {
        public UserRepository(CuriousDriveContext context) : base(context)
        {
        }

        public CuriousDriveContext CuriousDriveContext
        {
            get { return Context as CuriousDriveContext; }
        }

        public string GetSaltValueByEmailAddress(string emailAddress)
        {
            User users = CuriousDriveContext.User.Where(user => user.EmailAddress == emailAddress).FirstOrDefault();

            if (users != null)
                return users.SaltValue;
            else
                return string.Empty;
        }

        public User GetUserByEmailAddressAndPassword(string emailAddress, string password)
        {
            return CuriousDriveContext.User.Include(userRole => userRole.UserRole)
                                                .ThenInclude(userRole => userRole.Role)
                                                .Where(user => user.EmailAddress == emailAddress && user.Password == password).FirstOrDefault();

        }

        public List<User> GetUsersByRole(string role)
        {
            List<User> users = CuriousDriveContext.User.Include(user => user.UserRole)
                                                        .ThenInclude(userRole => userRole.Role)
                                                        .ToList();

            users = users.Where(u => u.UserRole.Any(ur => ur.Role.RoleName.Equals(Constant.RoleAdmin))).ToList();

            return users;
        }

        public List<User> GetTop10UsersByPrefix(string prefix)
        {
            List<User> users = CuriousDriveContext.User.Where(user => user.DisplayName.Contains(prefix)).ToList();

            if (users.Count() > 0)
                return users.Take(10).ToList();
            else
                return null;

        }

        public List<User> GetUsersByPrefix(string prefix)
        {
            return CuriousDriveContext.User.Where(user => user.DisplayName.Contains(prefix)).ToList();

        }

        public User GetSocialNetworkUserByEmailAddress(string emailAddress)
        {
            return CuriousDriveContext.User.Include(userRole => userRole.UserRole)
                                                .ThenInclude(userRole => userRole.Role)
                                                .Where(user => user.EmailAddress == emailAddress
                                                && (user.NetworkValue == Constant.FacebookNetwork || user.NetworkValue == Constant.GoogleNetwork)).FirstOrDefault();

        }
    }
}