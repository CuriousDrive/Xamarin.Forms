using CuriousDriveWebAPI.CuriousDrive.Repositories;
using System;

namespace CuriousDriveWebAPI.CuriousDrive.UnitsOfWork
{
    public interface IUnitOfWork : IDisposable
    {
        IRoleRepository Roles { get; }
        IMessageRepository Messages { get; }
        int Complete();
    }
}