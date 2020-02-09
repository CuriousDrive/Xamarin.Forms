using System;
using System.Collections.Generic;

namespace CuriousDriveMobileApp.CuriousDrive.Models
{
    public partial class Role
    {
        public Role()
        {
            UserRole = new HashSet<UserRole>();
        }

        public int RoleId { get; set; }
        public string RoleName { get; set; }
        public string RoleDescription { get; set; }
        public DateTime? CreatedDate { get; set; }
        public int? CreatedBy { get; set; }
        public DateTime? ModifiedDate { get; set; }
        public int? ModifiedBy { get; set; }
        public int? UpdateSeq { get; set; }

        public ICollection<UserRole> UserRole { get; set; }
    }
}
