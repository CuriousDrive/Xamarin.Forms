using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class UserDetailsViewModel
    {
        public string displayName { get; set; }
        public int? userId { get; set; }
        public string urlTitle { get; set; }
        public ProfilePictureViewModel profilePictureViewModel { get; set; }
    }
}
