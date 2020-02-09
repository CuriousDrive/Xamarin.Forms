using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebClient
{
    public class UserGroupViewModel
    {
        public int userGroupId { get; set; }
        public string groupName { get; set; }
        public string groupDescription { get; set; }
        public string groupStatusDescription { get; set; }
    }
}
